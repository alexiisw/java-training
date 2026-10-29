package workbook3.fileio;

import java.util.Random;
import java.util.Scanner;

public class FamousQuotes {
    public static void main(String[] args) {
        Scanner famousQuotes = new Scanner(System.in);

        String[] quotes = createQuotes(); // pulls the array of quotes created outside the main

        Random random = new Random(); // allows for a random generator
        String anotherSelection = "yes";
        while (anotherSelection.equalsIgnoreCase("yes")) {
            try {
                System.out.println("Would you like to (S)elect a number or generated (R)andomly? (enter S or R)");
                char quoteGenerator = Character.toUpperCase(famousQuotes.next().charAt(0));
                famousQuotes.nextLine(); // consumes leftover line

                if (quoteGenerator == 'S') {
                    System.out.println("Please select a number between 1 and 10");
                    int quoteSelection = famousQuotes.nextInt();
                    famousQuotes.nextLine(); // consumes leftover line

                    if (quoteSelection < 1 || quoteSelection > quotes.length) { // .length instead to cover any length list
                        System.out.println("Error: Invalid selection");
                    } else {
                        quoteSelection--;
                        System.out.println(quotes[quoteSelection]);
                    }
                } else if (quoteGenerator == 'R') {
                    String selectedQuote = quotes[random.nextInt(quotes.length)];
                    // quote[] - pulls the list of quotes ; random.nextInt() generates the random number; .length - pulls the list qty
                    System.out.println(selectedQuote);
                } else {
                    System.out.println("Error: Invalid selection");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid selection");
                famousQuotes.nextLine(); // eats leftover line
            }
            System.out.println("Would you like to make another selection? Yes/No");
            anotherSelection = famousQuotes.nextLine();
        }
        System.out.print("Thank you for making a selection. See you next time.");

        famousQuotes.close();
    }

    private static String[] createQuotes() {
                    // shorter version - returns it immediately vs waiting for list to be filled
        return new String[]{"Success is not final, failure is not fatal: it is the courage to continue that counts.",
                    "Discipline is choosing between what you want now and what you want most.",
                    "The person you become is more important than the goal you achieve.",
                    "Small daily improvements are the key to staggering long-term results.",
                    "You do not rise to the level of your goals. You fall to the level of your systems.",
                    "Comfort is expensive. Growth is uncomfortable, but it pays dividends forever.",
                    "Don't watch the clock; do what it does. Keep going.",
                    "The best time to plant a tree was 20 years ago. The second-best time is now.",
                    "Confidence isn't knowing you'll succeed. It's knowing you'll be okay if you don't.",
                    "A year from now, you'll wish you had started today."
        };
    }
}
//            String[] quotes = {"Success is not final, failure is not fatal: it is the courage to continue that counts.",
//                    "Discipline is choosing between what you want now and what you want most.",
//                    "The person you become is more important than the goal you achieve.",
//                    "Small daily improvements are the key to staggering long-term results.",
//                    "You do not rise to the level of your goals. You fall to the level of your systems.",
//                    "Comfort is expensive. Growth is uncomfortable, but it pays dividends forever.",
//                    "Don't watch the clock; do what it does. Keep going.",
//                    "The best time to plant a tree was 20 years ago. The second-best time is now.",
//                    "Confidence isn't knowing you'll succeed. It's knowing you'll be okay if you don't.",
//                    "A year from now, you'll wish you had started today."};
//            return quotes;