package com.bridgelabz.address.booksystem;

import java.util.Scanner;

public class AddressBookSystem {

    public static void main(String[] args) {
        System.out.println("----------------------------------------------------");
        System.out.println("         Welcome to Address Book Program");
        System.out.println("----------------------------------------------------");

        
        AddressBook addressBook1=new AddressBook();

        
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
                    addressBook1.addContact();
                    break;
            }
        }

    }

}

