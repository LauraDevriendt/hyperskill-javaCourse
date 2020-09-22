import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int n2 = (int) Math.pow(n, 2);
        int[][] matrix = new int[n2][n2];
        int[][] matrix2 = new int[n2][n2];
        int[][] matrix3 = new int[n2][n2];
        int count = 0;
        int countJkwadr = 0;
        int countIkwadr = 0;
        int row = 0;
        int col = 0;
        String solved = "NO";
        for (int i = 0; i < n2; i++) {
            // iterating through each 2D array ("table" or "matrix")
            for (int j = 0; j < n2; j++) { // iterating through each 1D array ("vector") array of a "matrix"
                // iterating through each element of a vector
                matrix[i][j] = scanner.nextInt();
                matrix2[j][i] = matrix[i][j];

                if (count == n) {
                    count = 0;
                    countJkwadr++;
                    row++;
                    col -= (n);
                }

                if (countJkwadr == n) {
                    countJkwadr = 0;
                    countIkwadr++;
                    col+=n;
                    if (countIkwadr < n){
                        row -= n;
                    }
                }

                if(countIkwadr == n){
                    countIkwadr =0;
                    col=0;
                }

                count++;
                matrix3[row][col] = matrix[i][j];

                col++;

            }
        }

        for (int i = 0; i < n2; i++) {
            if (!areDistinct(matrix[i]) || !areDistinct(matrix2[i]) || !areDistinct(matrix3[i])) {
                solved = "NO";
                break;
            } else {
                solved = "YES";
            }
        }

        System.out.println(solved);

    }


    public static boolean areDistinct(int[] rowCol) {
        if(rowCol.length == 1 && rowCol[0] != 1 ){
            return false;
        }
        for (int i = 0; i < rowCol.length; i++) {
            for (int j = i + 1; j < rowCol.length; j++) {
                if (rowCol[i] == rowCol[j]) {
                    return false;
                }
            }

        }
        return true;
    }

}