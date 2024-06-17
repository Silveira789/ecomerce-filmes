package br.unitins.topicos1.model;

import lombok.Getter;

@Getter
public enum Perfil {

    USER(1, "User"),
    ADMIN(2, "Admin"),
    CLIENTE(3, "Cliente");

    private final Integer id;
    private final String label;

    Perfil(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public static Perfil valueOf(Integer id) throws IllegalArgumentException {
        if (id == null)
            return null;
        for (Perfil perfil : Perfil.values()) {
            if (perfil.getId().equals(id))
                return perfil;
        }
        throw new IllegalArgumentException("Id inválido" + id);
    }

}
