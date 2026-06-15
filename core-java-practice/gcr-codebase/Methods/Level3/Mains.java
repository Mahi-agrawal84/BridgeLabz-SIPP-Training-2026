package Level3;
import java.util.*;

class OTPGenerator {
    public static int generateOTP() {
        return 100000 + (int)(Math.random() * 900000);
    }

    public static boolean areUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) return false;
            }
        }
        return true;
    }
}

public class Mains {
    public static void main(String[] args) {
        int[] otps = new int[10];
        for (int i = 0; i < 10; i++) otps[i] = OTPGenerator.generateOTP();
        System.out.println("OTPs: " + Arrays.toString(otps));
        System.out.println("All Unique: " + OTPGenerator.areUnique(otps));
    }
}

