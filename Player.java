/**
 * The Player class stores data about the player
 * as well as ways to edit the player data.
 *
 * @author Ania Pruchnik
 * @author Annie Tayson
 * @author Nirmiti Jhunjhunwala
 * @author August Pallesen
 */

public class Player {

    /**
     * The amount of players required for the game
     */
    public static final int NUM_PLAYERS = 2;

    /**
     * The player's name
     */
    public String playerName;

    /**
     * The amount of times the player has won
     */
    public int playerWins;


    /**
     * A constructor method for a default player with no name
     */
    public Player() {
        this.playerName = "guest";
        this.playerWins = 0;
    }

    /**
     * A constructor method for a player's data to be
     * tracked under a name (account)
     */
    public Player(String name) {
        this.playerName = name;
        this.playerWins = 0;
    }

    /**
     * Returns the name of the player
     *
     * @return the player's name
     */
    public String getPlayer(){
        return playerName;
    }

    /**
     * Returns the number of wins of the player
     * 
     * @return the player's win count
     */
    public int getWins() {
        return playerWins;
    }

    public void addWin() {
        this.playerWins++;
    }

}