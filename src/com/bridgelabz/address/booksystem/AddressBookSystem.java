package com.bridgelabz.address.booksystem;

import java.util.Scanner;

public class AddressBookSystem {

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        Contact contact1 = new Contact("Tejaswini","Patil","Chandgad","Kolhpur","Maharashtra","416509","9422630373","tejuypatil@gmail.com" );
        contact1.viewData();

        Contact contact2= new Contact();
        contact2.askDetailsToUser();
        contact2.viewData();



        Contact contact3 = new Contact("Babu","Patel","Forpur","Kolhpur","Maharashtra","416509","9422630373","e1@gmail.com" );
        Contact contact4 = new Contact("Sonu","Desai","Gagapur","Kolhpur","Maharashtra","416509","9422630373","e2@gmail.com" );
        Contact contact5 = new Contact("Sarica","More","Norttulo","Kolhpur","Maharashtra","416509","9422630373","e3@gmail.com" );

        System.out.println(" addressBook1 -----------------------------------------");
        AddressBook addressBook1=new AddressBook();

        addressBook1.add(contact3);
        addressBook1.add(contact4);
        addressBook1.add(contact5);
        addressBook1.print();

        System.out.println(" addressBook2 -----------------------------------------");
        AddressBook addressBook2=new AddressBook();

        addressBook2.add(contact1);
        addressBook2.add(contact2);
        addressBook2.print();
    }

}

