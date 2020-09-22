import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int n2 = (int) Math.pow(n,2);
        int[][] matrix = new int[n][n];

        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
            matrix[k][l] = scanner.nextInt();
            }
        }


        String ismatch = "YES";

        for (int k = 0; k < n - 1; k++) {
            for (int l = 0; l < n - 1; l++) {
                if (matrix[k][l] != matrix[l][k]) {
                    ismatch = "NO";
                    break;
                }
            }
        }

        System.out.print(ismatch);
    }
}