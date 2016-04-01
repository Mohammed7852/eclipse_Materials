/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author mohamed ali shabanah
 */
public class List_View extends JFrame {
 private JPanel panel;
    private JComboBox com;
    private JLabel label;
    private ArrayList<Place_Model>place=new ArrayList<>();
    private ListController temp = new ListController();
    private JTextArea area;
    /**
     * Creates new form List_View
     */
    public List_View() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450,430);
        panel=new JPanel ();
        setTitle("Sort");
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);
        com=new JComboBox();
        com.setBounds(70, 20, 200, 32);
       com.setModel(new DefaultComboBoxModel(new String[]{"Nearest Place","Rate","Taste"}));
      label=new JLabel();
      label.setText("Sort By :");
      label.setBounds(10, 25, 100, 25);
      area=new JTextArea();
      area.setBounds(15, 60, 400, 300);
      area.setLineWrap(true);
      area.setVisible(true);
      place= temp.sort("Nearest Place"," ");
      for (int i=0;i<place.size();i++){
          area.setText(place.get(i).getPlaceName()+"  "+place.get(i).getTaste());
      }
     
       com.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comActionPerformed(evt);
            }
            private void comActionPerformed(ActionEvent evt) {
                
                String type="";
                String choice=(String) com.getSelectedItem();
              System.out.println(choice);
              if (choice.equals("Nearest Place")){
                 place= temp.sort(choice,type);
                 area.setText("");
                  for(int i=0;i<place.size();i++){
          area.append(place.get(i).getPlaceName()+"  "+place.get(i).getAddress());
                 }
                 //frame.setVisible(true);
              }
              else if ("Rate".equals(choice)){
                  place=temp.sort(choice,type);
                  area.setText("");
                  for(int i=0;i<place.size();i++){
                  area.append(place.get(i).getPlaceName()+"  "+place.get(i).gettotalRate());
                  //frame.setVisible(true);
                    }
                }
              else{
                 type= JOptionPane.showInputDialog("Plaese Insert the Taste You want : ");
                 if (type.equals("")){
                     JOptionPane.showMessageDialog(null, "The Taste Is NOT Entered !");
                 }
                  if (type!=null&&type.length()!=0){ 
                  place=temp.sort(choice,type);
                   area.setText("");
                  for(int i=0;i<place.size();i++){
                    area.append(place.get(i).getPlaceName()+"  "+place.get(i).getTaste());
                  //frame.setVisible(true);
                 // frame.setTitle("Places sorted by "+choice);
                  }
              }
              }     
            }
        });
        panel.add(com);
        panel.add(label);
        add(area);
        area.setEditable(false);
    }
               
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
                new List_View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}