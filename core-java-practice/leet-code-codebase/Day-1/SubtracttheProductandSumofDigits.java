public class SubtracttheProductandSumofDigits {
    public static void main(String[] args) {
        int n = 234; 
        int result = subtractProductAndSum(n);
        System.out.println(result); 
    }

    public static int subtractProductAndSum(int n) {
        int product = 1; 
        int sum = 0; 
        
        while (n > 0) {
            int digit = n % 10; 
            product *= digit; 
            sum += digit; 
            n /= 10;  
        }
        
        return product - sum; 
    }
}
