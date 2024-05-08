package br.unitins.topicos1.dto.aula;

import br.unitins.topicos1.model.aula.Estado;

public record EstadoResponseDTO(
    Long id,
    String nome,
    String sigla
) {
    public static EstadoResponseDTO valueOf(Estado estado) {
        return new EstadoResponseDTO(
            estado.getId(), 
            estado.getNome(), 
            estado.getSigla());
    }
    
}
