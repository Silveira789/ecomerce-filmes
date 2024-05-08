package br.unitins.topicos1.dto.aula;

import br.unitins.topicos1.model.aula.Cidade;

public record CidadeResponseDTO(
    Long id,
    String nome,
    EstadoResponseDTO estado
) {
    public static CidadeResponseDTO valueOf(Cidade cidade) {
        return new CidadeResponseDTO(
            cidade.getId(), 
            cidade.getNome(), 
            EstadoResponseDTO.valueOf(cidade.getEstado()));
    }
    
}
