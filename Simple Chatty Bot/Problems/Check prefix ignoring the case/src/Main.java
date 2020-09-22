import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        System.out.println(sentence.toUpperCase().startsWith("J"));

    }
}
