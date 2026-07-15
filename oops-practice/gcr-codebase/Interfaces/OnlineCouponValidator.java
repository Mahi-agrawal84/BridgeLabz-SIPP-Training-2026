// Interface
interface CouponValidator {

    // Abstract method
    boolean validateCoupon(String code);

    // Static method
    static boolean isLengthValid(String code) {
        return code.length() >= 5 && code.length() <= 10;
    }
}

// Class implementing the interface
class ShoppingCart implements CouponValidator {

    @Override
    public boolean validateCoupon(String code) {

        // Coupon is valid if length is valid
        // and starts with "SAVE"
        return CouponValidator.isLengthValid(code)
                && code.startsWith("SAVE");
    }
}

// Main Class
public class OnlineCouponValidator {
    public static void main(String[] args) {

        String[] coupons = {
                "SAVE10",
                "SAVE50",
                "ABC",
                "DISCOUNT20",
                "SAVE100"
        };

        ShoppingCart cart = new ShoppingCart();

        for (String coupon : coupons) {
            if (cart.validateCoupon(coupon)) {
                System.out.println(coupon + " -> Valid Coupon");
            } else {
                System.out.println(coupon + " -> Invalid Coupon");
            }
        }
    }
}