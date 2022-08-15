package com.bridgelabz.address.booksystem;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBook {
    static Scanner scanner = new Scanner(System.in);
    Map<String,Contact> contactMap=new HashMap<>();

    ArrayList<Contact> contacts = new ArrayList<Contact>();
    static HashMap<String,Contact> cityContactList= new HashMap<>();
    static HashMap<String,Contact> stateContactList= new HashMap<>();
    private HashMap<String,ArrayList> addressBookList= new HashMap<>();
    static ArrayList<Contact> currentAddressBook;
    private String currentAddressBookName;

    public void addContact()
    {
       // Scanner scanner = new Scanner(System.in);
        Contact contact = new Contact();
        contact.askDetailsToUser();
        if(!contacts.stream().anyMatch(contact1 ->contact1.equals(contact)))
        {
            contacts.add(contact);
        }
        else
        {
            System.out.println("Duplicate entry");
        }
        // contactMap.put(contact.firstName,contact);
    }

    public void print()
    {
        for (Contact contact :contacts) {
            contact.viewData();
        }
    }

    public void editContact(String contactName)
    {

        for (Contact contact :contacts) {
            if (contact.firstName.equals(contactName)) {
                contact.viewData();
                contact.askDetailsToUser();
            }
        }

    }

    public void deleteContact(String name)
    {
        for (Contact contact :contacts) {
            if (contact.firstName.equals(name)) {
                contacts.remove(contact);
            }
        }
    }


    void searchContact(){
        System.out.println(" 1.Search by City\n 2.Search by State");

        int option = scanner.nextInt();
        switch (option){
            case 1:
                System.out.println("Enter the name of City: ");
                String city=scanner.next();
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

        List<Contact> filteredList=filteredStream.collect(Collectors.toList());

        for (Contact contact:filteredList)
        {
            contact.viewData();
        }

    }

    private void searchByCity(String cityToSearch) {
        Stream<Contact>filterStream = contacts.stream().filter(contact -> {return contact.city.equals(cityToSearch);});

        List<Contact>list =  filterStream.collect(Collectors.toList());
        for (Contact contact:list) {
            contact.viewData();

        }

    }
    void contactCount(){
        System.out.println("1.Count of City\n2.Count of State");
        int option = scanner.nextInt();
        switch (option){
            case 1:
                System.out.println("Enter City: ");
                String city = scanner.next();
                int cityCount= contacts.stream().filter(contact -> contact.city.equals(city)).toList().size();
                System.out.println("Count:- "+cityCount);
                break;
            case 2:
                System.out.println("Enter State: ");
                String state = scanner.next();
                int stateCount=contacts.stream().filter(contact -> contact.city.equals(state)).toList().size();
                System.out.println("Count: "+stateCount);
                break;
            default:
                contactCount();
                break;
        }
    }

}
