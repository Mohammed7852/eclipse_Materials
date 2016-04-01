import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

/**
 * 
 * @author mohamed ali shabanah
 *@class Fram2  makes  simple  caculator  ,,, performs some  simple  operations  
 *
 */

public class Fram2 {

	private JFrame frame;
	/**
	 * variable  n2 is  the  taxt that displayes the  values we calculate 
	 * 
	 */
	private JTextField n2;

	/**
	 * double value takes numbers that user enter 
	 * and hold operation 
	 */
	private  double   num1 ,num2 , res; 
	/**
	 * string  takes the type  of  operation the  user  select
	 * 
	 */
	String  operation ;
	
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run()
			{
				try {
					 Fram2 window = new Fram2();
					 window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//end  main 
	

	/**
	 * Create the application.
	 */
	
	/**
	 * default constructor  initialize fram2
	 */
	public Fram2() 
	{
		
		initialize();
		
		n2.setText("0");
		
		/**
		 * C  button delets what is  in display 
		 */
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				n2.setText("0");
			}
		});

		btnC.setForeground(Color.RED);
		btnC.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnC.setBounds(10, 62, 77, 50);
		
		frame.getContentPane().add(btnC);
		
		/**
		 * is the  dot  operator  for  floating  point 
		 */
		
		JButton button = new JButton(".");
		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String str = n2 .getText()+".";
				
				n2.setText(str);
			}
		});
		
		button.setForeground(Color.BLUE);
		button.setFont(new Font("Tahoma", Font.BOLD, 19));
		button.setBounds(127, 189, 46, 37);
		
		frame.getContentPane().add(button);
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnEdit.setForeground(Color.BLACK);
		mnEdit.setHorizontalAlignment(SwingConstants.CENTER);
		
		menuBar.add(mnEdit);
		
		JMenu menu = new JMenu("");
		menuBar.add(menu);
		
		JMenu mnView = new JMenu("View");
		mnView.setFont(new Font("Segoe UI", Font.BOLD, 16));
		
		menuBar.add(mnView);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Segoe UI", Font.BOLD, 16));
		
		menuBar.add(mnHelp);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() 
	{
	
 		frame = new JFrame();
 		
 		frame.setTitle("Simple Calculator");
 		
		frame.setBounds(100, 100, 498, 357);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
 
		/**
		 * button 7 
		 */
		
		JButton b7 = new JButton("7");
		b7.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				String  str = n2.getText()+"7";
				
				n2.setText(str);
			}
		});
		
		b7.setForeground(Color.BLUE);
		b7.setFont(new Font("Tahoma", Font.BOLD, 19));
		b7.setBounds(127, 75, 46, 37);
	
		frame.getContentPane().add(b7);
		
		/**
		 * button  8
		 */
		JButton b8 = new JButton("8");
		b8.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String  str = n2.getText()+"8";
				n2.setText(str);
				
			}
		});
		b8.setForeground(Color.BLUE);
		b8.setFont(new Font("Tahoma", Font.BOLD, 19));
		b8.setBounds(174, 75, 46, 37);
		frame.getContentPane().add(b8);
		
		/**
		 * button  9
		 */
		JButton b9 = new JButton("9");
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String  str = n2.getText()+"9";
				n2.setText(str);
				 
			}
		});
		b9.setForeground(Color.BLUE);
		b9.setFont(new Font("Tahoma", Font.BOLD, 19));
		b9.setBounds(221, 75, 46, 37);
		frame.getContentPane().add(b9);
		
		JButton b4 = new JButton("4");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  str = n2.getText()+"4";
				n2.setText(str);
				 
			}
		});
		b4.setForeground(Color.BLUE);
		b4.setFont(new Font("Tahoma", Font.BOLD, 19));
		b4.setBounds(127, 112, 46, 37);
		frame.getContentPane().add(b4);
		
		
		JButton b5 = new JButton("5");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  str = n2.getText()+"5";
				n2.setText(str);
				 
			}
		});
		b5.setForeground(Color.BLUE);
		b5.setFont(new Font("Tahoma", Font.BOLD, 19));
		b5.setBounds(174, 112, 46, 37);
		frame.getContentPane().add(b5);
		
		
		JButton b6 = new JButton("6");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String  str = n2.getText()+"6";
				n2.setText(str);
				 
			}
		});
		b6.setForeground(Color.BLUE);
		b6.setFont(new Font("Tahoma", Font.BOLD, 19));
		b6.setBounds(221, 112, 46, 37);
		frame.getContentPane().add(b6);
		
		JButton b1 = new JButton("1");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
  				String  str = n2.getText()+"1";
				n2.setText(str);
			}
		});
		b1.setForeground(Color.BLUE);
		b1.setFont(new Font("Tahoma", Font.BOLD, 19));
		b1.setBounds(127, 150, 46, 37);
		frame.getContentPane().add(b1);
		
		
		JButton b2 = new JButton("2");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String  str = n2.getText()+"2";
				n2.setText(str);
				 
			}
		});
		b2.setForeground(Color.BLUE);
		b2.setFont(new Font("Tahoma", Font.BOLD, 19));
		b2.setBounds(174, 150, 46, 37);
		frame.getContentPane().add(b2);
		
		JButton b3 = new JButton("3");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String  str = n2.getText()+"3";
				n2.setText(str);
				 
			}
		});
		b3.setForeground(Color.BLUE);
		b3.setFont(new Font("Tahoma", Font.BOLD, 19));
		b3.setBounds(221, 150, 46, 37);
		frame.getContentPane().add(b3);
		
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{	
				num1=Double.parseDouble(n2.getText());

				//num1=Double.parseDouble(n2.getText());
				System.out.println(num1+"\n");
 				n2.setText("0");
				operation="+";
				
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(373, 92, 65, 50);
		frame.getContentPane().add(btnNewButton);
		
		JButton button_9 = new JButton("-");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				num1=Double.parseDouble(n2.getText());
				operation="-";
				n2.setText("0");
			}
		});
		button_9.setForeground(Color.RED);
		button_9.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_9.setBounds(373, 137, 65, 50);
		frame.getContentPane().add(button_9);
		
		
		JButton button_10 = new JButton("*");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				num1=Double.parseDouble(n2.getText());
				operation="*";
				n2.setText("0");
			}
		});
		
		button_10.setForeground(Color.RED);
		button_10.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_10.setBounds(373, 176, 65, 50);
		frame.getContentPane().add(button_10);
		
		JButton button_11 = new JButton("/");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				num1=Double.parseDouble(n2.getText());
				
				n2.setText("0");
				operation="/";
			}
		});
		button_11.setForeground(Color.RED);
		button_11.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_11.setBounds(373, 222, 65, 50);
		frame.getContentPane().add(button_11);
		
		/**
		 * @this button referes  to the equal function 
		 * @which will take the  last number and current  number  and  perform the  selected  operation 
		 * @return integer 
		 */
		
		JButton button_12 = new JButton("=");
		button_12.addActionListener(new ActionListener() 
		{
			 
			public void actionPerformed(ActionEvent e) 
			{
				
				num2=Double.parseDouble(n2.getText());
				 System.out.println(num2+"\n");
				 
				if(operation=="+")
					{
					res=num1+num2;
					n2.setText(Double.toString(res));

					}
				else if(operation=="-")
					{
					res=num1-num2 ;
					n2.setText(Double.toString(res));

					}
				else if(operation=="*")
					{
					res=num1*num2;
					n2.setText(Double.toString(res));

					}
				else if(operation=="/")
					{
					res=num1/num2;
					n2.setText(Double.toString(res));

					}
				else
					n2.setText(Double.toString(num2));/// this  choice  if the  user 
				//pressed  number  and  = directly without  pressing  another  number 
				
			}
		});
		button_12.setForeground(Color.RED);
		button_12.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_12.setBounds(214, 222, 77, 50);
		frame.getContentPane().add(button_12);
		
		n2 = new JTextField();
		n2.setFont(new Font("Tahoma", Font.BOLD, 20));
		n2.setHorizontalAlignment(SwingConstants.RIGHT);
		n2.setColumns(10);
		n2.setBounds(10, 11, 428, 42);
		frame.getContentPane().add(n2);
		
		/**
		 * this methode  changes the sign of  numbers and  put  them in different  sign within text 
		 */
		JButton button = new JButton("+/-");
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				 num1=Integer.parseInt(n2.getText());
				 num1=-1*num1 ;
				 String  str  ="";
 				 n2.setText(Double.toString(num1));
			}
		});
		button.setForeground(Color.RED);
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setBounds(288, 222, 86, 50);
		frame.getContentPane().add(button);
	}
}
