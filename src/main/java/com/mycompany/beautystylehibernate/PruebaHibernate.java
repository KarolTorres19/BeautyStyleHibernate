package com.mycompany.beautystylehibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PruebaHibernate {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        System.out.println("Hibernate conectado correctamente");

        session.close();
        factory.close();
    }
}