package huffmand;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 

public class gui extends JFrame {
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui frame = new gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		t1 = new JTextField();
		t1.setBounds(121, 55, 418, 39);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JLabel l1 = new JLabel("Enter your String here:-");
		l1.setFont(new Font("Tahoma", Font.BOLD, 14));
		l1.setBounds(200, 0, 233, 44);
		contentPane.add(l1);
		
		t2 = new JTextField();
		t2.setBounds(92, 161, 503, 39);
		contentPane.add(t2);
		t2.setColumns(10);
		
		JLabel lblResultOfCompression = new JLabel("Result  of  Compression is  :-");
		lblResultOfCompression.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResultOfCompression.setBounds(200, 122, 196, 28);
		contentPane.add(lblResultOfCompression);
		
		JButton b1 = new JButton("Compress");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
 				
				hufmand h = new hufmand();
				 
				String input="input.txt" , temp="" , output = "output.txt"  ;
				Path p = Paths.get(input) ;
				
				try {
					byte [] b  = Files.readAllBytes(p);
					temp = new String(b);
					
 					t1.setText(temp);
					temp = h.Compress(temp) ;
					 
 					  t2.setText(temp);

 					  FileOutputStream w  = new FileOutputStream("output.txt");
 					  w.write(temp.getBytes());
 					  w.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
			}
		});
		b1.setBounds(434, 252, 116, 39);
		contentPane.add(b1);
		
		JButton b2 = new JButton("Decompress");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hufmand h = new hufmand();
				String str1 ,str2 ;
				str1 = t2.getText();
				
				try {
					Writer w  = new FileWriter("output.txt");
					byte [] b = str1.getBytes();
					
				} catch (IOException e) {
 					e.printStackTrace();
				}
			}
		});
		b2.setBounds(265, 252, 103, 39);
		contentPane.add(b2);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText("");
				t2.setText("");
			}
		});
		btnDelete.setBounds(121, 256, 110, 35);
		contentPane.add(btnDelete);
	}
}
