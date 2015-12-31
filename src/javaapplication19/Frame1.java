
package javaapplication19;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Frame1 extends JFrame {
    
    public Frame1()
    {
      
       this.setSize(400,400);
       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.setTitle("paint");
       
   
       this.add(new Surface());
     
       this.setVisible(true);
    }

   
    
   
}
