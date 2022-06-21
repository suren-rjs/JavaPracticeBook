import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer {
    static int id=1;
    int Customer_id;
    String Customer_name;
    String Customer_Contact;
    static Map<Integer, Customer> allCustomers = new HashMap<>();
    List<Product> CartItems;
    List<Invoice> CustomerInvoices;

    public Customer(String customerName,String customerContact) {
        this.Customer_id = id++;
        this.Customer_name = customerName;
        this.Customer_Contact = customerContact;
        this.CartItems = new ArrayList<>();
        this.CustomerInvoices = new ArrayList<>();
    }

    public static void CustomerControlPanel() {
    }

    public static void CreateNewCustomer(String customerName,String customerContact) {
        Customer newCustomer = new Customer(customerName, customerContact);
        allCustomers.put(newCustomer.Customer_id, newCustomer);
    }
}
