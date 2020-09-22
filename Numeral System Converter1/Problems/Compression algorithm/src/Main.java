import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringOutput = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer(scanner.next());

        for (int i = 0; i < stringBuffer.length(); i++) {
            int count = 1;
            while (i + 1 < stringBuffer.length()
                    && stringBuffer.charAt(i) == stringBuffer.charAt(i + 1)) {
                count++;
                i++;
            }
            stringOutput.append(stringBuffer.charAt(i));
            stringOutput.append(count);

        }

        System.out.println(stringOutput);
    }
    }


