package com.mycompany.beautystylehibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Clase utilitaria encargada de configurar y proporcionar
 * la SessionFactory utilizada por Hibernate.
 */
public class HibernateUtil {

    // Crea una única instancia de SessionFactory para toda la aplicación.
    private static final SessionFactory sessionFactory = buildSessionFactory();

    /**
     * Construye la SessionFactory utilizando la configuración
     * definida en el archivo hibernate.cfg.xml.
     *
     * @return SessionFactory configurada para Hibernate.
     */
    private static SessionFactory buildSessionFactory() {

        try {

            // Carga la configuración de Hibernate y crea la SessionFactory.
            return new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();

        } catch (Throwable ex) {

            // Muestra el error si no es posible crear la SessionFactory.
            System.err.println("Error al crear SessionFactory: " + ex);

            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Obtiene la SessionFactory utilizada para abrir sesiones
     * y realizar operaciones con la base de datos.
     *
     * @return SessionFactory de la aplicación.
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Cierra la SessionFactory cuando la aplicación
     * deja de utilizar Hibernate.
     */
    public static void shutdown() {
        getSessionFactory().close();
    }
}