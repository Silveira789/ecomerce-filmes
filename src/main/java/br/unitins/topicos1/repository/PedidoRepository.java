package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Pedido;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PedidoRepository implements PanacheRepository<Pedido> {

    public List<Pedido> findAll(String login) {
        return find("pessoa.login = ?1", login).list();
    }
    
    public List<Pedido> findAll(Long idPessoa) {
        return find("pessoa.id = ?1", idPessoa).list();
    }
}