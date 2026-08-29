package com.mycompany.beautystylehibernate.dao;

import com.mycompany.beautystylehibernate.Cita;
import com.mycompany.beautystylehibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * DAO encargado de realizar las operaciones de acceso
 * y persistencia de las citas utilizando Hibernate.
 */
public class CitaDAO {

    // Guarda una nueva cita en la base de datos.
    public void guardar(Cita cita) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // Inicia la transacción.
            transaction = session.beginTransaction();

            // Persiste la cita en la tabla correspondiente.
            session.persist(cita);

            // Confirma los cambios.
            transaction.commit();

        } catch (Exception e) {

            // Revierte la transacción si ocurre un error.
            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // Obtiene todas las citas registradas.
    public List<Cita> listar() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // Consulta HQL para obtener todas las citas.
            return session.createQuery(
                    "FROM Cita",
                    Cita.class
            ).list();

        }
    }

    // Obtiene únicamente las citas pertenecientes a un cliente.
    public List<Cita> listarPorCliente(Integer idCliente) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // Filtra las citas utilizando el identificador del cliente.
            return session.createQuery(
                    "FROM Cita c WHERE c.cliente.id_cliente = :idCliente",
                    Cita.class
            )
            .setParameter("idCliente", idCliente)
            .list();

        }
    }

    // Busca una cita utilizando su identificador.
    public Cita buscarPorId(Integer id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // Obtiene la cita mediante su clave primaria.
            return session.get(Cita.class, id);

        }
    }

    // Actualiza los datos de una cita existente.
    public void actualizar(Cita cita) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // Inicia la transacción.
            transaction = session.beginTransaction();

            // Sincroniza los cambios de la cita con la base de datos.
            session.merge(cita);

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

    // Elimina una cita utilizando su identificador.
    public void eliminar(Integer id) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // Inicia la transacción.
            transaction = session.beginTransaction();

            // Busca la cita antes de eliminarla.
            Cita cita = session.get(Cita.class, id);

            if (cita != null) {

                // Elimina la cita encontrada.
                session.remove(cita);
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