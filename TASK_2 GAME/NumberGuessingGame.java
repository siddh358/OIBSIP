import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        // Generate a random number between 1 and 100
        Random random = new Random();
        int number = random.nextInt(100) + 1;

        // Initialize the number of guesses and the guess variable
        int numGuesses = 0;
        int guess = 0;

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Loop until the user guesses the correct number
        while (guess != number) {
            // Ask the user to enter a guess
            System.out.print("Guess a number between 1 and 100: ");
            guess = scanner.nextInt();
            numGuesses++;

            // Check if the guess is correct and provide feedback to the user
            if (guess < number) {
                System.out.println("Your guess is too low. Try again.");
            } else if (guess > number) {
                System.out.println("Your guess is too high. Try again.");
            } else {
                System.out.println("Congratulations, you guessed the number!");
                System.out.println("It took you " + numGuesses + " guesses.");
            }
        }

        // Close the Scanner object
        scanner.close();
    }
}
