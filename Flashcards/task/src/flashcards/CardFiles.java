package flashcards;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CardFiles {





    public boolean imports (CardMechanics cardMechanics, String file) {
        int count = 0;


        try {
            Scanner fileReader = new Scanner(Paths.get(file));

            while (fileReader.hasNextLine()) {
                String row = fileReader.nextLine();


                String[] parts = row.split(":");
                String term = parts[0];
                String definition = parts[1];
                String mistakes = parts[2];
                cardMechanics.addTerms(term, definition);
                cardMechanics.addTermMistakes(term, mistakes);

                count ++;

            }
            if(count == 1) {
                System.out.println(count + " card has been loaded.");
                cardMechanics.addingInputToLog(count + " card has been loaded.");

            } else {
                System.out.println(count + " cards have been loaded.");
                cardMechanics.addingInputToLog(count + " cards have been loaded.");
            }

            return true;
        } catch (IOException e) {
            System.out.println("File not found.");
            cardMechanics.addingInputToLog("File not found.");
            return false;
        }
    }

    public boolean exports (CardMechanics cardMechanics, String file) {
        Map<String, String> exporting = cardMechanics.getInfo();
        Map<String, Integer> exportMistakes = cardMechanics.getMistakeInfo();
        int count = 0;

        try {
            PrintWriter printWriter = new PrintWriter(file);
            for(String words : exporting.keySet()) {
                printWriter.println(words + ":" + exporting.get(words) + ":" + exportMistakes.get(words));
                count++;
            }
            printWriter.close();

            if(count == 1) {
                System.out.println(count + " card has been saved.");
                cardMechanics.addingInputToLog(count + " card has been saved.");
            } else if (count > 1){
                System.out.println(count + " cards have been saved.");
                cardMechanics.addingInputToLog(count + " cards have been saved.");
            }

            return true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean exportLogs (CardMechanics cardMechanics, String file) {


        try {
            PrintWriter printWriter = new PrintWriter(file);
            System.out.println("The log has been saved.");
            cardMechanics.addingInputToLog("The log has been saved.");
            cardMechanics.addingInputToLog("");
            List<String> logsToSave = cardMechanics.getLoggingInfo();
            logsToSave.add(0,"");
            for(String logging : logsToSave) {
                printWriter.println(logging);
            }

            printWriter.close();

            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }

    }
}
