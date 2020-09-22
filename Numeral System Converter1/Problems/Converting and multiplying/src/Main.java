import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String string = scanner.next();
            try {
               int num = Integer.parseInt(string);
               if(num == 0){
                 break;
               }
                System.out.println(num*10);
            } catch (Exception e){
               System.out.println("Invalid user input:" + " " + string);
            }



        }
    }
}