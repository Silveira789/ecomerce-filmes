package br.unitins.topicos1.service.pedido;


import br.unitins.topicos1.dto.pedido.PedidoResponseDTO;
import br.unitins.topicos1.repository.PedidoRepository;
import br.unitins.topicos1.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.util.List;


@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {

    @Inject
    JsonWebToken jwt;
    
    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    PedidoRepository pedidoRepository;

    @Override
    public void delete(Long id) {
        pedidoRepository.deleteById(id);
    }

    @Override
    public List<PedidoResponseDTO> findByAll() {
        return pedidoRepository.listAll().stream()
                .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public PedidoResponseDTO findById(Long id) {
        if (pedidoRepository.findById(id) != null)
            return PedidoResponseDTO.valueOf(pedidoRepository.findById(id));
        else {
            throw new NotFoundException("Arma não encontrada para o ID: " + id);
        }
    }
}