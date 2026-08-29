package com.mycompany.beautystylehibernate.servlet;

import com.mycompany.beautystylehibernate.Cliente;
import com.mycompany.beautystylehibernate.Cita;
import com.mycompany.beautystylehibernate.dao.CitaDAO;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/MisCitasServlet")
public class MisCitasServlet extends HttpServlet {

    private CitaDAO citaDAO = new CitaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener la sesión actual del cliente.
        HttpSession session = request.getSession();

        // Recuperar el cliente que inició sesión.
        Cliente cliente = (Cliente) session.getAttribute("cliente");

        if (cliente != null) {

            // Consultar solamente las citas del cliente.
            List<Cita> citas = citaDAO.listarPorCliente(
                    cliente.getId_cliente()
            );

            // Enviar las citas a la página JSP.
            request.setAttribute("citas", citas);

            // Mostrar la página de Mis citas.
            request.getRequestDispatcher("mis-citas.jsp")
                    .forward(request, response);

        } else {

            // Si no existe una sesión, volver al inicio de sesión.
            response.sendRedirect("login.jsp");
        }
    }
}