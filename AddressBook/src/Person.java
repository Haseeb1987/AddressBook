/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
/**
 *
 * @author DareDevil
 */
public class Person {
    JFrame f;
    JTextField nam;
    JButton add,del,upd,search;
    JLabel ad,de,up,se;   
 
    public Person() {
        iniPerson();
    }
    
    public void iniPerson(){            
        f=new JFrame("Person");    
        Container c=f.getContentPane();
        c.setLayout(null);
        
        ad=new JLabel("Add");
        ad.setBounds(80,10,100,20);
        c.add(ad);
        add=new JButton(new ImageIcon("Images/add.png"));
        add.setBounds(40,30,100,100);       
        c.add(add);
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                AddRec a=new AddRec(); 
            }
        });
        
        de=new JLabel("Delete");
        de.setBounds(170,10,100,20);
        c.add(de);
        del=new JButton(new ImageIcon("Images/delete.png"));
        del.setBounds(140,30,100,100);
        c.add(del);
        del.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                DelRec d=new DelRec();
            }
        }); 
        
        up=new JLabel("Update");
        up.setBounds(280,10,100,20);
        c.add(up);
        upd=new JButton(new ImageIcon("Images/update.png"));
        upd.setBounds(240,30,110,100);
        c.add(upd);
        upd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                UpdateRec u=new UpdateRec();
            }
        });
        
        se=new JLabel("Search");
        se.setBounds(380,10,100,20);
        c.add(se);
        search=new JButton(new ImageIcon("Images/search.png"));
        search.setBounds(350,30,110,100);
        c.add(search);
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                SearchRec s=new SearchRec();
            }
        });
              
        f.setSize(500,200);
        f.setLocation(50,70);
        f.setVisible(true); 
        f.setResizable(false);        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }
}
