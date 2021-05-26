package flashcards;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private CardMechanics flashCardMechanics;
    private CardFiles cardFiles;


    public UserInterface(Scanner scanner, CardMechanics flashCardMechanics) {
        this.scanner = scanner;
        this.flashCardMechanics = flashCardMechanics;
        cardFiles = new CardFiles();


    }

    public void start(String first, String second, String third, String fourth) {
        if(first.equals("-import")) {
            cardFiles.imports(this.flashCardMechanics,second);
        } else if (third.equals("-import")) {
            cardFiles.imports(this.flashCardMechanics,fourth);
        }
        this.inputAction();

        System.out.println("Bye bye!");
        this.flashCardMechanics.addingInputToLog("Bye bye!");

        if(first.equals("-export")) {
            cardFiles.exports(this.flashCardMechanics,second);
        } else if (third.equals("-export")) {
          cardFiles.exports(this.flashCardMechanics,fourth);
        }




    }

    private void inputAction () {

        while (true) {
            System.out.println("Input the action (add, remove, import, export, ask, exit, log, hardest card" +
                    ", reset stats); ");
            this.flashCardMechanics.addingInputToLog("Input the action (add, remove, import, export, ask, exit, log, hardest card" +
                    ", reset stats); ");
            String action = scanner.nextLine();
            this.flashCardMechanics.addingInputToLog(action);
            if (action.equals("add")) {
                this.add();
            } else if (action.equals("remove")) {
                this.remove();
            } else if (action.equals("import")) {
                this.importation();

            } else if (action.equals("export")) {
                this.exportation();
            }else if (action.equals("ask")) {
                this.flashCardMechanics.guessing();
            }
            else if (action.equals("exit")) {
                break;
            }else if (action.equals("log")) {
                logRecords();
            } else if (action.equals("hardest card")) {
                this.flashCardMechanics.hardestCard();
            } else if (action.equals("reset stats")) {
                this.flashCardMechanics.resettingMistakes();
            }

        }

    }



        private void add () {
            System.out.println("The card:");
            this.flashCardMechanics.addingInputToLog("The card:");
            String term = scanner.nextLine();
            this.flashCardMechanics.addingInputToLog(term);
            if (!this.flashCardMechanics.termExistence(term)) {
                System.out.println("The definition of the card: ");
                this.flashCardMechanics.addingInputToLog("The definition of the card: ");
                String definition = scanner.nextLine();
                this.flashCardMechanics.addingInputToLog(definition);
                if (!this.flashCardMechanics.definitionExistence(definition)) {
                    this.flashCardMechanics.addTerms(term, definition);
                    this.flashCardMechanics.addTermMistakes(term);
                    System.out.println("The pair (" + "\"" + term + "\""  + ":" +"\"" + definition +"\"" + ") has been added.");
                    this.flashCardMechanics.addingInputToLog("The pair (" + "\"" + term + "\""  + ":" +"\"" + definition +"\"" + ") has been added.");
                }
            }
        }

        private void remove () {
            System.out.println("Which card?");
            this.flashCardMechanics.addingInputToLog("Which card?");
            String cardRemoval = scanner.nextLine();
            this.flashCardMechanics.addingInputToLog(cardRemoval);
            this.flashCardMechanics.cardRemove(cardRemoval);
        }

        private void importation () {
            System.out.println("File Name");
            this.flashCardMechanics.addingInputToLog("File Name");
            String fileName = scanner.nextLine();
            this.flashCardMechanics.addingInputToLog(fileName);
            cardFiles.imports(this.flashCardMechanics, fileName);
        }

        private void exportation () {
            System.out.println("File name: ");
            this.flashCardMechanics.addingInputToLog("File name: ");
            String fileName = scanner.nextLine();
            this.flashCardMechanics.addingInputToLog(fileName);
            cardFiles.exports(this.flashCardMechanics,fileName);

        }

        private void logRecords () {
            System.out.println("File name: ");
            this.flashCardMechanics.addingInputToLog("File name: ");
            String fileName = scanner.nextLine();
            this.flashCardMechanics.addingInputToLog(fileName);
            cardFiles.exportLogs(this.flashCardMechanics,fileName);
        }









    }


