package Code4_Tic_Tac_toc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLabel;

/** This class is a demo of TTT game with MVC Architecture.
  * Model is totally independent it updates the state when 
  * the Controller says that a change happens by the user
  * Controller listen to the view and takes user actions to the Model
  * View listens to the Model to change the display if Model changes
  */ 

@SuppressWarnings("serial")

public class TTTDemo extends JFrame implements ActionListener{

	TTTModel model;  
  	TTTView player1View;
  	TTTView player2View;
  
  	private JRadioButton player1OptionsView1;
  	private JRadioButton player1OptionsView2;
  	private JRadioButton player2OptionsView1;
  	private JRadioButton player2OptionsView2;
   	private ButtonGroup player1Options;
  	private ButtonGroup player2Options;
  
  	/** A Constructor to create the demo */
    
  	public TTTDemo() {
	  
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	getContentPane().setLayout(null);
    	setBounds(450, 250, 250, 175);


		player1OptionsView1 = new JRadioButton("View 1");
		player1OptionsView1.setBounds(6, 46, 109, 23);
		player1OptionsView1.setSelected(true);
	
		player1OptionsView2 = new JRadioButton("View 2");
		player1OptionsView2.setBounds(6, 72, 109, 23);
		player1OptionsView2.setSelected(false);

		player2OptionsView1 = new JRadioButton("View 1");
		player2OptionsView1.setBounds(117, 46, 109, 23);
		player2OptionsView1.setSelected(true);
	
		player2OptionsView2 = new JRadioButton("View 2");
		player2OptionsView2.setBounds(117, 72, 109, 23);
		player2OptionsView2.setSelected(false);

		JButton startGameBtn = new JButton("Start Game");
		startGameBtn.setBounds(10, 103, 214, 23);
		startGameBtn.addActionListener(this);
		
		JLabel lblNewLabel1 = new JLabel("Player 1:");
		lblNewLabel1.setBounds(10, 11, 60, 14);
		
		JLabel lblNewLabel2 = new JLabel("Player 2:");
		lblNewLabel2.setBounds(121, 11, 60, 14);
	
		player1Options = new ButtonGroup();
		player1Options.add(player1OptionsView1);
		player1Options.add(player1OptionsView2);

		player2Options = new ButtonGroup();
		player2Options.add(player2OptionsView1);
		player2Options.add(player2OptionsView2);
	
		getContentPane().add(player1OptionsView1);
		getContentPane().add(player1OptionsView2);
		getContentPane().add(player2OptionsView1);
		getContentPane().add(player2OptionsView2);
		
		getContentPane().add(startGameBtn);
		getContentPane().add(lblNewLabel1);
		getContentPane().add(lblNewLabel2);

		setResizable(false);
        setVisible(true);
    }

    /** The main function to run the demo */
    public static void main(String[] av) {
    	new TTTDemo();
    }//main

    @Override
    public void actionPerformed(ActionEvent arg0) {
    	
    	if(player1View != null) player1View.dispose();
    	if(player2View != null) player2View.dispose();
    	
	  	model = new TTTModel();
	  
	  	if(player1OptionsView1.isSelected()) player1View = new TTTView1(model,'X');
	  	else player1View = new TTTView2(model,'X');
  
	  	if(player2OptionsView1.isSelected()) player2View = new TTTView1(model,'O');
	  	else player2View = new TTTView2(model,'O');
	
  	}
    
}//class

