package com.mycompany.beautystylehibernate.dao;

import com.mycompany.beautystylehibernate.HibernateUtil;
import com.mycompany.beautystylehibernate.Servicio;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ServicioDAO {

    public void guardar(Servicio servicio) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(servicio);

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    public List<Servicio> listar() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery("FROM Servicio", Servicio.class).list();

        }
    }

    public Servicio buscarPorId(Integer id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.get(Servicio.class, id);

        }
    }

    public void actualizar(Servicio servicio) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.merge(servicio);

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    public void eliminar(Integer id) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Servicio servicio = session.get(Servicio.class, id);

            if (servicio != null) {
                session.remove(servicio);
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