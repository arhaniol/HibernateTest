package org.example;

public interface StudentDAO {
    void saveStudent(int id, String name);
    Student getStudent();
    void updateStudent(int id, String name);
}
