package org.example;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
    private static volatile EntityManagerFactory emf;

    private EntityManagerUtil(){
        emf= Persistence.createEntityManagerFactory("localDB");
    }

    public EntityManagerFactory getEntityManagerFactory(){
        synchronized (EntityManagerUtil.class) {
            if (emf == null) {
                new EntityManagerUtil();
            }
        }
        return emf;
    }
}
