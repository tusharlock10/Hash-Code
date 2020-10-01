import java.util.Scanner;

public class RotateaNumber {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int k = scn.nextInt();

        scn.close();

        int length = String.valueOf(num).length();
        
        k = k % length; // to reduce time kyuki , agar ke large h toh baar baar rotate hoga
        if (k < 0) { // if k is negative
            k = k + length;
        }
        int move = num % (int) Math.pow(10, k); //taking digits 
        num /= (int) Math.pow(10, k);   //reducing number

        num = move * (int) Math.pow(10, length - k) + num;  //formation

        System.out.println(num);
    }
}