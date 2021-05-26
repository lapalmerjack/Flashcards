import java.util.Random;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
       squaredNumbers(number);
    }


    public static void squaredNumbers(int number) {
        int squared = 1;


        while (true) {

            if(squared *squared > number) {
                break;
            }

            System.out.println(squared * squared);





            squared++;


        }



    }
}