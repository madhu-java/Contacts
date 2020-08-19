package contacts;
import java.util.Scanner;

public class Main {
       
    public static void main(String[] args) {
       // System.out.println("Hello World!");
       String name;
       String surName;
       String number;
       Scanner scanner = new Scanner(System.in);
       System.out.println("Enter the name of the person:");
       name = scanner.nextLine();
       System.out.println("Enter the surname of the person:");
       surName = scanner.nextLine();
       System.out.println("Enter the number:");
       //scanner.nextLine();
       number = scanner.nextLine();
       Contact contact = new Contact(name, surName, number);
       System.out.println("A record created!");
       System.out.println("A Phone Book with a single record created!");
       
    }
    


}
