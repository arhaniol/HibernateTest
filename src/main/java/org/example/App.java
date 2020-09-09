package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StudentImpl student=new StudentImpl();
        student.saveStudent(7,"Pola");
        student.close();
        System.out.println( "Hello World!" );
    }
}
