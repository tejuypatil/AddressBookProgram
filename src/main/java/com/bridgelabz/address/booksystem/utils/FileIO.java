package com.bridgelabz.address.booksystem.utils;

import com.bridgelabz.address.booksystem.Contact;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class  FileIO implements  SaverIo{


    @Override
    public void writeData(String fileName, ArrayList<Contact> contacts) {
        try {
            FileWriter file = new FileWriter(fileName, true);
            PrintWriter printWriter = new PrintWriter(file);

            for (Contact contact : contacts) {
                printWriter.println(contact.firstName + "," + contact.lastName + "," + contact.city + "," + contact.state + "," + contact.zip + "," + contact.phoneNumber + "," + contact.email);
            }
            printWriter.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void readData(String fileName, ArrayList<Contact> contacts) {

        try {
            File file = new File(fileName);
            Scanner scanFile = new Scanner(file);

            scanFile.useDelimiter("\r\n").tokens().forEach(fileLine ->
            {
                String[] lineArray = fileLine.split(",");
                if (lineArray.length == 7) {
                    Contact newContact = new Contact();
                    newContact.firstName = lineArray[0];
                    newContact.lastName = lineArray[1];
                    newContact.city = lineArray[2];
                    newContact.state = lineArray[3];
                    newContact.zip = lineArray[4];
                    newContact.phoneNumber = lineArray[5];
                    newContact.email = lineArray[6];
                    contacts.add(newContact);
                }
            });
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

