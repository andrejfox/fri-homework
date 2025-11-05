import java.util.Scanner;

public class DN03_63250335 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int height = sc.nextInt();
        int width = sc.nextInt();
        int k = sc.nextInt();

        int maxTileSide = (int) Math.pow(2, k);

        boolean heighIsDevisable = height % maxTileSide == 0;
        if (heighIsDevisable && width % maxTileSide == 0) {
            System.out.println((long) (height / maxTileSide) * (width / maxTileSide));
        } else if (heighIsDevisable) {
            System.out.println(getTileCount1(height, width, maxTileSide, 0));
        } else {
            System.out.println(getTileCount2(height, width, maxTileSide, 0));
        }
    }

    private static long getTileCount1(int height, int width, int curTile, long sum) {
        sum += (long) (height / curTile) * (width / curTile);
        if (curTile == 1 || width % curTile == 0) {
            return sum;
        }
        return getTileCount1(height, width % curTile, curTile / 2, sum);
    }

    private static long getTileCount2(int height, int width, int curTile, long sum) {
        sum += getTileCount1(height - (height % curTile), width, curTile, 0);
        if (curTile == 1 || height % curTile == 0) {
            return sum;
        }
        return getTileCount2(height % curTile, width, curTile / 2, sum);
    }
}
