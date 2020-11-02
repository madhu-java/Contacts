package contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main implements Serializable {

    public static void main(String[] args) {
        List<AllRecords> records = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        String fileName = "phonebook.db";
        //if file exists deserialize the object and store contacts in records
        if (new File(fileName).exists()) {
            // deserialize(fileName);

            try {
                records = (List<AllRecords>) SerializeUtil.deserialize(fileName);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        while (!exit) {
            System.out.println("[menu] Enter action (add, list, search, count, exit):");
            String userChoice = scanner.nextLine().trim().toLowerCase();
            switch (userChoice) {
                case "add":
                    System.out.print("Enter the type (person, organization): ");
                    String recordType = scanner.nextLine();

                    AllRecords record = createRecord(scanner, recordType);

                    records.add(record);

                    System.out.println("The record added.\n");
                    break;
                case "search":

                    ArrayList<AllRecords> searchRecords = search(records, scanner);
                    System.out.println("Found " + searchRecords.size() + " results:\n");
                    showAllRecords(searchRecords);
                    System.out.println("[search] Enter action ([number], back, again): ");
                    String searchOption = scanner.nextLine().trim();
                    if (searchOption.equals("again")) {
                        searchRecords = search(records, scanner);
                        System.out.println("Found " + searchRecords.size() + " results:\n");
                        showAllRecords(searchRecords);
                    } else if (Integer.parseInt(searchOption) <= searchRecords.size()) {
                        AllRecords rec = searchRecords.get(Integer.parseInt(searchOption) - 1);
                        String[] allFields = rec.changableFields();
                        for (String field : allFields) {
                            System.out.println(rec.getAField(field));
                        }

                        updateRecord(records, scanner, rec);
                    } else if (searchOption.equals("exit")) {
                        break;
                    }

                    break;

                case "count":
                    if (records.isEmpty()) {
                        System.out.println("The Phone Book has 0 records.");
                    } else {
                        System.out.println("The Phone Book has " + records.size() + " records.");
                    }
                    break;
                //case "info":
                case "list":
                    showAllRecords(records);
                    System.out.print("Enter index to show info: ");
                    int recordNumbr = scanner.nextInt();
                    AllRecords recordToShow = records.get(recordNumbr - 1);
                    System.out.println(recordToShow);
                    updateRecord(records, scanner, recordToShow);
                    break;
                case "exit":
                    exit = true;
                    break;
            }
        }
        //serialize the records
        SerializeUtil.seialize(records, fileName);


    }

    private static void updateRecord(List<AllRecords> records, Scanner scanner, AllRecords rec) {
        boolean recordExit = false;
        while (!recordExit) {
            System.out.println("[record] Enter action (edit, delete, menu): ");
            String recordOption = scanner.next();
            scanner.nextLine();
            switch (recordOption) {
                case "edit":
                    editARecord(rec, scanner);

                    System.out.println("Saved");
                    for (String field : rec.changableFields()) {
                        System.out.println(rec.getAField(field));
                    }

                    break;
                case "delete":

                    records.removeIf(contact -> contact.getPhoneNumber().equals(rec.getPhoneNumber()));
                    //removeARecord(rec,scanner);
                    //searchRecords.remove()
                    System.out.println("record deleted!");
                    break;
                case "menu":
                    recordExit = true;
                    System.out.println();
                    break;
            }

        }
    }

    private static ArrayList<AllRecords> search(List<AllRecords> records, Scanner scanner) {
        ArrayList<AllRecords> searchRecords = new ArrayList<>();
        System.out.println("Enter search query:");
        String searchString = scanner.nextLine().toLowerCase();
        //int i=1;
        //System.out.print(i);
        Pattern pattern = Pattern.compile("(?s).*" + searchString + ".*");
        Matcher matcher;
        for (AllRecords rec : records) {
            matcher = pattern.matcher(rec.getName().toLowerCase() + rec.getPhoneNumber());
            if (matcher.matches()) {
                searchRecords.add(rec);
            }
        }
        return searchRecords;
    }


    private static void editARecord(AllRecords phoneRecords, Scanner scanner) {

        System.out.println("select a field " + Arrays.toString(phoneRecords.changableFields()));
        String userEditOption = scanner.next();
        scanner.nextLine();
        for (String field : phoneRecords.changableFields()) {
            if (userEditOption.equals(field)) {
                System.out.println("Enter " + field + ": ");
                String str = scanner.nextLine();
                phoneRecords.changeAField(field, str);
                //scanner.nextLine();
            }
        }
    }

    private static void removeARecord(List<AllRecords> phoneRecords, Scanner scanner) {
        showAllRecords(phoneRecords);
        System.out.println("Select a record:");
        int recordToRemove = scanner.nextInt();
        phoneRecords.remove(recordToRemove - 1);
        System.out.println("The record removed!");
    }

    private static void showAllRecords(List<AllRecords> phoneRecords) {
        int i = 1;
        //System.out.print(i);
        for (AllRecords record : phoneRecords) {
            System.out.print(i + ". ");
            System.out.println(record.getName());

            i += 1;
        }
    }

    private static AllRecords createRecord(Scanner scanner, String recordType) {
        AllRecords newRecord = null;
        if (recordType.equals("person")) {
            String name;
            String surName;
            String number;
            String dob;
            String gender;
            PersonRecords personRecords = new PersonRecords();
            //Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the name: ");
            name = scanner.nextLine();
            personRecords.setFirstName(name);
            System.out.print("Enter the surname: ");
            surName = scanner.nextLine();
            personRecords.setLastName(surName);
            System.out.print("Enter the birth date: ");
            dob = scanner.nextLine();
            personRecords.setBirthDate(dob);
            System.out.print("Enter the gender(M, F):");
            gender = scanner.nextLine();
            personRecords.setGender(gender);
            System.out.print("Enter the number: ");
            number = scanner.nextLine();
            personRecords.setPhoneNumber(number);

            newRecord = personRecords;
        } else if (recordType.equals("organization")) {

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
            newRecord = organizationRecord;
        }
        return newRecord;
    }

}
