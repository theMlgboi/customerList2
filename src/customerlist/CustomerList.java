/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package customerlist;

import java.io.*; 
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrew Archer
 * This program allows users to enter their information and save it to a file
 */
public class CustomerList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        //varible intilvation
        int amountOfPeopleint=0;
        boolean noError = true;
        char postal =0;
        String amountOfPeople = JOptionPane.showInputDialog("Please enter the amount of people: ");   
        
        //checks to see if the user entered a int for the amount of people
        while(noError == true)  {
         try{ 
          //contunes the program if a int was entered   
          amountOfPeopleint=  Integer.parseInt(amountOfPeople);
          break;
         }catch (NumberFormatException nfe){
          System.out.println("You did not enter an Integer");
          System.out.println(nfe);
          noError=false;
         }
        }
        //creates a loop for the amount of people
        for(int i=0; i<amountOfPeopleint; i++ ){  
         //creates varibles for each user
         String name = JOptionPane.showInputDialog("Please enter your name: ");
         String address = JOptionPane.showInputDialog("Please enter your address: ");
         String city= JOptionPane.showInputDialog("Please enter your city of residance: ");
         String postalCode   = JOptionPane.showInputDialog("Please enter your postal code (No spaces): ");
         String province   = JOptionPane.showInputDialog("Please enter your province of residance: ");
        
         int lenght= postalCode.length();
         if(lenght>6){
             JOptionPane.showMessageDialog(null,"Postalcode is to long ");
         }
         
        
         int fun =7;
         int win =6;
        
         //checks to see if the user has entered a char at the appropriate places in the postalcode
         for(int j=0; j<3; j++){
          win--;
          win--;

          postal = postalCode.charAt(win);
         if(Character.isLetter(postal) ){

         }else{
          JOptionPane.showMessageDialog(null, "Please enter a correct Postalcode");
          //waits 5 seconds to exit the program so the user can see the error message
          TimeUnit.SECONDS.sleep(5);
          System.exit(1);
         } 
          System.out.println(postal);
         }
         
         //checks to see if the user has entered a int at the appropriate places in the postalcode
         for(int j=0; j<3; j++){
          fun--;
          fun--;
          postal = postalCode.charAt(fun);
          
          
         if(Character.isDigit(postal) ){

         }else{
          JOptionPane.showMessageDialog(null, "Please enter a correct Postalcode");
          //waits 5 seconds to exit the program so the user can see the error message
          TimeUnit.SECONDS.sleep(5);
          System.exit(1);
         }

          System.out.println(postal);
        }

        String fileOut = name + "\n";
        fileOut  += address + "\n";
        fileOut   += city + "\n";
        fileOut   += postalCode + "\n";
        fileOut   += province + "\n";
        fileOut += "--------------------";
        //adds each users information to the file 
        PrintWriter fileout = new PrintWriter(new FileWriter(
        "info.txt",true));
        System.out.println(fileOut);
       fileout.println(fileOut);
       
        fileout.close();
        }


    } 

}
