package com.mycompany.beautystylehibernate.pruebas;

import com.mycompany.beautystylehibernate.Estilista;
import com.mycompany.beautystylehibernate.dao.EstilistaDAO;
import java.util.List;

public class PruebaEstilistaDAO {

    public static void main(String[] args) {

        EstilistaDAO dao = new EstilistaDAO();

        Estilista estilista = new Estilista();

        estilista.setNombre("Maria Lopez");
        estilista.setEspecialidad("Color y peinados");
        estilista.setTelefono("3155555555");

        dao.guardar(estilista);

        System.out.println("Estilista guardada correctamente");

        List<Estilista> estilistas = dao.listar();

        for (Estilista e : estilistas) {

            System.out.println(
                e.getId_estilista() + " - " +
                e.getNombre()
            );
        }
    }
}