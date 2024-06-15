package br.unitins.topicos1.dto.filme;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class FilmeDTO extends ProdutoDTO{

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

    public FilmeDTO(@NotBlank(
        @NotNull(message = "Insira qual o gênero do filme correspondente.") String genero,
        @NotNull(message = "Insira a duração do filme corretamente."),
        @NotNull(message = "Insira o ano de lançamento corretamente."),
        @NotNull(message = "Insira o nome dos diretores correspondentes corretamente."),
        @NotNull(message = "Insira o Título original do filme corretamente."),





    )){
        super(nome,qtdNoEstoque,preco,descricao);
        this.genero = genero;
        this.duracao = duracao;
        this.AnoLancamento = AnoLancamento;
        this.direcao = direcao;
        this.TituloOriginal = TituloOriginal; 
    }

}
