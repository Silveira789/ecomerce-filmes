package br.unitins.topicos1.service.item;

import java.util.List;

import br.unitins.topicos1.dto.item.ItemPedidoDTO;
import br.unitins.topicos1.dto.item.ItemResponseDTO;



public interface ItemPedidoService {
    
    public ItemPedidoService insert(ItemPedidoDTO dto);

    public ItemResponseDTO update(ItemPedidoDTO dto, Long id);

    public void delete(Long id);

    public ItemResponseDTO findById(Long id);

    public List<ItemResponseDTO> findByNome(String nome);

    public List<ItemResponseDTO> findByAll(); 

    
}