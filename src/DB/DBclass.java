
package DB;

import GUI.AddCatgory_Type;
import GUI.table;
import OOP.Type;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.RowSetMetaData;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
public class DBclass {
 
     public Statement statment;
     public String db ;
     public Connection  con;
    public DBclass() throws SQLException, IOException, ClassNotFoundException{
    try{
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        db = "jdbc:ucanaccess://"+"java1.accdb";
        con = DriverManager.getConnection(db,"","");
        statment = con.createStatement(ResultSet.CONCUR_UPDATABLE, ResultSet.CONCUR_UPDATABLE);
       // String m="create table Student("+"name TEXT(300), "+")";
       // statment.execute(m);
    
        con.commit();
    }catch(Exception e) {
            	e.printStackTrace();
        }    
    }

  
    public boolean insert(String tableName ,String code ,String name ,double price , int disc) throws SQLException{
        try{
        this.statment.execute("INSERT INTO "+tableName+"(code , name , price ,decound) VALUES ( '"+code+"' ,'"+name+"' , "+price +"," +disc +" )");
        }catch(SQLException ex ){
           ex.printStackTrace();
          return false; 
        }  
        return true;
    }
//    
    public  void createTable(String TableName) throws SQLException{
       statment.executeUpdate("create table "+TableName+"("+"code varchar(50) primary key,"+ "name varchar(250),"+"price float,"+"decound int "+")");
    }
//    public  void checkTable(String table_name) throws SQLException{
//       statment.executeUpdate("create table "+table_name+"("+"product varchar(50),"+ "price float,"+"date varchar(50),"+"PaymentStatus varchar(8),"+"Sum float"+")");
//    }
    public  void update(String tableName,String code ,String name ,double price , int disc) throws SQLException{
      try{
          
        //statment.executeUpdate("update "+tableName+" set name= '"+name +"', price='"+price+"', decound ='"+disc +"' WHERE code = ' "+code+" '");
        statment.executeUpdate("UPDATE Type SET name='"+name+"',price = '"+price+"' ,decound = '"+disc+"' WHERE code='"+code+"'");
          
      }catch(SQLException ex){
           System.out.println(ex.getMessage());
        } 
    }
    
    public  void AllTable(String TableName)  throws SQLException {
    String query = "select * from "+TableName;
    try {
      ResultSet rs = this.statment.executeQuery(query);
      int index = 0;
         while (rs.next()) {
           String code  = rs.getString("code");
           String name  = rs.getString("name");
           double price  = rs.getFloat("price");
           int decound  = rs.getInt("decound");
           Type type = new Type (code,name, price, decound);
           AddCatgory_Type.dataA.add(type);
         }
    
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    }
    public  String [] GetRowInfo(String TableName,String codeGet)  {
        
        String query = "select * from "+TableName +" WHERE code = "+"'"+codeGet+"'";
        try {
            ResultSet rs = this.statment.executeQuery(query);
            if(rs.next()){
                String code  = rs.getString("code");
                String name  = rs.getString("name");
                double price  = rs.getFloat("price");
                int decound  = rs.getInt("decound");
                return new String []{code , name , price+"",decound+""};

               // System.out.println(code +" "+name+" "+price+" "+decound);
            }
            else
                JOptionPane.showMessageDialog(null,"This Record is Not Found!!","Error",JOptionPane.ERROR_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
  



//    
//// 
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        new DBclass().GetRowInfo("TYPE","Ty10");
    }
   
} 



