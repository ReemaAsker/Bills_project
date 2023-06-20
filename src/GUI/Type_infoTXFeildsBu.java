/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JTextField;

public class Type_infoTXFeildsBu  {
 
   private JTextField code;
   private JTextField name;
   private JTextField price;
   private JTextField disc;
   private boolean isSave;
   private boolean isUpdate;
   private boolean isDelete;

    
    public Type_infoTXFeildsBu(JTextField code, JTextField name, JTextField price, JTextField disc, boolean isSave, boolean isUpdate, boolean isDelete) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.disc = disc;
        this.isSave = isSave;
        this.isUpdate = isUpdate;
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Type_infoTXFeildsBu{" + "code=" + code.getText() + ", name=" + name.getText() + ", price=" + price.getText() + ", disc=" + disc.getText() + ", isSave=" + isSave + ", isUpdate=" + isUpdate + ", isDelete=" + isDelete + '}';
    }
    
   
}
