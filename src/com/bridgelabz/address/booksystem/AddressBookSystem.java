package com.bridgelabz.address.booksystem;

import java.util.Scanner;

public class AddressBookSystem {

    public static void main(String[] args) {
        System.out.println("----------------------------------------------------");
        System.out.println("         Welcome to Address Book Program");
        System.out.println("----------------------------------------------------");

        Contact contact1 = new Contact("Tejaswini","Patil","Chandgad","Kolhpur","Maharashtra","416509","9422630373","tejuypatil@gmail.com" );
        Contact contact2 = new Contact("Meghna","Patil","Chandgad","Kolhpur","Maharashtra","416509","9422630373","megnapatil@gmail.com" );
        Contact contact3 = new Contact("Babu","Patel","Forpur","Kolhpur","Maharashtra","416509","9422630373","e1@gmail.com" );
        Contact contact4 = new Contact("Sonu","Desai","Gagapur","Kolhpur","Maharashtra","416509","9422630373","e2@gmail.com" );
        Contact contact5 = new Contact("Sarica","More","Norttulo","Kolhpur","Maharashtra","416509","9422630373","e3@gmail.com" );

        AddressBook addressBook1=new AddressBook();

        addressBook1.addContact(contact1);
        addressBook1.addContact(contact2);
        addressBook1.addContact(contact3);
        addressBook1.addContact(contact4);
        addressBook1.addContact(contact5);

        while(true)
        {
            System.out.println("---Menu-------------------------------------");
            System.out.println("| 1. print AddressBook                      |");
            System.out.println("| 2. Edit Contact                           |");
            System.out.println("| 3. Delete Contact                         |");
            System.out.println("| 4. Add Contact                            |");
            System.out.println("--------------------------------------------");


            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    addressBook1.print();
                    break;
                case 2:
                    System.out.println("Enter first-name to edit contact: ");
                    String name = scanner.next();
                    addressBook1.editContact(name);
                    break;
                case 3:
                    System.out.println("Enter first-name to delete contact: ");
                    String nameToDelete = scanner.next();
                    addressBook1.deleteContact(nameToDelete);
                    break;
                case 4:
                    Contact contactToAdd=new Contact();
                    contactToAdd.askDetailsToUser();
                    addressBook1.addContact(contactToAdd);
                    break;
            }
        }

    }

}

