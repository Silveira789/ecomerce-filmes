package br.unitins.topicos1.dto.filme;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class FilmeDTO extends ProdutoDTO {
    @NotNull(message = "Insira qual o gênero do filme correspondente.")
    private String genero;
    @NotNull(message = "Insira a duração do filme corretamente.")
    private int duracao;
    @NotNull(message = "Insira o ano de lançamento corretamente.")
    private String AnoLancamento;
    @NotNull(message = "Insira o nome dos diretores correspondentes corretamente.")
    private String direcao;
    @NotNull(message = "Insira o Título original do filme corretamente.")
    private String TituloOriginal;

    public FilmeDTO(
            @NotBlank(message = "insira o nome corretamente") String nome,
            @NotNull(message = "insira a qtdNoEstoque corretamente") int qtdNoEstoque,
            @NotNull(message = "insira o preco corretamente") double preco,
            @NotBlank(message = "insira a descrição corretamente") String descricao,
            @NotNull(message = "insira o 'gênero' corretamente") String genero,
            @NotNull(message = "insira a 'duração' corretamente") int duracao,
            @NotNull(message = "insira o 'AnoLancamento' corretamente") String AnoLancamento,
            @NotNull(message = "insira a 'direcao' corretamente") String direcao,
            @NotNull(message = "insira o 'TituloOriginal' corretamente") String TituloOriginal) {
        super(nome, qtdNoEstoque, preco, descricao);
        this.genero = genero;
        this.duracao = duracao;
        this.AnoLancamento = AnoLancamento;
        this.direcao = direcao;
        this.TituloOriginal = TituloOriginal;
    }

}
