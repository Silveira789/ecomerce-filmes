package br.unitins.topicos1.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoFilme {

    ACAO(1,"Ação"),
    AVENTURA(2,"Aventura"),
    COMEDIA(3,"Comédia"),
    DRAMA(4,"Drama"),
    FICCAO_CIENTIFICA(5,"Ficção Científica"),
    ROMANCE(6,"Romance"),
    SUSPENSE(7,"Suspense"),
    DOCUMENTARIO(8,"Documentário"),
    FANTASIA(9,"Fantasia"),
    MUSICAL(10,"Musical"),
    THRILLER(11, "Thriller"),
    TERROR(12,"Terror");

    private final Integer id;
    private final String label;

    private TipoFilme(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public static TipoFilme valueOf(Integer id) {
        for (TipoFilme TipoFilme : values()) {
            if (TipoFilme.id == id) {
                return TipoFilme;
            }
        }
        throw new IllegalArgumentException("Nenhum TipoFilme encontrado com o ID: " + id);
    }



}
