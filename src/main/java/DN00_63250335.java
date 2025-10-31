import java.util.Scanner;

public class DN00_63250335 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int b = sc.nextInt();
		int p = sc.nextInt();

		System.out.printf("%d\n%d", b / p, b % p);
	}
}
