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
    private char[][] grid;

/* constructor Place initializes instance variables */
    public static Place() {
        grid = new char[rows][columns];
        for (int i = 0; i < rows; i ++) {
            for( int j = 0; j < columns; j++) {
                grid[i][j] = '.';
            }
        }  
    }
/* @param column to determine which space is chosen*/
    public static Space(int column){
        if(grid[rows][columns].getStatus().equals(Space.Status.TAKEN)){
            
        }
    }
/* @returns true if space is taken, false if empty*/    
    public boolean isSpaceFull(){
        if(grid[rows][columns].getStatus().equals(Space.Status.TAKEN)){
            return true;
        }
        return false;
        }
    }
/* @returns true if column is full, false if empty*/       
    public boolean isColumnFull(int column){
        if(grid[0][column].isSpaceFull() &&
            grid[1][column].isSpaceFull() &&
            grid[2][column].isSpaceFull() &&
            grid[3][column].isSpaceFull() &&
            grid[4][column].isSpaceFull() &&
            grid[5][column].isSpaceFull()){
                return true;
            }
        return false;
    }
/* Fills space from the top down
   @param column to determine which space is chosen*/
    public static setFullSpace(int column){
        if (isColumnFull(column)) {
            System.out.println("Choose another column");
        }
        for(int i=0;i<rows;i++){
            if(grid[i][column].isSpaceFull() && !grid[i+1][column].isSpaceFull()){
                
            }
        }
        
    }

    
}