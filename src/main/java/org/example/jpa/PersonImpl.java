package org.example.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class PersonImpl implements PersonDAO {
    private final EntityManager em;

    public PersonImpl() {
        try {
            em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
        } catch (Exception ex) {
            System.err.println("EntityManager object failed to create " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void close() {
        if (em != null) {
            em.close();
        }
    }

    @Override
    public void save(int id, String name) {
        EntityTransaction transaction = null;
        Person one = new Person(id, name);
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(one);
            transaction.commit();
        } catch (Exception ex) {
            System.err.println("Commit failed " + ex);
            if (transaction != null) {
                transaction.rollback();
            }
        }
        System.out.println("id: " + one.getId() + " name: " + one.getName());
    }

    public void save(String name) {
        EntityTransaction transaction = null;

        Person one = new Person();
        one.setName(name);

        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(one);
            transaction.commit();
        } catch (Exception ex) {
            System.err.println("Commit failed " + ex);
            if (transaction != null) {
                transaction.rollback();
            }
        }
        System.out.println("id: " + one.getId() + " name: " + one.getName());
    }


    @Override
    public String getName(int id) {
        String name;
        Person person = em.find(Person.class, id);
        name = person.getName();
        return name;
    }

    @Override
    public List getAllPerson() {
//        em.getCriteriaBuilder().cri
//        List<Person>personList
        return null;
    }

    @Override
    public void update(int id, String name) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Person person = em.find(Person.class, id);
            person.setName(name);
            et.commit();
        } catch (Exception ex) {
            System.err.println("Commit failed " + ex);
            if (et != null) {
                et.rollback();
            }
        }
        System.out.println("id: " + id + " name: " + name);
    }

    @Override
    public void delete(int id) {

    }
}
