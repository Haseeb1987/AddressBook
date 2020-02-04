/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
/**
 *
 * @author DareDevil
 */
public class DelRec {
    JFrame f=new JFrame("Delete RECORD");
    
    public DelRec() {
        Del();
    }
    public void Del(){   
        Container c=f.getContentPane();
        c.setLayout(null);
        
        JLabel id=new JLabel("Enter ID");
        id.setBounds(50,50,100,20);
        c.add(id);
        final JTextField ti=new JTextField(10);
        ti.setBounds(100,50,100,20);
        c.add(ti);
        
        JButton del=new JButton("Delete Record");
        del.setBounds(75,100,150,30);
        c.add(del);
        del.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {                                                          
                try{
                    String id=ti.getText();
                    
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    Connection con=DriverManager.getConnection("jdbc:odbc:AddressBook");
                    Statement st=con.createStatement();
                    st.executeQuery("DELETE FROM AddressBook WHERE ID='"+id+"'");
                    con.close();                    
                }
                    catch(Exception s){
                        System.out.print(s);
                    }
                JOptionPane.showMessageDialog(null,"Record Deleted");
                f.setVisible(false);
                GUI g=new GUI();
            }
        });
        
        f.setSize(300,250);
        f.setLocation(50,50);
        f.setVisible(true); 
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }        
}
