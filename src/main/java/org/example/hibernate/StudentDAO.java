package org.example.hibernate;

import java.util.List;

public interface StudentDAO {
    void saveStudent(int id, String name);

    Student getStudent(int id);

    List getAllStudents();

    void updateStudent(int id, String name);
}
