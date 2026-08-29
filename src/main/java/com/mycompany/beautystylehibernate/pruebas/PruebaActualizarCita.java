package com.mycompany.beautystylehibernate.pruebas;

import com.mycompany.beautystylehibernate.Cita;
import com.mycompany.beautystylehibernate.dao.CitaDAO;

public class PruebaActualizarCita {

    public static void main(String[] args) {

        CitaDAO dao = new CitaDAO();

        Cita cita = dao.buscarPorId(3);

        if (cita != null) {

            cita.setEstado("Atendida");

            dao.actualizar(cita);

            System.out.println("Cita actualizada correctamente");

        } else {

            System.out.println("No se encontró la cita");
        }
    }
}