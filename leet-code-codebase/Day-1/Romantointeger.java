public class Romantointeger {
    public static void main(String[] args) {
        String s = "MCMXCIV"; 
        int result = romanToInt(s);
        System.out.println(result); 
    }

    public static int romanToInt(String s) {
        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int value = getValue(c);

            if (value < prevValue) {
                result -= value; 
            } else {
                result += value; 
            }

            prevValue = value; 
        }

        return result;
    }

    private static int getValue(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;   
        };
    }
}
