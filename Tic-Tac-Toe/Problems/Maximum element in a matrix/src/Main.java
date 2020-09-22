import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        int m =  scanner.nextInt();
        int[][] matrix = new int[n][m];
        int maxCol = 0;
        int maxRow = 0;
        int result = 0;



        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
                if (matrix[i][j] > result || result == 0) {
                    result = matrix[i][j];
                    maxCol = j;
                    maxRow = i;
                }

                if (matrix[i][j] == result){
                    if(i < maxRow){
                        maxRow = i;
                    }

                    if( i == maxRow ){
                        if(j < maxCol){
                            maxCol = j;
                        }
                    }

                }
            }
        }

        System.out.println(maxRow + " " + maxCol);

    }
}