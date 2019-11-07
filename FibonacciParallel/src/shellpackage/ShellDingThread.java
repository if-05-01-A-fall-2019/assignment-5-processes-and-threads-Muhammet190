package shellpackage;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Muhammet Oezdogan
 */
public class ShellDingThread{
    public static void main(String[] args) throws InterruptedException, IOException{
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        String[] d = a.trim().split("&");
        try{
            String process;
            for (int i = 0; i < d.length; i++) {
                process = d[i];
                Process p = Runtime.getRuntime().exec("cmd /c"+process);
                BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
                while((process = input.readLine()) != null){
                    System.out.println(process);
                }
                input.close();
            }
        }
        catch(Exception err){
            err.printStackTrace();
        }
    }    
}
