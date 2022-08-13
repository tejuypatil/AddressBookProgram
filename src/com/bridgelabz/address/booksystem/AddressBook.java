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
    void selectAddressBook() {
        System.out.println(addressBookList.keySet());
        System.out.println("enter name of address book");
        String addressBookName = scanner.next();

        for (String key : addressBookList.keySet()) {
            if (key.equalsIgnoreCase(addressBookName)) {
                currentAddressBook = addressBookList.get(key);
                currentAddressBookName = key;
            }
        }
        System.out.println("current AddressBook is " + currentAddressBookName);

    }
void  viewContacts() {
        System.out.println("""
           Enter Option
                1.To view By City
                2.To view By State
                3.Exit
                """);
    switch (scanner.nextInt()){
        case 1:
            viewContactsByCity();
            break;
        case 2:
            viewContactByState();
            break;
        default:
            viewContacts();

    }
}

    private void viewContactsByCity() {
        System.out.println("Enter City: ");
        String city = scanner.next();
        for (String key: cityContactList.keySet()) {
            if (key.equalsIgnoreCase(city)){
                System.out.println(cityContactList.get(city));
            }
            
        }
    }

    private void viewContactByState() {
        System.out.println("Enter State: ");
        String state = scanner.next();
        for (String key:stateContactList.keySet()) {
            if (key.equalsIgnoreCase(state)){
                System.out.println(stateContactList.get(state));
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

}
