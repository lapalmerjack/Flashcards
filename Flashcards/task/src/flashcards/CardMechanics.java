package flashcards;

import java.util.*;

public class CardMechanics {



    private Map<String, String> flashcards;
    private Map<String, Integer> mistakeCounter;
    private List<String> input;




    public CardMechanics() {
        this.flashcards = new LinkedHashMap<>();
        this.input = new ArrayList<>();
        this.mistakeCounter = new LinkedHashMap<>();
    }

    public void addingInputToLog(String input) {
        this.input.add(input);
    }

    public void addTerms(String term, String definition) {
       this.flashcards.put(term, definition);

    }
    public void addTermMistakes(String term, String count) {
        this.mistakeCounter.put(term,Integer.parseInt(count));
    }

    public void addTermMistakes(String term) {
        this.mistakeCounter.putIfAbsent(term,0);



    }

    public boolean termExistence (String term) {
            if(this.flashcards.containsKey(term)) {
                System.out.println("The card " + "\"" + term + "\""
                        + " already exists.");
                this.addingInputToLog("The card " + "\"" + term + "\""
                        + " already exists.");
                return true;

        }
        return false;
    }
    public boolean definitionExistence (String definition) {
       if (this.flashcards.containsValue(definition)) {
           System.out.println("The definition " + "\"" + definition + "\""
                   + " already exists.");
           this.addingInputToLog("The definition " + "\"" + definition + "\""
                   + " already exists.");
           return true;
       }
       return false;
    }
    public void cardRemove (String card) {
        if(this.flashcards.containsKey(card)) {
            this.flashcards.remove(card);
            this.mistakeCounter.remove(card);
            System.out.println("This card has been removed.");
            this.addingInputToLog("This card has been removed.");

        } else {
            System.out.println("Can't remove " +  "\"" + card + "\"" + ": there is no such card.");
            this.addingInputToLog("Can't remove " +  "\"" + card + "\"" + ": there is no such card.");
        }
    }

public void guessing() {


        Scanner scanner = new Scanner(System.in);
    System.out.println("How many times to ask?");
    this.addingInputToLog("How many times to ask?");
    String askTimes = scanner.nextLine();
    this.addingInputToLog(askTimes);
    int count = 0;



        for(String term: this.flashcards.keySet()) {
            System.out.println("print the definition of " +  "\"" + term + "\"" + ":");
            this.addingInputToLog("print the definition of " +  "\"" + term + "\"" + ":");
            String definition = scanner.nextLine();
            this.addingInputToLog(definition);
            if(this.flashcards.get(term).equals(definition)) {
                System.out.println("Correct!");
                this.addingInputToLog("Correct!");
            }else if (!this.flashcards.get(term).equals(definition) && this.flashcards.containsValue(definition)) {
                this.addingMistakes(term);
                String rightAnswer = this.printOutDefinitionKey(definition);
                System.out.println("Wrong. the right answer is "  + "\"" + this.flashcards.get(term) + "\"" + ", " +
                        "but your definition is correct for " + "\"" + rightAnswer + "\"" + ".");
                this.addingInputToLog("Wrong. the right answer is "  + "\"" + this.flashcards.get(term) + "\"" + ", " +
                        "but your definition is correct for " + "\"" + rightAnswer + "\"" + ".");
            }else {
                this.addingMistakes(term);
                System.out.println("Wrong. the right answer is "+ "\"" + this.flashcards.get(term)+"\""+".");
                this.addingInputToLog("Wrong. the right answer is "+ "\"" + this.flashcards.get(term)+"\""+".");
            }

            count++;
            if(count == Integer.parseInt(askTimes)) {
                break;
            }




    }


}
    private String printOutDefinitionKey(String definition) {
        String definite = "";
        for(String definitions: this.flashcards.keySet()) {
            if (this.flashcards.get(definitions).equals(definition)) {
                definite = definitions;
            }
        }

        return definite;
}
    public Map<String,String> getInfo() {
       Map <String,String> flashCards = new LinkedHashMap<>();
      for  (String terms : this.flashcards.keySet()) {
          flashCards.put(terms, this.flashcards.get(terms));

        }

      return flashCards;
    }

    public Map<String,Integer> getMistakeInfo() {
        Map <String,Integer> flashCards = new LinkedHashMap<>();
        for  (String terms : this.mistakeCounter.keySet()) {
            flashCards.put(terms, this.mistakeCounter.get(terms));

        }

        return flashCards;
    }

    public List<String> getLoggingInfo() {
        List<String> loggingInfo = new ArrayList<>(this.input);

        return loggingInfo;
    }



    private void addingMistakes(String term) {
            int temp = this.mistakeCounter.get(term) + 1;
            this.mistakeCounter.put(term, temp);
        }


    public void resettingMistakes () {
       for(String term : this.mistakeCounter.keySet()) {
           this.mistakeCounter.put(term,0);
           System.out.println("Card statistics have been reset.");
           this.addingInputToLog("Card statistics have been reset.");
       }
    }

    public void hardestCard () {
        int hardestCardCount = 0;
        String hardestCard = "";
        StringBuilder hardestCardsSet = new StringBuilder();

        for(String term : this.mistakeCounter.keySet()) {
            if (hardestCardCount < this.mistakeCounter.get(term)) {
                hardestCardCount = this.mistakeCounter.get(term);
                hardestCard = term;


            } else if (hardestCardCount != 0 && hardestCardCount == this.mistakeCounter.get(term)) {
                hardestCardsSet.append(", ").append("\"" ).append(term).append("\"");
            }
        }

        if(hardestCardCount == 0) {
            System.out.println("There are no cards with errors.");
            this.addingInputToLog("There are no cards with errors.");
        }

        else if(hardestCardsSet.toString().isBlank()) {
            if(hardestCardCount == 1) {
                System.out.println("The hardest card is " + "\"" + hardestCard +"\""+". You have " + hardestCardCount + " " +
                        "error answering it.");
                this.addingInputToLog("The hardest card is " + "\"" + hardestCard +"\""+". You have " + hardestCardCount + " " +
                        "error answering it.");

            } else {
                System.out.println("The hardest card is " + "\"" + hardestCard +"\""+". You have " + hardestCardCount + " " +
                        "errors answering it.");
                this.addingInputToLog("The hardest card is " + "\"" + hardestCard +"\""+". You have " + hardestCardCount + " " +
                        "errors answering it.");
            }

        } else {
            if (hardestCardCount == 1) {
                System.out.println("The hardest cards are " + "\"" +hardestCard + "\"" + hardestCardsSet.toString()+ ". You have " +
                        hardestCardCount + " error answering them.");
                this.addingInputToLog("The hardest cards are " + "\"" +hardestCard + "\"" + hardestCardsSet.toString()+ ". You have " +
                        hardestCardCount + " error answering them.");
            } else {
                System.out.println("The hardest cards are " + "\"" + hardestCard + "\""  + hardestCardsSet.toString() + ". You have " +
                        hardestCardCount + " errors answering them.");
                this.addingInputToLog("The hardest cards are " + "\"" + hardestCard + "\""  + hardestCardsSet.toString() + ". You have " +
                        hardestCardCount + " errors answering them.");
            }


        }

    }



}
