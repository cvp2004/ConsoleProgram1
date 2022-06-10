import src.baseclasses.baseclasses.CustomerClass;
import src.baseclasses.baseclasses.InventoryLocationClass;
import src.baseclasses.baseclasses.ProductClass;
import src.baseclasses.baseclasses.SupplierClass;
import src.invoiceclasses.baseclasses.SalesInvoiceClass;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;


public class InventoryManagementSystem {

    private static InventoryManagementSystem single_Instance = null;

    public static InventoryManagementSystem getInstance() {
        if(single_Instance == null)  {
            single_Instance = new InventoryManagementSystem();
        }
        return single_Instance;
    }

    public static class InventoryClass {

        private static InventoryClass single_instance = null;

        public static  InventoryClass getInstance() {
            if(single_instance == null) {
                single_instance = new InventoryClass();
            }

            return single_instance;
        }

        private static final int size = 10;
        @SuppressWarnings("FieldMayBeFinal")
        private static InventoryLocationClass[][] Inventory = new InventoryLocationClass[size][size];

        private InventoryClass() {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    Inventory[i][j] = new InventoryLocationClass();
                }
            }
        }

        public static void setDataOfInventoryLocation() {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Sector No. : ");
            int sectorNo = sc.nextInt();

            System.out.print("Enter Unit No. : ");
            int unitNo = sc.nextInt();

            System.out.println();

            int sectorIndex = sectorNo - 1, unitIndex = unitNo - 1;

            if(sectorIndex > 9 || unitIndex > 9) {
                System.out.println("\t!!  Invalid Input  !!");
                System.out.println("Total No. of Sectors : 10");
                System.out.println("Total No. of Units   : 10");
            } else {
                if(Inventory[sectorIndex][unitIndex].returnStatus())
                    System.out.println("!!  The Unit is Already Occupied  !!");
                else {
                    Inventory[sectorIndex][unitIndex].setData();

                    System.out.println("\n!!  Unit Successfully Allotted  !!");
                }
            }
        }
        public static void relieveDataOfInventoryLocation() {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Sector No. : ");
            int sectorNo = sc.nextInt();

            System.out.print("\nEnter Unit No. : ");
            int unitNo = sc.nextInt();

            int sectorIndex = sectorNo - 1;
            int unitIndex = unitNo - 1;

            if(Inventory[sectorIndex][unitIndex].returnStatus()) {
                Inventory[sectorIndex][unitIndex].setStatus(false);
                System.out.println("!!  Unit Successfully Relieved  !!");
            }
            else
                System.out.println("!!  The Unit is Already Relieved  !!");
        }
        public static void updateDataOfInventoryLocation() {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Sector No. : ");
            int sectorNo = sc.nextInt();

            System.out.print("\nEnter Unit No. : ");
            int unitNo = sc.nextInt();

            int sectorIndex = sectorNo - 1, unitIndex = unitNo - 1;

            if(Inventory[sectorIndex][unitIndex].returnStatus())
                Inventory[sectorIndex][unitIndex].updateData();
            else
                System.out.println("!!  The Unit is Already Relieved  !!");
        }
        public static void showDataOfInventoryLocation() {
            Scanner sc = new Scanner(System.in);

            System.out.print("\nEnter Sector No. : ");
            int sectorNo = sc.nextInt();
            System.out.print("Enter Unit No.   : ");
            int unitNo = sc.nextInt();

            int sectorIndex = sectorNo - 1, unitIndex = unitNo - 1;

            if(Inventory[sectorIndex][unitIndex].returnStatus()) {
                System.out.println("\nUnit Details :");
                Inventory[sectorIndex][unitIndex].showData();
            }
            else
                System.out.println("!!  The Unit is Already Relieved  !!");
        }
        public static void showDataOfInventory() {
            Scanner sc = new Scanner(System.in);
            int choice, sectorNo;

            do {
                System.out.println("\n1. See Data");
                System.out.println("2. Exit");

                System.out.print("\nEnter Your Choice: ");
                choice = sc.nextInt();

                switch(choice) {
                    case 1 -> {
                        System.out.print("\nEnter Sector No.: ");
                        sectorNo = sc.nextInt();

                        System.out.println();
                        int sectorIndex = sectorNo - 1;

                        if(sectorIndex > 9) {
                            System.out.println("!!  Enter Valid Input  !!");
                            System.out.println("Total No. of Sectors : " + size);
                        } else {
                            String frmt = "%-20s |%-7s \n";

                            System.out.printf(frmt, "Unit No.", "Status");
                            for (int i = 0; i < 40; i++)
                                System.out.print("-");

                            System.out.println();

                            for (int i = 0; i < size; i++) {

                                boolean Status = Inventory[sectorIndex][i].returnStatus();
                                String status = Status ? "Occupied" : "Empty" ;

                                System.out.printf(frmt, i + 1, status);
                            }
                        }
                    }

                    case 2 -> {}

                    default -> {
                        System.out.println("!!  Enter Valid Input  !!");
                    }
                }
            } while (choice != 2);
        }

        public static void inventoryManagementMenu() {

            Scanner sc = new Scanner(System.in);
            int choice = 0;

            do {
                System.out.println();
                for (int i = 1; i <= 173; i++) System.out.print("*"); System.out.println();
                for (int i = 0; i < 75; i++) System.out.print(" "); System.out.println("!!  INVENTORY MANAGEMENT MENU  !!");
                for (int i = 1; i <= 173; i++) System.out.print("*"); System.out.println();
                System.out.println("\n");

                System.out.println("1. ALLOT A UNIT");
                System.out.println("2. RELIEVE A UNIT");
                System.out.println("3. UPDATE DETAILS OF A UNIT");
                System.out.println("4. SHOW DATA OF A PARTICULAR UNIT");
                System.out.println("5. SHOW STATUS OF ALL THE UNITS");
                System.out.println("6. RETURN TO MAIN-MENU");

                System.out.print("\nEnter Your Choice: ");
                choice = sc.nextInt();

                System.out.println();

                switch (choice) {
                    case 1 -> {
                        setDataOfInventoryLocation();
                    }

                    case 2 -> {
                        relieveDataOfInventoryLocation();
                    }

                    case 3 -> {
                        updateDataOfInventoryLocation();
                    }

                    case 4 -> {
                        showDataOfInventoryLocation();
                    }

                    case 5 -> {
                        showDataOfInventory();
                    }

                    case 6 -> {
                        // Return To Main-Menu
                    }

                    default -> {
                        System.out.println("!!  ENTER VALID OPTION  !!");
                    }
                }
            } while (choice != 6);
        }
    }

    public static class SupplierListClass {

        protected static LinkedList<SupplierClass> sList = new LinkedList<SupplierClass>();

        private static SupplierListClass single_instance = null;

        public static  SupplierListClass getInstance() {
            if(single_instance == null) {
                single_instance = new SupplierListClass();
            }

            return single_instance;
        }

        public static void addSupplier() {

            SupplierClass x = new SupplierClass();
            x.setData();

            if(ProductListClass.returnFoundProductUsingId(x.returnPrimaryProductId()) != -1) {
                if(sList.contains(x)) {
                    System.out.println("!!  Supplier Already Present  !!");
                    sList.get(sList.indexOf(x)).showData();
                } else {
                    sList.add(x);
                    sList.getLast().setSupplierId(Integer.toString(sList.indexOf(x)));

                    Comparator<SupplierClass> byId = Comparator.comparing(SupplierClass :: returnSupplierId);
                    Collections.sort(sList, byId);

                    System.out.println("\t\t!!  New Supplier SuccessFully Added  !!");
                    System.out.println();
                    sList.getLast().showData();
                }
            } else {
                System.out.println("!!  No Product with " + x.returnPrimaryProductId() + " Id Registered  !!");
            }
        }
        public static void removeSupplier() {
            Scanner sc = new Scanner(System.in);
            int choice = 0;

            do {
                System.out.println("1. Search Supplier using Id");
                System.out.println("2. Search Supplier using Name");
                System.out.println("3. Search Supplier using Primary Product Id");
                System.out.println("4. Exit");

                System.out.print("\nEnter Your Choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        int indexOfObject = 0;

                        System.out.print("Enter Supplier-Id: ");
                        String id = sc.nextLine();

                        for (int i = 0; i < sList.size(); i++) {
                            boolean result = sList.get(i).checkSupplierId(id);
                            if (result) {
                                indexOfObject = i;
                            }
                        }

                        if(indexOfObject == -1) {
                            System.out.println("!!  Supplier Not Found  !!");
                        }
                        else {
                            System.out.println("!!  Supplier Found  !!");
                            sList.remove(indexOfObject);
                            System.out.println("!!  Supplier Successfully Removed  !!");
                        }

                    }
                    case 2 -> {
                        int indexOfObject = 0;

                        System.out.print("Enter Supplier-Name: ");
                        String name = sc.nextLine();

                        for (int i = 0; i < sList.size(); i++) {
                            boolean result = sList.get(i).checkSupplierName(name);
                            if (result) {
                                indexOfObject = i;
                            }
                        }

                        if(indexOfObject == -1) {
                            System.out.println("!!  Supplier Not Found  !!");
                        }
                        else {
                            System.out.println("!!  Supplier Found  !!");
                            sList.remove(indexOfObject);
                            System.out.println("!!  Supplier Successfully Removed  !!");
                        }
                    }
                    case 3 -> {
                        int indexOfObject = 0;

                        System.out.print("Enter Primary Product's Id: ");
                        String productId = sc.nextLine();

                        for (int i = 0; i < sList.size(); i++) {
                            boolean result = sList.get(i).checkPrimaryProductId(productId);
                            if (result) {
                                indexOfObject = i;
                            }
                        }

                        if(indexOfObject == -1) {
                            System.out.println("!!  Supplier Not Found  !!");
                        }
                        else {
                            System.out.println("!!  Supplier Found  !!");
                            sList.remove(indexOfObject);
                            System.out.println("!!  Supplier Successfully Removed  !!");
                        }
                    }
                    case 4 -> {}

                    default -> {
                        System.out.println("!! Please Enter Valid Input !!");
                    }
                }
            }while (choice != 4);
        }
        public static void editSupplierDetails() {
            Scanner sc = new Scanner(System.in);
            int choice = 1;
            sc.skip("\n");

            do {
                System.out.println("1. Search Supplier using Id");
                System.out.println("2. Search Supplier using Name");
                System.out.println("3. Search Supplier using Primary Product Id");
                System.out.println("4. Exit");

                System.out.print("\nEnter Your Choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {

                        System.out.print("Enter Supplier-Id : ");
                        String id = sc.nextLine();

                        int indexOfObject = returnFoundSupplierUsingId(id);

                        if(indexOfObject == -1) {
                            System.out.println("!!  Supplier Not Found  !!");
                        }
                        else {
                            System.out.println("!!  Supplier Found  !!");
                            sList.get(indexOfObject).editDetails();
                        }

                    }

                    case 2 -> {

                        System.out.print("Enter Supplier-Name : ");
                        String name = sc.nextLine();

                        int indexOfObject = returnFoundSupplierUsingName(name);

                        if(indexOfObject == -1) {
                            System.out.println("!!  Supplier Not Found  !!");
                        }
                        else {
                            System.out.println("!!  Supplier Found  !!");
                            sList.get(indexOfObject).editDetails();
                        }
                    }

                    case 3 -> {

                        System.out.print("Enter Primary Product Id : ");
                        String primaryProductId = sc.nextLine();

                        int indexOfObject = returnFoundSupplierUsingPrimaryProductId(primaryProductId);

                        if(indexOfObject == -1) {
                            System.out.println("!!  Supplier Not Found  !!");
                        }
                        else {
                            System.out.println("!!  Supplier Found  !!");
                            sList.get(indexOfObject).editDetails();
                        }
                    }

                    case 4 -> {}

                    default -> System.out.println("!! Please Enter Valid Input !!");
                }
            }while (choice != 4);

        }
        public static void viewSupplierDetails() {
            Scanner sc = new Scanner(System.in);
            int choice = 0;

            do {
                System.out.println("1. Search Supplier using Id");
                System.out.println("2. Search Supplier using Name");
                System.out.println("3. Search Supplier using Primary Product Id");
                System.out.println("4. Exit");

                System.out.print("\nEnter Your Choice: ");
                choice = sc.nextInt();
                sc.skip("\n");

                switch (choice) {
                    case 1 -> {
                        int indexOfObject = -1;

                        System.out.print("Enter Supplier-Id: ");
                        String id = sc.nextLine();

                        for (int i = 0; i < sList.size(); i++) {
                            boolean result = sList.get(i).checkSupplierId(id);
                            if (result) {
                                indexOfObject = i;
                            }
                        }

                        if(indexOfObject == -1) {
                            System.out.println("!!  Supplier Not Found  !!");
                        }
                        else {
                            System.out.println("!!  Supplier Found  !!");
                            sList.get(indexOfObject).showData();
                        }
                    }
                    case 2 -> {
                        int indexOfObject = -1;

                        System.out.print("Enter Supplier-Name: ");
                        String name = sc.nextLine();

                        for (int i = 0; i < sList.size(); i++) {
                            boolean result = sList.get(i).checkSupplierName(name);
                            if (result) {
                                indexOfObject = i;
                            }
                        }

                        if(indexOfObject == -1) {
                            System.out.println("!!  Supplier Not Found  !!");
                        }
                        else {
                            System.out.println("!!  Supplier Found  !!");
                            sList.get(indexOfObject).showData();
                        }
                    }
                    case 3 -> {
                        int indexOfObject = -1;

                        System.out.print("Enter Primary Product's Id: ");
                        String productId = sc.nextLine();

                        for (int i = 0; i < sList.size(); i++) {
                            boolean result = sList.get(i).checkPrimaryProductId(productId);
                            if (result) {
                                indexOfObject = i;
                            }
                        }

                        if(indexOfObject == -1) {
                            System.out.println("!!  Supplier Not Found  !!");
                        }
                        else {
                            System.out.println("!!  Supplier Found  !!");
                            sList.get(indexOfObject).showData();
                        }
                    }
                    case 4 -> {}

                    default -> {
                        System.out.println("!! Please Enter Valid Input !!");
                    }
                }
            }while (choice != 4);
        }

        public static void displayListAll() {
            for (int i = 1; i <= 122; i++)  System.out.print("-"); System.out.println();
            for (int i = 1; i <= 50; i++) System.out.print(" ");   System.out.println("!! Supplier Details !!");
            for (int i = 1; i <= 122; i++)  System.out.print("-"); System.out.println();

            String frmt = "|%-10s|%-25s|%-25s|%-25s|%-30s|\n";
            System.out.printf(frmt, "Sr. No.", "Supplier Id", "Supplier Name", "City", "Product Id");
            for (int i = 1; i <= 122; i++) System.out.print("-");
            System.out.println();
            for (SupplierClass x : sList) {
                System.out.printf(frmt, sList.indexOf(x) + 1, x.returnSupplierId(), x.returnSupplierName(), x.returnSupplierCity()
                        , x.returnPrimaryProductId());
            }
        }
        public static void displayListContactDetails() {
            for (int i = 1; i <= 172; i++)  System.out.print("-"); System.out.println();
            for (int i = 1; i <= 71; i++) System.out.print(" ");   System.out.println("!! Supplier Contact Details !!");
            for (int i = 1; i <= 172; i++)  System.out.print("-"); System.out.println();

            String frmt = "|%-20s|%-25s|%-30s|%-30s|%-30s|%-30s|\n";
            System.out.printf(frmt,"Supplier Id", "Supplier Name", "Supplier's City", "Contact Person", "Contact No.", "Email-Id");
            for (int i = 1; i <= 172; i++)  System.out.print("-");
            System.out.println();

            for (SupplierClass x : sList) {
                System.out.printf(frmt,x.returnSupplierId(), x.returnSupplierName(), x.returnSupplierCity()
                        , x.returnContactPersonName(), x.returnContactPersonContactNo(), x.returnContactPersonEmailId());
            }
        }

        public static int returnFoundSupplierUsingId(String supplierId) {
            int indexOfObject = -1;

            for (int i = 0; i < sList.size(); i++) {
                boolean result = sList.get(i).checkSupplierId(supplierId);
                if (result) {
                    indexOfObject = i;
                }
            }
            return indexOfObject;
        }
        public static int returnFoundSupplierUsingName(String supplierName) {
            int indexOfObject = -1;

            for (int i = 0; i < sList.size(); i++) {
                boolean result = sList.get(i).checkSupplierName(supplierName);
                if (result) {
                    indexOfObject = i;
                }
            }

            return indexOfObject;
        }
        public static int returnFoundSupplierUsingPrimaryProductId(String productId) {
            int indexOfObject = -1;

            for (int i = 0; i < sList.size(); i++) {
                boolean result = sList.get(i).checkPrimaryProductId(productId);
                if (result) {
                    indexOfObject = i;
                }
            }

            return indexOfObject;
        }

        public static void supplierListMenu() {

            Scanner sc = new Scanner(System.in);
            int choice = 0;

            do {
                for (int i = 1; i <= 172; i++) System.out.print("*"); System.out.println();
                for (int i = 0; i < 67; i++) System.out.print(" "); System.out.println("!!  SUPPLIER-LIST MANAGEMENT MENU  !!");
                for (int i = 1; i <= 172; i++) System.out.print("*"); System.out.println();
                System.out.println("\n");

                System.out.println("1. ADD A SUPPLIER");
                System.out.println("2. REMOVE A SUPPLIER");
                System.out.println("3. UPDATE DETAILS OF A SUPPLIER");
                System.out.println("4. SHOW DATA OF A PARTICULAR SUPPLIER");
                System.out.println("5. SHOW ALL THE SUPPLIERS");
                System.out.println("6. SHOW CONTACT DETAILS OF ALL THE SUPPLIERS");
                System.out.println("7. RETURN TO MAIN-MENU");

                System.out.print("\nEnter Your Choice: ");
                choice = sc.nextInt();
                sc.skip("");
                System.out.println();

                switch (choice) {
                    case 1 -> {
                        addSupplier();
                    }

                    case 2 -> {
                        removeSupplier();
                    }

                    case 3 -> {
                        editSupplierDetails();
                    }

                    case 4 -> {
                        viewSupplierDetails();
                    }

                    case 5 -> {
                        displayListAll();
                    }

                    case 6 -> {
                        displayListContactDetails();
                    }

                    case 7 -> {
                        //Return To Main-Menu
                    }

                    default -> {
                        System.out.println("!!  ENTER VALID OPTION  !!");
                    }
                }
            } while (choice != 7);
        }

    }

    public static class ProductListClass {

        protected static LinkedList<ProductClass> pList = new LinkedList<ProductClass>();

        private static ProductListClass single_instance = null;

        public static  ProductListClass getInstance() {
            if(single_instance == null) {
                single_instance = new ProductListClass();
            }

            return single_instance;
        }

        public static ProductClass returnProduct(int x) {
            return pList.get(x);
        }

        public static void addProduct() {

            System.out.println("Current Size : " + pList.size());

            ProductClass x = new ProductClass();
            x.setData();

            if(pList.contains(x)) {
                System.out.println("!!  Product Already Present  !!");
                pList.get(pList.indexOf(x)).showData();
            } else {
                pList.add(x);
                pList.getLast().setProductId(Integer.toString(pList.indexOf(x)));

                Comparator<ProductClass> byId = Comparator.comparing(ProductClass :: returnProductId);
                Collections.sort(pList, byId);

                System.out.println("\t\t!!  New Product SuccessFully Added  !!");
                System.out.println();
                pList.getLast().showData();
            }
        }
        public static void removeProduct() {
            Scanner sc = new Scanner(System.in);
            int choice = 0;

            do {
                System.out.println("1. Search Product using Id");
                System.out.println("2. Search Product using Name");
                System.out.println("3. Exit");

                System.out.print("\nEnter Your Choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        int indexOfObject = 0;

                        sc.skip("\n");
                        System.out.print("\nEnter Product-Id: ");
                        String id = sc.nextLine();

                        for (int i = 0; i < pList.size(); i++) {
                            boolean result = pList.get(i).checkProductId(id);
                            if (result) {
                                indexOfObject = i;
                            }
                        }

                        if(indexOfObject == -1) {
                            System.out.println("\n!!  No Product Found  !!");
                        } else {
                            System.out.println();
                            pList.get(indexOfObject).showData();
                            pList.remove(indexOfObject);
                            System.out.println("\n!!  Product Successfully Removed  !!");
                        }
                    }
                    case 2 -> {
                        int indexOfObject = 0;

                        sc.skip("\n");
                        System.out.print("\nEnter Product-Name: ");
                        String name = sc.nextLine();

                        for (int i = 0; i < pList.size(); i++) {
                            boolean result = pList.get(i).checkProductName(name);
                            if (result) {
                                indexOfObject = i;
                            }
                        }

                        if(indexOfObject == -1) {
                            System.out.println("\n!!  No Product Found  !!");
                        } else {
                            System.out.println();
                            pList.get(indexOfObject).showData();
                            pList.remove(indexOfObject);
                            System.out.println("\n!!  Product Successfully Removed  !!");
                        }
                    }
                    case 3 -> {}

                    default -> {
                        System.out.println("!! Please Enter Valid Input !!");
                    }
                }
            }while (choice != 3);

        }
        public static void editProductDetails() {
            Scanner sc = new Scanner(System.in);
            int choice;

            do {
                System.out.println("1. Search Product using Id");
                System.out.println("2. Search Product using Name");
                System.out.println("3. Exit");

                System.out.print("\nEnter Your Choice: ");
                choice = sc.nextInt();
                sc.skip("");
                System.out.println();

                switch (choice) {
                    case 1 -> {
                        int indexOfObject = -1;

                        sc.skip("\n");
                        System.out.print("Enter Product-Id: ");
                        String id = String.valueOf(Integer.parseInt(sc.nextLine()) - 1);

                        for (int i = 0; i < pList.size(); i++) {
                            boolean result = pList.get(i).checkProductId(id);
                            if (result) {
                                indexOfObject = i;
                            }
                        }

                        if(indexOfObject == -1) {
                            System.out.println("!!  Product Not Found  !!");
                        } else {
                            System.out.println("!!  Product Found  !!");
                            pList.get(indexOfObject).editDetails();
                        }
                    }

                    case 2 -> {
                        int indexOfObject = -1;

                        sc.skip("\n");
                        System.out.print("Enter Product-Name: ");
                        String name = sc.nextLine();

                        for (int i = 0; i < pList.size(); i++) {
                            boolean result = pList.get(i).checkProductName(name);
                            if (result) {
                                indexOfObject = i;
                            }
                        }

                        if(indexOfObject == -1) {
                            System.out.println("!!  Product Not Found  !!");
                        } else {
                            System.out.println("!!  Product Found  !!");
                            pList.get(indexOfObject).editDetails();
                        }
                    }

                    case 3 -> {}

                    default -> System.out.println("!! Please Enter Valid Input !!");
                }
            }while (choice != 3);
        }
        public static void displayListAll() {

            String frmt = "|%-25s|%-25s|%-25s|\n";

            System.out.printf(frmt,"Product Id", "Product Name", "Available Units");
            for (int i = 1; i <= 80; i++)
                System.out.print("-");
            System.out.println();
            for (ProductClass x : pList) {
                System.out.printf(frmt, String.valueOf(Integer.parseInt(x.returnProductId()) + 1), x.returnProductName(), x.returnProductQuantity());
            }
        }
        public static void searchProduct() {
            Scanner sc = new Scanner(System.in);
            int choice = 0;

            do {
                System.out.println();
                System.out.println("1. Search Product using Id");
                System.out.println("2. Search Product using Name");
                System.out.println("3. Exit");

                System.out.print("\nEnter Your Choice: ");
                choice = sc.nextInt();
                sc.skip("\n");
                System.out.println();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter Product-Id: ");
                        String id = String.valueOf(Integer.parseInt(sc.nextLine()) - 1);

                        int indexOfObject = returnFoundProductUsingId(id);

                        if (indexOfObject == -1) {
                            System.out.println("\n!!  Product Not Found  !!");
                        } else {
                            System.out.println("\n!!  Product Found  !!");
                            System.out.println();
                            pList.get(indexOfObject).showData();
                        }
                    }

                    case 2 -> {

                        System.out.print("Enter Product-Name: ");
                        String name = sc.nextLine();

                        int indexOfObject = returnFoundProductUsingName(name);

                        if (indexOfObject == -1) {
                            System.out.println("\n!!  Product Not Found  !!");
                        } else {
                            System.out.println("\n!!  Product Found  !!");
                            System.out.println();
                            pList.get(indexOfObject).showData();
                        }
                    }

                    case 3 -> {}

                    default -> System.out.println("!! Please Enter Valid Input !!");
                }
            }while (choice != 3);
        }

        public static int returnFoundProductUsingName(String productName) {
            int indexOfObject = -1;

            for (int i = 0; i < pList.size(); i++) {
                boolean result = pList.get(i).checkProductName(productName);
                if (result) {
                    indexOfObject = i;
                }
            }

            return indexOfObject;
        }
        public static int returnFoundProductUsingId(String productId) {
            int indexOfObject = -1;

            for (int i = 0; i < pList.size(); i++) {
                boolean result = pList.get(i).checkProductId(productId);
                if (result) {
                    indexOfObject = i;
                }
            }
            return indexOfObject;
        }

        public static void productListManagementMenu() {

            Scanner sc = new Scanner(System.in);
            int choice = 0;

            do {
                System.out.println();
                System.out.println();
                for (int i = 1; i <= 195; i++) System.out.print("*"); System.out.println();
                for (int i = 0; i < 81; i++) System.out.print(" "); System.out.println("!!  PRODUCT-LIST MANAGEMENT MENU  !!");
                for (int i = 1; i <= 195; i++) System.out.print("*"); System.out.println();
                System.out.println("\n");

                System.out.println("1. ADD A PRODUCT");
                System.out.println("2. REMOVE A PRODUCT");
                System.out.println("3. UPDATE DETAILS OF A PRODUCT");
                System.out.println("4. SEARCH A PRODUCT");
                System.out.println("5. SHOW ALL THE PRODUCTS");
                System.out.println("6. RETURN TO MAIN-MENU");

                System.out.print("\nEnter Your Choice: ");
                choice = sc.nextInt();
                System.out.println();

                switch (choice) {
                    case 1 -> {
                        addProduct();
                    }

                    case 2 -> {
                        removeProduct();
                    }

                    case 3 -> {
                        editProductDetails();
                    }

                    case 4 -> {
                        searchProduct();
                    }

                    case 5 -> {
                        displayListAll();
                    }

                    case 6 -> {

                    }

                    default -> {
                        System.out.println("!!  ENTER VALID OPTION  !!");
                    }
                }
            } while (choice != 6);
        }
    }

    public static class CustomerListClass {
        protected static LinkedList<CustomerClass> cList = new LinkedList<CustomerClass>();

        private static CustomerListClass single_instance = null;

        public static  CustomerListClass getInstance() {
            if(single_instance == null) {
                single_instance = new CustomerListClass();
            }

            return single_instance;
        }

        public static void addCustomer() {

            System.out.println();
            CustomerClass x = new CustomerClass();
            x.setData();

            if(cList.contains(x)) {
                System.out.println("!!  Customer Already Present  !!");
                cList.get(cList.indexOf(x)).showData();
            } else {
                cList.add(x);
                cList.getLast().setCustomerId(Integer.toString(cList.indexOf(x)));

                Comparator<CustomerClass> byId = Comparator.comparing(CustomerClass :: returnCustomerId);
                Collections.sort(cList, byId);

                System.out.println("\n\t\t!!  New Customer SuccessFully Added  !!");
                System.out.println();
                cList.getLast().showData();
            }

        }
        public static void removeCustomer() {
            Scanner sc = new Scanner(System.in);
            int choice = 0;

            do {
                System.out.println("1. Search Customer using Id");
                System.out.println("2. Search Customer using Name");
                System.out.println("3. Exit");

                System.out.print("\nEnter Your Choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        int indexOfObject = 0;

                        System.out.print("Enter Customer-Id: ");
                        String id = sc.nextLine();

                        for (int i = 0; i < cList.size(); i++) {
                            boolean result = cList.get(i).checkCustomerId(id);
                            if (result) {
                                indexOfObject = i;
                            }
                        }

                        if(indexOfObject == -1) {
                            System.out.println("!!  Customer Not Found  !!");
                        }
                        else {
                            System.out.println("!!  Customer Found  !!");
                            cList.remove(indexOfObject);
                            System.out.println("!!  Customer Successfully Removed  !!");
                        }

                    }
                    case 2 -> {
                        int indexOfObject = 0;

                        System.out.print("Enter Customer-Name: ");
                        String name = sc.nextLine();

                        for (int i = 0; i < cList.size(); i++) {
                            boolean result = cList.get(i).checkCustomerName(name);
                            if (result) {
                                indexOfObject = i;
                            }
                        }

                        if(indexOfObject == -1) {
                            System.out.println("!!  Customer Not Found  !!");
                        }
                        else {
                            System.out.println("!!  Customer Found  !!");
                            cList.remove(indexOfObject);
                            System.out.println("!!  Customer Successfully Removed  !!");
                        }
                    }
                    case 3 -> {}

                    default -> {
                        System.out.println("!! Please Enter Valid Input !!");
                    }
                }
            }while (choice != 4);
        }
        public static void editCustomerDetails() {
            Scanner sc = new Scanner(System.in);
            int choice = 1;
            sc.skip("\n");

            do {
                System.out.println("1. Search Customer using Id");
                System.out.println("2. Search Customer using Name");
                System.out.println("3. Exit");

                System.out.print("\nEnter Your Choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {

                        System.out.print("Enter Customer-Id : ");
                        String id = sc.nextLine();

                        int indexOfObject = returnFoundCustomerUsingId(id);

                        if(indexOfObject == -1) {
                            System.out.println("!!  Customer Not Found  !!");
                        }
                        else {
                            System.out.println("!!  Customer Found  !!");
                            cList.get(indexOfObject).editDetails();
                        }

                    }

                    case 2 -> {

                        System.out.print("Enter Customer-Name : ");
                        String name = sc.nextLine();

                        int indexOfObject = returnFoundCustomerUsingName(name);

                        if(indexOfObject == -1) {
                            System.out.println("!!  Customer Not Found  !!");
                        }
                        else {
                            System.out.println("!!  Customer Found  !!");
                            cList.get(indexOfObject).editDetails();
                        }
                    }

                    case 3 -> {}

                    default -> System.out.println("!! Please Enter Valid Input !!");
                }
            }while (choice != 3);

        }
        public static void searchCustomer() {
            Scanner sc = new Scanner(System.in);
            int choice = 0;
            sc.skip("\n");

            do {
                System.out.println();
                System.out.println("1. Search Customer using Id");
                System.out.println("2. Search Customer using Name");
                System.out.println("3. Exit");

                System.out.print("\nEnter Your Choice: ");
                choice = sc.nextInt();
                sc.skip("\n");
                System.out.println();

                switch (choice) {
                    case 1 -> {
                        int indexOfObject = -1;

                        System.out.print("\nEnter Customer-Id: ");
                        String id = String.valueOf(Integer.parseInt(sc.nextLine()) - 1);
                        for (int i = 0; i < cList.size(); i++) {
                            boolean result = cList.get(i).checkCustomerId(id);
                            if (result) {
                                indexOfObject = i;
                            }
                        }

                        if(indexOfObject == -1) {
                            System.out.println("\n!!  Customer Not Found  !!");
                        }
                        else {
                            System.out.println("\n!!  Customer Found  !!\n");
                            cList.get(indexOfObject).showData();
                        }
                    }
                    case 2 -> {
                        int indexOfObject = -1;

                        System.out.print("\nEnter Customer-Name: ");
                        String name = sc.nextLine();

                        for (int i = 0; i < cList.size(); i++) {
                            boolean result = cList.get(i).checkCustomerName(name);
                            if (result) {
                                indexOfObject = i;
                            }
                        }

                        if(indexOfObject == -1) {
                            System.out.println("\n!!  Customer Not Found  !!");
                        }
                        else {
                            System.out.println("\n!!  Customer Found  !!\n");
                            cList.get(indexOfObject).showData();
                        }
                    }
                    case 3 -> {}

                    default -> {
                        System.out.println("\n!! Please Enter Valid Input !!");
                    }
                }
            }while (choice != 3);
        }

        public static void displayListAll() {
            for (int i = 1; i <= 90; i++)  System.out.print("-"); System.out.println();
            for (int i = 1; i <= 30; i++) System.out.print(" ");   System.out.println("!! Customer Details !!");
            for (int i = 1; i <= 90; i++)  System.out.print("-"); System.out.println();

            String frmt = "|%-10s|%-25s|%-25s|%-25s|\n";
            System.out.printf(frmt, "Sr. No.", "Customer Id", "Customer Name", "City");
            for (int i = 1; i <= 90; i++) System.out.print("-");
            System.out.println();
            for (CustomerClass x : cList) {
                System.out.printf(frmt, cList.indexOf(x) + 1, String.valueOf(Integer.parseInt(x.returnCustomerId()) + 1), x.returnCustomerName(), x.returnCustomerCity());
            }
        }
        public static void displayListContactDetails() {
            for (int i = 1; i <= 172; i++)  System.out.print("-"); System.out.println();
            for (int i = 1; i <= 76; i++) System.out.print(" ");   System.out.println("!! Customer Contact Details !!");
            for (int i = 1; i <= 172; i++)  System.out.print("-"); System.out.println();

            String frmt = "|%-15s|%-30s|%-30s|%-30s|%-30s|%-30s\n";
            System.out.printf(frmt, "Customer Id", "Customer Name", "Customer's City", "Contact Person", "Contact No.", "Email-Id");
            for (int i = 1; i <= 172; i++)  System.out.print("-");
            System.out.println();

            for (CustomerClass x : cList) {
                System.out.printf(frmt,  String.valueOf(Integer.parseInt(x.returnCustomerId()) + 1), x.returnCustomerName(), x.returnCustomerCity(), x.returnContactPersonName(), x.returnContactPersonContactNo(), x.returnContactPersonEmailId());
            }
        }

        public static int returnFoundCustomerUsingId(String CustomerId) {
            int indexOfObject = -1;

            for (int i = 0; i < cList.size(); i++) {
                boolean result = cList.get(i).checkCustomerId(CustomerId);
                if (result) {
                    indexOfObject = i;
                }
            }
            return indexOfObject;
        }
        public static int returnFoundCustomerUsingName(String CustomerName) {
            int indexOfObject = -1;

            for (int i = 0; i < cList.size(); i++) {
                boolean result = cList.get(i).checkCustomerName(CustomerName);
                if (result) {
                    indexOfObject = i;
                }
            }

            return indexOfObject;
        }

        public  void customerManagementMenu() {

            Scanner sc = new Scanner(System.in);
            int choice = 0;

            do {
                System.out.println();
                for (int i = 1; i <= 172; i++) System.out.print("*"); System.out.println();
                for (int i = 0; i < 67; i++) System.out.print(" "); System.out.println("!!  CUSTOMER-LIST MANAGEMENT MENU  !!");
                for (int i = 1; i <= 172; i++) System.out.print("*"); System.out.println();
                System.out.println("\n");

                System.out.println("1. ADD A CUSTOMER");
                System.out.println("2. REMOVE A CUSTOMER");
                System.out.println("3. UPDATE DETAILS OF A CUSTOMER");
                System.out.println("4. SEARCH A CUSTOMER");
                System.out.println("5. SHOW GENERAL DETAILS OF ALL THE CUSTOMERS");
                System.out.println("6. SHOW CONTACT DETAILS OF ALL THE CUSTOMERS");
                System.out.println("7. RETURN TO MAIN-MENU");

                System.out.print("\nEnter Your Choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        addCustomer();
                    }

                    case 2 -> {
                        removeCustomer();
                    }

                    case 3 -> {
                        editCustomerDetails();
                    }

                    case 4 -> {
                        searchCustomer();
                    }

                    case 5 -> {
                        displayListAll();
                    }

                    case 6 -> {
                        displayListContactDetails();
                    }

                    case 7 -> {
                        //Return To Main-Menu
                    }

                    default -> {
                        System.out.println("!!  ENTER VALID OPTION  !!");
                    }
                }
            } while (choice != 7);
        }
    }

    public static class SalesInvoiceListClass {

        protected static LinkedList<SalesInvoiceClass> salesList = new LinkedList<SalesInvoiceClass>();

        private static SalesInvoiceListClass single_instance = null;
        public static  SalesInvoiceListClass getInstance() {
            if(single_instance == null)
                single_instance = new SalesInvoiceListClass();

            return single_instance;
        }

        public static void addSaleInvoice() {
            SalesInvoiceClass x = new SalesInvoiceClass();
            Scanner sc = new Scanner(System.in);

            System.out.print("\nEnter Customer-Id : ");
            String customerId = String.valueOf(Integer.parseInt(sc.nextLine()) - 1);

            if(CustomerListClass.returnFoundCustomerUsingId(customerId) != -1) {

                System.out.print("Enter Product-Id : ");
                String productId = String.valueOf(Integer.parseInt(sc.nextLine()) - 1);

                int unitsSold = 0;
                if(ProductListClass.returnFoundProductUsingId(productId) != -1) {
                    int a = ProductListClass.returnProduct(ProductListClass.returnFoundProductUsingId(productId)).returnProductQuantity();

                    System.out.println("Available Units : " + a);
                    System.out.print("Enter No. of Units : ");
                    unitsSold = sc.nextInt();

                    if(unitsSold > a) {
                        System.out.println("!!  Only " + a + " Units Available !!");
                    } else {
                        int cost = ProductListClass.returnProduct(ProductListClass.returnFoundProductUsingId(productId)).returnCost();
                        int price = cost * unitsSold;
                        x.setData(customerId, productId, unitsSold, price);
                        salesList.add(x);
                        salesList.getLast().setSaleInvoiceId(Integer.toString(salesList.indexOf(x)));
                        salesList.getLast().setProductName(ProductListClass.returnProduct(ProductListClass.returnFoundProductUsingId(productId)).returnProductName());

                        Comparator<SalesInvoiceClass> byId = Comparator.comparing(SalesInvoiceClass:: returnSaleInvoiceId);
                        Collections.sort(salesList, byId);

                        salesList.getLast().showData();



                        ProductListClass.returnProduct(ProductListClass.returnFoundProductUsingId(productId)).decreaseProductUnits(unitsSold);
                    }
                } else {
                    System.out.println("!!  No Product with " + productId + " Id Registered  !!");
                }
            } else {
                System.out.println("!!  No Customer with " + customerId + " Id Registered  !!");
            }
        }
        public static void viewSalesInvoice() {
            Scanner sc = new Scanner(System.in);
            int indexOfObject = -1;

            System.out.print("Enter Sales Invoice Id: ");
            String invoiceId = sc.nextLine();

            for (int i = 0; i < salesList.size(); i++) {
                boolean result = salesList.get(i).checkInvoiceId(invoiceId);
                if (result) {
                    indexOfObject = i;
                }
            }

            if(indexOfObject == -1) {
                System.out.println("!!  Invoice Not Found  !!");
            }
            else {
                System.out.println("!!  Invoice Found  !!");
                salesList.get(indexOfObject).showData();
            }
        }
        public static void viewListAll() {
            String frmt = "|%-25s|%-25s|%-25s|%-20s|%-20s|%-20s|%-20s\n";

            System.out.printf(frmt,"Invoice Id", "Customer Id", "Product Id", "Units Sold", "Price", "Date", "Time");
            for (int i = 1; i <= 1630; i++)
                System.out.print("-");
            System.out.println();
            for (SalesInvoiceClass x : salesList) {
                System.out.printf(frmt, String.valueOf(Integer.parseInt(x.returnSaleInvoiceId()) + 1), String.valueOf(Integer.parseInt(x.returnCustomerId()) + 1), String.valueOf(Integer.parseInt(x.returnProductId()) + 1), Integer.toString(x.returnUnitsSold()), Integer.toString(x.returnPrice()), x.returnSaleDate(), x.returnSaleTime());
            }
        }

        public static void salesManagementMenu() {

            Scanner sc = new Scanner(System.in);
            int choice = 0;

            do {

                System.out.println();
                for (int i = 1; i <= 195; i++) System.out.print("*"); System.out.println();
                for (int i = 0; i < 81; i++) System.out.print(" "); System.out.println("!!  SALES MANAGEMENT MENU  !!");
                for (int i = 1; i <= 195; i++) System.out.print("*"); System.out.println();
                System.out.println("\n");

                System.out.println("1. NEW SALE");
                System.out.println("2. SHOW DATA OF A PARTICULAR SALE INVOICE");
                System.out.println("3. SHOW DATA OF ALL THE SALES");
                System.out.println("4. RETURN TO MAIN-MENU");

                System.out.print("\nEnter Your Choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        addSaleInvoice();
                    }

                    case 2 -> {
                        viewSalesInvoice();
                    }

                    case 3 -> {
                        viewListAll();
                    }

                    case 4 -> {}

                    default -> {
                        System.out.println("!!  ENTER VALID OPTION  !!");
                    }
                }
            } while (choice != 4);
        }

    }

    public static void MainMenu() {

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            for (int i = 1; i <= 173; i++) System.out.print("*"); System.out.println();
            for (int i = 0; i < 80; i++) System.out.print(" "); System.out.println("!!  MAIN MENU  !!");
            for (int i = 1; i <= 173; i++) System.out.print("*"); System.out.println();
            System.out.println("\n");

            System.out.println("1. INVENTORY MANAGEMENT MENU");
            System.out.println("2. SUPPLIER MANAGMENT MENU");
            System.out.println("3. PRODUCT MANAGMENT MENU");
            System.out.println("4. CUSTOMER MANAGMENT MENU");
            System.out.println("5. SALES MANAGEMENT MENU");
            System.out.println("6. EXIT");

            System.out.print("\nEnter Your Choice: ");
            choice = sc.nextInt();
            System.out.println();

            switch(choice) {
                case 1 -> {
                    InventoryClass Inventory = InventoryClass.getInstance();
                    Inventory.inventoryManagementMenu();
                }
                case 2 -> {
                    SupplierListClass SupplierList = SupplierListClass.getInstance();
                    SupplierList.supplierListMenu();
                }
                case 3 -> {
                    ProductListClass ProductList = ProductListClass.getInstance();
                    ProductList.productListManagementMenu();
                }
                case 4 -> {
                    CustomerListClass CustomerList = CustomerListClass.getInstance();
                    CustomerList.customerManagementMenu();
                }
                case 5 -> {
                    SalesInvoiceListClass SalesList = SalesInvoiceListClass.getInstance();
                    SalesList.salesManagementMenu();
                }
                case 6 -> {
                    System.exit(0);
                }
                default -> {
                    System.out.println("!!  Invalid Input  !!");
                }
            }


        } while (choice != 6);
    }

    public InventoryManagementSystem() {

        InventoryClass Inventory = new InventoryClass();
        SupplierListClass SupplierList = new SupplierListClass();
        ProductListClass ProductList = new ProductListClass();
        CustomerListClass CustomerList = new CustomerListClass();
        SalesInvoiceListClass SalesInvoiceList = new SalesInvoiceListClass();

        this.MainMenu();
    }

    public static void main(String[] args) {

        InventoryManagementSystem inventoryManagementSystem = new InventoryManagementSystem();
    }
}