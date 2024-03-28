/*
 * This is the rock paper scissors program 
 *
 * @author  Andi
 * @version 1.0
 * @since   2024-03-05
 */

import { createPrompt } from 'bun-promptx'

function rockPaperScissor(userInputString: string) {
  // this function simulates a game of "rock-paper-scissors"

  // computer chooses rock, paper, or scissors
  const computerOptions: string[] = ["rock", "paper", "scissors"]
  const computerChoice = computerOptions[Math.floor(Math.random() * 3)]

  let output = ""

  // process
  console.log(`You choose: ${userInputString}`)
  console.log(`The computer choose: ${computerChoice}`)
  if (userInputString == computerChoice) {
    output = "You tied."
  } else {
    switch (computerChoice) {
      case "rock":
        if (userInputString == "scissors") {
          output = "You lost..."
        } else {
          output = "You won!"
        }
        break
      case "paper":
        if (userInputString == "rock") {
          output = "You lost..."
        } else {
          output = "You won!"
        }
        break
      case "scissors":
        if (userInputString == "paper") {
          output = "You lost..."
        } else {
          output = "You won!"
        }
        break
    }
  }
  return output
}

// input
const userInput = createPrompt("rock, paper, or scissors?: ")
const userInputString = userInput.value.trim().toLowerCase()

// error check
if (userInputString == "rock" ||
   userInputString == "paper" ||
   userInputString == "scissors"
) {
  let output = rockPaperScissor(userInputString)
  console.log(output)
} else {
  console.log(`Invalid input.`)
}

console.log("\nDone.")
