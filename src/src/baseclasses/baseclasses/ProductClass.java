package src.baseclasses.baseclasses;

import java.util.Scanner;

import static java.lang.System.*;
import static java.lang.System.out;

public class ProductClass {
    private String ProductId;
    private String ProductName;
    private int CurrentUnitsInStock =  0;
    private int Cost;

    public String returnProductId() { return ProductId; }
    public String returnProductName() { return ProductName; }
    public int returnProductQuantity() { return CurrentUnitsInStock; }
    public int returnCost() { return Cost; }

    public void setProductId(String productId) { ProductId = productId; }
    public void setProductName(String productName) { ProductName = productName; }
    public void setCost(int cost) { Cost = cost; }
    public void setProductQuantity(int quantity) { CurrentUnitsInStock = quantity; }

    public boolean checkProductId(String productId) { return returnProductId().equals(productId); }
    public boolean checkProductName(String productName) { return returnProductName().equals(productName); }

    public void setData() {
        Scanner sc = new Scanner(in);

        out.print("Enter Product-Name      : ");
        this.setProductName(sc.nextLine());
        out.print("Enter Cost per Unit     : ");
        this.setCost(sc.nextInt());
        out.print("Current No. of Units    : ");
        this.setProductQuantity(sc.nextInt());
    }
    public void showData() {
        out.println("Product-Id             : " + String.valueOf(Integer.parseInt(this.returnProductId()) + 1));
        out.println("Product-Name           : " + this.returnProductName());
        out.println("Current Units in Stock : " + this.returnProductQuantity());
        out.println("Cost                   : " + this.returnCost());
    }
    public void editDetails() {
        Scanner sc = new Scanner(in);
        int choice = 1;

        do {
            out.println("1. Edit Product-Name");
            out.println("2. Edit Product Quantity");
            out.println("3. Edit Product Cost");
            out.println("4. Exit");

            out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    out.println("Current Product-Name   : " + this.returnProductName());
                    sc.skip("\n");
                    out.println("Enter New Product-Name : ");
                    this.setProductName(sc.nextLine());
                    out.println("!!  Product Successfully Edited  !!");
                }

                case 2 -> {
                    out.println("Current Product Units Available : " + this.returnProductQuantity());
                    sc.skip("\n");
                    out.println("Enter New Product Quatities     : ");
                    this.setProductName(sc.nextLine());
                    out.println("!!  Product Successfully Edited  !!");
                }

                case 3 -> {
                    out.println("Current Product-Cost   : " + this.returnCost());
                    out.println("Enter New Product-Cost : ");
                    this.setCost(sc.nextInt());
                    out.println("!!  Product Successfully Edited  !!");
                }

                case 4 -> {

                }

                default -> out.println("!!  Enter Valid Input  !!");
            }

        } while(choice != 4);
    }

    public void increaseProductUnits(int x) {
        this.CurrentUnitsInStock += x;
    }

    public void decreaseProductUnits(int x) {
        if(x <= this.CurrentUnitsInStock)
            this.CurrentUnitsInStock -= x;
    }
}
