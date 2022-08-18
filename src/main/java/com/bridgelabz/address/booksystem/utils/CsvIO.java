package com.bridgelabz.address.booksystem.utils;

import com.bridgelabz.address.booksystem.Contact;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvIO implements SaverIo {

    @Override
    public void writeData(String fileName, ArrayList<Contact> contacts) {
        try {
            FileWriter writer=new FileWriter(fileName+".csv");
            CSVWriter csvWriter = new CSVWriter(writer);
            for (Contact contact:contacts)
            {
                String[] newLine=new String[]{contact.firstName,contact.lastName,contact.city,contact.state,contact.zip,contact.phoneNumber,contact.email};
                csvWriter.writeNext(newLine);
            }
            csvWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void readData(String fileName, ArrayList<Contact> contacts)  {
        try {
            FileReader reader = new FileReader(fileName+".csv");
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> lines=csvReader.readAll();
            lines.forEach(lineArray -> {
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

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
