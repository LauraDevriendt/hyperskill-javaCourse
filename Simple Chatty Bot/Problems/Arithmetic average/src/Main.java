import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        double num = 0;
        double count = 0;

        for (; a <= b; a++) {
            if (a % 3 == 0) {
                num += a;
                count++;
            }
        }

        System.out.println(num / count);
    }
}