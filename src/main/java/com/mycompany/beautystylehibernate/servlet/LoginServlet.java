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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private ClienteDAO clienteDAO = new ClienteDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("password");

        Cliente encontrado = null;

        for (Cliente cliente : clienteDAO.listar()) {

            System.out.println("Usuario BD: " + cliente.getUsuario());
            System.out.println("Clave BD: " + cliente.getContrasena());

            if (usuario != null
                    && contrasena != null
                    && usuario.equals(cliente.getUsuario())
                    && contrasena.equals(cliente.getContrasena())) {

                encontrado = cliente;
                break;
            }
        }

        if (encontrado != null) {

            HttpSession session = request.getSession();

            session.setAttribute("cliente", encontrado);

            response.sendRedirect("inicio.jsp");

        } else {

            System.out.println("Usuario o contraseña incorrectos");
            response.sendRedirect("login.jsp?error=1");
        }
    }
}