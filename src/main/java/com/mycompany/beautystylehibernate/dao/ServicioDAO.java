package com.mycompany.beautystylehibernate.dao;

import com.mycompany.beautystylehibernate.HibernateUtil;
import com.mycompany.beautystylehibernate.Servicio;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * DAO encargado de realizar las operaciones de acceso
 * y persistencia de los servicios utilizando Hibernate.
 */
public class ServicioDAO {

    // Guarda un nuevo servicio en la base de datos.
    public void guardar(Servicio servicio) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // Inicia la transacción.
            transaction = session.beginTransaction();

            // Persiste el servicio en la tabla correspondiente.
            session.persist(servicio);

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

    // Obtiene todos los servicios registrados.
    public List<Servicio> listar() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // Consulta HQL para obtener todos los servicios.
            return session.createQuery(
                    "FROM Servicio",
                    Servicio.class
            ).list();

        }
    }

    // Busca un servicio utilizando su identificador.
    public Servicio buscarPorId(Integer id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // Obtiene el servicio mediante su clave primaria.
            return session.get(Servicio.class, id);

        }
    }

    // Actualiza los datos de un servicio existente.
    public void actualizar(Servicio servicio) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // Inicia la transacción.
            transaction = session.beginTransaction();

            // Sincroniza los cambios del servicio con la base de datos.
            session.merge(servicio);

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

    // Elimina un servicio utilizando su identificador.
    public void eliminar(Integer id) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // Inicia la transacción.
            transaction = session.beginTransaction();

            // Busca el servicio antes de eliminarlo.
            Servicio servicio = session.get(Servicio.class, id);

            if (servicio != null) {

                // Elimina el servicio encontrado.
                session.remove(servicio);
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