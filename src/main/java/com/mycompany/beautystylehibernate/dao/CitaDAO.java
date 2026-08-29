package com.mycompany.beautystylehibernate.dao;

import com.mycompany.beautystylehibernate.Cita;
import com.mycompany.beautystylehibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CitaDAO {

    // GUARDAR
    public void guardar(Cita cita) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(cita);

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // LISTAR TODAS LAS CITAS
    public List<Cita> listar() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                    "FROM Cita",
                    Cita.class
            ).list();

        }
    }

    // LISTAR CITAS DE UN CLIENTE
    public List<Cita> listarPorCliente(Integer idCliente) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                    "FROM Cita c WHERE c.cliente.id_cliente = :idCliente",
                    Cita.class
            )
            .setParameter("idCliente", idCliente)
            .list();

        }
    }

    // BUSCAR POR ID
    public Cita buscarPorId(Integer id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.get(Cita.class, id);

        }
    }

    // ACTUALIZAR
    public void actualizar(Cita cita) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.merge(cita);

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // ELIMINAR
    public void eliminar(Integer id) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Cita cita = session.get(Cita.class, id);

            if (cita != null) {
                session.remove(cita);
            }

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }
}