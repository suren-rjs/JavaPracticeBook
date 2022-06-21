import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CouponCodes {
    static Map<String, CouponCodes> couponList = new HashMap<>();
    static Scanner input = new Scanner(System.in);
    String Code;
    int DiscountAmount;
    boolean isValidCode;

    public CouponCodes(String code, int discount) {
        this.Code = code;
        this.DiscountAmount = discount;
        this.isValidCode = true;
    }

    public static void CouponCodesControlPanel() {
        System.out.println("1 -> Create CouponCode\n2 -> Update CouponCode\n3 -> Delete CouponCode\n4 -> List of All Coupons\n5 -> Back\nChoice :");
        int choice = input.nextInt();
        switch (choice){
            case 1:
                CreateCouponCode();
                break;
            case 2:
                UpdateCoupon();
                break;
            case 3:
                System.out.println("Enter Code");
                String code = input.nextLine();
                if(!isExistingCoupon(code)) return;
                couponList.remove(code);
                System.out.println("Coupon Deleted");
                break;
            case 4:
                printAllCouponCodes();
                break;
            case 5:
                AdminControlPanel.AdminControls("admin", "password");
                break;
        }
        CouponCodesControlPanel();
    }

    private static void printAllCouponCodes() {
        System.out.println("Code         Discount Amount            Availability");
        for (CouponCodes code:couponList.values()){
            System.out.println(code.Code+"        "+code.DiscountAmount+"         "+code.isValidCode);
        }
        System.out.println("========== End Of List ==========");
    }

    private static void UpdateCoupon() {
        System.out.println("Enter Code");
        String code = input.nextLine();
        if(!isExistingCoupon(code)) return;
        CouponCodes currentCoupon = couponList.get(code);
        System.out.println("Enter Discount");
        currentCoupon.DiscountAmount = input.nextInt();
        currentCoupon.isValidCode = true;
        System.out.println("Coupon Discount Updated!");
    }

    private static boolean isExistingCoupon(String code) {
        boolean isExistingCode = couponList.containsKey(code);
        if(!isExistingCode) System.out.println("Invalid Coupon!");
        return isExistingCode;
    }

    private static void CreateCouponCode() {
        System.out.println("Enter Code, Discount value");
        String code = input.next();
        int discount = input.nextInt();
        CouponCodes newCoupon = new CouponCodes(code,discount);
        couponList.put(code, newCoupon);
        System.out.println("====> Coupon code created!");
    }
}
