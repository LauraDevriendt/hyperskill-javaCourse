package tictactoe;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer fieldNumber = 3;
        Integer numberOfDiagonals = 2;
        String playerValue = "X";
        String[][] matrixRows = new String[fieldNumber][fieldNumber];
        String[][] matrixCols = new String[fieldNumber][fieldNumber];
        String[][] matrixDiagonals = new String[numberOfDiagonals][fieldNumber];

        System.out.println("---------");
        System.out.println("| " + " " + " " + " " + " " + " " + " |");
        System.out.println("| " + " " + " " + " " + " " + " " + " |");
        System.out.println("| " + " " + " " + " " + " " + " " + " |");
        System.out.println("---------");

        addRowsColumns(fieldNumber, matrixRows, matrixCols);
        addPrincipalDiagonal(fieldNumber, matrixRows, matrixDiagonals);
        addSecondaryDiagonal(matrixRows, fieldNumber, matrixDiagonals);

        GamePlay(fieldNumber,matrixRows, scanner, matrixCols,matrixDiagonals,numberOfDiagonals, playerValue);




    }

    static String changePlayerValue(String playerValue){
        if(playerValue.equals("X")){
            playerValue = "O";
        } else {
          playerValue = "X";
        }
    return playerValue;
    }

    static void GamePlay(int fieldNumber, String[][] matrixRows, Scanner scanner, String[][] matrixCols, String[][] matrixDiagonals, int numberOfDiagonals, String playerValue){

        matrixRows = checkInput(fieldNumber, matrixRows, scanner, playerValue);

        addRowsColumns(fieldNumber, matrixRows, matrixCols);
        addPrincipalDiagonal(fieldNumber, matrixRows, matrixDiagonals);
        addSecondaryDiagonal(matrixRows, fieldNumber, matrixDiagonals);

        printBoard(fieldNumber,matrixRows);

        String result = gameResult(matrixRows, matrixCols, matrixDiagonals,fieldNumber,numberOfDiagonals);

        if (result.equals("Game not finished") || result.equals("Impossible")){
            playerValue = changePlayerValue(playerValue);
            GamePlay(fieldNumber, matrixRows, scanner, matrixCols,matrixDiagonals,numberOfDiagonals, playerValue);
        }else {
            System.out.println(result);
        }



    }

    static void printBoard(int fieldNumber, String[][] matrixRows){
        System.out.println("---------");
        for (int i = 0; i < fieldNumber; i++) {
            System.out.print("| ");
            for (int j = 0; j < fieldNumber; j++) {
                System.out.print(matrixRows[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    static String[][] checkInput(int fieldNumber, String[][] matrixRows, Scanner scanner, String playerInput){
        int[] coordinates = checkInputNumbers(scanner);
        String[][] reversedMatrix = reverseMatrix(fieldNumber, matrixRows);
        if(!reversedMatrix[coordinates[1]-1][coordinates[0]-1].equals(" ")){
            System.out.println("This cell is occupied! Choose another one!");
            checkInput(fieldNumber,matrixRows,scanner, playerInput);
        }else{
            reversedMatrix[coordinates[1]-1][coordinates[0]-1] = playerInput;
        }

        return reverseMatrix(fieldNumber, reversedMatrix);

    }

    static String[][] reverseMatrix(int fieldNumber, String[][] matrixRows){
        String[][] matrixMatchCoordinates = new String[fieldNumber][fieldNumber];
        int rowNum = fieldNumber-1;

        for (int i = 0; i < fieldNumber; i++){
            matrixMatchCoordinates[i]=matrixRows[rowNum];
            rowNum--;
        }
        return matrixMatchCoordinates;
    }



    static int[] checkInputNumbers(Scanner scanner){
        boolean isValid = false;
        int coordinate1 = 0;
        int coordinate2 = 0;
        while (!isValid) {
            System.out.print("Enter your coordinates (1-3): ");


            try {
                coordinate1 = scanner.nextInt();
            } catch (Exception e) {
                // Read any pending input which would be invalid characters at this point
                scanner.next();
            }
            try {

                coordinate2 = scanner.nextInt();
            } catch (Exception e) {
                // Read any pending input which would be invalid characters at this point
                scanner.next();

            }

            if (coordinate1 > 3 || coordinate1 < 1 || coordinate2 > 3 || coordinate2 < 1 ) {
                System.out.println("Wrong input enter only 1 number between 1-3: ");
            } else {
                isValid = true;
            }

        }
        return new int[]{coordinate1, coordinate2};

    }

    static void addRowsColumns(int fieldNumber, String[][] matrixRows, String[][] matrixCols) {
        for (int i = 0; i < fieldNumber; i++) {
            for (int j = 0; j < fieldNumber; j++) {
                if(matrixRows[i][j] == null) {
                    matrixRows[i][j] = " ";
                    matrixCols[j][i] = " ";
                } else {
                    matrixCols[j][i] =  matrixRows[i][j];
                }
            }
        }

    }

    static void addPrincipalDiagonal(int fieldNumber, String[][] mat, String[][] matrixDiagonals) {
        for (int i = 0; i < fieldNumber; i++) {
            for (int j = 0; j < fieldNumber; j++) {
                if (i == j) {
                    matrixDiagonals[0][j] = mat[i][j];
                }
            }
        }
    }

    static void addSecondaryDiagonal(String mat[][], int n, String[][] matrixDiagonals) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // Condition for secondary diagonal
                if ((i + j) == (n - 1)) {
                    matrixDiagonals[1][j] = mat[i][j];
                }
            }
        }
    }

    static String gameResult(String[][] matrixRows, String[][] matrixCols, String[][] matrixdiagonals, int fieldNumber, int numberOfDiagonals) {
        String result = "";

        if (!gameFinishedForMatrix(matrixRows, fieldNumber) && !gameFinishedForMatrix(matrixCols, fieldNumber) && !gameFinishedForMatrix(matrixdiagonals, numberOfDiagonals)) {
            result = "Game not finished";
        }
        ;
        if (draw(matrixRows, fieldNumber)) {
            result = "Draw";
        }


        if ((xWins(matrixRows, fieldNumber) || xWins(matrixCols, fieldNumber) || xWins(matrixdiagonals, numberOfDiagonals))) {
            result = "X wins";
        }

        if ((oWins(matrixRows, fieldNumber) || oWins(matrixCols, fieldNumber) || oWins(matrixdiagonals, numberOfDiagonals))) {
            result = "O wins";
        }

        if (impossible(matrixRows, fieldNumber) && impossible(matrixCols, fieldNumber) && impossible(matrixdiagonals, numberOfDiagonals)) {
            result = "Impossible";
        }
        return result;
    }

    static boolean gameFinishedForMatrix(String[][] matrix, int fieldNumber) {
        int sumO = 0;
        int sumX = 0;
        for (int i = 0; i < fieldNumber; i++) {
            if (containValue(matrix[i], "X")) {
                sumX += containValueCount(matrix[i], "X");
            }
            if (containValue(matrix[i], "O")) {
                sumO += containValueCount(matrix[i], "O");
            }
        }

        if (sumO+sumX == 9 ) {
            return true;
        }
        return false;

    }

    static boolean draw(String[][] matrix, int fieldNumber) {
        int sumO = 0;
        int sumX = 0;
        for (int i = 0; i < fieldNumber; i++) {
            if (containValue(matrix[i], "X")) {
                sumX += containValueCount(matrix[i], "X");
            }
            if (containValue(matrix[i], "O")) {
                sumO += containValueCount(matrix[i], "O");
            }
        }

        if (sumO+sumX == 9 ) {
            return true;
        }
        return false;
    }

    static boolean xWins(String[][] matrix, int fieldNumber) {

        for (int i = 0; i < fieldNumber; i++) {
            if (equalValues(matrix[i]) && containValue(matrix[i], "X")) {
                return true;
            }
        }
        return false;
    }

    static boolean oWins(String[][] matrix, int fieldNumber) {

        for (int i = 0; i < fieldNumber; i++) {
            if (equalValues(matrix[i]) && containValue(matrix[i], "O")) {
                return true;
            }
        }
        return false;
    }

    static boolean impossible(String[][] matrix, int fieldNumber) {
        int sumX = 0;
        int sumO = 0;
        boolean equalX = false;
        boolean equal0 = false;
        for (int i = 0; i < fieldNumber; i++) {
            if (containValue(matrix[i], "X")) {
                sumX += containValueCount(matrix[i], "X");
            }
            if (containValue(matrix[i], "O")) {
                sumO += containValueCount(matrix[i], "O");
            }

            if (equalValues(matrix[i]) && containValue(matrix[i], "O")) {
                equal0 = true;
            }

            if (equalValues(matrix[i]) && containValue(matrix[i], "X")) {
                equalX = true;
            }


        }
        if (fieldNumber != 2) {
            if (((sumX - sumO > 1 || sumO - sumX > 1) || equal0 && equalX)) {
                return true;
            }
        }

        if (equal0 && equalX) {
            return true;
        } else {
            return false;
        }

    }
    static boolean equalValues(String[] row) {
        for (int i = 0; i < row.length; i++) {
            for (int j = i + 1; j < row.length; j++) {
                if (!row[i].equals(row[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean containValue(String[] row, String value) {
        for (String string : row) {
            if (string.equals(value)) {
                return true;
            }
        }
        return false;

    }

    static int containValueCount(String[] row, String value) {
        int count = 0;
        for (String string : row) {
            if (string.equals(value)) {
                count++;
            }
        }
        return count;

    }
}



