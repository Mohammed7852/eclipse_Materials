package LZ_77;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private static  Compression c  = new Compression();
	Scanner cin = new Scanner(System.in);
	
	
	public static  void compress()
	{
		c = new  Compression();
		
		String str  ;
		//System.out.println("Enter the String :");
		str = text1.getText();
		
		c.set_original(str);
		c.comprise();
		str =c.getcodes();
		
		text2.setText(str);
		
	}
	
	private JPanel contentPane;
	private static JTextField text1;
	private static JTextField text2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
					System.out.print("Enter");
					compress();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterYourString = new JLabel("Enter your String Here:-");
		lblEnterYourString.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterYourString.setForeground(Color.PINK);
		lblEnterYourString.setBounds(10, 11, 220, 57);
		contentPane.add(lblEnterYourString);
		
		text1 = new JTextField();
		text1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
 			}
		});
		text1.setBounds(182, 13, 473, 57);
		contentPane.add(text1);
		text1.setColumns(10);
		
		text2 = new JTextField();
		text2.setBounds(128, 129, 647, 323);
		contentPane.add(text2);
		text2.setColumns(10);
		
		JLabel lblTheOutputIs = new JLabel("The  Output  is :-");
		lblTheOutputIs.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTheOutputIs.setForeground(Color.ORANGE);
		lblTheOutputIs.setBounds(223, 85, 343, 33);
		contentPane.add(lblTheOutputIs);
		
		JButton Compress = new JButton("compress");
		Compress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
 				String  str  ;
				str = text1.getText();
				
				c.set_original(str);
			    c.comprise();
			    
			   str = c.getcodes();  
			   text2.setText(str);
			    
			}
		});

		Compress.setBounds(10, 88, 89, 41);
		contentPane.add(Compress);
		
		JButton Decompress = new JButton("decompress");
		Decompress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String str = text2.getText();
				
				c = new Compression();
 				c.Decompression();
			}
		});
		Decompress.setBounds(10, 138, 89, 41);
		contentPane.add(Decompress);
		
		JButton btnNewButton = new JButton("clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				text1.setText("");
				text2.setText("");
			}
		});
		btnNewButton.setBounds(0, 190, 89, 46);
		contentPane.add(btnNewButton);
	}
}
