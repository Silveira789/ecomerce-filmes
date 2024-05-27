package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Cartao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class CartaoRepository implements PanacheRepository<Cartao> {
    public List<Cartao> findByBanco(String banco) {
        return find("UPPER(banco) LIKE UPPER(?1)", "%" + banco + "%").list();
    }
}
