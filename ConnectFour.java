import java.util.*;
import java.io.*; 

public class ConnectFour {

    private static boolean winCondition = false;
    public static void main(String[] args) {
        System.out.println("Welcome to CONNECT FOUR: The Game" + "\n");

        //Scanner for user input
        Scanner userInput = new Scanner(System.in);

        Game();
        
        // When somebody finally wins
        if (winCondition) {
            System.out.println(Player.getPlayer() + "wins!");

            // If the user wants to play again
            System.out.println("Play again? Y/N: ");
            String playAgain = userInput.next();
            if (playAgain.equals("Y")) {
                winCondition = false;
                Game();
            } else if (playAgain.equals("N")) {
                System.out.println("See you next time!");
            } else {
                throw new IllegalArgumentException("Put Y or N");
            }
        }
    }

    public static void Game() {
        // Creating new board for the game
        Space gameBoard = new Space();
        // keeps track of which turn it is
        int turn = 0;

        // Keeps the board looping and updating as long as there is no win
        while (!winCondition()) { // winCondition needs to be coded; checks if anyone has won yet
            System.out.println(gameBoard);
            System.out.println("Turn " + turn + "\n");
            //System.out.println(Player.getPlayer()); // create new method in Player .getPlayer() to see whose turn it is
            Player player1 = new Player("Player1");
            Player player2 = new Player("Player2");

            while (!gameBoard.isSpaceFull){
                System.out.print("Which column would you like to drop an X in? Enter 1, 2, 3, 4, 5, or 6: "); // need playerToken to update between X and O depending on which player
                int column = userInput.nextInt();

                if (column < 0 || column > Space.cols){
                    System.out.println("Invalid column. Please enter a value between 0 and 6.");
                    continue;
                }

                if (turn % 2 == 0) {   // could this maybe an idea to swap between player1 and player2?
                    gameBoard.updateBoard(column, "X"); // Write method to update the gameBoard with the X in the last column
                //} else if (player == player2) {
                } else if (turn % 2 == 1) { //if (player == player1) { // Write player and player1 to mean something
                    gameBoard.updateBoard(column, "O");
                }

                if (true) {
                    System.out.println("Column is full. Try again.");
                }
            }

            turn++;
        }
    }
}

// When user runs program, program prints welcome statement, initial array, and whose turn it is at top
//     Token "X" is player one, token "O" is player 2
//      Create initial array
// Program prompts user which column they want to try and "drop" their token in-- Scan for user's input
// take column and for loop for each element in the column to see which is the last "empty" (0) space and fill it with X or O, depending on whose turn it is
// make a method that checks for wins-- ie. if there are four X's, player one wins, if there are 4 O's, player 2 wins
