package flashcards;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String first = "";
        String second = "";
        String third = "";
        String fourth = "";
        Scanner scanner = new Scanner(System.in);
        CardMechanics cardMechanics = new CardMechanics();
        UserInterface ui = new UserInterface(scanner,cardMechanics);

        if(args.length > 0) {
            first = args[0];
        }
        if(args.length > 1) {
            second = args[1];

        }

        if(args.length > 2) {
            third = args[2];
        }
        if (args.length > 3) {
            fourth = args[3];
        }




        ui.start(first,second,third,fourth);


    }}
