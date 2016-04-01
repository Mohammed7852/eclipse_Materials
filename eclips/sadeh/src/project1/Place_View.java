package project1;
import java.awt.event.ActionEvent;
import  java.util.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Place_View extends JFrame {

	private final JPanel panel;
	private final JLabel label1;
	private final JTextField name;
	private final JLabel label2;
	private final JTextField ID;
	private final JLabel label3;
	private final JTextField taste;
	private final JLabel label4;
	private final JTextField address;
	private final JLabel label5;
	private final JTextField desc;
	private final JButton button;

public Place_View(){
      
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(130, 100, 450,430);
        setTitle("Add Place");
        panel=new JPanel();
        setContentPane(panel);
        panel.setLayout(null);
        panel.setBorder(new EmptyBorder(5, 5, 5, 5)); 
        //*****************
        label1=new JLabel();
        name=new JTextField();
        name.setBounds(130, 10, 150, 25);
        label1.setBounds(10, 10, 100, 25);
        label1.setText("Place Name :");
        add(label1);
        add(name);
       //*********************
        label2=new JLabel();
        ID=new JTextField();
        ID.setBounds(130, 40, 50, 25);
        label2.setBounds(10, 40, 100, 25);
        label2.setText("Place ID :");
        add(label2);
        add(ID);
        //********************
        label3=new JLabel();
        taste=new JTextField();
        taste.setBounds(130, 70, 150, 25);
        label3.setBounds(10, 70, 100, 25);
        label3.setText("Place Taste :");
        add(label3);
        add(taste);
        //*******************
         label4=new JLabel();
        address=new JTextField();
        address.setBounds(130, 100, 200, 25);
        label4.setBounds(10, 100, 150, 25);
        label4.setText("Place Address :");
        add(label4);
        add(address);
        //*******************
         label5=new JLabel();
        desc=new JTextField();
        desc.setBounds(130, 130, 280, 25);
        label5.setBounds(10, 130, 150, 25);
        label5.setText("Place Description :");
        add(label5);
        add(desc);
        //*******************
        button=new JButton();
        button.setBounds(180, 200,100, 40);
        button.setText("OK");
        add(button);
        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }

            private void buttonActionPerformed(ActionEvent evt) {
                Place_Model place=new Place_Model();
                place.setPlaceName(name.getText());
                name.setText("");
                place.setPlaceID(Integer.valueOf(ID.getText()));
                ID.setText("");
                place.setAddress(address.getText());
                address.setText("");
                place.setTaste(taste.getText());
                taste.setText("");
                place.setPlacedescription(desc.getText());
                desc.setText("");
                Place_Controller control=new Place_Controller();
                control.addNewPlace(place);
                JOptionPane.showMessageDialog(null, "The place Added Successfully !");
           }
        });
 
  }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(List_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(List_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(List_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(List_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Place_View().setVisible(true);
            }
        });
    }
}
