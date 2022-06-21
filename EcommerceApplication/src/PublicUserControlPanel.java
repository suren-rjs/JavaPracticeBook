import java.util.Scanner;

public class PublicUserControlPanel {
    public static void userControls() {
        Scanner input =new Scanner(System.in);
        boolean isUserWantedToContinue = true;
        while (isUserWantedToContinue){
            System.out.println("1 -> Admin LogIn\n2 -> Customer LogIn\n3 -> Create New User\n4 -> Exit\nEnter Choice:");
            int userChoice = input.nextInt();
            switch (userChoice){
                case 1:
                    System.out.println("Enter AdminId and Password");
                    String AdminId = input.next();
                    String Password = input.next();
                    AdminControlPanel.AdminControls(AdminId,Password);
                    break;

                case 2:
                    System.out.println("Enter Customer Id:");
                    int CustomerId = input.nextInt();
                    ProductListPage.CustomerControls(CustomerId);
                    break;

                case 3:
                    Customer.CreateNewCustomer();
                    break;

                case 4:
                    return;
            };
        }
    }
}
