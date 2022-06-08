package src.baseclasses.baseclasses;

import java.util.Scanner;

public class CustomerClass {
    private String CustomerId;
    private String CustomerName;
    private String City;
    @SuppressWarnings("FieldMayBeFinal")
    private ContactPersonInfoClass ContactPerson = new ContactPersonInfoClass();

    public String returnCustomerName() { return CustomerName; }
    public String returnCustomerId() { return CustomerId; }
    public String returnCustomerCity() { return City; }
    public String returnContactPersonName() {return ContactPerson.returnName(); }
    public String returnContactPersonContactNo() {return ContactPerson.returnContactNo(); }
    public String returnContactPersonEmailId() {return ContactPerson.returnEmailId(); }

    public void setCustomerName(String customerName) { CustomerName = customerName; }
    public void setCustomerId(String customerId) { CustomerId = customerId; }
    public void setCustomerCity(String city) { City = city; }
    public void setContactPersonName(String contactPersonName) { ContactPerson.setName(contactPersonName); }
    public void setContactPersonContactNo(String contactPersonContactNo) { ContactPerson.setContactNo(contactPersonContactNo); }
    public void setContactPersonEmailId(String contactPersonEmailId) { ContactPerson.setEmailId(contactPersonEmailId); }

    public boolean checkCustomerId(String CustomerId) { return returnCustomerId().equals(CustomerId); }
    public boolean checkCustomerName(String CustomerName) { return returnCustomerName().equals(CustomerName); }

    public void setData() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer Name                : ");
        this.setCustomerName(sc.nextLine());
        System.out.print("Enter City Name                    : ");
        this.setCustomerCity(sc.nextLine());
        System.out.print("Enter Contact Person's Name        : ");
        this.setContactPersonName(sc.nextLine());
        System.out.print("Enter Contact Person's Contact No. : ");
        this.setContactPersonContactNo(sc.nextLine());
        System.out.print("Enter Contact Person's Email Id    : ");
        this.setContactPersonEmailId(sc.nextLine());

    }
    public void showData() {
        System.out.println("Customer Id        : " + String.valueOf(Integer.parseInt(this.returnCustomerId()) + 1));
        System.out.println("Customer Co.       : " + this.returnCustomerName());
        System.out.println("Customer City      : " + this.returnCustomerCity());
        System.out.println("Contact Person     : " + this.ContactPerson.returnName());
        System.out.println("Contact No.        : " + this.ContactPerson.returnContactNo());
        System.out.println("Email Id           : " + this.ContactPerson.returnEmailId());
    }
    public void editDetails() {
        Scanner sc = new Scanner(System.in);
        int choice = 1;

        do {
            System.out.println("1. Edit Customer-Name");
            System.out.println("2. Edit City");
            System.out.println("3. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();
            sc.skip("\n");

            switch (choice) {
                case 1 -> {
                    System.out.println("Current Customer-Name   : " + this.returnCustomerName());
                    System.out.print("Enter New Customer-Name : ");
                    this.setCustomerName(sc.nextLine());
                    System.out.println("!!  Customer Details Successfully Edited  !!");
                }

                case 2 -> {
                    System.out.println("Current Customer City   : " + this.returnCustomerCity());
                    System.out.print("Enter New Customer City : ");
                    this.setCustomerCity(sc.nextLine());
                    System.out.println("!!  Customer Details Successfully Edited  !!");
                }

                default -> System.out.println("!!  Enter Valid Input  !!");
            }

        } while(choice != 3);
    }
}
