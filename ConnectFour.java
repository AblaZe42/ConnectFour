import java.util.*;

/**
 * Controls the main gameplay of the game
 *
 * @author Annie Tayson
 * @author August Pallesen
 * @author Ania Pruchnik
 * @author Nirmiti Jhunjhunwala
 */
public class ConnectFour {

    /**
     * Creates a Player to store player one's data under
     */
    private static Player playerOne;

    /**
     * Creates a Player to store player two's data under
     */
    private static Player playerTwo;

    /**
     * The boolean to check if someone has won
     */
    private static boolean winCondition = false;
    
    /**
     * Controls the before, during, and after of the game
     *
     * @param args the in-line commands
     * @throws IllegalArgumentException if the user inputs something other than Y or N
     */
    public static void main(String[] args) {
        System.out.println("Welcome to CONNECT FOUR: The game\n");

        //Scanner for user input
        Scanner userInput = new Scanner(System.in);
        
        System.out.print("Please enter the first player's name and token (X or O): ");
        
        String playerOneName = userInput.next();
        String playerOneToken = userInput.next();

        while (!(playerOneToken.equalsIgnoreCase("X") 
                || playerOneToken.equalsIgnoreCase("O"))) {
            System.out.println("Invalid input! Please enter X or O");
            playerOneName = userInput.next();
            playerOneToken = userInput.next();
        
        }
        playerOne = new Player(playerOneName, playerOneToken);

    
        System.out.println("Please enter the second player's name:");

        String playerTwoName = userInput.next();
        String playerTwoToken = "";
        if (playerOneToken.equalsIgnoreCase("X")) {
            playerTwoToken = "O";
        } else if (playerOneToken.equalsIgnoreCase("O")) {
            playerTwoToken = "X";   
        }


        playerTwo = new Player(playerTwoName, playerTwoToken);
        game(userInput);
        
        // When somebody finally wins
        if (winCondition) {
            
            boolean keepGameGoing = true;

            while (keepGameGoing) {
                playerOne.piecesPlaced = 0;
                playerOne.maxConnectedPieces = 0;
                playerTwo.piecesPlaced = 0;
                playerTwo.maxConnectedPieces = 0;

                if (playerOne.hasWon) {
                    playerOne.hasWon = false;
                    playerOne.playerWins++;
                    System.out.println("");
                    System.out.println(playerOne.playerName + " wins!");
                    System.out.println("Score: " 
                        + playerOne.playerName + " " 
                        + playerOne.playerWins + " - " 
                        + playerTwo.playerWins + " " 
                        + playerTwo.playerName);
                    System.out.println("");

                } else if (playerTwo.hasWon) {
                    playerTwo.hasWon = false;
                    playerTwo.playerWins++;
                    System.out.println("");
                    System.out.println(playerTwo.playerName + " wins!");
                    System.out.println("Score: " 
                        + playerOne.playerName + " " 
                        + playerOne.playerWins + " - " 
                        + playerTwo.playerWins + " " 
                        + playerTwo.playerName);
                    System.out.println("");
                }

                // If the user wants to play again
                System.out.println("Play again? Y/N: ");
                String playAgain = userInput.next();
                if (playAgain.equals("Y")) {
                    winCondition = false;
                    game(userInput);
                    
                } else if (playAgain.equals("N")) {
                    System.out.println("See you next time!");
                    keepGameGoing = false;
                    
                } else {
                    throw new IllegalArgumentException("Put Y or N");
                }
            }
        }
    }


    /**
     * Uses the players' input to run the game
     *
     * @param userInput to scan the user's input
     */
    public static void game(Scanner userInput) {

        // Creating new board for the game
        Space gameBoard = new Space();

        // keeps track of which turn it is
        int turn = 0;
        int column;
        

        // Keeps the board looping and updating as long as there is no win
        while (!winCondition && !gameBoard.isSpaceFull()) { 

            System.out.println(gameBoard);
            
            if (turn % 2 == 0) {
                System.out.println(playerOne.playerName + "'s turn" + " - Turn " + turn);
                
                
            } else {
                System.out.println(playerTwo.playerName + "'s turn" + " - Turn " + turn);
                
            }
            System.out.println(" ");

            if((turn % 2) == 0) {
                System.out.print("Which column would you like to" +  
                                    "drop an in? Enter 1, 2, 3, 4, 5, 6 or 7: "); 
            } else {
                System.out.print("Which column would you like" + 
                                    "to drop an O in? Enter 1, 2, 3, 4, 5, 6 or 7: "); 
            }
            column = -1;

            boolean validInput = false;
            while (!validInput) {

                if (userInput.hasNextInt()) {
                    column = userInput.nextInt();

                    if (column >= 1 && column <= Space.COLS) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid column." +
                                    "Please enter a value between 1 and 7.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    userInput.next();
                }
            }



            if (turn % 2 == 0) {  
                gameBoard.updateBoard(column, playerOne.token);
                playerOne.incrementPiecesPlaced();
                int connectedPieces = gameBoard.calculateConnectedPieces(column, playerOne.token);
                playerOne.updateMaxConnectedPieces(connectedPieces);

                System.out.println(playerOne.playerName + 
                    " has placed " + playerOne.piecesPlaced + " pieces.");
                System.out.println(playerOne.playerName +
                    " has connected pieces: " + playerTwo.maxConnectedPieces);
                System.out.println(" ");
            } else if (turn % 2 == 1) {
                gameBoard.updateBoard(column, playerTwo.token);
                playerTwo.incrementPiecesPlaced();
                int connectedPieces = gameBoard.calculateConnectedPieces(column, playerTwo.token);
                playerTwo.updateMaxConnectedPieces(connectedPieces);

                System.out.println(playerTwo.playerName + 
                    " has placed " + playerTwo.piecesPlaced + " pieces.");
                System.out.println(playerTwo.playerName +  
                    " has connected pieces: " + playerTwo.maxConnectedPieces);
                System.out.println(" ");

            }
            

            
            
            if (gameBoard.checkWin(playerOne.token)
                && turn % 2 == 0) {
                winCondition = true;
                playerOne.hasWon = true;
                
                System.out.println(gameBoard);
            } 
            else if (gameBoard.checkWin(playerTwo.token)
                && turn % 2 == 1) {
                winCondition = true;
                playerTwo.hasWon = true;
                
                System.out.println(gameBoard);
            }
            turn++;
        }

    }
}
