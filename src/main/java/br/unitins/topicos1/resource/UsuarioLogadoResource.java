package br.unitins.topicos1.resource;

import java.io.IOException;
import java.util.logging.Logger;

import org.eclipse.microprofile.jwt.JsonWebToken;
// import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.unitins.topicos1.dto.usuario.AlterarSenhaUsuarioDTO;
import br.unitins.topicos1.service.usuario.UsuarioService;
import io.quarkus.logging.Log;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;


@Path("/usuariologado")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@APIResponse(responseCode = "403", description = "Você não tem permissão para acessar esse recurso.")
public class UsuarioLogadoResource {

    @Inject
    JsonWebToken jwt;

    @Inject
    UsuarioService usuarioService;

    @GET
    @RolesAllowed({ "User", "Admin" })
    public Response getUsuario() {

        // Obtendo o login pelo token jwt
        String login = jwt.getSubject();
        Log.info("Pegando o usuario logado string: " + login);
        Log.info("Pegando o usuário logado");
        return Response.ok(usuarioService.findByLogin(login)).build();
    }

     @Path("/usuariologado")
    @PUT
    @RolesAllowed({"User", "Admin"})
    public Response putInfos(AlterarSenhaUsuarioDTO senhaUsuarioDTO){
        String login = jwt.getSubject();
        Log.info("Pegando o usuario logado string: " + login);
        Log.info("Alterando a senha do usuário logado");
        usuarioService.alterarSenha(senhaUsuarioDTO, login);
        return Response.noContent().build();
    }

}

