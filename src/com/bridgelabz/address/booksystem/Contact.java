package com.bridgelabz.address.booksystem;

import java.util.Scanner;

class Contact {
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String phoneNumber;
    String email;
    Scanner scanner = new Scanner(System.in);

    Contact()
    {

    }
    Contact(String firstName, String lastName, String address, String city, String state, String zip, String mobileNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = mobileNumber;
        this.email = email;
    }

    public String askDetailsToUser() {
        System.out.println("Enter First Name:-");
        firstName = scanner.next();
        System.out.println("Enter Last Name:-");
        lastName = scanner.next();
        System.out.println("Enter Address:-");
        address = scanner.next();
        System.out.println("Enter City:-");
        city = scanner.next();
        System.out.println("Enter State:-");
        state = scanner.next();
        System.out.println("Enter Zip Code:-");
        zip = scanner.next();
        System.out.println("Enter a Mobile Number:-");
        phoneNumber = scanner.next();
        System.out.println("Enter a Email Id:-");
        email = scanner.next();

        return firstName;
    }
    public void viewData ()
    {
        System.out.println("First Name:-" + firstName);
        System.out.println("Last Name:-" + lastName);
        System.out.println("Address:-" + address);
        System.out.println("City:-" + city);
        System.out.println("State:-" + state);
        System.out.println("Zip Code:-" + zip);
        System.out.println("Mobile Number:-" + phoneNumber);
        System.out.println("Email Id:-" + email);
    }
}