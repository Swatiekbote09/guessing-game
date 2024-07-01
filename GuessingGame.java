import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int score = 0;
        
        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // Generate a random number between 1 and 100
            int numberOfAttempts = 0;
            boolean guessedCorrectly = false;
            
            System.out.println("I have generated a number between 1 and 100. Can you guess what it is?");
            
            while (!guessedCorrectly && numberOfAttempts < 10) { // Limit the number of attempts to 10
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                numberOfAttempts++;
                
                if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! You've guessed the number.");
                    guessedCorrectly = true;
                    score += (10 - numberOfAttempts); // Score based on number of attempts taken
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + numberToGuess);
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String userResponse = scanner.next();
            if (!userResponse.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }
        
        System.out.println("Your final score is: " + score);
        System.out.println("Thank you for playing!");
        
        scanner.close();
    }
}
