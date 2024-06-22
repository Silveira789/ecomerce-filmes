package br.unitins.topicos1.service.filme;

import java.util.List;

import br.unitins.topicos1.dto.filme.FilmeDTO;
import br.unitins.topicos1.dto.filme.FilmeResponseDTO;
import br.unitins.topicos1.model.Filme;
import br.unitins.topicos1.repository.FilmeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class FilmeServiceImpl implements FilmeService {

    @Inject
    FilmeRepository repository;

    @Override
    @Transactional
    public FilmeResponseDTO insert(FilmeDTO dto) {
        Filme novoFilme = new Filme();
        novoFilme.setNome(dto.getNome());
        novoFilme.setDescricao(dto.getDescricao());
        novoFilme.setGenero(dto.getGenero());
        novoFilme.setAnoLancamento(dto.getAnoLancamento());
        novoFilme.setDirecao(dto.getDirecao());
        novoFilme.setDuracao(dto.getDuracao());
        novoFilme.setPreco(dto.getPreco());
        novoFilme.setQtdNoEstoque(dto.getQtdNoEstoque());
        novoFilme.setTituloOriginal(dto.getTituloOriginal());

        repository.persist(novoFilme);

        return FilmeResponseDTO.valueOf(novoFilme);

    }

    @Override
    @Transactional
    public FilmeResponseDTO update(FilmeDTO dto, Long id) {

        Filme filme = (Filme) repository.findById(id);

        if (filme != null) {
            filme.setNome(dto.getNome());
            filme.setDescricao(dto.getDescricao());
            filme.setGenero(dto.getGenero());
            filme.setAnoLancamento(dto.getAnoLancamento());
            filme.setDirecao(dto.getDirecao());
            filme.setDuracao(dto.getDuracao());
            filme.setPreco(dto.getPreco());
            filme.setQtdNoEstoque(dto.getQtdNoEstoque());
            filme.setTituloOriginal(dto.getTituloOriginal());

        } else
            throw new NotFoundException();
        return FilmeResponseDTO.valueOf(filme);
    }

    // TRATAR ERRO DE ID INVALIDO
    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException("Filme não encontrada para o ID: " + id);
    }

    @Override
    public FilmeResponseDTO findById(Long id) {
        if (repository.findById(id) != null)
            return FilmeResponseDTO.valueOf(repository.findById(id));
        else {
            throw new NotFoundException("Filme não encontrada para o ID: " + id);
        }
    }

    @Override
    public List<FilmeResponseDTO> findByNome(String nome) {
        if (nome != null || nome == "") {
            return repository.findByNome(nome).stream()
                    .map(p -> FilmeResponseDTO.valueOf(p)).toList();
        }
        throw new NotFoundException("Nome não encontrado!");
    }

    @Override
    public List<FilmeResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(p -> FilmeResponseDTO.valueOf(p)).toList();
    }

    @Override
    public FilmeResponseDTO updateNomeImagem(Long id, String nomeImagem) {
        Filme filme = repository.findById(id);
        filme.setNomeImagem(nomeImagem);
        return FilmeResponseDTO.valueOf(filme);
    }

}
