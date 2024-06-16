package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.endereco.EnderecoDTO;
import br.unitins.topicos1.dto.endereco.EnderecoResponseDTO;
import br.unitins.topicos1.dto.item.ItemPedidoDTO;
import br.unitins.topicos1.dto.item.ItemPedidoResponseDTO;
import br.unitins.topicos1.service.endereco.EnderecoService;
import br.unitins.topicos1.service.filme.FilmeService;
import br.unitins.topicos1.service.item.ItemPedidoService;
import io.quarkus.logging.Log;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/itens")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemPedidoResource {

    @Inject
    ItemPedidoService  service;

    @POST
    @RolesAllowed({"Admin"})
    public ItemPedidoResponseDTO insert(ItemPedidoDTO dto) {
        Log.info("Cadastrando um filme.");
        return service.insert(dto);
    }

    //     @POST
    //     @RolesAllowed({ "Admin" })
    //     public ItemResponseDTO insert(ItemPedidoDTO dto) {
    //         Log.info("Cadastrando um item.");
    //         return service.insert(dto);
    //     }

    //     @PUT
    //     @Transactional
    //     @Path("/{id}")
    //     @RolesAllowed({ "Admin" })
    //     public ItemResponseDTO update(ItemPedidoDTO dto, @PathParam("id") Long id) {
    //         Log.info("Atualizando os dados de um filme.");
    //         return service.update(dto, id);
    //     }

    //     @DELETE
    //     @Transactional
    //     @Path("/{id}")
    //     @RolesAllowed({ "Admin" })
    //     public void delete(@PathParam("id") Long id) {
    //         Log.info("Filme deletado.");
    //         service.delete(id);
    //     }

    //     @GET
    //     public Response findAll() {
    //         Log.info("Busca de todos os filmes");
    //         return Response.ok(service.findByAll()).build();
    //     }

    //     @GET
    //     @Path("/{id}")
    //     @RolesAllowed({ "Admin" })
    //     public Response findById(@PathParam("id") Long id) {
    //         Log.info("Busca de um filme expecificado pelo id");
    //         return Response.ok(service.findById(id)).build();
    //     }

    //     @GET
    //     @Path("/search/nome/{nome}")
    //     public Response findByNome(@PathParam("nome") String nome) {
    //         Log.info("Busca de uma filme expecificado pelo nome");
    //         return Response.ok(service.findByNome(nome)).build();
    //     }

    }

