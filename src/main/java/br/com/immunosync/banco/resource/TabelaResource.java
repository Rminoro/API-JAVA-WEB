package br.com.immunosync.banco.resource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.immunosync.banco.exception.BadInfoException;
import br.com.immunosync.banco.exception.IdNotFoundException;
import br.com.immunosync.banco.factory.ConnectionFactory;
import br.com.immunosync.banco.service.PacienteService;
import br.com.immunosync.banco.service.TabelaService;
import br.com.immunosync.model.Paciente;
import br.com.immunosync.model.Tabela;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("/tabela")
public class TabelaResource {

    private TabelaService service;

    public TabelaResource() throws ClassNotFoundException, SQLException {
        this.service = new TabelaService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response lista() {
        try {
            List<Tabela> tabelas = service.listarTabelas();
            return Response.ok(tabelas).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response busca(@PathParam("id") int codigo) throws ClassNotFoundException, SQLException {
        try {
            return Response.ok(service.pesquisaTabelaPorId(codigo)).build();
        } catch (IdNotFoundException e) {
            return Response.status(Status.NOT_FOUND).build();
        }
    }
    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response lista(@Context jakarta.servlet.http.HttpServletResponse response) throws ClassNotFoundException, SQLException {     
    	return Response.ok(service.listarTabelas()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrar(Tabela tabela, @Context UriInfo uri) throws ClassNotFoundException, SQLException {
        try {
            service.cadastrarTabela(tabela);
            UriBuilder uriBuilder = uri.getAbsolutePathBuilder();
            uriBuilder.path(String.valueOf(tabela.getId()));
            return Response.created(uriBuilder.build()).build();
        } catch (BadInfoException e) {
            e.printStackTrace();
            return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizar(Tabela tabela, @PathParam("id") int codigo) throws ClassNotFoundException, SQLException {
        try {
        	tabela.setId(codigo);
            service.atualizarTabela(tabela);
            return Response.ok().build();
        } catch (BadInfoException e) {
            return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response remover(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        service.removerTabela(id);
		return Response.noContent().build();
    }
}

