package br.unitins.topicos1.dto.usuario;

import jakarta.validation.constraints.NotBlank;

public record AlterarSenhaUsuarioDTO(
        @NotBlank(message = "O campo nome não pode ser nulo.") 
        String senha

) {

}