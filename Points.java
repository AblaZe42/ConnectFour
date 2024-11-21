/* points class keeps count of which spaces and columns are open, taken, and connected and keeps track of points totaled. */
public class Points {

/* instance fields that depend on player movements */    
    private static final int WIN_POINTS = 4;
    private static final int openSpaces = 42;
    private static final int takenSpaces;
    private static final int connectedSpaced;
    private static final int points;
    private static final int columns = 7;
    private static final int rows = 6;
    private char[][] board;

/* constructor Place initializes instance variables */
    public static Place() {
        board = new char[rows][columns];
        for (int i = 0; i < rows; i ++) {
            for( int j = 0; j < columns; j++) {
                board[i][j] = '.';
            }
        }  
    }
/* @param column to determine which space is chosen*/
    public static Space(int column){
        if(board[rows][columns].getStatus().equals(Space.Status.TAKEN)){
            
        }
    }
/* @returns true if space is taken, false if empty*/    
    public boolean isSpaceFull(){
        if(board[rows][columns].getStatus().equals(Space.Status.TAKEN)){
            return true;
        }
        return false;
        }
    }

/* Fills space from the top down
   @param column to determine which space is chosen*/
    public static setFullSpace(int column){
        if (isColumnFull(column)) {
            System.out.println("Choose another column");
        }
        for(int i=0;i<rows;i++){
            if(board[i][column].isSpaceFull() && !board[i+1][column].isSpaceFull()){
                
            }
        }
        
    }

    
}