package Code4_Tic_Tac_toc;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


/**
The TicTacToe1 is the first version of our
game that has everything in one class without
seperation of Model, View and Controller.
It implements Observer interface to listen to the Mode
and update itself when notified 
*/

@SuppressWarnings("serial")
public class TTTView2 extends TTTView implements Observer {
	
	private char localPlayer;
	private TTTModel model;
	
	private JPanel gamePanel;
	private JLabel messageLabel;
	private JButton [][] gameButtons = new JButton [3][3];
	
	/** Builds a game board 3 x 3 and displays it */
	public TTTView2(TTTModel model, char localPlayer) {
		this.model = model;
		this.localPlayer = localPlayer;
		model.addObserver(this);            // Register with the model
		
		buildPanels();
		setVisible(true);
	}
	
	/** This method builds a message panel and a board panel 4 x-o game */
	protected void buildPanels(){
		getContentPane().setLayout(null);
		setTitle("Tic Tac Toe - player " + localPlayer);
		setResizable(false);
		setBounds(450, 250, 290, 300);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		messageLabel = new JLabel();
		messageLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		messageLabel.setBounds(12, 240, 260, 20);
		
		gamePanel = new JPanel();
		gamePanel.setBackground(Color.WHITE);
		gamePanel.setBounds(12, 10, 260, 220);
		gamePanel.setLayout(new GridLayout(3, 3, 2, 2));
		
		for (int i = 0; i < 3; i++){
	         for (int j = 0; j < 3; j++) {
	            gameButtons[i][j] = new JButton ();
	            gameButtons[i][j].setContentAreaFilled(false);
	            gameButtons[i][j].setToolTipText ("("+i+","+j+")");
	            gameButtons[i][j].setBackground(Color.WHITE);
	            gameButtons[i][j].addActionListener(new TTTController(this, model));
	            gamePanel.add(gameButtons[i][j]);
	         }
		}
		
		getContentPane().add(messageLabel);
		getContentPane().add(gamePanel);
		
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				gameButtons [i][j].setEnabled (localPlayer == 'X');
	   
		if(localPlayer == 'X')
			messageLabel.setText("it's your turn");
		else messageLabel.setText("it's not your turn");
	}
	
	@Override
	public void update(Observable model, Object lastMove) {
		
		// Get game status from the Model
		char winner = ((TTTModel)model).getWinner();
		char player = ((Move)lastMove).getPlayer();
		int x = ((Move)lastMove).getX();
		int y = ((Move)lastMove).getY();
	      
		gameButtons[x][y].setIcon(new ImageIcon(player + ".gif"));
	      
		// Disable the board if game ends or if it is not the local player turn
		if (winner == 'D' || winner == 'X' || winner == 'O') 
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
	public JButton[][] getGameButtons() {
		return gameButtons;
	}
}
