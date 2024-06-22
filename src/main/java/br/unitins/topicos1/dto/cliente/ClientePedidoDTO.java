package br.unitins.topicos1.dto.cliente;

import br.unitins.topicos1.dto.usuario.UsuarioResponseDTO;
import br.unitins.topicos1.model.Cliente;

public record ClientePedidoDTO(
                Long id,
                String nome,
                String cpf,
                UsuarioResponseDTO usuario) {

        public static ClientePedidoDTO valueOf(Cliente cliente) {
                return new ClientePedidoDTO(
                                cliente.getId(),
                                cliente.getNome(),
                                cliente.getCpf(),
                                UsuarioResponseDTO.valueOf(cliente.getUsuario()));

        }
}