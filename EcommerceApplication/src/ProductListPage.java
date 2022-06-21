import java.util.Scanner;

public class ProductListPage {
    static String invoice = "";
    static Scanner input = new Scanner(System.in);
    public static void CustomerControls(int customerId) {
        if(!isExistingUser(customerId)) return;
        Customer currentCustomer = Customer.allCustomers.get(customerId);
        System.out.println("======== Welcome "+currentCustomer.Customer_name+" =========");
        boolean isUserWantedToContinue = true;
        while (isUserWantedToContinue){
            System.out.println("1 -> List All Products\n2 -> Cart Items\n3 -> Purchase History\n4 -> Back\nChoice");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    ShowAllProducts(currentCustomer);
                    break;
                case 2:
                    ShowCartItems(currentCustomer);
                    break;
                case 3:
                    System.out.println("======== Purchase History =========");
                    currentCustomer.CustomerInvoices.forEach(invoice -> {
                        System.out.println(invoice);
                    });
                    System.out.println("========    End of list   =========");
                    break;
                case 4:
                    PublicUserControlPanel.userControls();
                    break;
                default:
                    break;
            }
        }
    }

    private static void ShowCartItems(Customer currentCustomer) {
        System.out.println("========== Cart Items ===========");
        currentCustomer.CartItems.forEach(productId -> {
            Product currentProduct = Product.allProducts.get(productId);
            System.out.println(currentProduct.productId+" -> "+currentProduct.productName+": Rs."+currentProduct.productPrice);
        });
        System.out.println("========== End of list ===========");
        boolean isUserWantedToContinue = true;
        while (isUserWantedToContinue){
            System.out.println("1 -> Remove an cartItem\n2 -> Continue To Purchase\n3 -> Back");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter Item Id:");
                    currentCustomer.CartItems.remove(Integer.valueOf(input.nextInt()));
                    System.out.println("Item Removed from cart");
                    break;
                case 2:
                    invoice = "";
                    currentCustomer.CartItems.forEach(id -> {
                        Product currentProduct = Product.allProducts.get(id);
                        invoice += currentProduct.productName+"   Rs."+currentProduct.productPrice+"\n";
                        Product.allProducts.remove(id);
                    });
                    currentCustomer.CustomerInvoices.add(invoice);
                    System.out.println("============ Payment Success ============ ");
                    break;
                case 3:
                    isUserWantedToContinue = false;
                    break;
                default:
                    break;
            }
        }
        return;
    }

    private static void ShowAllProducts(Customer currentCustomer) {
        Product.updateProductList();
        for (Product product : Product.productArrayList) {
      System.out.println(
          product.productId + "    " + product.productName + "    " + product.productPrice+"    "+product.productCount);
        }
        boolean isUserWantsToAddMore = true;
        while (isUserWantsToAddMore){
            System.out.println("1 -> Add Product To Cart\n2 -> Back");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter Product Id");
                    int productId = input.nextInt();
                    currentCustomer.CartItems.add(productId);
                    break;
                case 2:
                    isUserWantsToAddMore = false;
                    PublicUserControlPanel.userControls();
                    break;
                default:
                    break;
            }
        }
    }

    private static boolean isExistingUser(int customerId) {
        boolean isExistingCustomer = Customer.allCustomers.containsKey(customerId);
        if(!isExistingCustomer) System.out.println("User Not Found");
        return isExistingCustomer;
    }
}
