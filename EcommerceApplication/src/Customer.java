import java.util.*;

public class Customer {
    static int id=1;
    static Map<Integer, Customer> allCustomers = new HashMap<>();
    static Scanner input = new Scanner(System.in);
    int Customer_id;
    String Customer_name;
    String Customer_Contact;
    List<Integer> CartItems;
    List<String> CustomerInvoices;

    public Customer(String customerName,String customerContact) {
        this.Customer_id = id++;
        this.Customer_name = customerName;
        this.Customer_Contact = customerContact;
        this.CartItems = new ArrayList<>();
        this.CustomerInvoices = new ArrayList<>();
    }

    public static void CustomerControlPanel() {
        System.out.println("1 -> Create New Customer\n2 -> Update Customer Details\n3 -> Delete Customer\n4 -> List All Customers\n5 -> Back\nChoice :");
        Scanner input = new Scanner(System.in);
        int AdminSelection = input.nextInt();
        switch (AdminSelection){
            case 1:
                CreateNewCustomer();
                break;
            case 2:
                System.out.println("Enter Customer Id");
                int  customerId = input.nextInt();
                if(!isExistingCustomer(customerId)) CustomerControlPanel();
                updateCustomerDetails(customerId);
                break;
            case 3:
                System.out.println("Enter Customer Id");
                customerId = input.nextInt();
                if(!isExistingCustomer(customerId)) CustomerControlPanel();
                allCustomers.remove(customerId);
                System.out.println("Successfully Deleted!");
                break;
            case 4:
                printAllCustomers();
                break;
            case 5:
                AdminControlPanel.AdminControls("admin", "password");
                break;
        }
        CustomerControlPanel();
    }

    private static boolean isExistingCustomer(int customerId) {
        boolean isExistingUser = allCustomers.containsKey(customerId);
        if(!isExistingUser) System.out.println("User Not Found!");
        return isExistingUser;
    }

    private static void updateCustomerDetails(int customerId) {
        Customer customerDetails = allCustomers.get(customerId);
        if(!isExistingCustomer(customerId)) CustomerControlPanel();
        System.out.println("1 -> Update Name\n 2 -> Update Contact\n3 -> Update Name and Contact\n4 -> Back\nChoice :");
        int choice = input.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter Name:");
                String  customerName = input.next();
                customerDetails.Customer_name = customerName;
                break;
            case 2:
                System.out.println("Enter Contact:");
                String customerContact = input.next();
                customerDetails.Customer_Contact = customerContact;
                break;
            case 3:
                System.out.println("Enter Name and Contact :");
                customerName = input.next();
                customerContact = input.next();
                customerDetails.Customer_name = customerName;
                customerDetails.Customer_Contact = customerContact;
                break;
            case 4:
                break;
        }
        System.out.println("Customer Details Updated for "+customerDetails.Customer_name);
        CustomerControlPanel();
    }

    private static void printAllCustomers() {
        System.out.println(
                "======================= Customers List ==============\n== CustomerId == Customer Name == Customer Contact ==");
        for (Customer currentCustomer : allCustomers.values()) {
            System.out.println(currentCustomer.Customer_id+"                  "+currentCustomer.Customer_name+"                  "+currentCustomer.Customer_Contact);
        }
        System.out.println("======================= End Of List ==============\n");
    }

    public static void CreateNewCustomer() {
        System.out.println("Enter Customer Name and Customer Contact");
        String  customerName = input.next();
        String customerContact = input.next();
        Customer newCustomer = new Customer(customerName, customerContact);
        allCustomers.put(newCustomer.Customer_id, newCustomer);
        System.out.println("Customer Id Created for "+newCustomer.Customer_name+"\nCustomerId : "+newCustomer.Customer_id);
    }
}
