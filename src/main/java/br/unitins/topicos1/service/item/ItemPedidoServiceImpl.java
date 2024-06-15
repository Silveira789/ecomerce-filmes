package br.unitins.topicos1.service.item;

import java.util.List;

import br.unitins.topicos1.dto.item.ItemPedidoDTO;
import br.unitins.topicos1.dto.item.ItemResponseDTO;
import br.unitins.topicos1.model.Filme;
import br.unitins.topicos1.model.ItemPedido;
import br.unitins.topicos1.repository.FilmeRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

public class ItemPedidoServiceImpl {

    @Inject
    FilmeRepository repository;

    // @Override
    // @Transactional
    // public ItemResponseDTO insert(ItemPedidoDTO dto) {
    //     ItemPedido novoItem = new ItemPedido();
    //         novoItem.setNome(dto.getNome());
    //         novoItem.setDescricao(dto.getDescricao());
    //         novoItem.setGenero(dto.getGenero());
    //         novoItem.setAnoLancamento(dto.getAnoLancamento());
    //         novoItem.setDirecao(dto.getDirecao());
    //         novoItem.setDuracao(dto.getDuracao());
    //         novoItem.setPreco(dto.getPreco());
    //         novoItem.setQtdNoEstoque(dto.getQtdNoEstoque());
    //         novoItem.setTituloOriginal(dto.getTituloOriginal());

    //     repository.persist(novoItem);

    //     return ItemResponseDTO.valueOf(novoItem);

    // }

    // @Override
    // @Transactional
    // public ItemResponseDTO update(ItemPedidoDTO dto, Long id) {

    //     Filme filme = (Filme) repository.findById(id);

    //     if (filme != null) {
    //         filme.setNome(dto.getNome());
    //         filme.setDescricao(dto.getDescricao());
    //         filme.setGenero(dto.getGenero());
    //         filme.setAnoLancamento(dto.getAnoLancamento());
    //         filme.setDirecao(dto.getDirecao());
    //         filme.setDuracao(dto.getDuracao());
    //         filme.setPreco(dto.getPreco());
    //         filme.setQtdNoEstoque(dto.getQtdNoEstoque());
    //         filme.setTituloOriginal(dto.getTituloOriginal());

    //     } else
    //         throw new NotFoundException();
    //     return ItemResponseDTO.valueOf(filme);
    // }

    // // TRATAR ERRO DE ID INVALIDO
    // @Override
    // @Transactional
    // public void delete(Long id) {
    //     if (!repository.deleteById(id))
    //         throw new NotFoundException("Arma não encontrada para o ID: " + id);
    // }

    // @Override
    // public ItemResponseDTO findById(Long id) {
    //     if (repository.findById(id) != null)
    //         return ItemResponseDTO.valueOf(repository.findById(id));
    //     else {
    //         throw new NotFoundException("Arma não encontrada para o ID: " + id);
    //     }
    // }

    // @Override
    // public List<ItemResponseDTO> findByNome(String nome) {
    //     if (nome != null || nome == "") {
    //         return repository.findByNome(nome).stream()
    //                 .map(p -> ItemResponseDTO.valueOf(p)).toList();
    //     }
    //     throw new NotFoundException("Nome não encontrado!");
    // }

    // @Override
    // public List<ItemResponseDTO> findByAll() {
    //     return repository.listAll().stream()
    //             .map(p -> ItemResponseDTO.valueOf(p)).toList();
    // }

}
