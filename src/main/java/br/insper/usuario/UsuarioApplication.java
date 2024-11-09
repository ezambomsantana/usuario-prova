package br.insper.usuario;

import br.insper.usuario.dto.CreateUsuarioDTO;
import br.insper.usuario.model.Usuario;
import br.insper.usuario.repository.UsuarioRepository;
import br.insper.usuario.service.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioApplication.class, args);
	}


	@Bean
	public CommandLineRunner loadData(UsuarioService usuarioService) {
		return args -> {

			CreateUsuarioDTO usuario = new CreateUsuarioDTO();
			usuario.setNome("Teste");
			usuario.setCpf("123");
			usuario.setPassword("teste");
			usuario.setEmail("teste@teste.com");

			usuarioService.createUser(usuario);

			CreateUsuarioDTO usuario2 = new CreateUsuarioDTO();
			usuario2.setNome("Teste 2");
			usuario2.setCpf("123");
			usuario2.setPassword("teste2");
			usuario2.setEmail("teste2@teste.com");

			usuarioService.createUser(usuario2);
		};
	}

}
