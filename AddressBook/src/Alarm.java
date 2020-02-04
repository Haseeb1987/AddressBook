/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.RandomAccessFile;
import javax.swing.event.*;
/**
 *
 * @author DareDevil
 */
public class Alarm {
    JFrame f=new JFrame("Set Alarm");

    public Alarm() {
        iniAlarm();
    }

    public void iniAlarm(){
        Container c=f.getContentPane();
        c.setLayout(null);

        final JLabel sh=new JLabel("Set Hour 0-23");
        sh.setBounds(20,40,80,20);
        c.add(sh);
        final JTextField th=new JTextField(10);
        th.setBounds(120,40,50,20);
        c.add(th);

        final JLabel sm=new JLabel("Set Minute 0-59");
        sm.setBounds(20,100,100,20);
        c.add(sm);
        final JTextField tm=new JTextField(10);
        tm.setBounds(120,100,50,20);
        c.add(tm);

        JButton sa=new JButton("Set Alarm");
        sa.setBounds(220,70,100,30);
        c.add(sa);
        sa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {                
                String H=th.getText();
                String M=tm.getText();
		try{
                    RandomAccessFile f1=new RandomAccessFile("Alarm.txt","rw");
                    f1.writeUTF(H+" "+M);
                    f1.close();
                }
                catch(Exception ax){
                    System.out.print("File Not Found");
                }                
                th.setText("");
                tm.setText("");
            	JOptionPane.showMessageDialog(null,"Alarm Set");
                f.setVisible(false);
                GUI g=new GUI();
            }
        });

        f.setSize(400,200);
        f.setLocation(50,50);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }       
}
