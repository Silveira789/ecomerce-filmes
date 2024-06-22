package br.unitins.topicos1.dto.filme;

import br.unitins.topicos1.model.Filme;

public record FilmeResponseDTO(
        long id,
        String nome,
        String descricao,
        Double preco,
        int qtdNoEstoque,
        String genero,
        int duracao,
        String AnoLancamento,
        String direcao,
        String nomeImagem,
        String TituloOriginal

) {
    public static FilmeResponseDTO valueOf(Filme filme) {
        return new FilmeResponseDTO(filme.getId(),
                filme.getNome(),
                filme.getDescricao(),
                filme.getPreco(),
                filme.getQtdNoEstoque(),
                filme.getGenero(),
                filme.getDuracao(),
                filme.getAnoLancamento(),
                filme.getDirecao(),
                filme.getNomeImagem(),
                filme.getTituloOriginal());

    }

}
