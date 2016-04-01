package LZW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LZWfram extends JFrame {

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
					LZWfram frame = new LZWfram();
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
	public LZWfram() {
		setForeground(Color.MAGENTA);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		t1 = new JTextField();
		t1.setBackground(new Color(224, 255, 255));
		t1.setForeground(new Color(255, 0, 0));
		t1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t1.setBounds(10, 41, 517, 40);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBackground(new Color(224, 255, 255));
		t2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t2.setForeground(Color.RED);
		t2.setBounds(21, 134, 493, 58);
		contentPane.add(t2);
		t2.setColumns(10);
		
		JLabel lblEnterYourString = new JLabel("The  String Will be Here:-");
		lblEnterYourString.setForeground(Color.BLUE);
		lblEnterYourString.setBackground(Color.MAGENTA);
		lblEnterYourString.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterYourString.setBounds(140, 0, 204, 46);
		contentPane.add(lblEnterYourString);
		
		JLabel lblTheResultIs = new JLabel("Decompression Will be  Here:-");
		lblTheResultIs.setForeground(Color.BLUE);
		lblTheResultIs.setBackground(Color.PINK);
		lblTheResultIs.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTheResultIs.setBounds(109, 83, 215, 46);
		contentPane.add(lblTheResultIs);
		
		JButton C = new JButton("Compress");
		C.setBackground(Color.ORANGE);
		C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String  str1  , str2  ;
 				Scanner cin= new Scanner(System.in);
				LZW c = new LZW();
				
 				str1 = t1.getText();
 				c.setoriginal(str1);
 				c.Compress();
 				str1 = c.view_1();
				 t2.setText(str1);
				
				
			}
		});
		C.setForeground(Color.RED);
		C.setFont(new Font("Tahoma", Font.BOLD, 15));
		C.setBounds(343, 220, 143, 58);
		contentPane.add(C);
		
		JButton D = new JButton("Dcompress");
		D.setBackground(Color.CYAN);
		D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				LZW c  = new  LZW();

				String  tem ;
				tem= t2.getText();
				
				Pattern p = Pattern.compile("\\d+");
				Matcher m = p.matcher(tem);
				List<String> li = new ArrayList();
				List<Integer> l2 = new  ArrayList();
			 	
				while(m.find())
				{
		 			li.add(m.group());
		 		}
				  		
				for(int i=0;i<li.size();i++)
				{
					l2.add(Integer.parseInt(li.get(i)));
				}
				System.out.print(li+"\n\n"+l2+"\n\n");  
				
				c.setcodes(l2);
				c.Decompress();
				tem = c.view_2();
				t1.setText(tem);
				
				
			}
		});
		D.setForeground(Color.RED);
		D.setFont(new Font("Tahoma", Font.BOLD, 15));
		D.setBounds(59, 220, 143, 58);
		contentPane.add(D);
		
		JButton btnClear = new JButton("clear\r\n");
		btnClear.setBackground(Color.PINK);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText("");
				t2.setText("");
			}
		});
		btnClear.setForeground(Color.RED);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClear.setBounds(201, 261, 143, 58);
		contentPane.add(btnClear);
	}
}
