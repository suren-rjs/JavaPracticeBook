import java.util.Scanner;

public class ProductListPage {
    static String invoice = "";
    static int TotalPayableAmount;
    static int CouponDiscount;
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
                    invoice = "=========================================\n";
                    TotalPayableAmount = 0;
                    CouponDiscount = 0;
                    currentCustomer.CartItems.forEach(id -> {
                        Product currentProduct = Product.allProducts.get(id);
                        invoice += currentProduct.productName+"   Rs."+currentProduct.productPrice+"\n";
                        TotalPayableAmount+=currentProduct.productPrice;
                        Product.allProducts.remove(id);
                    });
                    CouponDiscount = applyCouponCode();
                    currentCustomer.CustomerInvoices.add(invoice+"\nTotal Purchase Amount = Rs."+TotalPayableAmount+"\nTotal Discount Amount = Rs."+CouponDiscount+"\nTotal Amount Paid = Rs."+(TotalPayableAmount-CouponDiscount));
                    System.out.println("============ Payment Success ============ ");
                    currentCustomer.CartItems.clear();
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

    private static int applyCouponCode() {
        System.out.println("Enter Coupon Code:");
        String Code = input.next();
        if(!CouponCodes.couponList.containsKey(Code)){
            System.out.println("Invalid Promo Code\n1 -> Enter PromoCode Again\nAny Key to Continue Without PromoCode\nChoice : ");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    applyCouponCode();
                    break;
                default:
                    return 0;
            }

        }
        CouponCodes AppliedCoupon = CouponCodes.couponList.get(Code);
        return AppliedCoupon.DiscountAmount;
    }

    private static void ShowAllProducts(Customer currentCustomer) {
        Product.updateProductList();
        for (Product product : Product.productArrayList) {
      System.out.println(
          product.productId + "    " + product.productName + "    " + product.productPrice+"    "+product.productCount);
        }
        boolean isUserWantsToAddMore = true;
        while (isUserWantsToAddMore){
            System.out.println("1 -> Add Product To Cart\n2Goto Cart\n3 -> Back");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter Product Id");
                    int productId = input.nextInt();
                    currentCustomer.CartItems.add(productId);
                    break;
                case 2:
                    ShowCartItems(currentCustomer);
                    break;
                case 3:
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
