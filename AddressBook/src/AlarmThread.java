/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 *
 * @author DareDevil
 */
public class AlarmThread extends Thread{
    boolean flag;

    public void SetFlag(){
        flag=true;
    }

    boolean checkA(){
        String h,m;
        try{
            RandomAccessFile f=new RandomAccessFile("Alarm.txt","rw");
            String r=f.readUTF();
            StringTokenizer s=new StringTokenizer(r," ");
            h=s.nextToken();
            m=s.nextToken();
            Date d=new Date();
            DateFormat df=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            String dt=df.format(d);
            System.out.println(dt);
            StringTokenizer s2=new StringTokenizer(dt,"/ :");
            String h2,m2;
            h2=s2.nextToken();
            h2=s2.nextToken();
            h2=s2.nextToken();
            h2=s2.nextToken();
            m2=s2.nextToken();
            if(h.equals(h2)&&m.equals(m2)){
                return true;
            }
            f.close();
        }
        catch(Exception e){
            System.out.println("File Not Found");
        }
        return false;
    }

    boolean checkR(){
	int day,mnth,year;
        String d,mn,y;
        try{
            RandomAccessFile f=new RandomAccessFile("Reminder.txt","rw");
            String r=f.readUTF();
            StringTokenizer s=new StringTokenizer(r," ");
            d=s.nextToken();
            mn=s.nextToken();
            y=s.nextToken();
            Date da=new Date();
            DateFormat df=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            String dt=df.format(da); 
            System.out.println(dt);
            StringTokenizer s2=new StringTokenizer(dt,"/ :");
            String d2,mn2,y2;
            y2=s2.nextToken();
            mn2=s2.nextToken();
            d2=s2.nextToken();
            if(y.equals(y2)&&mn.equals(mn2)&&d.equals(d2)){
                return true;
            }
            f.close();
        }
        catch(Exception e){
            System.out.println("File Not Found");
        }
        return false;
    }

    public void run(){
        try{
            while (flag==false){
                Thread.sleep(3000);                
                if(checkR()){
                    JOptionPane.showMessageDialog(null,"You Have Set Reminder");
		
                }
                if(checkA()){
                    JOptionPane.showMessageDialog(null,"You Have Set Alarm");
		
                            
                }
            }
        }catch (InterruptedException e){
            System.out.println("Thread Exception "+e);
	}
    }
}

