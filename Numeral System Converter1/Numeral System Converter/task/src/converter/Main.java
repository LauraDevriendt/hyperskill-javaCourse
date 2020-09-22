package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int sourceRadix = scanner.nextInt();
            String sourceNumber = scanner.next();
            int targetRadix = scanner.nextInt();
            if (targetRadix >= 1 && sourceRadix >= 1 && targetRadix <= 36 && sourceRadix <= 36) {
                System.out.println(convertNumber(sourceNumber, sourceRadix, targetRadix));
            } else {
                throw new Exception("error message: wrong radix");
            }

        } catch (Exception e) {
            System.out.println("error message:" + e.getMessage());
        }

    }

    public static String convertNumber(String sourceNumber, int sourceRadix, int targetRadix) {
        if (sourceNumber.contains(".")) {
            String fractionalConverted = "";
            String intPartString = sourceNumber.split("\\.")[0];
            String decimalPartString = sourceNumber.split("\\.")[1];

            String intConverted = convertIntegerPartToDecimalandBase(sourceRadix, intPartString, targetRadix);

            if (sourceRadix != 10) {
                String fractionIntoDecimal = convertFractionalPartIntoDecimal(sourceRadix, decimalPartString);
                fractionalConverted = fractionalIntoNewBase(targetRadix, Double.parseDouble(fractionIntoDecimal));

            } else {
                fractionalConverted = fractionalIntoNewBase(targetRadix, Double.parseDouble("0." + decimalPartString));
            }

            return (intConverted + "." + fractionalConverted);
        } else {
            return (convertIntegerPartToDecimalandBase(sourceRadix, sourceNumber, targetRadix));
        }
    }

    public static String convertIntegerPartToDecimalandBase(int sourceRadix, String sourceNumber, int targetRadix) {
        int outputInDecimal;
        String output;
        if (sourceRadix == 1) {
            outputInDecimal = sourceNumber.length();
        } else {
            outputInDecimal = Integer.parseInt(sourceNumber, sourceRadix);
        }

        if (targetRadix == 1) {
            output = "1".repeat(Math.max(0, outputInDecimal));
        } else {
            output = Integer.toString(outputInDecimal, targetRadix);
        }
        return output;
    }

    public static String convertFractionalPartIntoDecimal(int sourceRadix, String decimalPart) {
        Double result = 0.0;
        char[] charArray = decimalPart.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int numericValue = Character.getNumericValue(charArray[i]);

            result += (numericValue / Math.pow(sourceRadix, i + 1));
        }

        return result.toString();
    }

    public static String fractionalIntoNewBase(int targetRadix, double decimalPart) {
        String result = "";
        String integerPart = "1";

        while (Integer.parseInt(integerPart) > 0) {
            double multiply = decimalPart * targetRadix;
            integerPart = Double.toString(multiply).split("\\.")[0];
            String decimalPartString = Double.toString(multiply).split("\\.")[1];
            decimalPart = Double.parseDouble("0." + decimalPartString);
            result += Integer.toString(Integer.parseInt(integerPart), targetRadix);

            if (result.length() == 5) {
                break;
            }
        }
        if (result.length() < 5) {
            for (int i = result.length(); i < 5; i++) {
                result += "0";
            }
        }

        return result;
    }

}

