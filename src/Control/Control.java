package Control;


import DB.DBclass;
import OOP.Type;
import java.io.IOException;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Control {
    
    DBclass conect;

    public Control() throws SQLException, IOException, ClassNotFoundException {
            this.conect = new DBclass();
    }
    
    public void CreateTable(String TableName) throws SQLException{
        this.conect.createTable(TableName);
        System.out.println("Done");
    }
    public boolean saveData( String tableName,String code ,String name,double price ,int disc) throws SQLException{
        return this.conect.insert(tableName,code ,name, price ,disc);
    }
    public String [] giveData(String table , String code){
        return this.conect.GetRowInfo(table , code);
    }
    public boolean isCategoryFound(String category){
        
        return false;
    }
    public boolean isTypeFound(String code){
        
        return false;
    }
    public boolean deleteType(String code){
        //isTypeFound
        return false;
    }
    public boolean updateTypeInfo(String tableName,String code ,String name,double price ,int disc){
        try {
            this.conect.update(tableName,code ,name, price ,disc);
            JOptionPane.showMessageDialog(null,"Updated is Done!");
        } catch (SQLException ex) {
            System.out.println("Not done");
        }
        return true;
    }
     public void AllTypeInfo(String tableName){
        try {
         this.conect.AllTable("type");
        } catch (SQLException ex) {
          //  System.out.println("Not done");
        }
        return;
    }
    
}