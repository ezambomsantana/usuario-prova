package br.insper.usuario.dto;

import br.insper.usuario.model.Usuario;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReturnUsuarioDTO {
    private String nome;
    private String cpf;
    private String email;
    private String password;
    private String role;

    public static ReturnUsuarioDTO convert(Usuario usuario) {
        ReturnUsuarioDTO dto = new ReturnUsuarioDTO();
        dto.setCpf(usuario.getCpf());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setPassword(usuario.getPassword());
        dto.setRole(usuario.getRole());
        return dto;
    }
}
