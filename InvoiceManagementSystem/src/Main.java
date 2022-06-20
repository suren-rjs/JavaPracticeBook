import java.util.Scanner;

/*
* Develop a mini-project ‘Invoice Management’ with the following modules :

1. Add a customer
2. Add an invoice
3. Add items to an invoice
4. List all customers
5. List all invoices
6. List all invoices for a customer
7. Display the full details of an invoice

*/
public class Main {
  public static void main(String[] args) {
    Scanner input  = new Scanner(System.in);
    System.out.println("\n================================="+"\n=== Invoice Management System ==="+"\n=================================");
    boolean isUserWantsToContinue = true;
    while (isUserWantsToContinue){
      System.out.println(
          "\nFollowing Features are Available\n1 -> Add a Customer " +
                  "\n2 -> Add an Invoice" +
                  "\n3 -> Add Items to an invoice" +
                  "\n4 -> List all customers" +
                  "\n5 -> List all Invoices" +
                  "\n6 -> List all Invoices for a customer" +
                  "\n7 -> Display the full details of an invoice" +
                  "\n8 -> Exit" +
                  "\nEnter Selection :");
      int userChoice = input.nextInt();
      switch (userChoice){
        case 1:
          break;
        case 2:
          break;
        case 3:
          break;
        case 4:
          break;
        case 5:
          break;
        case 6:
          break;
        case 7:
          break;
        case 8:
          isUserWantsToContinue = false;
          break;
      }
    }
  }
}
