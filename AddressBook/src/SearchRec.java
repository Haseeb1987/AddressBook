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
public class SearchRec {
    JFrame f=new JFrame("Search RECORD");

    public SearchRec() {
        Search();
    }
    
    public void Search(){
        final Container c=f.getContentPane();
        c.setLayout(null);
        
        JLabel id=new JLabel("Enter ID to Search");
        id.setBounds(20,10,150,20);
        c.add(id);
        final JTextField ti=new JTextField(10);
        ti.setBounds(130,10,100,20);
        c.add(ti);
        
        JButton ser=new JButton("Search Record");
        ser.setBounds(75,50,150,30);
        c.add(ser);
        ser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {                                                          
                String[]col={"Name","Fname","ID","Phone","city","Gender"};                    
                ArrayList num=new ArrayList(); 
                String id=ti.getText();                   
                    try{                                        
                        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        Connection con=DriverManager.getConnection("jdbc:odbc:AddressBook");
                        Statement st=con.createStatement();
                        ResultSet r=st.executeQuery("SELECT * FROM AddressBook WHERE ID='"+id+"'");
                        if("ID".equals(id)){
                            JOptionPane.showMessageDialog(null,"Record Does Not Exit");                                            
                        }
                        else{
                            while(r.next()){
                                /*System.out.println("Name : "+r.getString(1));
                                System.out.println("Father Name : "+r.getString(2));
                                System.out.println("ID : "+r.getString(3));
                                System.out.println("Phone # : "+r.getString(4));
                                System.out.println("City : "+r.getString(5));
                                System.out.println("Gender : "+r.getString(6));*/
                                num.add(r.getString(1));
                                num.add(r.getString(2));
                                num.add(r.getString(3));
                                num.add(r.getString(4));
                                num.add(r.getString(5));
                                num.add(r.getString(6));
                            }   
                        }
                                con.close();                                            
                        }
                        catch(Exception s){
                            System.out.print(s);
                        }
                    //JOptionPane.showMessageDialog(null,"Record Searched");                
                    int row=(num.size())/col.length;
                    int n=0;
                    Object[][]rec=new Object[row][col.length];
                    System.out.print("Record"+row);
                    for(int i=0; i<row; i++){
                        for(int j=0; j<col.length; j++){
                            Object o=(Object)num.get(n++);
                            rec[i][j]=o;
                        }
                    }
                    JTable t=new JTable(rec,col);
                    JScrollPane js=new JScrollPane(t);
                    c.add(js);
                    js.setAutoscrolls(true);
                    js.setBounds(20,100,300,200);                                                                 
            }                 
        });                    
        f.setSize(400,250);
        f.setLocation(50,50);
        f.setVisible(true); 
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }        
}
