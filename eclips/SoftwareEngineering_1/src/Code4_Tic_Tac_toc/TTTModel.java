package Code4_Tic_Tac_toc;

import java.util.Observable;
/**
    Tic Tac Toe Game Model, independent of any Views
*/

public class TTTModel extends Observable 
{  
	private char winner = ' ';
	private int nMoves = 0;
	private Move lastMove; 
	private char[][] board = {{'1','2','3'},
                              {'4','5','6'},
                              {'7','8','9'}};

   /** @param move is used to set the last move made */
	public void setMove (Move move) {
		this.lastMove = move;
     
		// Decide who made the last move: X = even, O = odd
		
		lastMove.setPlayer ((nMoves % 2) == 0 ? 'X' : 'O');
		nMoves++;
     
		// Set the board according to the last move
		
		board [lastMove.getX()][lastMove.getY()] = lastMove.getPlayer();
     
		// Decide if there is a winner or draw
		if (isWon())
			winner = lastMove.getPlayer();
		else if (nMoves == 9)
			winner = 'D';

		System.out.println (this);
     
		// Notify the view that a change happened
		setChanged();
		notifyObservers (lastMove); 
	}                                                                                          
     
   /** Determine if the game ends with a winner
     * @return true 'X' or 'O' wins the game
     */
	public boolean isWon () {
		if ((board [0][0] == board [1][1] &&
			 board [0][0] == board [2][2]) ||
			(board [2][0] == board [1][1] &&
			 board [2][0] == board [0][2])) 
			return true; 
		for (int i = 0; i < 3; i ++)
			if (board [i][0] == board [i][1] &&
              	board [i][0] == board [i][2])
				return true;
		for (int i = 0; i < 3; i ++)
			if (board [0][i] == board [1][i] &&
              	board [0][i] == board [2][i])
				return true;
		return false;
   }
   
   /** @return the winner 'X' or 'O or 'D' in case of Draw */ 
	public char getWinner() {
		return winner;
	}
 
   /** @return a String representing the board and last move */
	public String toString () {
		String boardString = "\n";
		for (int i = 0; i < 3; i ++) {
			for (int j = 0; j < 3;  j++)
				boardString += board [i][j] + " ";
			boardString += "\n";
		}
		return boardString + lastMove;
   }
}