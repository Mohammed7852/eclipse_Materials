/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

/**
 *
 * @author mohamed ali shabanah
 */
import java.util.*;
import  javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.plaf.basic.BasicArrowButton;

        
public class Notification_View extends javax.swing.JFrame {
int  counter = 0;
    /**
     * Creates new form Notification_View
     */
    private ArrayList<User_model>usermodellist = new ArrayList() ;
    private ArrayList<String> usernoty = new ArrayList();
    private  int count = 0 ;
    
    public Notification_View() {
       // 
        initComponents();
        
        JButton btn = new JButton("Friend-Ship Notifications");
        btn.setBounds(100, 1, 200, 30);
        panel.hide();
        btn.addActionListener(new  ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(counter==0){
                panel.show();
                counter++;
                }else  if(counter==1){
                    panel.hide();
                    counter=0;
                }                
             }
           });
        
        setBounds(100, 100, 760, 600);
        panel.setBounds(10, 30, 400, 500);
        panel.setBackground(Color.PINK);
        add(panel);
        add(btn);
        setTitle("Notifications");
       // notify.setText("mohammed");
    }

  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        home = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        home.setText("Home");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(170, 677, Short.MAX_VALUE)
                .addComponent(home)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(524, Short.MAX_VALUE)
                .addComponent(home)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
   
        hide();
        new HomePage().view();
        
// TODO add your handling code here:
    }//GEN-LAST:event_homeActionPerformed

   ///****
    JPanel panel = new JPanel();
    JButton abuttons [] ;
    JLabel [] labels ;
    JButton rbuttons  [] ;
    
    public void friends(Map<String, User_model> friends){
        Iterator it  = friends.entrySet().iterator();
        Map.Entry pair ;
        usermodellist = new ArrayList();
        usernoty = new ArrayList();
        while(it.hasNext()){
            pair=(Map.Entry) it.next();
            usermodellist.add((User_model)pair.getValue());
            usernoty.add((String)pair.getKey());
        }
        int sz  = usermodellist.size();
        
        abuttons= new JButton[sz];
        rbuttons = new JButton[sz];
        labels = new JLabel[sz];
        
        panel.setBounds(10, 30, 450, 500);
        panel.setBackground(Color.red);
        add(panel);
        User_model usermodel = new User_model();
        
        int  w = 0 ;
        for(int  i=0 ;i<sz ;i++){
            abuttons[i] = new JButton("Accept");
            rbuttons[i] = new JButton("Reject");
            labels[i] = new JLabel();
            labels[i].setText(usernoty.get(i));
            
            labels[i].setBounds(10, w+=20, 300, 20);
            abuttons[i].setBounds(300, w, 75, 2);
            rbuttons[i].setBounds(375, w, 75, 20);
            
            panel.add(abuttons[i]);
            panel.add(rbuttons[i]);
            panel.add(labels[i]);
            
            usermodel = usermodellist.get(i);
            int x  =i ;
            abuttons[i].addActionListener(new ActionListener (){
                 public void actionPerformed(ActionEvent e) {
                     JOptionPane op =new JOptionPane();
                     op.showMessageDialog(null, "you accept friens ship");
                     
                 }
            });
            
              rbuttons[i].addActionListener(new ActionListener (){
                 public void actionPerformed(ActionEvent e) {
                     JOptionPane op =new JOptionPane();
                     op.showMessageDialog(null, "you accept friens ship");
                     
                 }
            });
            
            
        }
        
        
        
        

    // friendship.setText(friends.toString());
    }
    
    ///*****
    
    public void messages(Map<String, User_model> messages){
       // this.messages.setText(messages.toString());
    }
    
     public void likes(Map<String, User_model> like){
        //this.likes.setText(like.toString());
    }
    public void  view(){
        
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Notification_View().setVisible(true);
            }
        });
         
          
    }
    public static void main(String args[]) {
   
        Notification_View nv  = new Notification_View();
        nv.view();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton home;
    // End of variables declaration//GEN-END:variables
}
