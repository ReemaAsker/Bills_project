
package GUI;

import Control.Control;
import OOP.Type;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class AddCatgory_Type extends JPanel implements ActionListener,ListSelectionListener, MouseListener{
     
    JLabel CatNumL,TypesNumL,CategoryL,TypeL,Type_codeL,Type_nameL,Type_priceL,Type_discoundL,spaceL,titlePanelInfoL ,TypeCodeInfoL,TypeNameInfoL,TypePriceInfoL,TypeDescoundInfoL;
    JTextField CatNum,TypesNum ,Type_code,Type_name,Type_price,Type_discound,TypeCodeInfo,TypeNameInfo,TypePriceInfo,TypeDescoundInfo;
    JButton addCategoryB,addTypeB,saveIconB,updateIconB,deleteIconB,updateTableIconB;
   // JList Categories;
    //DefaultListModel Categories_model;
    JPanel PanelCompleteInfo;
           // Type_panel ,PanelCompleteInfo;
    //JScrollPane Type_Scroll;
          //  Categories_Scroll , Type_Scroll;
    Font f = new Font("Arial",Font.BOLD,15);
    boolean addTypeInfo = true;
    //int Cx ,Nx ,Px,Dx ,Cy ,Ny ,Py ,Dy,IconY ;
    JTextField txCode ,txName ,txPrice , txDiscound;
   // JButton btnSave ,btnUpdate ,btnDelete;
   
    
        JTable debts_detatils;
        JScrollPane debts_detatils_Scroller, debtors_Scroller;
        DefaultTableCellRenderer rightRenderer;
        DefaultTableModel debts_detatils_model;
        String col[] = {"Code", "Name", "Price", "Discound/s"};
        public static ArrayList<Type> dataA= new ArrayList<Type>();
        
        String data[][] = {};
        //JButton addDebt = new JButton("add Debt");
        
    
    
    //int i =0;
    public AddCatgory_Type(){
      
        setLayout(null);
        this.setBackground(new Color(255, 255, 255,100));
        dataA.add(new Type("123", "milk",  12, 10));
        CatNumL = new JLabel("Category Num. :", SwingConstants.CENTER);
        TypesNumL = new JLabel("Types For this Category :", SwingConstants.CENTER);
        CategoryL  = new JLabel("Category", SwingConstants.CENTER);
        TypeL  = new JLabel("Types Info", SwingConstants.CENTER);
        Type_codeL = new JLabel("   Code", SwingConstants.LEFT);
        Type_nameL = new JLabel("Name", SwingConstants.CENTER);
        Type_priceL = new JLabel("   Price", SwingConstants.CENTER);
        Type_discoundL = new JLabel("   Discound", SwingConstants.CENTER);
        spaceL = new JLabel(" ");
        titlePanelInfoL = new JLabel("Full Information");
        TypeCodeInfoL = new JLabel("Type code", SwingConstants.CENTER);
        TypeNameInfoL = new JLabel("Type Name", SwingConstants.CENTER);
        TypePriceInfoL = new JLabel("Type price", SwingConstants.CENTER);
        TypeDescoundInfoL = new JLabel("Type Descound", SwingConstants.CENTER);
        CatNum = new JTextField (6);
        TypesNum = new JTextField (8);
        Type_code = new JTextField (7);
        Type_name = new JTextField (10);
        Type_price = new JTextField (6);
        Type_discound = new JTextField (4);
        TypeCodeInfo = new JTextField (7);
        TypeNameInfo  = new JTextField (10);
        TypePriceInfo = new JTextField (6);
        TypeDescoundInfo = new JTextField (4);
        addCategoryB = new JButton ("add_Category");
        addTypeB = new JButton ("add_Type");
        deleteIconB = new JButton ("Delete");
        saveIconB = new JButton("Save");
        updateIconB = new JButton("Update");
        updateTableIconB = new JButton();
       // Categories_model = new DefaultListModel ();
       // Categories = new JList(Categories_model);
       // Type_panel =new  JPanel (null);
        PanelCompleteInfo =new  JPanel (null);
       // Categories_Scroll= new JScrollPane(Categories);
       // Type_Scroll= new JScrollPane(Type_panel ,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        Type_Scroll.getViewport().setPreferredSize(new Dimension(100, 100));
//        Type_Scroll.setVisible (true);
        
        
        debts_detatils = new JTable()
        {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
        
            debts_detatils_Scroller = new JScrollPane(debts_detatils);
            rightRenderer = new DefaultTableCellRenderer();
        try {
            new Control ().AllTypeInfo("TYPE");
        } catch (SQLException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
            debts_detatils_model = new DefaultTableModel(data, col);
            debts_detatils.setModel(debts_detatils_model);
            
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
                    if(target.getSelectedColumn() == 0){
                    try {
                        String colValue =  target.getValueAt(target.getSelectedRow(), target.getSelectedColumn()).toString();
                        String info [] = new Control().giveData("TYPE",colValue);
                        PanelCompleteInfo.setVisible(false);
                        System.out.println(info+"reema");//////////////////////
//                        TypeCodeInfo.setText(info[0]);
//                        TypeNameInfo.setText(info[1]);
//                        TypePriceInfo.setText(info[2]);
//                        TypeDescoundInfo.setText(info[3]);
                        PanelCompleteInfo.setVisible(true);
                    } catch (SQLException ex) {
                        System.out.println("1");
                    } catch (IOException ex) {
                         System.out.println("2");
                    } catch (ClassNotFoundException ex) {
                         System.out.println("3");
                    }
               }
                    else
                       System.out.println("nooooo");  
                }
            });
        
       
        //setOpaque
        CatNumL.setOpaque(true);
        TypesNumL.setOpaque(true);
        CategoryL.setOpaque(true);
        TypeL.setOpaque(true);
        Type_codeL.setOpaque(true);
        Type_nameL.setOpaque(true);
        Type_priceL.setOpaque(true);
        Type_discoundL.setOpaque(true);
        spaceL.setOpaque(true);
        
        
        //setForeground
        CatNumL.setForeground(Color.blue);
        TypesNumL.setForeground(Color.blue);
        CategoryL.setForeground(Color.blue);
        TypeL.setForeground(Color.blue);
        TypeCodeInfoL.setForeground(Color.blue);
        TypeNameInfoL.setForeground(Color.blue);
        TypePriceInfoL.setForeground(Color.blue);
        TypeDescoundInfoL.setForeground(Color.blue);
        titlePanelInfoL.setForeground(new Color(113,19,198));
        
        //setBackground
//        Type_panel.setBackground(Color.WHITE);
        PanelCompleteInfo.setBackground(new Color(182,205,254,90));
        
        
        
        //setIcon
        saveIconB.setIcon(new ImageIcon(new ImageIcon("saveIcon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        updateIconB.setIcon(new ImageIcon(new ImageIcon("update.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        deleteIconB.setIcon(new ImageIcon(new ImageIcon("delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        updateTableIconB.setIcon(new ImageIcon(new ImageIcon("updateTable.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
      
        //setFont
        CatNumL.setFont(f);
        TypesNumL.setFont(f);
        CategoryL.setFont(f);
        TypeL.setFont(f);
        Type_codeL.setFont(f);
        Type_nameL.setFont(f);
        Type_priceL.setFont(f);
        Type_discoundL.setFont(f);
        CatNum.setFont(f);
        TypesNum.setFont(f);
        Type_code.setFont(f);
        Type_name.setFont(f);
        Type_price.setFont(f);
        Type_discound.setFont(f);
        titlePanelInfoL.setFont( new Font("Arial",Font.BOLD,18));
        TypeCodeInfo.setFont(f);
        TypeNameInfo.setFont(f);
        TypePriceInfo.setFont(f);
        TypeDescoundInfo.setFont(f);
        addCategoryB.setFont(f);
        TypeCodeInfoL.setFont( new Font("Arial",Font.BOLD,16));
        TypeNameInfoL.setFont( new Font("Arial",Font.BOLD,16));
        TypePriceInfoL.setFont( new Font("Arial",Font.BOLD,16));
        TypeDescoundInfoL.setFont( new Font("Arial",Font.BOLD,16));

        debts_detatils.setFont(f);
        
        
        
        //setEditable
        CatNum.setEditable(false);
        TypesNum.setEditable(false);

        
        //addActionListener
        
        addCategoryB.addActionListener(this);
        updateTableIconB.addActionListener(this);
        saveIconB.addActionListener(this);
        addTypeB.addActionListener(this);
        deleteIconB.addActionListener(this);
        updateIconB.addActionListener(this);
        //Categories.addListSelectionListener(this);   /////// 

        
        //setBounds
        CatNumL.setBounds(80, 25, 150, 38);
        CatNum.setBounds(250, 25, 100, 38);
        TypesNumL.setBounds(480, 25, 200, 38);
        TypesNum.setBounds(700, 25, 100, 38);
        
        CategoryL.setBounds(80, 70, 270, 30);
//        Categories_Scroll.setBounds(80, 110, 270, 550);
        addCategoryB.setBounds(80,670, 270, 30);
        TypeL.setBounds(400, 70, 610, 30);
       // Type_Scroll.setBounds(400, 120, 610, 300);
        Type_codeL.setBounds(15, 10, 120, 30);
        Type_nameL.setBounds(120, 10, 150, 30);
        Type_priceL.setBounds(270, 10, 100, 30);
        Type_discoundL.setBounds(370, 10, 120, 30);
        spaceL.setBounds(480, 10, 100, 30);
        Type_code.setBounds(15, 50, 80, 30);
        Type_name.setBounds(110, 50, 170, 30);
        Type_price.setBounds(300, 50, 80, 30);
        Type_discound.setBounds(405, 50, 65, 30);
        

        
        updateTableIconB.setBounds(1020, 300, 30, 30);
        PanelCompleteInfo.setBounds(400, 420, 610, 270);
        TypeCodeInfoL.setBounds(25, 80, 100, 30);
        TypeNameInfoL.setBounds(300, 80, 100, 30);
        TypePriceInfoL.setBounds(25, 150, 100, 30);
        TypeDescoundInfoL.setBounds(300, 150, 130, 30);
        titlePanelInfoL.setBounds(250, 15, 160, 30);
        TypeCodeInfo.setBounds(145, 80, 100, 30);////
        TypeNameInfo.setBounds(450, 80, 100, 30);
        TypeDescoundInfo.setBounds(450, 150, 100, 30);
        TypePriceInfo.setBounds(145, 150, 100, 30);
        saveIconB.setBounds(125, 220, 120, 30);
        updateIconB.setBounds(260, 220, 120, 30);
        deleteIconB.setBounds(395, 220, 120, 30);
        
        
        debts_detatils_Scroller.setBounds(400, 110, 610, 300);
        
        
        //add
        PanelCompleteInfo.add(titlePanelInfoL);
        PanelCompleteInfo.add(TypeCodeInfoL);
        PanelCompleteInfo.add(TypeNameInfoL);
        PanelCompleteInfo.add(TypePriceInfoL);
        PanelCompleteInfo.add(TypeDescoundInfoL);
        PanelCompleteInfo.add(TypeCodeInfo);
        PanelCompleteInfo.add(TypePriceInfo);
        PanelCompleteInfo.add(TypeNameInfo);
        PanelCompleteInfo.add(TypeDescoundInfo);
        PanelCompleteInfo.add(saveIconB);
        PanelCompleteInfo.add(updateIconB);
        PanelCompleteInfo.add(deleteIconB);

        add(CatNumL);
        add(CatNum);
        add(TypesNumL);
        add(TypesNum);
        add(CategoryL);
        //add(Categories_Scroll);
        add(addCategoryB);
        add(TypeL);
        add(debts_detatils_Scroller);
        add(updateTableIconB);
        add(PanelCompleteInfo);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == updateTableIconB){
            this.setVisible(false);
            Object [] ob = new Object [4];
            for(int i=0 ;i<ob.length ; ++i){
                ob[0]=dataA.get(i).getCode();
                ob[1]=dataA.get(i).getName();
                ob[2]=dataA.get(i).getPrice();
                ob[3]=dataA.get(i).getDiscount();
                debts_detatils_model.addRow(ob);
            }
           updateTableIconB.setEnabled(false);
            this.setVisible(true);
        }
           if(e.getSource() == saveIconB){
            try {
                System.out.println(new Control().saveData("Type",TypeCodeInfo.getText(), TypeNameInfo.getText(), Float.parseFloat(TypePriceInfo.getText()), Integer.parseInt(TypeDescoundInfo.getText())));
            } catch (SQLException ex) {
                System.out.println("1");
            } catch (IOException ex) {
                System.out.println("2");
            } catch (ClassNotFoundException ex) {
                System.out.println("3");
            }
               System.out.println("ok"); 
           }
//            this.setVisible(false);
//            txCode = new JTextField();
//            Cy+=40;
//            txCode.setFont(f);
//            txCode.setBounds(Cx, Cy, 80, 30);
//            Type_panel.add(txCode);
//            txName = new JTextField();
//            Ny+=40;
//            txName.setFont(f);
//            txName.setBounds(Nx, Ny, Type_name.getWidth(), Type_name.getHeight());
//            Type_panel.add(txName);
//            txPrice = new JTextField();
//            Py+=40;
//            txPrice.setFont(f);
//            txPrice.setBounds(Px, Py, 80, 30);
//            Type_panel.add(txPrice);
//            txDiscound = new JTextField();
//            Dy+=40;
//            txDiscound.setFont(f);
//            txDiscound.setBounds(Dx,Dy, Type_discound.getWidth(), 30);
//            Type_panel.add(txDiscound);
//            btnSave =new JButton();
//            btnSave.setIcon(new ImageIcon(new ImageIcon("saveIcon.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
//            IconY+=40;
//            btnSave.setBounds(saveIconB.getX(), IconY, saveIconB.getWidth(), 30);
//            btnSave.addActionListener(this);
//            Type_panel.add(btnSave);
//            btnUpdate =new JButton();
//            btnUpdate.setIcon(new ImageIcon(new ImageIcon("update.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
//            btnUpdate.setBounds(updateIconB.getX(), IconY, updateIconB.getWidth(), 30);
//            btnUpdate.addActionListener(this);
//            Type_panel.add(btnUpdate);
//            btnDelete =new JButton();
//            btnDelete.setIcon(new ImageIcon(new ImageIcon("delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
//            btnDelete.setBounds(deleteIconB.getX(), IconY, deleteIconB.getWidth(), 30);
//            btnDelete.addActionListener(this);
//            Type_panel.add(btnDelete);
//            this.setVisible(true);
//            addIconB.setEnabled(false);
////            tx.add(new Type_infoTXFeildsBu(txCode, txName, txPrice, txDiscound, false, false, false));
////            for(int i=0 ; i<tx.size() ; ++i)
////            System.out.println(tx.get(i).toString());
////            
////        System.out.println("**size = "+tx.size()+" **\n");
 
        }
        
    
    public static void main(String[] args) {
            Frame frame = new Frame();
            frame.setContentPane(new AddCatgory_Type());
            frame.setVisible(true);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}








//determinate diminsions
//        Cx = Type_code.getX();
//        Nx = Type_name.getX();
//        Px = Type_price.getX();
//        Dx = Type_discound.getX();
//        Cy = 10;
//        Ny = 10;
//        Py = 10;
//        Dy = 10;
//        IconY = 10;



//        saveIconB.setBounds(480, 50, 30, 30);
//        updateIconB.setBounds(515, 50, 30, 30);
//        deleteIconB.setBounds(550, 50, 30, 30);

//
/*
        Type_panel.add(Type_codeL);
        Type_panel.add(Type_nameL);
        Type_panel.add(Type_priceL);
        Type_panel.add(Type_discoundL);
        Type_panel.add(spaceL);
         Type_panel.add(new table());
        Type_panel.add(Type_code);
        Type_panel.add(Type_name);
        Type_panel.add(Type_price);
        Type_panel.add(Type_discound);
        Type_panel.add(saveIconB);
        Type_panel.add(updateIconB);
        Type_panel.add(deleteIconB);



*/















//else if(e.getSource() == btnSave){
//            try {
//              
//                if(txCode.getText().matches("Ty\\d{2,6}") && txName.getText().matches("\\w{5,}") && txPrice.getText().matches("\\d{1,}") && txDiscound.getText().matches("\\d{1,}")){
//                    this.setVisible(false);
//                    this.setVisible(true);
//                    if(new Control().saveData("Type",txCode.getText(), txName.getText(),Double.parseDouble(txPrice.getText()), Integer.parseInt(txDiscound.getText()))){
//                        txCode.setBackground(new Color(205,255,155));
//                        txCode.setHorizontalAlignment(JTextField.CENTER);
//                        txCode.setEditable(false);
//                        txName.setBackground(new Color(205,255,155));
//                        txName.setHorizontalAlignment(JTextField.CENTER);
//                        txName.setEditable(false);
//                        txPrice.setBackground(new Color(205,255,155));
//                        txPrice.setHorizontalAlignment(JTextField.CENTER);
//                        //txPrice.setEditable(false);
//                        txDiscound.setBackground(new Color(205,255,155));
//                        txDiscound.setHorizontalAlignment(JTextField.CENTER);
//                       this.setVisible(false);
//                        this.setVisible(true);
//
//                        txDiscound.setEditable(false);
//                        btnSave.setEnabled(false);
//                        addIconB.setEnabled(true);
//                        this.setVisible(false);
//                        this.setVisible(true);
//                                JOptionPane.showMessageDialog(null,"Saved is Done!");
//
//                    }else
//                       JOptionPane.showMessageDialog(this, "The reord is founded before!!!");
//                }
//                else
//                    System.out.println("Not");
//            } catch (SQLException ex) {
//                System.out.println("1");
//            } catch (IOException ex) {
//                   System.out.println("2");
//            } catch (ClassNotFoundException ex) {
//                   System.out.println("3");
//            }
//        }
//        else if(e.getSource() == btnUpdate){
//            try {
//                String codeUpDate = JOptionPane.showInputDialog(this,"Enter the product code that want to upate ");
//                if(new Control().updateTypeInfo("Type",txCode.getText(), txName.getText(),Double.parseDouble(txPrice.getText()), Integer.parseInt(txDiscound.getText()))){
//                    btnUpdate.addActionListener(this);
//                }
//           
//            } catch (SQLException ex) {
//                Logger.getLogger(AddCatgory_Type.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IOException ex) {
//                Logger.getLogger(AddCatgory_Type.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(AddCatgory_Type.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            
//        }