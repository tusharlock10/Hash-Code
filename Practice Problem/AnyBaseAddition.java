import java.util.Scanner;

public class AnyBaseAddition {
    public static int anyBaseAddition(int b, int n1, int n2) {
        int res = 0;
        int power = 0;
        int carry = 0;
        int sum = 0;

        while (n1 != 0 || n2 != 0 || carry != 0) {
            int d1 = n1 % 10;
            n1 /= 10;
            
            int d2 = n2 % 10;
            n2 /= 10;

            sum = d1 + d2 + carry;  //last digit of both nums + carry
            
            res += (sum % b) * Math.pow(10, power); //sum % b == result digit
            power++;            //e.g. 7 + 1 = 8 => 8 % 8 = 1(carry)(octal case)

            carry = sum / b;    //update krdo carry ko, 8 / 8 = 1, in octal
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        scn.close();

        System.out.println(anyBaseAddition(b, n1, n2));
    }
}