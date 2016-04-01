package Code4_Tic_Tac_toc;


// Needed for ActionListener Interface

import javax.swing.*;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
   The TicTacToe1 is the first version of our
   game that has everything in one class without
   seperation of Model, View and Controller.
   It implements Observer interface to listen to the Mode
   and update itself when notified 
*/

@SuppressWarnings("serial")
public class TTTView1 extends TTTView implements Observer{
	private char localPlayer;
	private TTTModel model;
	private JPanel msgPanel, gamePanel;    // Panels for messages and board
	private JLabel messageLabel;           // Displays messages on game status
                                          // Game internal board
	private JButton [][] gameButtons = new JButton [3][3];
   /** Builds a game board 3 x 3 and displays it */
	public TTTView1(TTTModel model, char localPlayer)
	{
		this.model = model;
		this.localPlayer = localPlayer;
		model.addObserver(this);            // Register with the model
		setTitle("Tic Tac Toe - player " + localPlayer);  // Set the window title.
		setBounds(450, 250, 310, 210);      // Set the window width x height.
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout (new GridLayout(2,1));    // Top cell 4 msg, btm 4 board
		buildPanels();                          // Build msg & board panels
		add(msgPanel);
		add(gamePanel);
      
		setResizable(false);
		setVisible(true);                       // Display the window.
      
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				gameButtons [i][j].setEnabled (localPlayer == 'X');
   
		if(localPlayer == 'X')
			messageLabel.setText("it's your turn");
		else messageLabel.setText("it's not your turn");
	}

   /** This method builds a message panel and a board panel 4 x-o game */
	protected void buildPanels()
	{
		// Create a label to display instructions.
		messageLabel = new JLabel("It is X turn.");
		msgPanel = new JPanel(new FlowLayout());
		gamePanel = new JPanel(new GridLayout(3,3));

		msgPanel.add(messageLabel);
      
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
				gameButtons [i][j] = new JButton ("");
				gameButtons [i][j].setToolTipText ("("+i+","+j+")");
				gamePanel.add(gameButtons [i][j]);
				(gameButtons[i][j]).addActionListener(new TTTController(this, model));
			}
	} 
	
	public void update(Observable model, Object lastMove) {
		// Get game status from the Model
		char winner = ((TTTModel)model).getWinner();
		char player = ((Move)lastMove).getPlayer();
		int x = ((Move)lastMove).getX();
		int y = ((Move)lastMove).getY();
      
		gameButtons [x][y].setText (Character.toString(player));
      
		// Disable the board if game ends
		if (winner == 'D' || winner == 'X' || winner == 'O' ) 
			for (int i = 0; i < 3; i++)
				for (int j = 0; j < 3; j++)
					gameButtons [i][j].setEnabled (false);
      
		if (winner == 'D')
      		{ messageLabel.setText ("Draw !!"); return; }
		if (winner == 'X')
      		{ messageLabel.setText ("X Wins :)"); return; }
		if (winner == 'O')
      		{ messageLabel.setText ("O Wins :)"); return; }
   
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				gameButtons [i][j].setEnabled (player != localPlayer);
      
		// Disable the last square clicked and put X or O
		gameButtons [x][y].setEnabled (false);
   
		if(player != localPlayer)
			messageLabel.setText("it's your turn");
		else messageLabel.setText("it's not your turn");
        
	}
	
	@Override
	public JButton[][] getGameButtons (){
		return gameButtons;
	}
}