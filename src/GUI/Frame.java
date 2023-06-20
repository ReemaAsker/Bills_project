/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import javax.swing.ImageIcon;
import javax.swing.JFrame;

public final class Frame extends JFrame{
    Frame(){
    super.setTitle("Reema");
    super.setLayout(null);
    super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    super.setBounds(300,60,1100,800);
    super.setResizable(false);
    ImageIcon img = new ImageIcon("loginbc.jpg");
    super.setIconImage(img.getImage());
    
}
    
}
