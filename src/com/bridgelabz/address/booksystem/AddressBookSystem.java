package com.bridgelabz.address.booksystem;

public class AddressBookSystem {

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        Contact object = new Contact("Tejaswini","Patil","Chandgad","Kolhpur","Maharashtra","416509","9422630373","tejuypatil@gmail.com" );
        object.contacts();
    }

}
class Contact
{
        String firstName;
        String lastName;
        String address;
        String city;
        String state;
        String zip;
        String phoneNumber;
        String email;

    Contact(String firstName, String lastName,String address,String city,String state,String zip,String mobileNumber,String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = mobileNumber;
        this.email  = email;
    }
    public void contacts()
    {
        System.out.println("First Name:-"+firstName);
        System.out.println("Last Name:-"+lastName);
        System.out.println("Address:-"+address);
        System.out.println("City:-"+city);
        System.out.println("State:-"+state);
        System.out.println("Zip Code:-"+zip);
        System.out.println("Mobile Number:-"+phoneNumber);
        System.out.println("Email Id:-"+email);
    }
}


