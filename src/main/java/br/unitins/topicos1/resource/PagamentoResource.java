package br.unitins.topicos1.resource;


import br.unitins.topicos1.dto.pagamento.PagamentoDTO;
import br.unitins.topicos1.dto.pagamento.PagamentoResponseDTO;
import br.unitins.topicos1.service.pagamento.PagamentoService;
import io.quarkus.logging.Log;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/pagamentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PagamentoResource {

    @Inject
    PagamentoService service;

    @POST
    @RolesAllowed({"Admin"})
    public PagamentoResponseDTO insert(PagamentoDTO dto) {
        Log.info("Cadastrando um pagamento.");
        return service.insert(dto);
    }
    
    @GET
    public Response findAll() {
        Log.info("Busca de todos os pagamentos");
        return Response.ok(service.findByAll()).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({ "Admin" })
    public Response findById(@PathParam("id") Long id) {
        Log.info("Busca de um pagamento especificado pelo id");
        return Response.ok(service.findById(id)).build();
    }
}