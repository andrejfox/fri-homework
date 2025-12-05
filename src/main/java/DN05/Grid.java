package DN05;

public class Grid {
    private static int[] arr;
    private static int size;

    public Grid(int size) {
        arr = new int[size * 2];
        Grid.size = size;
    }

    public static void main(String[] args) {
        Grid g = new Grid(6);
        Block b = new Block(0);

        setDrop(b, 1);
        setDrop(b, 0);

        System.out.println(g);
    }

    public static void setDrop(Block b, int position) {
        int height = getHitHeight(b, position);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (b.grid[j][i] == 0) continue;
                arr[size + position + i - 1] = height - (3 - j);
            }
        }
    }

    public static int getHitHeight(Block b, int location) {
        int max = 0;
        for (int h : arr) {
            if (max < h) max = h;
        }



        return getHitHeightRec(b, location, max + 4);
    }

    public static int getHitHeightRec(Block b, int location, int height) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (b.grid[i][j] == 0) continue;

                int r_h = height - j;
                int r_x = location + i;


                int c_h = arr[r_x + size - 1];

                if (r_h <= c_h) {
                    return height + 1;
                }
            }
        }

        return getHitHeightRec(b, location, height - 1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) continue;
            sb.append(String.format("%d: %d\n", i - size + 1, arr[i]));
        }
        return sb.toString();
    }
}
