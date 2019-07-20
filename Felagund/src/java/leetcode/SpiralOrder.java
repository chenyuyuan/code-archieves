package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public static void main(String[] args) {
        spiralOrderURDL();
    }

    //LeftDownRightUp
    public static void spiralOrderLDRU() {
        int[][] matrix = new int[100][100];

        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        int count = 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j++) {
                matrix[rowBegin][j] = count;
                ++count;
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j++) {
                matrix[j][colEnd] = count;
                ++count;
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j--) {
                    matrix[rowEnd][j] = count;
                    ++count;
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j--) {
                    matrix[j][colBegin] = count;
                    ++count;
                }
            }
            colBegin++;
        }
        for (int i = 0;i < matrix.length;++i) {
            for (int j = 0;j < matrix[0].length;++j) {
                System.out.printf("%11d",matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }




    //UpRightDownLeft
    public static void spiralOrderURDL() {
        int[][] matrix = new int[100][100];

        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        int count = 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j++) {
                matrix[rowBegin][j] = count;
                ++count;
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j++) {
                matrix[j][colEnd] = count;
                ++count;
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j--) {
                    matrix[rowEnd][j] = count;
                    ++count;
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j--) {
                    matrix[j][colBegin] = count;
                    ++count;
                }
            }
            colBegin++;
        }
        for (int i = 0;i < matrix.length;++i) {
            for (int j = 0;j < matrix[0].length;++j) {
                System.out.printf("%11d",matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
