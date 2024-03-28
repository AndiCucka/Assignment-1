/*
 * This is the rock paper scissors game
 *
 * @author  Andi Cucka
 * @version 1.0
 * @since   2024-03-06
 */

import java.util.Random;
import java.util.Scanner;


// This is the standard Rock Paper Scissors program.
final class RockPaperScissors {

    // Prevents instantiation of the RockPaperScissors class
    // by throwing an IllegalStateException if attempted.
    private RockPaperScissors() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    // Simulates a game of "rock-paper-scissors" based on
    // the user's input and returns the result as a string.
    public static String rockPaperScissor(String userInputString) {

        // variables
        final String rockString = "rock";
        final String paperString = "paper";
        final String scissorsString = "scissors";
        final String winOutcome = "You won!";
        final String lostOutcome = "You lost...";
        final String tiedOutcome = "You tied.";
        final int randnumberMax = 3;
        String output = "";

        // Computer chooses rock, paper, or scissors
        final String[] computerOptions =
            {rockString, paperString, scissorsString};
        final Random random = new Random();
        final String computerChoice =
            computerOptions[random.nextInt(randnumberMax)];

        // Process
        System.out.println("You choose: " + userInputString);
        System.out.println("The computer choose: " + computerChoice);
        if (userInputString.equals(computerChoice)) {
            output = tiedOutcome;
        } else {
            switch (computerChoice) {
                case rockString:
                    if (userInputString.equals(scissorsString)) {
                        output = lostOutcome;
                    } else {
                        output = winOutcome;
                    }
                    break;
                case paperString:
                    if (userInputString.equals(rockString)) {
                        output = lostOutcome;
                    } else {
                        output = winOutcome;
                    }
                    break;
                case scissorsString:
                    if (userInputString.equals(paperString)) {
                        output = lostOutcome;
                    } else {
                        output = winOutcome;
                    }
                    break;
                default:
                    break;
            }
        }
        return output;
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(String[] args) {
        // variables
        final String rockString = "rock";
        final String paperString = "paper";
        final String scissorsString = "scissors";

        // Input
        final Scanner scanner = new Scanner(System.in);
        System.out.print("rock, paper, or scissors?: ");
        final String userInputString = scanner.nextLine().trim().toLowerCase();

        // Error check
        if (userInputString.equals(rockString)
            || userInputString.equals(paperString)
            || userInputString.equals(scissorsString)) {
            final String output = rockPaperScissor(userInputString);
            System.out.println(output);
        } else {
            System.out.println("Invalid input.");
        }

        System.out.println("\nDone.");
    }
}
