
package GUI;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import DB.DBclass;
import GUI.panelBac;
import DB.DBclass;
import java.awt.FlowLayout;

public class IndexFrame extends panelBac implements ActionListener{
    
    JTabbedPane tabp ;
    JPanel panel ;
    JButton name ,specalize,uni;
    int row = 5;
   public IndexFrame(){
    super.setLayout(null);
        tabp = new JTabbedPane();
        //new GridLayout(row, 3)
        panel = new JPanel(new FlowLayout());
        name = new JButton("Enter the name");
        specalize = new JButton("Enter the specalize");
        uni = new JButton("Enter the university");
        name.addActionListener(this);
      //  tabp.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        panel.add(name);
        panel.add(specalize);
        panel.add(uni);
        tabp.addTab("Main page",panel);
        tabp.addTab("Managment",new AddCatgory_Type());
        tabp.addTab("Clients",new JPanel(null));
        panel.setBackground(new Color(255, 255, 255,100));
         panel.add(name);
       // panel.add(new JLabel("اهلا وسهلا بكم في الصفحة الرئيسية"));
       
     
       
        
            

        tabp.setBounds(5, 0,1070,750);
        super.add(tabp);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
//        String name = JOptionPane.showInputDialog(this, "Input","Enter the name");
//        DBclass dbconn;
//        try {
//            dbconn = new DBclass();
//             dbconn.insertName(name);
//        } catch (SQLException ex) {
//            Logger.getLogger(IndexFrame.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(IndexFrame.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(IndexFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
//       JOptionPane.showMessageDialog(this, "OK");
    }
    
}
