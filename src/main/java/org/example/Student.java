package org.example;

public class Student {
    private int StudentID;
    private String name;

    public Student() {
    }

    public Student(int studentID, String name) {
        StudentID = studentID;
        this.name = name;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int studentID) {
        StudentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
