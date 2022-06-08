package src.invoiceclasses.baseclasses;

import java.time.LocalDate;
import java.time.LocalTime;

public class SalesInvoiceClass {

    private LocalDate SaleDate;
    private LocalTime SaleTime;
    private String SaleInvoiceId;
    private String CustomerId;
    private String ProductName;
    private String ProductId;
    private int UnitsSold;
    private int Price;

    public String returnSaleInvoiceId() { return SaleInvoiceId; }
    public String returnCustomerId() { return CustomerId; }
    public String returnProductName() { return ProductName; }
    public String returnProductId() { return ProductId; }
    public int returnUnitsSold() { return UnitsSold; }
    public LocalDate returnSaleDate() { return SaleDate; }
    public LocalTime returnSaleTime() { return SaleTime; }
    public int returnPrice() { return Price; }

    public void setSaleInvoiceId(String salesInvoiceId) { SaleInvoiceId = salesInvoiceId; }
    public void setCustomerId(String customerId) { CustomerId = customerId; }
    public void setProductName(String productName) { ProductName = productName; }
    public void setProductId(String productId) { ProductId = productId; }
    public void setUnitsSold(int unitsSold) { UnitsSold = unitsSold; }
    public void setSaleDate(LocalDate saleDate) { SaleDate = saleDate; }
    public void setSaleTime(LocalTime saleTime) { SaleTime = saleTime; }
    public void setPrice(int price) { Price = price; }

    public boolean checkInvoiceId(String invoiceId) { return returnSaleInvoiceId().equals(invoiceId); }

    public void setData(String customerId, String productId, int unitsSold, int price) {
        this.setSaleDate(LocalDate.now());
        this.setSaleTime(LocalTime.now());
        this.setCustomerId(customerId);
        this.setProductId(productId);
        this.setUnitsSold(unitsSold);
        this.setPrice(price);
    }

    public void showData() {
        for (int i = 0; i < 75; i++) System.out.print("-");
        System.out.println();
        for (int i = 0; i < 31; i++) System.out.print(" ");
        System.out.println("SALES INVOICE");
        for (int i = 0; i < 75; i++) System.out.print("-");
        System.out.println();
        System.out.println("Sale Date    : " + this.returnSaleDate());
        System.out.println("Sale Time    : " + this.returnSaleTime());
        System.out.println("Invoice-Id   : " + String.valueOf(Integer.parseInt(this.returnSaleInvoiceId()) + 1));
        System.out.println("Customer-Id  : " + String.valueOf(Integer.parseInt(this.returnCustomerId()) + 1));
        System.out.println("Product Name : " + this.returnProductName());
        System.out.println("Product-Id   : " + String.valueOf(Integer.parseInt(this.returnProductId() + 1)));
        System.out.println("Units Sold   : " + this.returnUnitsSold());
        System.out.println("Price Paid   : " + this.returnPrice());
        for (int i = 0; i < 75; i++) System.out.print("-");
        System.out.println();
    }
}