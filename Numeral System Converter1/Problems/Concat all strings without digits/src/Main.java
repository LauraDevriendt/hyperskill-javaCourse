import java.util.Scanner;

class ConcatenateStringsProblem {

    public static StringBuilder concatenateStringsWithoutDigits(String[] strings) {
        StringBuilder mainString = new StringBuilder();
        for (String string:strings
             ) {
            for(int i = 0; i < string.length(); i++){
                if(!isNumeric(String.valueOf(string.charAt(i)))){
                    mainString.append(string.charAt(i));
                }
            }

        }
    return mainString;
    }

    public static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        StringBuilder result = concatenateStringsWithoutDigits(strings);
        System.out.println(result);
    }
}