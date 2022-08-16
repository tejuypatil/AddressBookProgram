package com.bridgelabz.address.booksystem;

import java.util.Scanner;

class Contact{
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
  /*  Contact(String firstName, String lastName, String address, String city, String state, String zip, String mobileNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = mobileNumber;
        this.email = email;
    }*/

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
        System.out.print("First Name:-" + firstName);
         System.out.print(" Last Name:-" + lastName);
        System.out.print(" Address:-" + address);
        System.out.print(" City:-" + city);
        System.out.print(" State:-" + state);
        System.out.print(" Zip Code:-" + zip);
        System.out.print(" Mobile Number:-" + phoneNumber);
        System.out.println(" Email Id:-" + email);
    }

    public boolean equals(Object c) {
        if (this.firstName.equals(((Contact) c).firstName)) {
            return true;
        } else {
            return false;
        }
    }


}