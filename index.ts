/*
 * Rock Paper Scissors code foor assignment
 *
 * @author  Andi Cucka
 * @version 1.0
 * @since   2024-02-22
 */
import * as readline from 'readline';

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

enum Choice {
    ROCK = "rock",
    PAPER = "paper",
    SCISSORS = "scissors"
}

function getUserChoice(): Promise<Choice> {
    return new Promise((resolve) => {
        rl.question('Enter your choice (rock, paper, scissors): ', (answer) => {
            const choice = answer.trim().toLowerCase();
            if (Object.values(Choice).includes(choice as Choice)) {
                resolve(choice as Choice);
            } else {
                console.log("Invalid choice. Please enter rock, paper, or scissors.");
                resolve(getUserChoice());
            }
        });
    });
}

function getComputerChoice(): Choice {
    const choices = Object.values(Choice);
    const randomIndex = Math.floor(Math.random() * choices.length);
    return choices[randomIndex] as Choice;
}

function determineWinner(userChoice: Choice, computerChoice: Choice): string {
    if (userChoice === computerChoice) {
        return "It's a tie!";
    } else if (
        (userChoice === Choice.ROCK && computerChoice === Choice.SCISSORS) ||
        (userChoice === Choice.PAPER && computerChoice === Choice.ROCK) ||
        (userChoice === Choice.SCISSORS && computerChoice === Choice.PAPER)
    ) {
        return "You win!";
    } else {
        return "Computer wins!";
    }
}

async function playGame() {
    console.log("Let's play Rock, Paper, Scissors!");
    const userChoice = await getUserChoice();
    const computerChoice = getComputerChoice();
    console.log(`You chose: ${userChoice}`);
    console.log(`Computer chose: ${computerChoice}`);
    console.log(determineWinner(userChoice, computerChoice));
    rl.close();
}

playGame();
