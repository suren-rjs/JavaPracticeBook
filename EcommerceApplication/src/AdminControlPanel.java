import java.util.Scanner;

public class AdminControlPanel {
    public static void AdminControls(String adminId, String password) {
        if(!adminId.equals("admin") && !password.equals("password")){
            System.out.println("Wrong Credentials!");
            return;
        }
        boolean isAdminWantedToContinue = true;
        while (isAdminWantedToContinue){
            System.out.println("1 -> Products\n2 -> Customers\n3 -> Coupon Codes\n4 -> Back To Home\nEnterChoice");
            Scanner adminInput = new Scanner(System.in);
            int adminChoice = adminInput.nextInt();
            switch (adminChoice){
                case 1:
                    Product.ProductsControlPanel();
                    break;
                case 2:
                    Customer.CustomerControlPanel();
                    break;
                case 3:
                    CouponCodes.CouponCodesControlPanel();
                    break;
                case 4:
                    break;
            }
        }
    }
}
