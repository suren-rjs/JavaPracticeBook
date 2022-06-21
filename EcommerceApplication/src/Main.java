import java.util.Scanner;

/*
* E-Commerce Applications
   1 -> Admin
   2 -> Client
   3 -> Create New User

   * Entire Client List -> List
   * Entire Purchase List -> List
   * Entire Product List -> Map
   * Entire Customer Purchase List -> Map

   * Admin
      -> Add Product
      -> Can view/Add/Delete/Update Customers List
      -> Can view/Add/Delete/Update Products List
      -> Can view/Add/Delete/Update Coupon Codes
      -> Can view All Sales
      * Product Registration
          -> Product Id
          -> Product Name
          -> Product Stock

   * Client
      -> Can View/AddToCart/Buy a Product
      -> Can View Invoice
      -> Delete Product while checkout

   * New Client Registration
      -> Client Name
      -> Client User ID
      -> Admin Password To Verifications

*
*/
public class Main {
  public static void main(String[] args) {
    System.out.println("=================================" +
            "\n======E-Commerce Application=====" +
            "\n=================================");
    Scanner input =new Scanner(System.in);
    boolean isUserWantedToContinue = true;
    while (isUserWantedToContinue){
      System.out.println("1 -> Admin LogIn\n2 -> Customer LogIn\n3 -> Create New User\n4 -> Exit\nEnter Choice:");
      int userChoice = input.nextInt();
      switch (userChoice){
        case 1:
          System.out.println("Enter AdminId and Password");
          String AdminId = input.nextLine();
          String Password = input.nextLine();
          AdminControlPanel.AdminControls(AdminId,Password);
          break;
        case 2:
          System.out.println("Enter Customer Id:");
          int CustomerId = input.nextInt();
          ProductListPage.CustomerControls();
          break;
        case 3:
          System.out.println("Enter Customer Name and Customer Contact");
          String  CustomerName = input.next();
          String CustomerContact = input.next();
          Customer.CreateNewCustomer(CustomerName, CustomerContact);

          break;
        case 4:
          isUserWantedToContinue = false;
          break;
      };
    }
  }
}
