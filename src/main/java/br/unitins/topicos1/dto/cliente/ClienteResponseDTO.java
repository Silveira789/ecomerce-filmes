package br.unitins.topicos1.dto.cliente;

import java.util.List;

import br.unitins.topicos1.dto.endereco.EnderecoResponseDTO;
import br.unitins.topicos1.dto.usuario.UsuarioResponseDTO;
import br.unitins.topicos1.model.Cliente;


public record ClienteResponseDTO(
        Long id,
        String nome,
        String cpf,
        UsuarioResponseDTO usuario) {

public static ClienteResponseDTO valueOf(Cliente cliente) {
        return new ClienteResponseDTO(
                        cliente.getId(),
                        cliente.getNome(),
                        cliente.getCpf(),
                        // cliente.getNumeroRegistro_posse_porte(),
                        UsuarioResponseDTO.valueOf(cliente.getUsuario()));

}
}