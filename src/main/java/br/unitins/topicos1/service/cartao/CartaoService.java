package br.unitins.topicos1.service.cartao;

import java.util.List;

import br.unitins.topicos1.dto.cartao.CartaoDTO;
import br.unitins.topicos1.dto.cartao.CartaoResponseDTO;




public interface CartaoService {
        public CartaoResponseDTO insert(CartaoDTO dto);

    public CartaoResponseDTO update(CartaoDTO dto, Long id);

    public void delete(Long id);

    public CartaoResponseDTO findById(Long id);
    
    public List<CartaoResponseDTO> findByBanco(String banco);

    public List<CartaoResponseDTO> findByAll();
}
