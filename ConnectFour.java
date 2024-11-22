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
     */
    public static void main(String[] args) {
        System.out.println("Welcome to CONNECT FOUR: The Game\n");

        //Scanner for user input
        Scanner userInput = new Scanner(System.in);
        
        System.out.print("Please enter the first player's name and token (X or O): ");
        
        String PlayerOneName = userInput.next();
        String PlayerOneToken = userInput.next();

        while (!(PlayerOneToken.equalsIgnoreCase("X") 
                || PlayerOneToken.equalsIgnoreCase("O"))){
            System.out.println("Invalid input! Please enter X or O");
            PlayerOneName = userInput.next();
            PlayerOneToken = userInput.next();
        
        }
        playerOne = new Player(PlayerOneName, PlayerOneToken);

    
        System.out.println("Please enter the second player's name:");

        String PlayerTwoName = userInput.next();
        String PlayerTwoToken = "";
        if (PlayerOneToken.equalsIgnoreCase("X")) {
            PlayerTwoToken = "O";
        } else if (PlayerOneToken.equalsIgnoreCase("O")) {
            PlayerTwoToken = "X";   
        }


        playerTwo = new Player(PlayerTwoName, PlayerTwoToken);
        Game(userInput);
        
        // When somebody finally wins
        if (winCondition) {
            
            boolean KeepGameGoing = true;

            while (KeepGameGoing){
                
                if (playerOne.hasWon){
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

                } else if (playerTwo.hasWon){
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
                    Game(userInput);
                    
                } else if (playAgain.equals("N")) {
                    System.out.println("See you next time!");
                    KeepGameGoing = false;
                    
                } else {
                    throw new IllegalArgumentException("Put Y or N");
                }
            }
        }
    }


    /**
     * Uses the players' input to run the game
     *
     * @param playerOne the first player
     * @param playerTwo the second player
     * @param userInput to scan the user's input
     */
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
            System.out.println(" ");

            if((turn % 2) == 0){
                System.out.print("Which column would you like to drop an in? Enter 1, 2, 3, 4, 5, 6 or 7: "); 
            }else{
                System.out.print("Which column would you like to drop an O in? Enter 1, 2, 3, 4, 5, 6 or 7: "); 
            }
            column = -1;

            boolean validInput = false;
            while (!validInput) {

                if (userInput.hasNextInt()) {
                    column = userInput.nextInt();

                    if (column >= 1 && column <= Space.cols) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid column. Please enter a value between 1 and 7.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    userInput.next();
                }
            }



            if (turn % 2 == 0) {  
                gameBoard.updateBoard(column, playerOne.token);
            } else if (turn % 2 == 1) {
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
