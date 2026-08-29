package com.mycompany.beautystylehibernate.servlet;

import com.mycompany.beautystylehibernate.Cita;
import com.mycompany.beautystylehibernate.Cliente;
import com.mycompany.beautystylehibernate.Estilista;
import com.mycompany.beautystylehibernate.Servicio;
import com.mycompany.beautystylehibernate.dao.CitaDAO;
import com.mycompany.beautystylehibernate.dao.ServicioDAO;
import com.mycompany.beautystylehibernate.dao.EstilistaDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Servlet encargado de procesar la información del formulario
 * utilizado para agendar una nueva cita.
 */
@WebServlet("/AgendarCitasServlet")
public class AgendarCitasServlet extends HttpServlet {

    // DAO utilizado para guardar y gestionar las citas.
    private CitaDAO citaDAO = new CitaDAO();

    // DAO utilizado para consultar los servicios disponibles.
    private ServicioDAO servicioDAO = new ServicioDAO();

    // DAO utilizado para consultar los estilistas registrados.
    private EstilistaDAO estilistaDAO = new EstilistaDAO();

    /**
     * Procesa la información enviada mediante el método POST
     * desde el formulario para agendar una cita.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            // Obtiene la sesión actual del usuario.
            HttpSession session = request.getSession();

            // Obtiene el cliente que inició sesión.
            Cliente cliente = (Cliente) session.getAttribute("cliente");

            // Obtiene la fecha enviada desde el formulario.
            LocalDate fecha = LocalDate.parse(
                    request.getParameter("fecha")
            );

            // Obtiene la hora enviada desde el formulario.
            LocalTime hora = LocalTime.parse(
                    request.getParameter("hora")
            );

            // Obtiene el ID del servicio seleccionado.
            Integer idServicio = Integer.parseInt(
                    request.getParameter("servicio")
            );

            // Busca en la base de datos el servicio seleccionado.
            Servicio servicio = servicioDAO.buscarPorId(idServicio);

            // Selecciona un estilista registrado en la base de datos.
            Estilista estilista = estilistaDAO.buscarPorId(1);

            // Crea una nueva instancia de Cita.
            Cita cita = new Cita();

            // Asigna la fecha de la cita.
            cita.setFecha(fecha);

            // Asigna la hora de la cita.
            cita.setHora(hora);

            // Establece el estado inicial de la cita.
            cita.setEstado("confirmada");

            // Asocia la cita con el cliente que inició sesión.
            cita.setCliente(cliente);

            // Asocia la cita con el servicio seleccionado.
            cita.setServicio(servicio);

            // Asocia la cita con el estilista.
            cita.setEstilista(estilista);

            // Guarda la nueva cita utilizando Hibernate mediante el DAO.
            citaDAO.guardar(cita);

            // Si el registro fue exitoso, regresa a la página de inicio.
            response.sendRedirect("inicio.jsp");

        } catch (Exception e) {

            // Muestra en la consola cualquier error ocurrido durante el proceso.
            e.printStackTrace();

            // Si ocurre un error, regresa al formulario de agendamiento.
            response.sendRedirect("agendar.jsp");
        }
    }
}
