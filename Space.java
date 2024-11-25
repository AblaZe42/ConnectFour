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
    public static final int COLS = 7;
        
    /**
    * The number of ROWS in the game board or grid.
    */
    private static final int ROWS = 6;


    /**
     * The number of directions to check for connected pieces.
     */
    public static final int DIRECTIONS = 4;

    /**
    * Represents the total number of spaces in the game.
    */
    public static final int TOTAL_SPACES = ROWS * COLS;

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
        board = new String[ROWS][COLS];
        for(int i = 0;i < ROWS;i++) {
            for(int j = 0;j < COLS ;j++) {
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
        for (int i = 0; i < ROWS; ++i) {
            for (int j = 0; j < COLS; ++j) {
                if(board[i][j].equals("_")) {
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
    public boolean isColumnFull(int column) {
        for (int i = 0; i < ROWS; i++) {
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
     * @return whether the token was successfully placed
     */

    public boolean updateBoard(int column, String token) {
        boolean tokenPlaced = false;
        for (int i = board.length - 1; i >= 0; i--) { // Start from the bottom row
            if (board[i][column - 1].equals("_")) {
                board[i][column - 1] = token;
                tokenPlaced = true;
                break;
            }
        }

        if (!tokenPlaced) {
            System.out.println("Column is full, please choose another column.");
        }

        return tokenPlaced;
    }

    
    /**
     * Checks if someone has won
     *
     * @param token the user's token of choice
     *
     * @return whether the specific token has won
     */
    public boolean checkWin(String token) {
        
    /* checks for horizontal win
    */
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS - 3; j++) {
                if (board[i][j].equals(token) &&
                    board[i][j + 1].equals(token) &&
                    board[i][j + 2].equals(token) &&
                    board[i][j + 3].equals(token)) {
                    return true;
                }
            }
        }
        
/* checks for vertical win 
*/
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j].equals(token) &&
                    board[i + 1][j].equals(token) &&
                    board[i + 2][j].equals(token) &&
                    board[i + 3][j].equals(token)) {
                    return true;
                }
            }
        }
/* checks for diagonal win (from top left to bottom right)
*/
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLS - 3; j++) {
                if (board[i][j].equals(token) &&
                    board[i + 1][j + 1].equals(token) &&
                    board[i + 2][j + 2].equals(token) &&
                    board[i + 3][j + 3].equals(token)) {
                    return true;
                }
            }
        }

/*checks for diagonal win (from top left to bottom right)
*/
        for (int i = 3; i < ROWS; i++) {
            for (int j = 0; j < COLS - 3; j++) {
                if (board[i][j].equals(token) &&
                    board[i - 1][j + 1].equals(token) &&
                    board[i - 2][j + 2].equals(token) &&
                    board[i - 3][j + 3].equals(token)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Calculates the maximum number of connected pieces
     *  for a given player token in a specific column.
     * 
     * This method checks all four directions (horizontal,
     *  vertical, diagonal top-left to bottom-right,
     * diagonal bottom-left to top-right) for the maximum
     *  number of connected pieces of the specified token
     * starting from the specified column. It returns the
     *  maximum number of connected pieces for the token.
     *
     * @param column the column (1-based index) in which the token was placed
     * @param token the player's token to check for connected pieces ("X" or "O")
     * @return the maximum number of connected pieces of the given token
     */
    public int calculateConnectedPieces(int column, String token) {
        int maxConnected = 0;

        column--;

        for (int i = 0; i < board.length; i++) {
            if (board[i][column].equals(token)) {
                maxConnected = Math.max(maxConnected, countConnected(i, column, 0, 1, token));
                maxConnected = Math.max(maxConnected, countConnected(i, column, 1, 0, token));
                maxConnected = Math.max(maxConnected, countConnected(i, column, 1, 1, token));
                maxConnected = Math.max(maxConnected, countConnected(i, column, -1, 1, token));
            }
        }

        return maxConnected;
    }

    /**
     * Counts the number of consecutive connected pieces 
     * in a specified direction starting from a given position.
     * 
     * This helper method counts the connected pieces of
     *  the specified token starting from the given position
     * in the specified direction (horizontal, vertical,
     *  diagonal). It checks for up to 4 connected pieces in
     * the specified direction, returning the count of connected pieces.
     *
     * @param row the starting row position (zero-based index)
     * @param col the starting column position (zero-based index)
     * @param rowDir the direction to move in rows (1 for down, -1 for up, 0 for no movement)
     * @param colDir the direction to move in columns (1 for right, -1 for left, 0 for no movement)
     * @param token the player's token to check for connected pieces ("X" or "O")
     * @return the number of connected pieces of the specified token in the given direction
     */
    
    private int countConnected(int row, int col, int rowDir, int colDir, String token) {
        int count = 0;

        // Count in the specified direction
        for (int i = 0; i < DIRECTIONS; i++) {
            int r = row + i * rowDir;
            int c = col + i * colDir;

            if (r < 0 || r >= board.length || c < 0 
                || c >= board[0].length || !board[r][c].equals(token)) {
                break;
            }
            count++;
        }

        return count;
    }


    /**
     * Returns the board in a string format
     *
     * @return the board as a string
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < ROWS; ++i) {
            s += "       ";
            for (int j = 0; j < COLS; ++j) {
                s += "|" + board[i][j];
            }
            s += "| \n";
        }
        System.out.println("        1 2 3 4 5 6 7");
        return s;
    }
}




