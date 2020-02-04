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
public class GUI {
    JFrame f;
    JButton person,alarm,rem;
    
    public GUI() {
        iniGUI();
    }
    
    public void iniGUI(){
        f=new JFrame("Address Book");
        Container c=f.getContentPane();
        c.setLayout(null);
        
        JLabel pr=new JLabel("Person");
        pr.setBounds(75,10,50,15);
        c.add(pr);
        person=new JButton(new ImageIcon("Images/person.png"));
        person.setBounds(50,30,100,100);
        person.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false); 
                Person p=new Person();
            }
        });
        c.add(person);
        
        JLabel al=new JLabel("Alarm");
        al.setBounds(210,10,50,15);
        c.add(al);      
        alarm=new JButton(new ImageIcon("Images/clock.png"));
        alarm.setBounds(180,30,100,100);
        c.add(alarm);
        alarm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                Alarm a=new Alarm();
            }
        });
        
        JLabel re=new JLabel("Reminder");
        re.setBounds(355,10,70,15);
        c.add(re);
        rem=new JButton(new ImageIcon("Images/reminder.gif"));
        rem.setBounds(325,30,120,100);
        c.add(rem);
        rem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                Reminder r=new Reminder();
            }
        });
        
        f.setSize(500,200);
        f.setLocation(50,70);
        f.setVisible(true); 
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }    
}
