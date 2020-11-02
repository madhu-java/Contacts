package contacts;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
       
    public static void main(String[] args) {
       List<AllRecords> records = new ArrayList<>();
       Scanner scanner = new Scanner(System.in);
       boolean exit =false;
       while(!exit){
          System.out.println("Enter action (add, remove, edit, count, info, exit):");
          String userChoice = scanner.nextLine().trim().toLowerCase();
          switch(userChoice){
             case "add":
                System.out.println("Enter the type (person, organization): ");
                String recordType = scanner.nextLine();

                   AllRecords record = createRecord(scanner,recordType);
                   record.setDateCreated(LocalDateTime.now());
                   record.setLastEditDate(LocalDateTime.now());
                   records.add(record);

                System.out.println("The record added.\n");
                break;
             case "remove":
                if(records.isEmpty()){
                   System.out.println("No records to remove!");
                }else{
                   removeARecord(records, scanner);
                }
                break;
             case "edit":
                if(records.isEmpty()){
                   System.out.println("No records to edit!");
                }else {
                   editARecord(records, scanner);
                   System.out.println("The record updated!\n");
                }
                break;
             case "count":
                if(records.isEmpty()){
                   System.out.println("The Phone Book has 0 records.");
                }else {
                   System.out.println("The Phone Book has "+records.size() +" records.");
                }
                break;
             case "info":
                showAllRecords(records);
                System.out.print("Enter index to show info: ");
                int recordNumbr = scanner.nextInt();
                AllRecords recordToShow = records.get(recordNumbr-1);
                System.out.println(recordToShow);
                break;
             case "exit":
                exit = true;
                break;
          }
       }
    }

   private static void editARecord(List<AllRecords> phoneRecords, Scanner scanner) {
      showAllRecords(phoneRecords);
      System.out.println("Select a record:");
      int recordToEdit = scanner.nextInt();
     // AllRecords editPersonRecords =  phoneRecords.get(recordToEdit-1);
      //System.out.println(editContact);
      if(phoneRecords.get(recordToEdit-1).getClass()==PersonRecords.class) {
         PersonRecords editPersonRecords= (PersonRecords) phoneRecords.get(recordToEdit-1);
         System.out.println("Select a field (name, surname, birth, gender, number): ");
         String userEditOption = scanner.next();
         switch (userEditOption) {
            case "name":
               System.out.print("Enter name: ");
               editPersonRecords.setFirstName(scanner.next());
               break;
            case "surname":
               System.out.print("Enter surname: ");
               editPersonRecords.setLastName(scanner.next());
               break;
            case "number":

               System.out.print("Enter number: ");
               scanner.nextLine();
               editPersonRecords.setPhoneNumber(scanner.nextLine());
               break;
            case "birth":

               System.out.print("Enter birth date: ");
               editPersonRecords.setBirthDate(scanner.nextLine());
               break;
            case "gender":

               System.out.print("Enter gender: ");
               editPersonRecords.setGender(scanner.next().trim().toUpperCase());
               break;

         }
         editPersonRecords.setLastEditDate(LocalDateTime.now());
         }else if(phoneRecords.get(recordToEdit-1).getClass()==OrganizationRecords.class) {
            OrganizationRecords editOrgRecords= (OrganizationRecords) phoneRecords.get(recordToEdit-1);
            System.out.println("Select a field (name, address, number): ");
            String userEditOption = scanner.next();
            switch (userEditOption) {
               case "name":
                  System.out.print("Enter name: ");
                  editOrgRecords.setOrganizationName(scanner.next());
                  break;
               case "number":

                  System.out.print("Enter number: ");
                  scanner.nextLine();
                  editOrgRecords.setPhoneNumber(scanner.nextLine());
                  break;
               case "address":

                  System.out.print("Enter address: ");
                  scanner.nextLine();
                  editOrgRecords.setOrganizationAddress(scanner.nextLine());
                  break;
            }
         editOrgRecords.setLastEditDate(LocalDateTime.now());
      }
      //System.out.println(editContact);
     // System.out.println("The record updated!\n");
   }

   private static void removeARecord(List<AllRecords> phoneRecords, Scanner scanner) {
      showAllRecords(phoneRecords);
      System.out.println("Select a record:");
      int recordToRemove = scanner.nextInt();
      phoneRecords.remove(recordToRemove-1);
      System.out.println("The record removed!");
   }

   private static void showAllRecords(List<AllRecords> phoneRecords) {
      int i=1;
      //System.out.print(i);
      for (AllRecords record : phoneRecords) {
         System.out.print(i+". ");
         if(record.getClass()==PersonRecords.class){
            System.out.println(((PersonRecords) record).getFirstName()+" "+((PersonRecords) record).getLastName());
         }else if(record.getClass()==OrganizationRecords.class){
            System.out.println(((OrganizationRecords) record).getOrganizationName());
         }
         //System.out.print(record);
         //System.out.println();
         i += 1;
      }
   }

   private static AllRecords createRecord(Scanner scanner,String recordType) {
       AllRecords newRecord=null;
       if(recordType.equals("person")) {

          PersonRecords personRecords = new PersonRecords();
          //Scanner scanner = new Scanner(System.in);
          System.out.print("Enter the name: ");
          personRecords.setFirstName(scanner.nextLine());
          System.out.print("Enter the surname: ");
          personRecords.setLastName(scanner.nextLine());
          System.out.print("Enter the birth date: ");
          personRecords.setBirthDate(scanner.nextLine());
          System.out.print("Enter the gender(M, F):");
          personRecords.setGender(scanner.nextLine());
          System.out.print("Enter the number: ");
          personRecords.setPhoneNumber(scanner.nextLine());





          //System.out.println("A record created!");
          //System.out.println("A Phone Book with a single record created!");
          newRecord= personRecords;
       }else if (recordType.equals("organization")) {

          String name;

          String address;
          String number;
          //Scanner scanner = new Scanner(System.in);
          System.out.println("Enter the organization name:");
          name = scanner.nextLine();
          System.out.println("Enter the address:");
          address = scanner.nextLine();
          System.out.println("Enter the number:");
          number = scanner.nextLine();
          OrganizationRecords organizationRecord = new OrganizationRecords();
          organizationRecord.setOrganizationName(name);
          organizationRecord.setOrganizationAddress(address);
          organizationRecord.setPhoneNumber(number);
          //System.out.println("A record created!");
          //System.out.println("A Phone Book with a single record created!");
          newRecord= organizationRecord;
       }
       return newRecord;
   }

}
