package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Filme;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NoResultException;

@ApplicationScoped 
public class FilmeRepository implements PanacheRepository<Filme>{
    public List<Filme> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1) ", "%"+nome.toUpperCase()+"%").list();
    }

    public Filme findById(Long id) {
        try {
            return find("id = ?1", id).singleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }
}
