package Prdictive_Codeing;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JPanel contentPane = new  JPanel();
	private JPanel panel2 = new JPanel() ;
	private JComboBox comboBox = new JComboBox();
    private  JOptionPane  note  = new  JOptionPane();
    private JButton btn1 = new JButton();
    private JButton btn2 = new JButton();
	private  JLabel label1 = new JLabel() ;
 
	public GUI() {

		
    	//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 700, 457);

		contentPane = new JPanel();
 		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
 		setTitle("Assignment#4");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox com = new JComboBox();
		com.setBounds(500, 200, 200, 40);
		
		contentPane.add(com);
	 
		com.addItem("Type of User");
		com.addItem("Normal user");
		com.addItem("premuim user");
		label1.setText("message from i");
		label1.setBounds(10, 10, 200, 20);
 		btn1.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 			}});
		
 		btn1 .setBounds(200, 10, 80, 20);
 		btn2.setBounds(280, 10, 80, 20);
 

 		int sz = 30;

 		panel2.setBounds(10, 10, 360,650);
 		panel2.setBackground(Color.ORANGE);
 		panel2.setLayout(null);
 		
 		JButton Abuttons  [] = new  JButton[sz];
  		JButton Rbuttons  [] = new  JButton[sz];
 		JLabel labels[] = new JLabel[sz];
 		
 		int w1=0,w2=0,h1=0,h2=0;

 		for(int  i=0 ;i<sz;i++){
 			Abuttons[i] = new JButton("Accept");
 			Rbuttons[i] = new JButton("Reject");
 			labels[i] = new JLabel();
 			Abuttons[i].setText("Accept");
 			Rbuttons[i].setText("Reject");
 			labels[i].setText("messsage from"+(i+1));
 			
 			labels[i].setBounds(1, h1+=21, 200, 20);
 			Abuttons[i].setBounds(200,h1, 80, 20);
 			Rbuttons[i].setBounds(280, h1, 80, 20);
 			
 			panel2.add(labels[i]);
 			panel2.add(Abuttons[i]);
 			panel2.add(Rbuttons[i]);
 			
 			int x = i;
 			
  			Abuttons[i].addActionListener(new ActionListener (){
 				public void actionPerformed(ActionEvent e) {
 						JOptionPane op = new JOptionPane();
 						op.showMessageDialog(null ,"message "+(x+1)+" Accepted");
 					
				}});
  			
  			Rbuttons[i].addActionListener(new ActionListener (){
 				public void actionPerformed(ActionEvent e) {
 						JOptionPane op = new JOptionPane();
 						op.showMessageDialog(null ,"message "+(x+1)+" Rejected");
 				}});
  					
 		}
 		
		contentPane.add(panel2);
		
		JPanel  p3 = new JPanel();
		p3.setBounds(400, 20, 100, 300);
	    p3.setBackground(Color.BLUE);	
	    
	     p3.add(btn1);
	    contentPane.add(p3);
	   // contentPane.add(btn1);
	    
		
		
	}//defualt 

	public void view(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
  					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main(String[] args) {
		 GUI gui = new GUI();
		 gui.view();
	}
}//class diagram 

