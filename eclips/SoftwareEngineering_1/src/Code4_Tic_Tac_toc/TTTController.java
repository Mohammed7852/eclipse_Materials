package Code4_Tic_Tac_toc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; // Needed for ActionListener Interface

import javax.swing.JButton;

/**
   The TTTController works with TTTView and TTTModel
   to implement TicTacToe game using MVC
   */

   /** GameSquareListener listens to game squares and has the game logic */
 
public class TTTController implements ActionListener
  { 
  
	TTTModel model;
    TTTView view;
     
     /** A Constructor to set the View and Model
       * of this Controller
       */
     public TTTController (TTTView view, TTTModel model) {
       this.model = model;
       this.view = view;
     }
     
      /** The actionPerformed method executes when the user
         clicks on one of the board squares.
         It passes the most recent Move to the Model
         @param e The event object representing pressing a square.
      */
      public void actionPerformed(ActionEvent e)
      {      
           ((JButton)(e.getSource())).setEnabled (false);
           for (int i = 0; i < 3; i++){
              for (int j = 0; j < 3; j++){
                 if (e.getSource() == view.getGameButtons() [i][j]){
                    model.setMove (new Move (i, j, ' '));
           			break;
      			 }
              }
           }
      }
     
}//class