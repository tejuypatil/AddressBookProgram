package com.bridgelabz.address.booksystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {

    Map<String,Contact> contactMap=new HashMap<>();

    ArrayList<Contact> contacts = new ArrayList<Contact>();
    public void addContact()
    {
       // Scanner scanner = new Scanner(System.in);
        Contact contact = new Contact();
        contact.askDetailsToUser();
        if(!contacts.contains(contact))
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
}
