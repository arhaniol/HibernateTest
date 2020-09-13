package org.example.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
    private static volatile EntityManagerFactory emf;

    private EntityManagerUtil() {
        try {
            emf = Persistence.createEntityManagerFactory("remoteDB");
        } catch (Exception ex) {
            System.err.println("EntityManagerFactory object - failed to create " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        synchronized (EntityManagerUtil.class) {
            if (emf == null) {
                new EntityManagerUtil();
            }
        }
        return emf;
    }
}
