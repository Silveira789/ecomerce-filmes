package br.unitins.topicos1.service.filme;

import java.util.List;

import br.unitins.topicos1.dto.filme.FilmeDTO;
import br.unitins.topicos1.dto.filme.FilmeResponseDTO;

public interface FilmeService {
    
    public FilmeResponseDTO insert(FilmeDTO dto);

    public FilmeResponseDTO update(FilmeDTO dto, Long id);

    public void delete(Long id);

    public FilmeResponseDTO findById(Long id);

    public List<FilmeResponseDTO> findByNome(String nome);

    public List<FilmeResponseDTO> findByAll(); 

    
}