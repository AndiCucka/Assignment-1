/*
 * Rock Paper Scissor assignment 
 *
 * @author  Andi Cucka
 * @version 1.0
 * @since   2024-02-22
 */
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    enum Choice {
        ROCK,
        PAPER,
        SCISSORS
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Let's play Rock, Paper, Scissors!");

        System.out.print("Enter your choice (rock, paper, scissors): ");
        String userInput = scanner.nextLine().trim().toLowerCase();
        Choice userChoice;
        switch (userInput) {
            case "rock":
                userChoice = Choice.ROCK;
                break;
            case "paper":
                userChoice = Choice.PAPER;
                break;
            case "scissors":
                userChoice = Choice.SCISSORS;
                break;
            default:
                System.out.println("Invalid choice. Please enter rock, paper, or scissors.");
                return;
        }

        Choice computerChoice = getRandomChoice(random);

        System.out.println("You chose: " + userChoice);
        System.out.println("Computer chose: " + computerChoice);

        String result = determineWinner(userChoice, computerChoice);
        System.out.println(result);

        scanner.close();
    }

    private static Choice getRandomChoice(Random random) {
        int choiceIndex = random.nextInt(3);
        switch (choiceIndex) {
            case 0:
                return Choice.ROCK;
            case 1:
                return Choice.PAPER;
            case 2:
                return Choice.SCISSORS;
            default:
                return Choice.ROCK; // Default should never be reached
        }
    }

    private static String determineWinner(Choice userChoice, Choice computerChoice) {
        if (userChoice == computerChoice) {
            return "It's a tie!";
        } else if (
            (userChoice == Choice.ROCK && computerChoice == Choice.SCISSORS) ||
            (userChoice == Choice.PAPER && computerChoice == Choice.ROCK) ||
            (userChoice == Choice.SCISSORS && computerChoice == Choice.PAPER)
        ) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
}
