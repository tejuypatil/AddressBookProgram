package com.bridgelabz.address.booksystem;

import java.util.Scanner;

public class AddressBook {

    Contact[] contacts=new Contact[100];
    int index=0;
    public void add(Contact contact)
    {
        contacts[index]=contact;
        index++;
    }

    public void print()
    {
        for (int i = 0; i < index; i++) {
            contacts[i].viewData();
        }
    }

    public void editContact(String contactName)
    {
        for (int i=0;i<index;i++)
        {
            Contact c=contacts[i];
            if ( c.firstName.equals(contactName)  )
            {
                // c is contact to edit
                c.viewData();
                c.askDetailsToUser();
            }
        }

    }

    public void deleteContact(String name)
    {
        int indexToDelete=-1;
        for (int i=0;i<index;i++)
        {
            Contact c=contacts[i];
            if ( c.firstName.equals(name)  )
            {
                indexToDelete=i;
                break;
            }
        }

        if(indexToDelete > -1)
        {
            //delete logic
            for (int i = indexToDelete; i < index ; i++) {
                contacts[i]=contacts[i+1];
            }
            index--;
        }
    }
}
