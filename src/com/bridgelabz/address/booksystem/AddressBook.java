package com.bridgelabz.address.booksystem;

import java.util.HashMap;
import java.util.Map;
public class AddressBook {
    Map<String,Contact> contactMap=new HashMap<>();
    public void addContact(Contact contact)
    {
        contactMap.put(contact.firstName,contact);
    }

    public void print()
    {
        for (Contact contact : contactMap.values()) {
            contact.viewData();
        }
    }

    public void editContact(String contactName)
    {
        Contact contact=contactMap.get(contactName);
        contact.viewData();
        contact.askDetailsToUser();
    }

    public void deleteContact(String name)
    {
        contactMap.remove(name);
    }
}
