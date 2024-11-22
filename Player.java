/* stores the player’s information and interacts with Space class to manage player scores and track wins
*/
public class Player {
/*class constants to initialize variables for number of players, player names, 
  player wins, if anyone has won, and token as "game pieces"
*/
   public static final int NUM_PLAYERS = 2;
   public String playerName;
   public int playerWins;
   public boolean hasWon;
   public String token;
   
/* Player constructor sets playerName to guest, playerWins to 0, and hasWon to false
*/
   public Player() {
      this.playerName = "guest";
      this.playerWins = 0;
      this.hasWon = false;
   }
/* Player constructor sets playerName to var1 and token to var2. 
  @param var1 will be passed as userInput for names
  @param var2 will be passed as userInput for token piece
*/
   public Player(String var1, String var2) {
      this.playerName = var1;
      this.token = var2;
   }
/* @returns token for playing piece
*/
   public String getToken() {
      return this.token;
   }
/* @returns player name
*/
   public String getPlayer() {
      return this.playerName;
   }
/* @returns number of player Wins
*/
   public int getWins() {
      return this.playerWins;
   }
/* increments number of player wins
*/
   public void addWin() {
      ++this.playerWins;
   }
}
