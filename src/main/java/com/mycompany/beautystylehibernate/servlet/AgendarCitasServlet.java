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


@WebServlet("/AgendarCitasServlet")
public class AgendarCitasServlet extends HttpServlet {


    private CitaDAO citaDAO = new CitaDAO();
    private ServicioDAO servicioDAO = new ServicioDAO();
    private EstilistaDAO estilistaDAO = new EstilistaDAO();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        try {

            // Obtener cliente que inició sesión
            HttpSession session = request.getSession();

            Cliente cliente = (Cliente) session.getAttribute("cliente");


            // Obtener datos del formulario
            LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));

            LocalTime hora = LocalTime.parse(request.getParameter("hora"));

            Integer idServicio = Integer.parseInt(
                    request.getParameter("servicio")
            );


            // Buscar servicio seleccionado
            Servicio servicio = servicioDAO.buscarPorId(idServicio);


            // Seleccionar un estilista existente
            Estilista estilista = estilistaDAO.buscarPorId(1);


            // Crear la cita
            Cita cita = new Cita();

            cita.setFecha(fecha);

            cita.setHora(hora);

            cita.setEstado("confirmada");

            cita.setCliente(cliente);

            cita.setServicio(servicio);

            cita.setEstilista(estilista);


            // Guardar usando Hibernate
            citaDAO.guardar(cita);


            response.sendRedirect("inicio.jsp");


        } catch (Exception e) {

            e.printStackTrace();

            response.sendRedirect("agendar.jsp");

        }

    }

}