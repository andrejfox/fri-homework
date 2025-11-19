import java.util.Arrays;
import java.util.Scanner;

public class DN04_63250335 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] cache = new int[n];
        Arrays.fill(cache, -1);

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (cache[i] != -1) {
                count += cache[i];
                continue;
            }

            int cur_count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] + arr[j] == k) {
                    cur_count++;
                }
            }

            count += cur_count;
            cache[i] = cur_count;
        }

        System.out.println(count);
    }
}
