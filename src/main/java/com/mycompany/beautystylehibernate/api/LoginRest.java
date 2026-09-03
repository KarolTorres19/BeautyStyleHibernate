package com.mycompany.beautystylehibernate.api;

import com.mycompany.beautystylehibernate.Cliente;
import com.mycompany.beautystylehibernate.dao.ClienteDAO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * Servicio REST para la autenticación de clientes
 * registrados en el sistema Beauty Style.
 */
@Path("login")
public class LoginRest {

    // DAO encargado de consultar los clientes registrados.
    private ClienteDAO clienteDAO = new ClienteDAO();

    /**
     * Endpoint para validar el usuario y la contraseña.
     *
     * @param usuario nombre de usuario recibido desde la solicitud.
     * @param contrasena contraseña recibida desde la solicitud.
     * @return respuesta indicando si la autenticación fue exitosa o no.
     */
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(
            @jakarta.ws.rs.FormParam("usuario") String usuario,
            @jakarta.ws.rs.FormParam("contrasena") String contrasena) {

        // Recorre los clientes registrados en la base de datos.
        for (Cliente cliente : clienteDAO.listar()) {

            // Comprueba que el usuario y la contraseña coincidan.
            if (usuario != null
                    && contrasena != null
                    && usuario.equals(cliente.getUsuario())
                    && contrasena.equals(cliente.getContrasena())) {

                // Devuelve un mensaje de autenticación satisfactoria.
                return Response.ok(
                        "{\"mensaje\":\"Inicio de sesión exitoso\", \"cliente\":\""
                        + cliente.getNombre() + " " + cliente.getApellido()
                        + "\"}"
                ).build();
            }
        }

        // Devuelve un error cuando las credenciales no son correctas.
        return Response.status(Response.Status.UNAUTHORIZED)
                .entity("{\"mensaje\":\"Usuario o contraseña incorrectos\"}")
                .build();
    }
}