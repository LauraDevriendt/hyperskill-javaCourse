import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        StringBuilder string = new StringBuilder();


        for (char character:word.toCharArray()
             ) {
            string.append(character);
            string.append(character);
        }

        System.out.println(string.toString());
    }
}