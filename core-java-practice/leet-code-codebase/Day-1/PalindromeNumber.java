public class PalindromeNumber {
    public static void main(String[] args) {
        int x = 121; 
        boolean isPalindrome = isPalindrome(x);
        System.out.println(isPalindrome); 
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false; 
        }
        
        int original = x;
        int reversed = 0;
        
        while (x != 0) {
            int digit = x % 10; 
            reversed = reversed * 10 + digit; 
            x /= 10;  
        }
        
        return original == reversed; 
    }
}
