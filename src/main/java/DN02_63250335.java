import java.util.Scanner;

public class DN02_63250335 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int b = sc.nextInt();
        int d = sc.nextInt();
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(getPathLength(b, d, arr));
    }

    /// Gets the length of the path per given keyboard, size, and an array of key preses.
    public static int getPathLength(int type, int size, int[] MovesArr) {
        return switch (type) {
            case 1 -> pathLengthRavnovrstnica(MovesArr);
            case 2 -> pathLengthKvadratnica(size, MovesArr);
            case 3 -> pathLengthPiramidnica(size, MovesArr);
            case 4 -> pathLengthSpiralnica(size, MovesArr);
            default -> -1;
        };
    }

    /// Gets the length of the path for the linear keyboard.
    private static int pathLengthRavnovrstnica(int[] MovesArr) {
        int sum = 0;
        for (int i = 0; i < MovesArr.length - 1; i++) {
            sum += Math.abs(MovesArr[i] - MovesArr[i + 1]);
        }
        return sum;
    }

    /// Gets the length of the path for the square keyboard.
    private static int pathLengthKvadratnica(int size, int[] MovesArr) {
        int sum = 0;
        for (int i = 0; i < MovesArr.length - 1; i++) {
            int deltaHorizontal = Math.abs(MovesArr[i] % size - MovesArr[i + 1] % size);
            int deltaVertical = Math.abs(MovesArr[i] / size - MovesArr[i + 1] / size);

            sum += deltaHorizontal + deltaVertical;
        }
        return sum;
    }

    /// Gets the length of the path for the pyramid keyboard.
    private static int pathLengthPiramidnica(int size, int[] MovesArr) {
        int sum = 0;
        for (int i = 0; i < MovesArr.length - 1; i++) {
            int key1 = MovesArr[i];
            int key2 = MovesArr[i + 1];
            int y1 = (int) Math.sqrt(key1);
            int y2 = (int) Math.sqrt(key2);
            int x1 = size - y1 + key1 - (int) Math.pow(y1, 2);
            int x2 = size - y2 + key2 - (int) Math.pow(y2, 2);

            int deltaHorizontal = Math.abs(x1 - x2);
            int deltaVertical = Math.abs(y1 - y2);

            sum += deltaHorizontal + deltaVertical;
        }
        return sum;
    }

    /// Gets the length of the path for the spiral keyboard.
    private static int pathLengthSpiralnica(int size, int[] MovesArr) {
        int sum = 0;
        for (int i = 0; i < MovesArr.length - 1; i++) {
            int key1 = MovesArr[i];
            int key2 = MovesArr[i + 1];

            int sqrtRingCorner1 = getSqrtOfRingCorner(key1);
            int sqrtRingCorner2 = getSqrtOfRingCorner(key2);

            int[] xyRing1 = getPositionInRing(sqrtRingCorner1, key1);
            int[] xyRing2 = getPositionInRing(sqrtRingCorner2, key2);

            int offset1 = getOffset(sqrtRingCorner1, size);
            int offset2 = getOffset(sqrtRingCorner2, size);

            int x1 = offset1 + xyRing1[0];
            int y1 = offset1 + xyRing1[1];
            int x2 = offset2 + xyRing2[0];
            int y2 = offset2 + xyRing2[1];

            int deltaHorizontal = Math.abs(x1 - x2);
            int deltaVertical = Math.abs(y1 - y2);

            sum += deltaHorizontal + deltaVertical;
        }
        return sum;
    }

    /// Returns the sqrt of the upper-left corner in the ring the key belongs to. <br>
    /// Example: for number <code>5</code>, this function returns <code>1</code> <br>
    /// because <code>sqrt(1) == 1</code>.
    /// <pre>
    /// +-------+
    /// | 1 2 3 |
    /// | 8 0 4 |
    /// | 7 6 5 |
    /// +-------+
    /// </pre>
    public static int getSqrtOfRingCorner(int key) {
        int sqrt = (int) Math.sqrt(key);
        return (sqrt % 2 == 0) && (sqrt != 0) ? sqrt - 1 : sqrt;
    }

    /// Return the offset of the current ring to the max ring dictated by <code>size</code> <br>
    public static int getOffset(int sqrtRingCorner, int size) {
        return sqrtRingCorner != 0 ? size / 2 - sqrtRingCorner / 2 : size / 2 + 1;
    }

    /// Gets the x and y positions in the ring
    public static int[] getPositionInRing(int sqrtRingCorner, int num) {
        int x = 0;
        int y = 0;
        int side = sqrtRingCorner + 1;

        int c0 = (int) Math.pow(sqrtRingCorner, 2);
        int c1 = c0 + side;
        int c2 = c1 + side;
        int c3 = c2 + side;

        if (num < c1) {
            x = num - c0;
        } else if (num < c2) {
            x = side;
            y = num - c1;
        } else if (num < c3) {
            x = side - (num - c2);
            y = side;
        } else {
            y = side - (num - c3);
        }

        return new int[]{x, y};
    }
}
