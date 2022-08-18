package com.bridgelabz.address.booksystem.utils;

import com.bridgelabz.address.booksystem.Contact;

import java.util.ArrayList;

public interface SaverIo {

    public void writeData(String fileName, ArrayList<Contact> contacts);
    public void readData(String fileName, ArrayList<Contact> contacts) ;
}
