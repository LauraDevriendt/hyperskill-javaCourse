import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String[][] field = new String[num][num];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (i == num / 2  || j == num / 2 || i == j || i + j == num - 1 ) {
                    field[i][j] = "*";
                } else{
                    field[i][j] = "."; // assign a value to an element
                }
                System.out.print(field[i][j] + " ");
            }
                System.out.println();
        }


    }
}