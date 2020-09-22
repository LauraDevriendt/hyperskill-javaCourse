import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String sentence = scanner.nextLine();
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        System.out.println(sentence.substring(num1, num2+1));
    }
}
