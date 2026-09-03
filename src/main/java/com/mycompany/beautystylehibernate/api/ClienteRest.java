package com.mycompany.beautystylehibernate.api;

import com.mycompany.beautystylehibernate.Cliente;
import com.mycompany.beautystylehibernate.dao.ClienteDAO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 * Servicio REST para consultar y registrar clientes
 * en el sistema Beauty Style.
 */
@Path("clientes")
public class ClienteRest {

    private ClienteDAO clienteDAO = new ClienteDAO();

    /**
     * Consulta todos los clientes registrados.
     *
     * @return lista de clientes en formato JSON.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> listarClientes() {

        return clienteDAO.listar();
    }

    /**
     * Registra un nuevo cliente en el sistema.
     *
     * @param cliente datos del cliente recibidos en formato JSON.
     * @return mensaje indicando si el registro fue exitoso.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarCliente(Cliente cliente) {

        // Guarda el nuevo cliente utilizando el DAO.
        clienteDAO.guardar(cliente);

        // Devuelve una respuesta indicando que el registro fue exitoso.
        return Response.status(Response.Status.CREATED)
                .entity("{\"mensaje\":\"Registro exitoso\"}")
                .build();
    }
}