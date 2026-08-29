package com.mycompany.beautystylehibernate;

import com.mycompany.beautystylehibernate.dao.CitaDAO;

public class PruebaEliminarCita {

    public static void main(String[] args) {

        CitaDAO dao = new CitaDAO();

        dao.eliminar(3);

        System.out.println("Cita eliminada correctamente");
    }
}