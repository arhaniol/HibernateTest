package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentImpl implements StudentDAO {
    private Session session;

    public StudentImpl() {
//        SessionFactory sessionFactory = HibernateUtil.getSessionManagerFactory();
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
        }catch (Exception ex){
            System.err.println("Session factory object faild of creation "+ex);
        }
    }

    public void close() {
        if (session != null) {
            session.close();
        }
    }

    @Override
    public void saveStudent(int id, String name) {
        Transaction tx = null;
        int studentID = 0;

        try {
            tx = session.beginTransaction();
            Student student = new Student(id, name);
            studentID = (Integer) session.save(student);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println(studentID);
    }

    @Override
    public Student getStudent() {

        return null;
    }

    @Override
    public void updateStudent(int id, String name) {

    }
}
