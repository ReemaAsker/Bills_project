/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author hp
 */
public class panelBac extends JPanel{
    
    panelBac(){
        setLayout(null);
    }
     @Override
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);
        Image img = new ImageIcon("loginbc.jpg").getImage();

        g.drawImage(img, 0, 0, 1100, 800, null);

    }
    
    
}
