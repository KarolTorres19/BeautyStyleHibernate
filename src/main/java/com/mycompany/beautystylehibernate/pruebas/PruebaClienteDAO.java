package com.mycompany.beautystylehibernate.pruebas;

import com.mycompany.beautystylehibernate.Cliente;
import com.mycompany.beautystylehibernate.dao.ClienteDAO;
import java.util.List;

public class PruebaClienteDAO {

    public static void main(String[] args) {

        ClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();

        cliente.setNombre("Carlos");
        cliente.setApellido("Gomez");
        cliente.setTelefono("3000000000");
        cliente.setCorreo("carlos@gmail.com");
        cliente.setUsuario("carlos123");
        cliente.setContrasena("12345");

        dao.guardar(cliente);

        System.out.println("Cliente guardado correctamente");


        List<Cliente> clientes = dao.listar();

        for (Cliente c : clientes) {

            System.out.println(
                c.getId_cliente() + " - " +
                c.getNombre() + " " +
                c.getApellido()
            );
        }
    }
}