package Code4_Tic_Tac_toc;

/**
   This class represents a TicTacToe move which is
   x, y coordinates of the square and player 'X' or 'O'.
   It is used with TTTModel (TicTacToe with MVC)
*/

public class Move {
  private int x, y; 
  private char player;

  /** A constructor for a new Move 
    * @param i is the x coordinate for the square
    * @param j is the y coordinate for the square
    * @param p is the capital character of the player
    */
  
  public Move (int i, int j, char p) {
    x = i;
    y = j;
    this.player = p;
  }
  
  
   /** @return the row of the square occupied in this move */
  
   public int getX() { return x; }

   
   /** @return the column of the square occupied in this move */
   
   public int getY() { return y; }
  
   
    /** @return the player (capital char) who made this move */
   
    public char getPlayer() { return player; }
  
    
  /** @param a player to set as the maker of this move */ 
    
  public void setPlayer(char p) {
    this.player = p;
  }
  
  
  /** @return a String representing the move */ 
  
  public String toString () {
    return "\n(" + (x+1) + ", " + (y+1) + ") player " + player; 
  }
}