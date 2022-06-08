package src.baseclasses.baseclasses;

import java.time.LocalDate;
import java.util.Scanner;

public class InventoryLocationClass {
    private Boolean Status = false;
    private String ProductId;
    private String SupplierId;
    private int UnitCount;

    public Boolean returnStatus() { return this.Status; }
    public String returnProductId() { return this.ProductId; }
    public String returnSupplierId() { return this.SupplierId; }
    public int returnUnitCount() { return this.UnitCount; }

    public void setStatus(Boolean status) { Status = status; }
    public void setProductId(String productId) { ProductId = productId; }
    public void setSupplierId(String supplierId) { SupplierId = supplierId; }
    public void setUnitCount(int unitCount) { this.UnitCount = unitCount; }

    public void setData() {
        boolean i;
        Scanner sc = new Scanner(System.in);

        this.setStatus(true);

        System.out.print("Enter Product-Id                  : ");
        this.setProductId(sc.nextLine());
        System.out.print("Enter Supplier-Id                 : ");
        this.setSupplierId(sc.nextLine());
        System.out.print("Enter No. of Units of the Product : ");
        int y = sc.nextInt();

        this.setUnitCount(y);
    }
    public void showData() {
        System.out.println("Product-Id              : " + this.returnProductId());
        System.out.println("Supplier-Id             : " + this.returnSupplierId());
        System.out.println("No. of Units of Product : " + this.returnUnitCount());
    }
    public void updateData() {

        boolean i;
        Scanner sc = new Scanner(System.in);

        System.out.println("\nCurrent Data ->");
        System.out.println("Product-Id   : " + this.returnProductId());
        System.out.println("Supplier-Id  : " + this.returnSupplierId());
        System.out.println("No. of Units : " + this.returnUnitCount());

        int choice = 0;

        do {
            System.out.println();
            System.out.println("1. Edit Product Id");
            System.out.println("2. Edit Supplier Id");
            System.out.println("3. Edit No. of Units in Stock");
            System.out.println("4. Exit");

            System.out.print("\nEnter Your Choice : ");
            choice = sc.nextInt();
            sc.skip("\n");

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Product-Id   : ");
                    this.setProductId(sc.nextLine());
                    System.out.println("\n!!  Inventory Location Successfully Edited  !!");
                }
                case 2 -> {
                    System.out.print("Enter Supplier-Id   : ");
                    this.setSupplierId(sc.nextLine());
                    System.out.println("\n!!  Inventory Location Successfully Edited  !!");
                }
                case 3 -> {
                    System.out.print("Enter Supplier-Id   : ");
                    this.setUnitCount(sc.nextInt());
                    System.out.println("\n!!  Inventory Location Successfully Edited  !!");
                }
                case 4 -> {

                }
                default -> {
                    System.out.println("\n!!  Enter Valid Input  !!");
                }
            }


        } while(choice != 4);



    }
}
