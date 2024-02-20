import java.util.Scanner;
public class BaseMtoN{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Hi!\nThis program currently only has support for Base-1 to Base-10!\n");
        System.out.print("Please enter the number to be converted: ");
        int num1 = input.nextInt();
        System.out.print("\nMy number is base-");
        final int M = input.nextInt();
        System.out.print("\nI want to convert to base-");
        final int N = input.nextInt();
        String num2 = Converter(num1, M, N);
        if (num2.compareTo("This number is not in the given base, base is greater than 10, or base is less than 1") != 0){
        System.out.printf("\nYou entered %d in base%d, and it has now been converted to %s in base%d", num1, M, num2, N);
        } else {
            System.out.println(num2);
        }
        input.close();
    }
    private static String Converter(int num1, final int M, final int N){
        boolean convertable = Checker(num1, M);
        if (convertable == false){
            return "This number is not in the given base, base is greater than 10, or base is less than 1";
        }
        //Convert to base 10
        int base10 = 0;
        int power = 0;
        System.out.println("\nConverting to base10...");
        while (num1 != 0) {
            int digit = num1 % 10;
            num1 /= 10;
            base10 += digit * Math.pow(M, power);
            power++;;
        }
        System.out.printf("Converting to base%d...\n", N);
        String result = "";
        while (base10 != 0) {
            int digit10 = base10 % N;
            base10 -= digit10;
            base10 /= N;
            result = String.format("%d%s", digit10, result);
        }
        return result;
    }
    // Check if the numbers entered are valid
    private static boolean Checker(int num1, final int M){
        if (M == 10) {
            return true;
        } else if (M > 10 || M < 1){
            return false;
        }
        String num1String = Integer.toString(num1);
        for(char digit: num1String.toCharArray()){
            int digitValue = Character.getNumericValue(digit);
            if (digitValue >= M) {
                return false;}
            }
        return true;
    }
}