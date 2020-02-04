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
public class AddRec {      
    JFrame f=new JFrame("ADD RECORD");
    
    public AddRec(){              
        Add();                    
    }
       
    public void Add(){               
        Container c=f.getContentPane();
        c.setLayout(null);        
        
        JLabel name=new JLabel("Name");
        name.setBounds(20,20,50,20);
        c.add(name);
        final JTextField tnam=new JTextField(20);
        tnam.setBounds(60,20,120,20);
        c.add(tnam);
        
        JLabel fname=new JLabel("Father Name");
        fname.setBounds(210,20,100,20);
        c.add(fname);
        final JTextField tfnam=new JTextField(20);
        tfnam.setBounds(290,20,120,20);
        c.add(tfnam);
        
        JLabel id=new JLabel("ID");
        id.setBounds(20,50,50,20);
        c.add(id);
        final JTextField tid=new JTextField(15);
        tid.setBounds(40,50,120,20);
        c.add(tid);
        
        JLabel ph=new JLabel("Phone #");
        ph.setBounds(20,80,70,20);
        c.add(ph);
        final JTextField tp=new JTextField(10);
        tp.setBounds(70,80,120,20);
        c.add(tp);
        
        JLabel ge=new JLabel("Gender");
        ge.setBounds(20,110,70,20);
        c.add(ge);
        String gen[]={"Male","Female"};
        final JComboBox cgen=new JComboBox(gen); 
        cgen.setBounds(70,110,100,20);
        c.add(cgen);
        
        JLabel city=new JLabel("City");
        city.setBounds(230,80,50,20);
        c.add(city);
        final JTextField tcity=new JTextField(20);
        tcity.setBounds(260,80,120,20);
        c.add(tcity);
        
        JButton adr=new JButton("Add Record");
        adr.setBounds(170,175,100,30);
        c.add(adr);
        adr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {                                                
                try{
                    String Name=tnam.getText();
                    String Fname=tfnam.getText();
                    String ID=tid.getText();
                    String Phone=tp.getText();
                    String city=tcity.getText();
                    String Gender=(String)cgen.getSelectedItem();
                    
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    Connection con=DriverManager.getConnection("jdbc:odbc:AddressBook");
                    Statement st=con.createStatement();
                    st.executeQuery("INSERT INTO AddressBook VALUES ('"+Name+"','"+Fname+"','"+ID+"','"+Phone+"','"+city+"','"+Gender+"')");
                    con.close();
                }
                    catch(Exception s){
                        System.out.print(s);
                    }
                JOptionPane.showMessageDialog(null,"Record Added");
                f.setVisible(false);
                GUI g=new GUI();
                tnam.setText("");
                tfnam.setText("");
                tid.setText("");
                tp.setText("");
                tcity.setText("");                              
            }
        });                           
        
        f.setSize(500,250);
        f.setLocation(50,50);
        f.setVisible(true); 
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }                   
}
