package org.example.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class TranzakcjaImpl {
    private final EntityManager EM;

    public TranzakcjaImpl() {
        EM = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
    }

    public void create(Person from, Person to, double value){
        EntityTransaction et= EM.getTransaction();

        Tranzakcja tranzakcja=new Tranzakcja();
        tranzakcja.setFrom(from);
        tranzakcja.setTo(to);
        tranzakcja.setValue(value);

        try{
            et.begin();
            EM.persist(tranzakcja);
            et.commit();
        }catch(Exception ex){
            if(et!=null){
                et.rollback();
            }
            ex.printStackTrace();
        }
    }

    public Tranzakcja getByFrom(Person from){
        TypedQuery<Tranzakcja> tq = EM.createQuery("select * from Tranzakcja s WHERE s.form= :f", Tranzakcja.class);
        tq.setParameter("f",from);

        Tranzakcja tranzakcja=null;
        try{
            tranzakcja=tq.getSingleResult();
        }catch (NoResultException ex){
            ex.printStackTrace();
        }
        return tranzakcja;
    }
}
