package com.bridgelabz.address.booksystem;

import com.bridgelabz.address.booksystem.utils.CsvIO;
import com.bridgelabz.address.booksystem.utils.FileIO;
import com.bridgelabz.address.booksystem.utils.JsonIO;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBook {
    static Scanner scanner = new Scanner(System.in);
    Map<String, Contact> contactMap = new HashMap<>();

    ArrayList<Contact> contacts = new ArrayList<Contact>();
    static HashMap<String, Contact> cityContactList = new HashMap<>();
    static HashMap<String, Contact> stateContactList = new HashMap<>();
    private HashMap<String, ArrayList> addressBookList = new HashMap<>();
    static ArrayList<Contact> currentAddressBook;
    private String currentAddressBookName;

    public void addContact() {
        // Scanner scanner = new Scanner(System.in);
        Contact contact = new Contact();
        contact.askDetailsToUser();
        if (!contacts.stream().anyMatch(contact1 -> contact1.equals(contact))) {
            contacts.add(contact);
        } else {
            System.out.println("Duplicate entry");
        }
        // contactMap.put(contact.firstName,contact);
    }

    public void print() {
        for (Contact contact : contacts) {
            contact.viewData();
        }
    }

    public void editContact(String contactName) {

        for (Contact contact : contacts) {
            if (contact.firstName.equals(contactName)) {
                contact.viewData();
                contact.askDetailsToUser();
            }
        }

    }

    public void deleteContact(String name) {
        for (Contact contact : contacts) {
            if (contact.firstName.equals(name)) {
                contacts.remove(contact);
            }
        }
    }


    void searchContact() {
        System.out.println(" 1.Search by City\n 2.Search by State");

        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter the name of City: ");
                String city = scanner.next();
                searchByCity(city);
                break;
            case 2:
                System.out.println("Enter the name of State: ");
                searchByState(scanner.next());
                break;
        }
    }

    private void searchByState(String stateToSearch) {

        Stream<Contact> filteredStream = contacts.stream().filter(contact -> {
            return contact.state.equals(stateToSearch);
        });

        //Stream<Contact> filteredStream = contacts.stream().filter(contact -> contact.state.equals(stateToSearch));

        List<Contact> filteredList = filteredStream.collect(Collectors.toList());

        for (Contact contact : filteredList) {
            contact.viewData();
        }

    }

    private void searchByCity(String cityToSearch) {
        Stream<Contact> filterStream = contacts.stream().filter(contact -> {
            return contact.city.equals(cityToSearch);
        });

        List<Contact> list = filterStream.collect(Collectors.toList());
        for (Contact contact : list) {
            contact.viewData();

        }

    }


    void contactCount() {
        System.out.println("1.Count of City\n2.Count of State");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter City: ");
                String city = scanner.next();
                int cityCount = contacts.stream().filter(contact -> contact.city.equals(city)).toList().size();
                System.out.println("Count:- " + cityCount);
                break;
            case 2:
                System.out.println("Enter State: ");
                String state = scanner.next();
                int stateCount = contacts.stream().filter(contact -> contact.city.equals(state)).toList().size();
                System.out.println("Count: " + stateCount);
                break;
            default:
                contactCount();
                break;
        }
    }

    void sortContact() {
        System.out.println("1.By City\n2.By State\n3.By Zip");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("Entries sorted by City: ");
                List<Contact> contactList1 = contacts.stream().sorted((c1, c2) -> c1.city.compareToIgnoreCase(c2.city)).collect(Collectors.toList());
                contactList1.stream().forEach(contact -> contact.viewData());
                break;
            case 2:
                System.out.println("Entries sorted by State: ");
                List<Contact> contactList2 = contacts.stream().sorted((c1, c2) -> c1.state.compareToIgnoreCase(c2.state)).collect(Collectors.toList());
                contactList2.stream().forEach(contact -> contact.viewData());
                break;
            case 3:
                System.out.println(" Entries sorted by Zip: ");
                List<Contact> contactList3 = contacts.stream().sorted((c1, c2) -> c1.zip.compareToIgnoreCase(c2.zip)).collect(Collectors.toList());
                contactList3.stream().forEach(contact -> contact.viewData());
                break;
            default:
                contactCount();
                break;
        }
    }

    public void save(String fileName) {
        System.out.println("1.Write txt file\n2.Write csv file\n3.Write json file");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                FileIO fileIO = new FileIO();
                fileIO.writeData(fileName, contacts);
                break;
            case 2:
                CsvIO csvIO = new CsvIO();
                csvIO.writeData(fileName,contacts);
                break;
            case 3:
                JsonIO jsonIO = new JsonIO();
                jsonIO.writeData(fileName,contacts);
                break;
            default:
                break;
        }
    }
    public void load(String fileName) {
        System.out.println("1.Read txt file\n2.Read csv file\n3.Read json file");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                FileIO fileIO = new FileIO();
                fileIO.readData(fileName, contacts);
                break;
            case 2:
                CsvIO csvIO = new CsvIO();
                csvIO.readData(fileName,contacts);
                break;
            case 3:
                JsonIO jsonIO = new JsonIO();
                jsonIO.readData(fileName,contacts);
            default:
                break;
        }
    }
}


