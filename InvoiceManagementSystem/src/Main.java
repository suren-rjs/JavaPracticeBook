import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* Develop a mini-project ‘Invoice Management’ with the following modules :

1. Add a customer
    -> Customer Id
    -> Customer Name
    -> Customer Contact
    -> Customer TotalPurchase
    -> List of Invoices

2. Add an invoice
    -> InvoiceId
    -> List of Products
    -> Total Purchase Amount

3. Add items to an invoice
    -> ProductId
    -> Buying Count
    -> Product Amount

4. List all customers
     -> List of all Customers

5. List all invoices
     -> List of all invoices

6. List all invoices for a customer
     -> List of Customer Invoices

7. Display the full details of an invoice
     -> Print Specific Invoice

*/
public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println(
            """
                    =================================
                    === Invoice Management System ===
                    =================================
            """);
    boolean isUserWantsToContinue = true;
    while (isUserWantsToContinue) {
      System.out.println(
              """
                      Following Features are Available
                      1 -> Add a Customer\s
                      2 -> Generate an Invoice
                      3 -> List all customers
                      4 -> List all Invoices
                      5 -> List all Invoices for a customer
                      6 -> Display the full details of an invoice
                      7 -> Exit
                      Enter Selection :""");
      int userChoice = input.nextInt();
      switch (userChoice) {
        case 1 -> {
          System.out.println("\nEnter Customer Name:");
          String CustomerName = input.next();
          System.out.println("\nEnter Customer Contact:");
          String CustomerContact = input.next();
          Customer newCustomer = new Customer(CustomerName, CustomerContact);
          Customer.UpdateCustomer(newCustomer);
          System.out.println("\nRegistration Success -> " + newCustomer.CustomerName);
          System.out.println("=============================================================");
        }
        case 2 -> {
          List<Product> ProductList = new ArrayList<>();
          System.out.println("\nEnter CustomerId:");
          int CustomerIdForInvoice = input.nextInt();
          if (validateExistingCustomers(CustomerIdForInvoice)) break;
          Invoice newInvoice = new Invoice();
          Customer.AddInvoiceToCustomer(CustomerIdForInvoice, newInvoice);
          Customer currentCustomer =
                  Customer.AllCustomers.get(CustomerIdForInvoice);
          currentCustomer.PurchaseHistory.add(newInvoice);
          Invoice.AllInvoices.put(newInvoice.InvoiceId, newInvoice);
          System.out.println("Enter No of Products:");
          int NoOfProducts = input.nextInt();
          for (int i = 0; i < NoOfProducts; i++) {
            System.out.println("Enter Product Name");
            String ProductName = input.next();
            System.out.println("Enter Product Price");
            int ProductPrice = input.nextInt();
            System.out.println("Enter Product Count");
            int ProductCount = input.nextInt();
            Product newProduct = new Product(ProductName, ProductPrice, ProductCount);
            ProductList.add(newProduct);
          }
          Customer.UpdateCustomerInvoice(CustomerIdForInvoice, newInvoice.InvoiceId, ProductList);
          System.out.println("Invoice Created For " + currentCustomer.CustomerName);
          System.out.println("=============================================================");
        }
        case 3 -> {
          System.out.println("CustomerName         CustomerContact          TotalPurchase");
          for (Customer CustomerDetails : Customer.AllCustomers.values()) {
            System.out.println(
                    CustomerDetails.CustomerName
                            + "                "
                            + CustomerDetails.Contact
                            + "                   "
                            + CustomerDetails.TotalPurchase);
          }
          System.out.println("=========================================================");
        }
        case 4 -> {
          for (Invoice userInvoice : Invoice.AllInvoices.values()) {
            Invoice.ShowInvoiceDetails(userInvoice);
          }
          System.out.println("=========================================================");
        }
        case 5 -> {
          System.out.println("\nEnter CustomerId:");
          int getInvoiceCustomerId = input.nextInt();
          if (validateExistingCustomers(getInvoiceCustomerId)) break;
          List<Invoice> getUserInvoices = Customer.getCustomerInvoices(getInvoiceCustomerId);
          for (Invoice userInvoice : getUserInvoices) {
            Invoice.ShowInvoiceDetails(userInvoice);
          }
          System.out.println("=========================================================");
        }
        case 6 -> {
          System.out.println("Enter InvoiceId:");
          int invoiceId = input.nextInt();
          if (!Invoice.AllInvoices.containsKey(invoiceId)) {
            System.out.println("Invoice Not Available");
            break;
          }
          Invoice userInvoice = Invoice.AllInvoices.get(invoiceId);
          Invoice.ShowInvoiceDetails(userInvoice);
          System.out.println("=========================================================");
        }
        case 7 -> isUserWantsToContinue = false;
      }
    }
  }

  private static boolean validateExistingCustomers(int customerIdForInvoice) {
    boolean notRegisteredCustomer = false;
    if (!Customer.AllCustomers.containsKey(customerIdForInvoice)) {
      System.out.println("Not Registered Customer");
      notRegisteredCustomer = true;
    }
    return notRegisteredCustomer;
  }
}
