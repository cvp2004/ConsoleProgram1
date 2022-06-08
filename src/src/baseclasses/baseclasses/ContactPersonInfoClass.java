package src.baseclasses.baseclasses;

import java.util.Scanner;

public class ContactPersonInfoClass {
    private String name;
    private String contactNo;
    private String emailId;

    public String returnName() { return name; }
    public String returnContactNo() { return contactNo; }
    public String returnEmailId() { return emailId; }

    public void setName(String name) { this.name = name; }
    public void setContactNo(String contactNo) { this.contactNo = contactNo; }
    public void setEmailId(String emailId) { this.emailId = emailId; }

    public void getData() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee Name : ");
        this.setName(sc.nextLine());
        System.out.print("Enter Contact No.   : ");
        this.setContactNo(sc.nextLine());
        System.out.print("Enter Email Id      : ");
        this.setEmailId(sc.nextLine());
    }

    public void showData() {
        System.out.println("Employee Name : " + returnName());
        System.out.println("Contact No.   : " + returnContactNo());
        System.out.println("Email-Id      : " + returnEmailId());
    }
}
