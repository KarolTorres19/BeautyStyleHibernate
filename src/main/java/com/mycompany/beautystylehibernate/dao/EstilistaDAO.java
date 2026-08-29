package com.mycompany.beautystylehibernate.dao;

import com.mycompany.beautystylehibernate.Estilista;
import com.mycompany.beautystylehibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * DAO encargado de realizar las operaciones de acceso
 * y persistencia de los estilistas utilizando Hibernate.
 */
public class EstilistaDAO {

    // Guarda un nuevo estilista en la base de datos.
    public void guardar(Estilista estilista) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // Inicia la transacción.
            transaction = session.beginTransaction();

            // Persiste el estilista en la tabla correspondiente.
            session.persist(estilista);

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

    // Obtiene todos los estilistas registrados.
    public List<Estilista> listar() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // Consulta HQL para obtener todos los estilistas.
            return session.createQuery(
                    "FROM Estilista",
                    Estilista.class
            ).list();

        }
    }

    // Busca un estilista utilizando su identificador.
    public Estilista buscarPorId(Integer id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // Obtiene el estilista mediante su clave primaria.
            return session.get(Estilista.class, id);

        }
    }

    // Actualiza los datos de un estilista existente.
    public void actualizar(Estilista estilista) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // Inicia la transacción.
            transaction = session.beginTransaction();

            // Sincroniza los cambios del estilista con la base de datos.
            session.merge(estilista);

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

    // Elimina un estilista utilizando su identificador.
    public void eliminar(Integer id) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            // Inicia la transacción.
            transaction = session.beginTransaction();

            // Busca el estilista antes de eliminarlo.
            Estilista estilista = session.get(Estilista.class, id);

            if (estilista != null) {

                // Elimina el estilista encontrado.
                session.remove(estilista);
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