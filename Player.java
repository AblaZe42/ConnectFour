/**
 * Stores the player's information and interacts with the
 *  Space class to manage player scores and track wins.
 * 
 * This class holds the data for a player, such as the player's name,
 *  token, number of wins, pieces placed,
 * and the maximum number of connected pieces.
 * It provides methods for updating and retrieving player information
 * during the course of the game.
 * 
 * @author Annie Tayson
 * @author August Pallesen
 * @author Ania Pruchnik
 * @author Nirmiti Jhunjhunwala
 */
public class Player {

    /**
     * The number of players in the game (set to 2).
     */
    public static final int NUM_PLAYERS = 2;

    /**
     * The player's name.
     */
    public String playerName;

    /**
     * The number of wins the player has accumulated.
     */
    public int playerWins;

    /**
     * Indicates whether the player has won the game.
     */
    public boolean hasWon;

    /**
     * The number of pieces the player has placed on the board.
     */
    public int piecesPlaced;

    /**
     * The maximum number of connected pieces the player has formed so far.
     */
    public int maxConnectedPieces;

    /**
     * The token representing the player's game piece (either "X" or "O").
     */
    public String token;

    /**
     * Default constructor. Initializes the player with
     *  a default name of "guest", 0 wins, and not having won the game.
     */
    public Player() {
        this.playerName = "guest";
        this.playerWins = 0;
        this.hasWon = false;
    }

    /**
     * Constructor to set the player's name and token.
     * 
     * @param var1 the player's name
     * @param var2 the player's token (e.g., "X" or "O")
     */
    public Player(String var1, String var2) {
        this.playerName = var1;
        this.token = var2;
        this.piecesPlaced = 0;
        this.maxConnectedPieces = 0;
    }

    /**
     * Increments the number of pieces placed by the player.
     * This method is called each time the player places a new piece on the board.
     */
    public void incrementPiecesPlaced() {
        this.piecesPlaced++;
    }

    /**
     * Updates the player's maximum number of connected pieces if the new value is greater.
     * 
     * @param connectedPieces the number of connected 
     * pieces to check against the player's current maximum
     */
    public void updateMaxConnectedPieces(int connectedPieces) {
        if (connectedPieces > this.maxConnectedPieces) {
            this.maxConnectedPieces = connectedPieces;
        }
    }

    /**
     * Returns the player's token.
     * 
     * @return the token representing the player's game piece (e.g., "X" or "O")
     */
    public String getToken() {
        return this.token;
    }

    /**
     * Returns the player's name.
     * 
     * @return the player's name
     */
    public String getPlayer() {
        return this.playerName;
    }

    /**
     * Returns the number of wins the player has accumulated.
     * 
     * @return the number of wins
     */
    public int getWins() {
        return this.playerWins;
    }

    /**
     * Increments the player's win count by one.
     * This method is called when the player wins a game.
     */
    public void addWin() {
        ++this.playerWins;
    }
}
