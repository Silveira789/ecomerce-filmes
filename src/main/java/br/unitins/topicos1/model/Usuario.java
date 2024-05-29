package br.unitins.topicos1.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Usuario extends DefaultEntity {

    private String login;
    private String senha;

    private Perfil perfil;

}
