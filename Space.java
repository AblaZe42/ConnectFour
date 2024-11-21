
public class Space {
    
    /**
    * The number of columns in the game.
    */
    public static final int cols = 7;
        
    /**
    * The number of rows in the game board or grid.
    */
    private static final int rows = 6;

    // private Status status;

    /**
    * Represents the total number of spaces in the game.
    */
    public static final int TOTAL_SPACES = rows * cols;
    public enum Status{TAKEN, NOT_TAKEN};
    

    public String[][] board;

    public Space() {
        board = new String[rows][cols];
        for(int i = 0;i < rows;i++) {
            for(int j=0;j < cols;j++) {
                board[i][j] = "_";
                //board[i][j].setStatus(Status.NOT_TAKEN);
            }
        }
    }
    
    // public Status getStatus(){
    //     return status;
    // }

    // public void setStatus(Status status){
    //     this.status = status;
    // }
    
    
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
    
    public String[][] getBoard() {
        return board;
    }

    
    // /**
    // * Retrieves the number of wins for the current player.
    // *
    // * @return An int representing the number of wins for the player.
    // */
    // public static int playerWins() {

    // }
    
    // /**
    // * Adds a specified number of points to the player's score.
    // *
    // * @param Adds points to a player.
    // */
    // public static void addPoints(int points) {

    // }
    
    
    // /**
    // * Initializes a new player with the given name.
    // *
    // * @param name The name of the player to create.
    // * @return Returns true if the player was successfully created, false otherwise.
    // */
    // public static boolean Player(String name) {
        
    // }
    /* @returns true if column is full, false if empty*/       
    public boolean isColumnFull(int column){
        if(board[0][column].isSpaceFull() &&
            board[1][column].isSpaceFull() &&
            board[2][column].isSpaceFull() &&
            board[3][column].isSpaceFull() &&
            board[4][column].isSpaceFull() &&
            board[5][column].isSpaceFull()){
                return true;
            }
        return false;
    }

    public void updateBoard(int Column, String token){
        boolean hasTokenBeenPlaced = false;
        for (int i = board.length - 1; i >= 0; i--){
            if( board[i][Column].equals("_")){
                board[i][Column] = token;
                //board[i][Column].setStatus(Status.TAKEN);
                hasTokenBeenPlaced = true;
                break;
            }
        }
        if (!hasTokenBeenPlaced){
            System.out.println("Column is full, please choose another column");
        }
    }
    public boolean checkWin(String token){
        
        //check for horizontal win
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
        
        // check for vertical win 
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
        // check for diagonal win (from top left to bottom right)
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

        // check for diagonal win (from top left to bottom right)
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

    public String toString(){
        String s = "";
        for (int i = 0; i < rows; ++i){
            for (int j = 0; j < cols; ++j){
                s += board[i][j];
            }
            s += "\n";
        }
        return s;
    }
}




