package com.mycompany.beautystylehibernate;

import com.mycompany.beautystylehibernate.dao.CitaDAO;
import java.util.List;

public class PruebaCitaDAO {

    public static void main(String[] args) {

        CitaDAO dao = new CitaDAO();

        List<Cita> citas = dao.listar();

        for (Cita c : citas) {

            System.out.println(
                c.getId_cita() + " - " +
                c.getEstado()
            );
        }
    }
}