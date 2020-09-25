package org.example;

import org.example.jpa.Person;
import org.example.jpa.PersonImpl;
import org.example.jpa.TranzakcjaImpl;

import java.util.List;


public class App {
    public static void main(String[] args) {

        //hibernate
//        StudentImpl student=new StudentImpl();
//        student.saveStudent(7,"Pola");
//        student.close();

        //JPA
        PersonImpl czlowiek = new PersonImpl();
//        czlowiek.save(2,"Marek");
        czlowiek.save("Jozek");
        czlowiek.save("Marek");
        System.out.println("czekam...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Zmieniam imie " + czlowiek.getName(2));
        czlowiek.update(2, "Jurek");

        TranzakcjaImpl tranzakcja = new TranzakcjaImpl();
        List<Person> ludzie = czlowiek.getAllPerson();
        tranzakcja.create(ludzie.get(0), ludzie.get(1), 10.1);

        czlowiek.close();
    }
}
