package br.unitins.topicos1.service.item;

import java.util.List;

import br.unitins.topicos1.dto.item.ItemPedidoDTO;
import br.unitins.topicos1.dto.item.ItemPedidoResponseDTO;



public interface ItemPedidoService {
    
    public ItemPedidoResponseDTO insert(ItemPedidoDTO dto);

    public ItemPedidoResponseDTO update(ItemPedidoDTO dto, Long id);

    public void delete(Long id);

    public ItemPedidoResponseDTO findById(Long id);

    public List<ItemPedidoResponseDTO> findByNome(String nome);

    public List<ItemPedidoResponseDTO> findByAll(); 

    
}