import java.util.*;

public class ConnectFour {

    private static Player playerOne;
    private static Player playerTwo;

    private static boolean winCondition = false;
    public static void main(String[] args) {
        System.out.println("Welcome to CONNECT FOUR: The Game" + "\n");

        //Scanner for user input
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter the first player's name and token (X or O):");
        playerOne = new Player(userInput.next(), userInput.next());

        System.out.println("Please enter the second player's name and the other token:");
        playerTwo = new Player(userInput.next(), userInput.next());
        Game(userInput);
        
        // When somebody finally wins
        if (winCondition) {
            if (playerOne.hasWon){
                System.out.println(playerOne.playerName + " wins!");
                playerOne.hasWon = false;
                playerOne.playerWins++;
                System.out.println("Score: " + playerOne.playerName + " " + playerOne.playerWins + " - " + playerTwo.playerWins + " " + playerTwo.playerName);
            } else if (playerTwo.hasWon){
                System.out.println(playerTwo.playerName + " wins!");
                playerTwo.hasWon = false;
                playerTwo.playerWins++;
            }
            

            boolean KeepGameGoing = true;
            while (KeepGameGoing){
                // If the user wants to play again
                System.out.println("Play again? Y/N: ");
                String playAgain = userInput.next();
                if (playAgain.equals("Y")) {
                    winCondition = false;
                    Game(userInput);
                    System.out.println("Score: " + playerOne.playerName + " " + playerOne.playerWins + " - " + playerTwo.playerWins + " " + playerTwo.playerName);
                } else if (playAgain.equals("N")) {
                    System.out.println("See you next time!");
                    KeepGameGoing = false;
                    System.out.println("Score: " + playerOne.playerName + " " + playerOne.playerWins + " - " + playerTwo.playerWins + " " + playerTwo.playerName);
                } else {
                    throw new IllegalArgumentException("Put Y or N");
                }
            }
        }
    }


    public static void Game(Scanner userInput) {
        // Creating new board for the game
        Space gameBoard = new Space();
        // keeps track of which turn it is
        int turn = 0;
        int column;
        

        // Keeps the board looping and updating as long as there is no win
        while (!winCondition && !gameBoard.isSpaceFull()) { // winCondition needs to be coded; checks if anyone has won yet
            System.out.println(gameBoard);
            System.out.println("Turn " + turn);
            if (turn % 2 == 0) {
                System.out.println(playerOne.playerName + "'s turn");
            } else {
                System.out.println(playerTwo.playerName + "'s turn");
                
            }
            //System.out.println(Player.getPlayer()); // create new method in Player .getPlayer() to see whose turn it is

            System.out.print("Which column would you like to drop an X in? Enter 1, 2, 3, 4, 5, 6 or 7: "); // need playerToken to update between X and O depending on which player
            column = userInput.nextInt();

            if (column < 1 || column > Space.cols){
                System.out.println("Invalid column. Please enter a value between 1 and 7.");
                continue;
            }

            if (turn % 2 == 0) {   // could this maybe an idea to swap between player1 and player2?
                gameBoard.updateBoard(column, playerOne.token); // Write method to update the gameBoard with the X in the last column
            //} else if (player == player2) {
            } else if (turn % 2 == 1) { //if (player == player1) { // Write player and player1 to mean something
                gameBoard.updateBoard(column, playerTwo.token);
            }

            
            
            if (gameBoard.checkWin(playerOne.token)
                && turn % 2 == 0){
                winCondition = true;
                playerOne.hasWon = true;
            } 
            else if (gameBoard.checkWin(playerTwo.token)
                && turn % 2 == 1){
                winCondition = true;
                playerTwo.hasWon = true;
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
