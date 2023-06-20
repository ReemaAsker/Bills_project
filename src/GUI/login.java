
package GUI;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class login extends panelBac implements ActionListener {

    static Frame frame = new Frame();
    JPanel panel ;
    JLabel loginPhoto, user, passwared, eyePhoto;
    JTextField userT;
    JPasswordField pass;
    JButton enter;
    Font font = new Font("Arial", Font.BOLD, 18);
    Color color = new Color(0, 0, 0);

    login() {
       setLayout(null);
       
        this.setLayout(null);
        panel = new JPanel(null);
        loginPhoto = new JLabel();
        loginPhoto.setIcon(new ImageIcon(new ImageIcon("login1.png").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
        eyePhoto = new JLabel();
        eyePhoto.setIcon(new ImageIcon(new ImageIcon("eye.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        eyePhoto.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pass.setEchoChar((char) 0);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                pass.setEchoChar('*');

            }

        });
        user = new JLabel("اسم المستخدم ");
        passwared = new JLabel("كلمة المرور");
        userT = new JTextField() {
            @Override
            public Insets getInsets() {
                return new Insets(5, 5, 5, 15);
            }
        };
        pass = new JPasswordField() {
            @Override
            public Insets getInsets() {
                return new Insets(5, 5, 5, 15);
            }
        };
        enter = new JButton("دخول");

        panel.setBackground(new Color(255, 255, 255,160));
        panel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        panel.setBorder(new LineBorder(new Color(0, 0, 0, 70)));
        user.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        user.setFont(font);
        user.setForeground(color);
        passwared.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        passwared.setFont(font);
        passwared.setForeground(color);
        userT.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        userT.setFont(new Font("Arial", Font.BOLD, 13));
        userT.setForeground(color);
        pass.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        pass.setFont(new Font("Arial", Font.BOLD, 13));
        pass.setForeground(color);
        pass.setEchoChar('*');
        enter.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        enter.setFont(font);
        enter.setForeground(color);
        enter.setIcon(new ImageIcon(new ImageIcon("loginBu.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        enter.setHorizontalTextPosition(AbstractButton.RIGHT);
        enter.setVerticalTextPosition(AbstractButton.CENTER);
        enter.addActionListener(this);

        panel.setBounds(120, 180, 430, 430);
        loginPhoto.setBounds(140, 20, 150, 150);
        user.setBounds(230, 180, 120, 25);
        userT.setBounds(130, 180, 120, 25);
        passwared.setBounds(230, 230, 120, 25);
        pass.setBounds(130, 230, 120, 25);
        eyePhoto.setBounds(90, 230, 35, 25);
        enter.setBounds(150, 290, 150, 30);
        panel.add(loginPhoto);
        panel.add(user);
        panel.add(passwared);
        panel.add(userT);
        panel.add(pass);
        panel.add(eyePhoto);
        panel.add(enter);

       add(panel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(enter)) {
            String passwaredText = new String(pass.getPassword());
            if (userT.getText().equalsIgnoreCase("reema") && passwaredText.equals("123")) {
                this.setVisible(false);////refreash
               frame.setContentPane(new IndexFrame());
            } else {
                JOptionPane.showMessageDialog(null, "خطأ", "الادخال خاطىء", 0);
            }

        }
    }

    public static void main(String[] args) {
      
        frame.setContentPane(new login());
        try {
            javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.setVisible(true);
    }

    

}
