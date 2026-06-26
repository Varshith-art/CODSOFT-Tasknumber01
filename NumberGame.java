import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        String playAgain;

        System.out.println("===== WELCOME TO NUMBER GAME =====");

        do {
            int randomNumber = random.nextInt(100) + 1;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {

                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");

                    int roundScore = maxAttempts - attempt + 1;
                    totalScore += roundScore;

                    System.out.println("Score earned in this round: " + roundScore);
                    guessedCorrectly = true;
                    break;
                } 
                else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } 
                else {
                    System.out.println("Too high! Try again.");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempt));
            }

            if (!guessedCorrectly) {
                System.out.println("You lost this round.");
                System.out.println("The correct number was: " + randomNumber);
            }

            System.out.println("Total Score: " + totalScore);

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\nThank you for playing!");
        System.out.println("Final Score: " + totalScore);

        sc.close();
    }
}