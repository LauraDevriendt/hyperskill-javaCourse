import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        double count = 0;

        for (char character:string.toLowerCase().toCharArray()
             ) {
            if (character == 'c' || character == 'g'){
                count++;
            }

        }

        System.out.println(count/string.length()*100);

    }
}