package com.mycompany.beautystylehibernate.dao;

import com.mycompany.beautystylehibernate.Cliente;
import com.mycompany.beautystylehibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * DAO encargado de realizar las operaciones de acceso
 * y persistencia de los clientes utilizando Hibernate.
 */
public class ClienteDAO {

    // Guarda un nuevo cliente en la base de datos.
    public void guardar(Cliente cliente) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // Inicia la transacción.
            transaction = session.beginTransaction();

            // Persiste el cliente en la tabla correspondiente.
            session.persist(cliente);

            // Confirma los cambios realizados.
            transaction.commit();

        } catch (Exception e) {

            // Revierte la transacción si ocurre un error.
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // Obtiene todos los clientes registrados.
    public List<Cliente> listar() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // Consulta HQL para obtener todos los clientes.
            return session.createQuery(
                    "FROM Cliente",
                    Cliente.class
            ).list();

        }
    }

    // Busca un cliente utilizando su identificador.
    public Cliente buscarPorId(Integer id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // Obtiene el cliente mediante su clave primaria.
            return session.get(Cliente.class, id);

        }
    }

    // Actualiza los datos de un cliente existente.
    public void actualizar(Cliente cliente) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // Inicia la transacción.
            transaction = session.beginTransaction();

            // Sincroniza los cambios del cliente con la base de datos.
            session.merge(cliente);

            // Confirma la actualización.
            transaction.commit();

        } catch (Exception e) {

            // Revierte los cambios si ocurre un error.
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // Elimina un cliente utilizando su identificador.
    public void eliminar(Integer id) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // Inicia la transacción.
            transaction = session.beginTransaction();

            // Busca el cliente antes de eliminarlo.
            Cliente cliente = session.get(Cliente.class, id);

            if (cliente != null) {

                // Elimina el cliente encontrado.
                session.remove(cliente);
            }

            // Confirma la eliminación.
            transaction.commit();

        } catch (Exception e) {

            // Revierte la transacción si ocurre un error.
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }
}