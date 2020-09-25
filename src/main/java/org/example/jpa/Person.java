package org.example.jpa;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany
    private List<Tranzakcja> tranzakcje;

    public List<Tranzakcja> getTranzakcje() {
        return tranzakcje;
    }

    public void setTranzakcje(List<Tranzakcja> tranzakcje) {
        this.tranzakcje = tranzakcje;
    }

    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
