package DN05;

import java.util.Arrays;

public class Block {
    public int[][] grid = new int[4][4];

    public Block(int type) {
        switch (type) {
            case 0 -> Arrays.fill(grid[0], 1);
            case 1 -> {
                for (int i = 0; i < grid.length; i++) grid[i][0] = 1;
            }
            default -> {
                grid[0][0] = 1;
            }
        }
    }
}
