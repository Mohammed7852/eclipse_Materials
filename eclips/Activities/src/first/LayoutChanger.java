package first;

import javax.swing.*;
import java.util.*;    
import java.awt.event.*; // Needed for ActionListener Interface
import java.awt.*;       // Needed for ActionListener Interface

public class LayoutChanger extends JFrame {
  boolean flowLayout = true;
  
  public LayoutChanger()
  {
      setTitle("Press to Chang Layout");  
      setSize(310, 210);                  
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout (new FlowLayout());    

      JLabel  messageLabel = new JLabel("   Dummy Message");
      JButton switchButton = new JButton ("Change Layout");
      JButton dummyButton1 = new JButton ("Dummy");
      JButton dummyButton2 = new JButton ("Dummy");
   
      switchButton.addActionListener (new SwitchLayoutListener());
      add(messageLabel);
      add(switchButton);
      add(dummyButton1);
      add(dummyButton2);
     
      setVisible(true);
   }
   public static void main(String args[]) {    
      new LayoutChanger();
   }
   private class SwitchLayoutListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e) {        
        if (flowLayout)
           setLayout (new GridLayout(2,2));   
        else
           setLayout (new FlowLayout());
        flowLayout = !flowLayout;
        setVisible(true);                    
     }
  }
}