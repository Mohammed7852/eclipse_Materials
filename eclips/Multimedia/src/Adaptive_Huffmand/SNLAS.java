package Adaptive_Huffmand;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Insets;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;

public class SNLAS {

 	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SNLAS window = new SNLAS();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SNLAS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 575, 404);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("new2");
		mnFile.add(mntmNew);
		
		JMenuItem mntmNew_2 = new JMenuItem("new4");
		mnFile.add(mntmNew_2);
		
		JMenuItem mntmNew_1 = new JMenuItem("new3");
		mnFile.add(mntmNew_1);
		
		JRadioButtonMenuItem rdbtnmntmNew = new JRadioButtonMenuItem("new ");
		mnFile.add(rdbtnmntmNew);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnEdit.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("New menu item");
		mnEdit.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("New menu item");
		mnEdit.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mnEdit.add(mntmNewMenuItem_2);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("New menu item");
		mnHelp.add(mntmNewMenuItem_5);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("New radio item");
		mnHelp.add(rdbtnmntmNewRadioItem);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("New menu item");
		mnHelp.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnHelp.add(mntmNewMenuItem_1);
		
		JMenu mnFeatures = new JMenu("Features");
		menuBar.add(mnFeatures);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem = new JCheckBoxMenuItem("New check item");
		mnFeatures.add(chckbxmntmNewCheckItem);
		
		JMenu newfile = new JMenu("New menu");
		menuBar.add(newfile);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JButton Login = new JButton("Login");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    
 			}
		});
		GridBagConstraints gbc_Login = new GridBagConstraints();
		gbc_Login.gridx = 1;
		gbc_Login.gridy = 2;
		frame.getContentPane().add(Login, gbc_Login);
	}
}
