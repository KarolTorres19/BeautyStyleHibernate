package com.mycompany.beautystylehibernate.pruebas;

import com.mycompany.beautystylehibernate.Servicio;
import com.mycompany.beautystylehibernate.dao.ServicioDAO;
import java.util.List;

public class PruebaServicioDAO {

    public static void main(String[] args) {

        ServicioDAO dao = new ServicioDAO();

        Servicio servicio = new Servicio();

        servicio.setNombre_servicio("Manicure");
        servicio.setDescripcion("Manicure tradicional");
        servicio.setPrecio(18000.0);

        dao.guardar(servicio);

        System.out.println("Servicio guardado correctamente");


        List<Servicio> servicios = dao.listar();

        for (Servicio s : servicios) {

            System.out.println(
                s.getId_servicio() + " - " +
                s.getNombre_servicio()
            );
        }
    }
}