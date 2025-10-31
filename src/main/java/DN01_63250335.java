import java.util.Scanner;

public class DN01_63250335 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        // add all 1x1 squares
        int sqCount = (a - 1) * (b - 1);


        // sets an as the bigger value
        int hold = a;
        if (a < b) {
            a = b;
            b = hold;
        }


        for (int i = 2; i <= b; i++) {
            sqCount += (a - i) * (b - i);
        }

        System.out.println(sqCount);
    }
}
