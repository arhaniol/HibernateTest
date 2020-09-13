package org.example.hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="student")
public class Student implements Serializable {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int studentID;

    @Column(name="name")
    private String name;

    public Student() {
        super();
    }

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
