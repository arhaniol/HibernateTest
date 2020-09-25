package org.example.jpa;

import javax.persistence.*;

@Entity
@Table(name = "tranzakcje")
public class Tranzakcja {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double value;
    @ManyToOne
    private Person from;
    @ManyToOne
    private Person to;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Person getFrom() {
        return from;
    }

    public void setFrom(Person from) {
        this.from = from;
    }

    public Person getTo() {
        return to;
    }

    public void setTo(Person to) {
        this.to = to;
    }
}
