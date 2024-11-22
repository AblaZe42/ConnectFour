/**
 * Creates, updates, and checks the board and the win
 *
 * @author Annie Tayson
 * @author August Pallesen
 * @author Ania Pruchnik
 * @author Nirmiti Jhunjhunwala
 */
public class Space {
    
    /**
    * The number of columns in the game.
    */
    public static final int cols = 7;
        
    /**
    * The number of rows in the game board or grid.
    */
    private static final int rows = 6;

    /**
    * Represents the total number of spaces in the game.
    */
    public static final int TOTAL_SPACES = rows * cols;

    /**
    * Keeps track of which spaces are taken
    */
    public enum Status { TAKEN, NOT_TAKEN } 
    
    /**
    * The board the game will be played with
    */
    public String[][] board;

    /**
    * Constructor method for a new game board
    */
    public Space() {
        board = new String[rows][cols];
        for(int i = 0;i < rows;i++) {
            for(int j=0;j < cols ;j++) {
                board[i][j] = "_";
            }
        }
    }
    
    /**
    * Checks if a space in the game board or grid is already occupied.
    *
    * @return returns true if the space is full, false otherwise.
    */
    public boolean isSpaceFull() {
        for (int i = 0; i < rows; ++i){
            for (int j = 0; j < cols; ++j){
                if(board[i][j].equals("_")){
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Returns the game board
     *
     * @return the instance field board
     */
    public String[][] getBoard() {
        return board;
    }

    /**
     * Checks if the column is full
     *
     * @param column the user-specified column
     *
     * @return whether the column is full
     */
    public boolean isColumnFull(int column){
        for (int i = 0; i < rows; i++) {
            if (board[i][column - 1].equals("_")) {
                return false;
            }
        }
        return true;
    }

    /**
     * Updates the game board by "dropping" the user's token
     *
     * @param column the specific column to be updated
     * @param token  the user's token of choice
     */
    public void updateBoard(int Column, String token) {
        boolean hasTokenBeenPlaced = false;
        for (int i = board.length - 1; i >= 0; i--){
            if( board[i][Column - 1].equals("_")){
                board[i][Column - 1] = token;
                hasTokenBeenPlaced = true;
                break;
            }
        }
        if (!hasTokenBeenPlaced){
            System.out.println("Column is full, please choose another column");
        }
    }
    
    /**
     * Checks if someone has won
     *
     * @param token the user's token of choice
     *
     * @return whether the specific token has won
     */
    public boolean checkWin(String token){
        
/* checks for horizontal win
*/
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - 3; j++) {
                if (board[i][j].equals(token) &&
                    board[i][j+1].equals(token) &&
                    board[i][j+2].equals(token) &&
                    board[i][j+3].equals(token)) {
                    return true;
                }
            }
        }
        
/* checks for vertical win 
*/
        for (int i = 0; i < rows - 3; i++){
            for (int j = 0; j < cols; j++){
                if (board[i][j].equals(token) &&
                    board[i+1][j].equals(token) &&
                    board[i+2][j].equals(token) &&
                    board[i+3][j].equals(token)) {
                    return true;
                }
            }
        }
/* checks for diagonal win (from top left to bottom right)
*/
        for (int i = 0; i < rows - 3; i++){
            for (int j = 0; j < cols - 3; j++){
                if (board[i][j].equals(token) &&
                    board[i+1][j+1].equals(token) &&
                    board[i+2][j+2].equals(token) &&
                    board[i+3][j+3].equals(token)) {
                    return true;
                }
            }
        }

/*checks for diagonal win (from top left to bottom right)
*/
        for (int i = 3; i < rows; i++){
            for (int j = 0; j < cols - 3; j++){
                if (board[i][j].equals(token) &&
                    board[i-1][j+1].equals(token) &&
                    board[i-2][j+2].equals(token) &&
                    board[i-3][j+3].equals(token)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns the board in a string format
     *
     * @return the board as a string
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < rows; ++i){
            for (int j = 0; j < cols; ++j){
                s += "|" + board[i][j];
            }
            s += "| \n";
        }
        System.out.println(" 1 2 3 4 5 6 7");
        return s;
    }
}




