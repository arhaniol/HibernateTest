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
        student.saveStudent(4,"Ada");
        student.close();
        System.out.println( "Hello World!" );
    }
}
