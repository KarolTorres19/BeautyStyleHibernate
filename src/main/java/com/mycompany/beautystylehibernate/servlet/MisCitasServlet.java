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

/**
 * Servlet encargado de consultar y mostrar las citas
 * correspondientes al cliente que inició sesión.
 */
@WebServlet("/MisCitasServlet")
public class MisCitasServlet extends HttpServlet {

    // DAO utilizado para consultar las citas almacenadas.
    private CitaDAO citaDAO = new CitaDAO();

    /**
     * Procesa las solicitudes realizadas mediante el método GET.
     * Consulta las citas del cliente y las envía a la página JSP.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtiene la sesión actual del cliente.
        HttpSession session = request.getSession();

        // Recupera el cliente que inició sesión.
        Cliente cliente = (Cliente) session.getAttribute("cliente");

        // Comprueba que exista un cliente en la sesión.
        if (cliente != null) {

            // Consulta solamente las citas pertenecientes al cliente.
            List<Cita> citas = citaDAO.listarPorCliente(
                    cliente.getId_cliente()
            );

            // Envía la lista de citas a la página JSP.
            request.setAttribute("citas", citas);

            // Redirige la solicitud a la página donde se muestran
            // las citas del cliente.
            request.getRequestDispatcher("mis-citas.jsp")
                    .forward(request, response);

        } else {

            // Si no existe una sesión activa, se redirige al login.
            response.sendRedirect("login.jsp");
        }
    }
}
