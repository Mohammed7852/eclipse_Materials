package Code4_Tic_Tac_toc;

import javax.swing.JButton;
import javax.swing.JFrame;
// Needed for ActionListener Interface
// Needed for ActionListener Interface

/**
   The TicTacToe1 is the first version of our
   game that has everything in one class without
   separation of Model, View and Controller.
   It implements Observer interface to listen to the Mode
   and update itself when notified 
*/

@SuppressWarnings("serial")
public abstract class TTTView extends JFrame {
   /** This method builds a message panel and a board panel 4 x-o game */
   protected abstract void buildPanels();
   public abstract JButton[][] getGameButtons ();
}