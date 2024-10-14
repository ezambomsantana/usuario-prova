package br.insper.usuario.repository;

import br.insper.usuario.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, Integer> {

    Optional<Usuario> findByCpf(String cpf);

    Optional<Usuario> findByEmailAndPassword(String email, String password);
}
