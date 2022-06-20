import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Invoice {
  //    To Create and Update Invoice
  static int Id = 1;
  static Map<Integer, Invoice> AllInvoices = new HashMap<>();
  int InvoiceId;
  int TotalPrice;
  List<Product> ProductList;

  public Invoice() {
    this.InvoiceId = Id++;
    this.ProductList = new ArrayList<>();
    this.TotalPrice = 0;
  }

  public static void ShowInvoiceDetails(Invoice userInvoice) {
    System.out.println(
        "InvoiceId  "
            + userInvoice.InvoiceId
            + ",  TotalPurchase "
            + userInvoice.TotalPrice
            + "\nProducts:");
    for (Product userProduct : userInvoice.ProductList) {
      System.out.println(
          userProduct.ProductName
              + " : "
              + userProduct.ProductPrice
              + " x "
              + userProduct.ProductCount);
    }
  }
}
