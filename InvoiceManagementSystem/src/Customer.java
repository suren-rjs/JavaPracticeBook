import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer {
  //    To Create and Update Customer
  static int id = 1;
  static Map<Integer, Invoice> CustomerInvoiceList = new HashMap<>();
  static Map<Integer, Customer> AllCustomers = new HashMap<>();
  int CustomerId;
  String CustomerName;
  String Contact;
  int TotalPurchase;
  List<Invoice> PurchaseHistory;

  public Customer(String customerName, String customerContact) {
    this.CustomerId = id++;
    this.CustomerName = customerName;
    this.Contact = customerContact;
    this.PurchaseHistory = new ArrayList<>();
    this.TotalPurchase = 0;
  }

  public static void AddInvoiceToCustomer(int customerId, Invoice newInvoice) {
    CustomerInvoiceList.put(customerId, newInvoice);
  }

  public static void UpdateCustomerInvoice(
      int customerIdForProducts, int invoiceId, List<Product> productList) {
    int TotalPurchaseAmount = 0;
    Customer currentCustomer = AllCustomers.get(customerIdForProducts);
    Invoice currentCustomerInvoice = Invoice.AllInvoices.get(invoiceId);
    for (Product getProduct : productList) {
      TotalPurchaseAmount += (getProduct.ProductPrice * getProduct.ProductCount);
      currentCustomerInvoice.ProductList.add(getProduct);
    }
    currentCustomerInvoice.TotalPrice += TotalPurchaseAmount;
    currentCustomer.TotalPurchase += TotalPurchaseAmount;
  }

  public static void UpdateCustomer(Customer newCustomer) {
    AllCustomers.put(newCustomer.CustomerId, newCustomer);
  }

  public static List<Invoice> getCustomerInvoices(int getInvoiceCustomerId) {
    Customer currentCustomer = AllCustomers.get(getInvoiceCustomerId);
    return currentCustomer.PurchaseHistory;
  }
}
