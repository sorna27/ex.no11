/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ex.no.pkg11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class ExNo11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        countw c=new countw();
        Scanner obj=new Scanner(System.in);
        System.out.println("Enter the file names:");
        for(int i=0;i<3;i++)
        {
            String s=obj.next();
            file f=new file(c,s);
            f.start();
        }
        
    }
    
}
class countw
{
    public void count(String filename) throws IOException
    {
        File f=new File(filename);
        BufferedReader fd=new BufferedReader(new FileReader(f));
        String read;
        int c=0;
        while((read=fd.readLine())!=null)
        {
            int i;
            String s[]=read.split(" ");
            for(i=0;i<s.length;i++)
            {
                c++;
            }
           
        }
        System.out.println(f.getName()+"..."+c+"words");
        fd.close();
    }
}
class file extends Thread
{
    countw w;
    String fn;
    public file(countw w,String fname){
        this.w=w;
        this.fn=fname;
    }
    public void run()
    {
        try
        {
            w.count(fn);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}