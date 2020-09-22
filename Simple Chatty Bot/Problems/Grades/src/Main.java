import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        for (int i = 0; i <= n; i++) {
            int testCase = scanner.nextInt();
            if (testCase == 5) {
                countA++;
            } else if (testCase == 4) {
                countB++;
            } else if (testCase == 3) {
                countC++;
            } else if (testCase == 2) {
                countD++;
            }
        }

        System.out.println(countD + " " + countC + " " + countB + " " + countA);
    }
}