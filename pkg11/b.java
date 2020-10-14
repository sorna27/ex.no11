/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ex.no.pkg11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class b {
    public static void main(String[] args) throws InterruptedException
    {

        vb obj=new vb();
        String s;
        Scanner o=new Scanner(System.in); 

        System.out.println("...VENUE BOOKING...");
        System.out.println("Three bookings are available per day \n 1.10am\n2.3pm\n3.6pm");
        System.out.println("enter the name:");
        s=o.next();
        System.out.println("enter the timing:");
        int x=o.nextInt();
        a aa=new a(obj,x,s);
        aa.start();
        aa.join();
        
        System.out.println("...VENUE BOOKING...");
        System.out.println("Three bookings are available per day \n 1.10am\n2.3pm\n3.6pm");
        System.out.println("enter the name:");
        s=o.next();
        System.out.println("enter the timing:");
        int y=o.nextInt();
        d dd=new d(obj,y,s,x);
        dd.start();
        dd.join();
           
        System.out.println("...VENUE BOOKING...");
        System.out.println("Three bookings are available per day \n 1.10am\n2.3pm\n3.6pm");
        System.out.println("enter the name:");
        s=o.next();
        System.out.println("enter the timing:");
        int z=o.nextInt();
        c cc=new c(obj,z,s,y,x);
        cc.start();
        cc.join();
    }  
}
class vb
{
    int time;
    synchronized public void resort(int time,String s1){        
        System.out.println("\nTIME:"+time+"\nNAME:"+s1+"\nBOOKING SUCCESSFUL...");
    }
}
class a extends Thread
{
    vb v;
    int t=0;
    String s;
    public a(vb v,int t,String s)
    {
        this.v=v;
        this.t=t;
        this.s=s;
    }
    public void run()
    {
        v.resort(t,s);
    }
} 
class d extends Thread
{
    vb v;
    int t,x;
    String s;
    public d(vb v,int t,String s,int x)
    {
        this.v=v;
        this.t=t;
        this.s=s;
        this.x=x;
    }
    public void run()
    {
        if(t!=x)
        {
        v.resort(t,s);
        }
        else
            System.out.println("BOOKING UNSUCCESSFUL");
    }
} 
class c extends Thread
{
    vb v;
    int t,x,y;
    String s;
    public c(vb v,int t,String s,int x,int y)
    {
        this.v=v;
        this.t=t;
        this.s=s;
        this.x=x;
        this.y=y;
    }
    public void run()
    {
        if(t!=x&&t!=y)
        {
        v.resort(t,s);
        }
        else
            System.out.println("BOOKING UNSUCESSFUL");
    }
} 