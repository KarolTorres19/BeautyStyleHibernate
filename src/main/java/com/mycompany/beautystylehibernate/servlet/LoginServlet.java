package com.mycompany.beautystylehibernate.servlet;

import com.mycompany.beautystylehibernate.Cliente;
import com.mycompany.beautystylehibernate.dao.ClienteDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet encargado de procesar el inicio de sesión de los clientes.
 * Recibe el usuario y la contraseña desde el formulario de login,
 * consulta los clientes registrados y valida las credenciales.
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    // DAO utilizado para consultar la información de los clientes.
    private ClienteDAO clienteDAO = new ClienteDAO();

    /**
     * Procesa la información enviada mediante el método POST
     * desde el formulario de inicio de sesión.
     */
    
    
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtiene el usuario y la contraseña enviados desde el formulario.
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("password");

        // Variable utilizada para almacenar el cliente encontrado.
        Cliente encontrado = null;

        // Recorre los clientes registrados en la base de datos.
        for (Cliente cliente : clienteDAO.listar()) {

            // Muestra temporalmente en la consola los datos consultados.
            System.out.println("Usuario BD: " + cliente.getUsuario());
            System.out.println("Clave BD: " + cliente.getContrasena());

            // Comprueba que los datos recibidos no sean nulos
            // y compara las credenciales con las almacenadas.
            if (usuario != null
                    && contrasena != null
                    && usuario.equals(cliente.getUsuario())
                    && contrasena.equals(cliente.getContrasena())) {

                // Guarda el cliente que coincide con las credenciales.
                encontrado = cliente;
                break;
            }
        }

        // Si se encontró un cliente válido, se inicia la sesión.
        if (encontrado != null) {

            HttpSession session = request.getSession();

            // Guarda el cliente en la sesión para utilizarlo
            // en las demás páginas del sistema.
            session.setAttribute("cliente", encontrado);

            // Redirige al usuario a la página principal.
            response.sendRedirect("inicio.jsp");

        } else {

            // Si las credenciales son incorrectas,
            // se informa del error y se regresa al formulario de login.
            System.out.println("Usuario o contraseña incorrectos");
            response.sendRedirect("login.jsp?error=1");
        }
    }
}
