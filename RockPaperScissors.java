// This is the rock-paper-scissors game
// Author: Andi Cucka
// Version: 1.0
// Date: 2024-03-05

// Define a function to simulate the rock-paper-scissors game
function rockPaperScissors(userInputString) {
  // This function simulates a game of "rock-paper-scissors"

  // Define an array containing the options: rock, paper, scissors
  const computerOptions = ["rock", "paper", "scissors"];
  
  // Generate a random choice for the computer
  const computerChoice = computerOptions[Math.floor(Math.random() * 3)];

  let output = "";

  // Output user and computer choices
  console.log(`You choose: ${userInputString}`);
  console.log(`The computer choose: ${computerChoice}`);

  // Determine the outcome of the game
  if (userInputString === computerChoice) {
    output = "You tied.";
  } else {
    switch (computerChoice) {
      case "rock":
        if (userInputString === "scissors") {
          output = "You lost...";
        } else {
          output = "You won!";
        }
        break;
      case "paper":
        if (userInputString === "rock") {
          output = "You lost...";
        } else {
          output = "You won!";
        }
        break;
      case "scissors":
        if (userInputString === "paper") {
          output = "You lost...";
        } else {
          output = "You won!";
        }
        break;
    }
  }
  return output;
}

// Prompt the user for input
const userInput = prompt("rock, paper, or scissors? (lowercase): ");
const userInputString = userInput.toLowerCase();

// Check if the input is valid and play the game
if (userInputString === "rock" || userInputString === "paper" || userInputString === "scissors") {
  const output = rockPaperScissors(userInputString);
  console.log(output);
} else {
  console.log("Invalid input.");
}

console.log("\nDone.");
