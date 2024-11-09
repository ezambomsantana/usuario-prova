package br.insper.usuario.service;

import br.insper.usuario.dto.CreateUsuarioDTO;
import br.insper.usuario.dto.LoginDTO;
import br.insper.usuario.dto.ReturnUsuarioDTO;
import br.insper.usuario.model.Usuario;
import br.insper.usuario.repository.UsuarioRepository;
import br.insper.usuario.utils.PasswordUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final HashMap<String, ReturnUsuarioDTO> cache =
            new HashMap<>();

    public boolean verifyToken(String token) {
        return cache.containsKey(token);
    }

    public ReturnUsuarioDTO createUser(CreateUsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setCpf(dto.getCpf());
        usuario.setNome(dto.getNome());
        usuario.setPassword(PasswordUtils.md5Hash(dto.getPassword()));
        usuario.setEmail(dto.getEmail());
        usuario.setRole(dto.getRole());

        return ReturnUsuarioDTO.convert(usuarioRepository.save(usuario));
    }

    public List<ReturnUsuarioDTO> getUsers() {
        return usuarioRepository
                .findAll()
                .stream()
                .map(u -> ReturnUsuarioDTO.convert(u))
                .toList();
    }

    public ReturnUsuarioDTO getUser(String cpf) {
        Usuario usuario = usuarioRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException());
        return ReturnUsuarioDTO.convert(usuario);
    }

    public String login(LoginDTO dto) {

        Usuario usuario = usuarioRepository
                .findByEmailAndPassword(dto.getEmail(), PasswordUtils.md5Hash(dto.getPassword()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));
        String token = UUID.randomUUID().toString();

        cache.put(token, ReturnUsuarioDTO.convert(usuario));
        return token;

    }
}
