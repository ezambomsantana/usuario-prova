package br.insper.usuario.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUsuarioDTO {
    private String cpf;
    private String role;
}
