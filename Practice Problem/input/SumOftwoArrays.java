import java.util.Scanner;

public class SumOftwoArrays {
    public static int[] sumOftwoArrays(int[] A, int[] B) {
        int resultSize = Math.max(A.length, B.length) + 1; //done me se jo array bda h uska size + 1
        int result[] = new int[resultSize];

        int carry = 0; 
        int sum = 0;

        int i = A.length - 1;   //array ko chlane ke lie pointers
        int j = B.length - 1;
        int k = result.length - 1;

        while (i >= 0 && j >= 0) {  //ye loops jb tak dono 0 se bde hai
            int d1 = A[i];
            int d2 = B[j];

            sum = d1 + d2 + carry;  
            carry = sum / 10;

            result[k] = sum % 10;

            i--;
            j--;
            k--;
        }

        while (i >= 0) {    //agar A[] ke element kuch bach gye
            sum = A[i] + carry;
            carry = sum / 10;
            result[k] = sum % 10;
            i--;
            k--;
        }

        while (j >= 0) {    //agar B[] ke element bach gye
            sum = B[j] + carry;
            carry = sum / 10;
            result[k] = sum % 10;
            j--;
            k--;
        }

        if (carry != 0) {   //agar carry bach gyi
            result[k] = carry;
        }

        return result;
    }
    public static void main(final String[] args) {
        final Scanner scn = new Scanner(System.in);
        final int n1 = scn.nextInt();

        final int A[] = new int[n1];

        for (int i = 0; i < n1; i++) {
            A[i] = scn.nextInt();
        }
        final int n2 = scn.nextInt();

        final int B[] = new int[n2];

        for (int i = 0; i < n2; i++) {
            B[i] = scn.nextInt();
        }

        scn.close();

        int result[] = sumOftwoArrays(A, B); // getting result

        if (result[0] == 0) //agar pehla element 0 hai toh loop 1 se chalu kro
            for (int i = 1; i < result.length; i++) { //kyuki size + 1 kia tha 
                System.out.println(result[i]);
            }
        else
            for (int i = 0; i < result.length; i++) {//NHI TOH 0 se chalu kro
                System.out.println(result[i]);
            }

    }
}