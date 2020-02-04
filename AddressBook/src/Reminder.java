/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author DareDevil
 */
public class Reminder {
    JFrame f=new JFrame("Set Reminder");

    public Reminder() {
        iniRem();
    }
    
    public void iniRem(){
        Container c=f.getContentPane();
        c.setLayout(null);
        
        JLabel sd=new JLabel("Set Day");
        sd.setBounds(20,20,50,20);
        c.add(sd);
        final JTextField td=new JTextField(10);
        td.setBounds(90,20,50,20);
        c.add(td);
        
        JLabel sm=new JLabel("Set Month");
        sm.setBounds(20,70,100,20);
        c.add(sm);
        final JTextField tm=new JTextField(10);
        tm.setBounds(90,70,50,20);
        c.add(tm);
        
        JLabel sy=new JLabel("Set Year");
        sy.setBounds(20,120,100,20);
        c.add(sy);
        final JTextField ty=new JTextField(10);
        ty.setBounds(90,120,50,20);
        c.add(ty);
        
        JButton sa=new JButton("Set Reminder");
        sa.setBounds(200,70,120,30);
        c.add(sa);
        
        sa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String D=td.getText();
                String M=tm.getText();
                String Y=ty.getText();
		try{
                    RandomAccessFile f1=new RandomAccessFile("Reminder.txt","rw");
                    f1.writeUTF(Y+" "+M+" "+D);
                    f1.close();
                }
                catch(Exception l1){
                    System.out.print("File Not Found");
                }                
                td.setText("");
                tm.setText("");
                ty.setText("");
            	JOptionPane.showMessageDialog(null,"Reminder Set");
                f.setVisible(false);
                GUI g=new GUI();
            }            
        });
        
        f.setSize(400,250);
        f.setLocation(50,50);
        f.setVisible(true); 
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }               
}
