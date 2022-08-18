package com.bridgelabz.address.booksystem.utils;

import com.bridgelabz.address.booksystem.Contact;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JsonIO implements SaverIo{
    @Override
    public void writeData(String fileName, ArrayList<Contact> contacts) {

        JSONArray contactsJsonArray = new JSONArray();
        for (Contact contact: contacts) {
            JSONObject jsonObject = new JSONObject();


            jsonObject.put("firstName", contact.firstName);
            jsonObject.put("lastName", contact.lastName);
            jsonObject.put("city", contact.city);
            jsonObject.put("state",contact.state);
            jsonObject.put("zip", contact.zip);
            jsonObject.put("phoneNumber",contact.phoneNumber);
            jsonObject.put("email",contact.email);

            contactsJsonArray.add(jsonObject);
        }
        try {
            FileWriter fileWriter = new FileWriter(fileName+".json");
            fileWriter.write(contactsJsonArray.toJSONString());
            fileWriter.close();
        } catch (IOException e) {
           e.printStackTrace();
        }
        System.out.println("Json File created:"+contactsJsonArray);
    }

    @Override
    public void readData(String fileName, ArrayList<Contact> contacts)  {
        try {
            Object obj= new JSONParser().parse(new FileReader(fileName+".json"));
            JSONArray jsonArray = (JSONArray) obj;

            jsonArray.forEach(contact -> {
                JSONObject jsonObject = (JSONObject) contact;
                Contact newContact = new Contact();
                newContact.firstName =(String)jsonObject.get("firstName");
                newContact.lastName = (String) jsonObject.get("lastName");
                newContact.city =(String) jsonObject.get("city");
                newContact.state = (String) jsonObject.get("state");
                newContact.zip = (String) jsonObject.get("zip");
                newContact.phoneNumber = (String) jsonObject.get("phoneNumber");
                newContact.email = (String) jsonObject.get("email");
                contacts.add(newContact);
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
