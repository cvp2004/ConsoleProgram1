package src.baseclasses.baseclasses;

import java.util.Scanner;

public class SupplierClass {
    private String SupplierName;
    private String SupplierId;
    private String City;
    private String primaryProductId;
    @SuppressWarnings("FieldMayBeFinal")
    private ContactPersonInfoClass ContactPerson = new ContactPersonInfoClass();

    public String returnSupplierName() { return SupplierName; }
    public String returnSupplierId() { return SupplierId; }
    public String returnSupplierCity() { return City; }
    public String returnPrimaryProductId() { return primaryProductId; }
    public String returnContactPersonName() {return ContactPerson.returnName(); }
    public String returnContactPersonContactNo() {return ContactPerson.returnContactNo(); }
    public String returnContactPersonEmailId() {return ContactPerson.returnEmailId(); }

    public void setSupplierName(String supplierName) { SupplierName = supplierName; }
    public void setSupplierId(String supplierId) { SupplierId = supplierId; }
    public void setSupplierCity(String city) { City = city; }
    public void setPrimaryProductId(String primaryProductId) { this.primaryProductId = primaryProductId; }
    public void setContactPersonName(String contactPersonName) { ContactPerson.setName(contactPersonName); }
    public void setContactPersonContactNo(String contactPersonContactNo) { ContactPerson.setContactNo(contactPersonContactNo); }
    public void setContactPersonEmailId(String contactPersonEmailId) { ContactPerson.setEmailId(contactPersonEmailId); }

    public boolean checkSupplierId(String supplierId) { return returnSupplierId().equals(supplierId); }
    public boolean checkSupplierName(String supplierName) { return returnSupplierName().equals(supplierName); }
    public boolean checkPrimaryProductId(String primaryProductId) { return returnPrimaryProductId().equals(primaryProductId); }

    public void setData() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Supplier Name                : ");
        this.setSupplierId(sc.nextLine());
        System.out.print("Enter City Name                    : ");
        this.setSupplierCity(sc.nextLine());
        System.out.print("Enter Primary Product Id           : ");
        this.setPrimaryProductId(sc.nextLine());
        System.out.print("Enter Contact Person's Name        : ");
        this.setContactPersonName(sc.nextLine());
        System.out.print("Enter Contact Person's Contact No. : ");
        this.setContactPersonContactNo(sc.nextLine());
        System.out.print("Enter Contact Person's Email Id    : ");
        this.setContactPersonEmailId(sc.nextLine());

    }
    public void showData() {
        System.out.println("Supplier Id        : " + this.returnSupplierId());
        System.out.println("Supplier Co.       : " + this.returnSupplierName());
        System.out.println("Supplier City      : " + this.returnSupplierCity());
        System.out.println("Primary Product Id : " + this.returnPrimaryProductId());
        System.out.println("Contact Person     : " + this.ContactPerson.returnName());
        System.out.println("Contact No.        : " + this.ContactPerson.returnContactNo());
        System.out.println("Email Id           : " + this.ContactPerson.returnEmailId());
    }
    public void editDetails() {
        Scanner sc = new Scanner(System.in);
        int choice = 1;

        do {
            System.out.println("1. Edit Supplier-Name");
            System.out.println("2. Edit Primary Product-Id");
            System.out.println("3. Edit City");
            System.out.println("4. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();
            sc.skip("\n");

            switch (choice) {

                case 1 -> {
                    System.out.println("Current Supplier-Name   : " + this.returnSupplierName());
                    System.out.print("Enter New Supplier-Name : ");
                    this.setSupplierName(sc.nextLine());
                    System.out.println("!!  Supplier Details Successfully Edited  !!");
                }

                case 2 -> {
                    System.out.println("Current Primary Product-Id   : " + this.returnPrimaryProductId());
                    System.out.print("Enter New Primary Product-Id : ");
                    this.setPrimaryProductId(sc.nextLine());
                    System.out.println("!!  Supplier Details Successfully Edited  !!");
                }

                case 3 -> {
                    System.out.println("Current Supplier City   : " + this.returnSupplierCity());
                    System.out.print("Enter New Supplier City : ");
                    this.setSupplierCity(sc.nextLine());
                    System.out.println("!!  Supplier Details Successfully Edited  !!");
                }

                case 4 -> {}

                default -> System.out.println("!!  Enter Valid Input  !!");
            }

        } while(choice != 4);
    }
}
