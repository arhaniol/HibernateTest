package org.example.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class StudentImpl implements StudentDAO {
    private Session session;

    public StudentImpl() {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionManagerFactory();
            session = sessionFactory.openSession();
        } catch (Exception ex) {
            System.err.println("Session factory object failed of creation " + ex);
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
    public List getAllStudents() {
        return null;
    }

    @Override
    public Student getStudent(int id) {

        return null;
    }

    @Override
    public void updateStudent(int id, String name) {

    }
}
