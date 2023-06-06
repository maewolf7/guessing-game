// mae wolf
// class: cs & 145
// date: 04/06/2023
// lab 1: guessing game

import java.util.Scanner;
import java.util.Random;

public class MWGuess {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      
      instructions();
      
      String response = "";
      
      char firstLetter = 0;
      boolean playAgain = true;
      boolean validEntry = false;
      int gameCount = 0;
      int totalGuesses = 0;
      double guessesAverage = 0;
      int currentGuessCount;
      int bestGame = 99999999;
      
      // While loop calls playGame method & prompts user to play again
      while (playAgain){
        
         validEntry = false;
         currentGuessCount = playGame();
         totalGuesses += currentGuessCount;
         if (currentGuessCount < bestGame){
            bestGame = currentGuessCount;
         }
         gameCount++;
         
         // Asks the user for input until they give a valid input 
         while (!validEntry){
            
            System.out.println("Would you like to play again?");
            response = input.next();
            firstLetter = response.charAt(0);
            
            if (firstLetter ==  'y' || firstLetter == 'Y') {
               validEntry = true;
               playAgain = true; 
            }
            
            else if (firstLetter == 'n' || firstLetter == 'N'){
               validEntry = true;
               playAgain = false;
            }
            
            else{
               System.out.println("That is not a vaild entry. Try Again.");
            
            }  
         
         }//end while
      }//end of playAgain loop
      
      guessesAverage = totalGuesses / gameCount;
      
      giveResults(gameCount, totalGuesses, guessesAverage, bestGame);
   }//end of main
 
   // gives instructions 
   public static void instructions() {
      System.out.println("This progam allows you to play a guessing game!");
      System.out.println("I will think of a number between 1");
      System.out.println("and 100 and will allow you to guess until");
      System.out.println("you get it. For each guess, I will tell you ");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.");
   }//end of instructions
 
   // main code of guessing game, prompts user for guess and tells them higher or lower
   public static int playGame(){
      Scanner input = new Scanner(System.in);
      
      Random rand = new Random();
      int randomNum = rand.nextInt(100) + 1;
   
      System.out.println("I'm thinking of a number between 1 and 100...");
      System.out.print("Your guess? ");
      int guess = input.nextInt();
      int count = 1;
      
      while(guess != randomNum){
         if (guess > randomNum) {
         
            System.out.println("It's lower.");
            count++;
         }
         if (guess < randomNum) {
         
            System.out.println("It's higher.");
            count++; 
         }
         System.out.print("Your Guess?");
         guess = input.nextInt();
      }// end of while
      
      System.out.println("You got it right in " + count + " guesses!");
      
      return count;
   }// end of playGame
      
   // gives the final game results once user decides not to play again
   public static void giveResults(int gameCount, int totalGuesses, double guessesAverage, int bestGame) {
   
      System.out.println("Overall results: ");
   
      System.out.println("\ttotal games = " + gameCount); 
      System.out.println("\ttotal guesses = " + totalGuesses);
      System.out.println("\tgesses/game = " + guessesAverage);
      System.out.println("\tbest game = " + bestGame);
   
   
   }//end of giveResults
}//end of MWGuess