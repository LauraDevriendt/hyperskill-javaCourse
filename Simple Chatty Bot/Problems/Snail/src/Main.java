import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int result = 0;
        int count =0;

        while (result < h) { 
            result = result + a;
            if (result < h) {
                result = result - b;
            }
            count++;
        }

        System.out.println(count);
    }
}
