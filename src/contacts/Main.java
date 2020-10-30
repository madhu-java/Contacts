package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
       
    public static void main(String[] args) {
       List<Contact> phoneRecords = new ArrayList<>();
       Scanner scanner = new Scanner(System.in);
       boolean exit =false;
       while(!exit){
          System.out.println("Enter action (add, remove, edit, count, list, exit):");
          String userChoice = scanner.nextLine().trim().toLowerCase();
          switch(userChoice){
             case "add":
                Contact contact = createRecord(scanner);
                phoneRecords.add(contact);
                System.out.println("The record added.");
                break;
             case "remove":
                if(phoneRecords.isEmpty()){
                   System.out.println("No records to remove!");
                }else{
                   removeARecord(phoneRecords, scanner);
                }
                break;
             case "edit":
                if(phoneRecords.isEmpty()){
                   System.out.println("No records to edit!");
                }else {
                   editARecord(phoneRecords, scanner);
                   System.out.println("The record updated!");
                }
                break;
             case "count":
                if(phoneRecords.isEmpty()){
                   System.out.println("The Phone Book has 0 records.");
                }else {
                   System.out.println("The Phone Book has "+phoneRecords.size() +" records.");
                }
                break;
             case "list":
                showAllRecords(phoneRecords);
                break;
             case "exit":
                exit = true;
                break;
          }
       }
    }

   private static void editARecord(List<Contact> phoneRecords, Scanner scanner) {
      showAllRecords(phoneRecords);
      System.out.println("Select a record:");
      int recordToEdit = scanner.nextInt();
      Contact editContact = phoneRecords.get(recordToEdit-1);
      //System.out.println(editContact);
      System.out.println("Select a field (name, surname, number): ");
      String userEditOption = scanner.next();
      switch (userEditOption) {
         case "name":
            System.out.println("Enter name:");
            editContact.setFirstName(scanner.next());
            break;
         case "surname":
            System.out.println("Enter surname:");
            editContact.setLastName(scanner.next());
            break;
         case "number":

            System.out.println("Enter number:");
            editContact.setPhoneNumber(scanner.nextLine());
            break;
      }
      //System.out.println(editContact);
     // System.out.println("The record updated!\n");
   }

   private static void removeARecord(List<Contact> phoneRecords, Scanner scanner) {
      showAllRecords(phoneRecords);
      System.out.println("Select a record:");
      int recordToRemove = scanner.nextInt();
      phoneRecords.remove(recordToRemove-1);
      System.out.println("The record removed!");
   }

   private static void showAllRecords(List<Contact> phoneRecords) {
      int i=1;
      //System.out.print(i);
      for (Contact record : phoneRecords) {
         System.out.print(i);
         System.out.print(record);
         System.out.println();
         i += 1;
      }
   }

   private static Contact createRecord(Scanner scanner) {
      String name;
      String surName;
      String number;
      //Scanner scanner = new Scanner(System.in);
      System.out.println("Enter the name:");
      name = scanner.nextLine();
      System.out.println("Enter the surname:");
      surName = scanner.nextLine();
      System.out.println("Enter the number:");
      number = scanner.nextLine();
      Contact contact = new Contact();
      contact.setFirstName(name);
      contact.setLastName(surName);
      contact.setPhoneNumber(number);
      //System.out.println("A record created!");
      //System.out.println("A Phone Book with a single record created!");
      return contact;
   }


}
