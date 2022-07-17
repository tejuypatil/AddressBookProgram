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
    }

}


