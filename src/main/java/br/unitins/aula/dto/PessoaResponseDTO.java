package br.unitins.topicos1.dto;

import java.util.List;

import br.unitins.topicos1.model.Pessoa;
import br.unitins.topicos1.model.Sexo;

public record PessoaResponseDTO(
    Long id,
    String nome,
    Sexo sexo,
    List<TelefoneResponseDTO> telefones
) {
    public static PessoaResponseDTO valueOf(Pessoa pessoa) {
        List<TelefoneResponseDTO> lista = pessoa.getListaTelefone()
                                            .stream()
                                            .map(TelefoneResponseDTO::valueOf)
                                            .toList();
        return new PessoaResponseDTO(
            pessoa.getId(), 
            pessoa.getNome(), 
            pessoa.getSexo(),
            lista);
    }
    
}
