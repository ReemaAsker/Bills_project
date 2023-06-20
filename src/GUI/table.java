    package GUI;

import Control.Control;
import DB.DBclass;
import OOP.Type;
    import java.awt.Color;
    import java.awt.Font;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.awt.event.MouseAdapter;
    import java.awt.event.MouseEvent;
    import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
    import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
    import javax.swing.DefaultListCellRenderer;
    import javax.swing.DefaultListModel;
    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JPanel;
    import javax.swing.JScrollPane;
    import javax.swing.JTable;
    import javax.swing.SwingConstants;
    import javax.swing.table.DefaultTableCellRenderer;
    import javax.swing.table.DefaultTableModel;

    public class table extends JTable implements ActionListener, MouseListener {

        JTable debts_detatils;
        JScrollPane debts_detatils_Scroller, debtors_Scroller;
        DefaultTableCellRenderer rightRenderer;
        DefaultTableModel debts_detatils_model;
        String col[] = {"Code", "Name", "Price", "Discound/s"};
        public static ArrayList<Type> dataA= new ArrayList<Type>();
        String data[][] = {};
        JButton addDebt = new JButton("add Debt");
        Font font = new Font("Arial", Font.BOLD, 13);
        
        public table() throws SQLException, IOException, ClassNotFoundException {
          
            setLayout(null);
            //setSize(500, 500);
            setBounds(400, 110, 610, 300);
            setBackground(Color.WHITE);
            debts_detatils = new JTable() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    if (debts_detatils.getValueAt(row, column).toString().trim().length() != 0) {
                        return true;
                    }

                    return false;
                }
            };
            debts_detatils_Scroller = new JScrollPane(debts_detatils);
            rightRenderer = new DefaultTableCellRenderer();
            new Control ().AllTypeInfo("TYPE");
            debts_detatils_model = new DefaultTableModel(data, col);
            debts_detatils.setModel(debts_detatils_model);
            debts_detatils.setFont(font);
            debts_detatils.setRowHeight(24);
            rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            debts_detatils.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
            debts_detatils.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
            debts_detatils.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
            debts_detatils.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
              debts_detatils.setRowHeight(25);
            debts_detatils.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    JTable target = (JTable) e.getSource();
                    System.out.println(target.getValueAt(target.getSelectedRow(), target.getSelectedColumn()));
                }
            });
            addDebt.addActionListener(this);
            debts_detatils_Scroller.setBounds(0, 0, 610, 300);
            addDebt.setBounds(20, 420, 100, 30);
            add(debts_detatils_Scroller);
            add(addDebt);

        }

        public static void main(String[] args) {
            JFrame f = new JFrame();
            f.setSize(600, 600);
            try {
                f.add(new table());
            } catch (SQLException ex) {
                Logger.getLogger(table.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(table.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(table.class.getName()).log(Level.SEVERE, null, ex);
            }
            f.setVisible(true);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            this.setVisible(false);
            Object [] ob = new Object [4];
            for(int i=0 ;i<ob.length ; ++i){
                ob[0]=dataA.get(i).getCode();
                ob[1]=dataA.get(i).getName();
                ob[2]=dataA.get(i).getPrice();
                ob[3]=dataA.get(i).getDiscount();
                debts_detatils_model.addRow(ob);
            }
            this.setVisible(true);
        }
//        public  void show(){
//            Object [] ob = new Object [4];
//            for(int i=0 ;i<ob.length ; ++i){
//                ob[0]=dataA.get(i).getCode();
//                ob[1]=dataA.get(i).getName();
//                ob[2]=dataA.get(i).getPrice();
//                ob[3]=dataA.get(i).getDiscount();
//                debts_detatils_model.addRow(ob);
//            }
//        }
        @Override
        public void mouseClicked(MouseEvent e) {
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
