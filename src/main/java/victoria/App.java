import java.util.*;
import java.util.Arrays;

public int countCornerRectangles(int[][] grid) {
    int count = 0;
    int m = grid.length, n = grid[0].length;
    for (int i = 0; i < m - 1; i++) {
        for (int j = i + 1; j < m; j++) {
            int currCount = 0;
            for (int k = 0; k < n; k++) {
                if (grid[i][k] == 1 && grid[j][k] == 1) {
                    currCount++;
                }
            }
            count += currCount * (currCount - 1) / 2;
        }
    }
    return count;
}
