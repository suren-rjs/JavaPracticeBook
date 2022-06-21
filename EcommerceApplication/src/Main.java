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
    PublicUserControlPanel.userControls();
  }
}
