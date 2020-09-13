package org.example.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sf;

    private HibernateUtil() {
        try {
            sf = new Configuration().configure().buildSessionFactory();
        } catch (Throwable throwable) {
            System.err.println("Failed to create session factory object " + throwable);
            throw new ExceptionInInitializerError(throwable);
        }
    }

    public static SessionFactory getSessionManagerFactory() {
        if (sf == null) {
            new HibernateUtil();
        }
        return sf;
    }
}
