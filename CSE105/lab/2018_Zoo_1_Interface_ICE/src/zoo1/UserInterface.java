/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joelewis
 */
public class UserInterface {
    private static Scanner kb;
    
    public static void showMenu(){
        kb = new Scanner(System.in);
        System.out.println("Welcome to my Zoo!\n");
        System.out.println("Please select:");
        System.out.println("1.\tAdd animal");
        System.out.println("2.\tRemove animal");  
        System.out.println("3.\tSave to file");  
        System.out.println("4.\tLoad from file");  
        int command = getIntInput();
        switch(command){
            
            case 1:
                getImageInput();
            break;
            
            case 2:
                System.out.println("Removing animal:");
                RemoveAnimal();
                //now, how are we going to remove an animal
            break;
            
            case 3:
                FileUtils.saveZooToFile(Zoo1.getMyAnimals());
            break;
            
            case 4:
                FileUtils.readZooFromFile();
            break;
               
            default:
                System.out.println("Please input a value from 1 to 3");
        }    
        showMenu();
    }
    
    private static int getIntInput(){
        int input = 0;
        try{
            input = Integer.parseInt(kb.nextLine());
        }
        catch(NumberFormatException e){
            System.out.println("That is not an int; "
                                + "please try again");
            input = getIntInput();
        }
        finally{
            return input;    
        }
    }
    
    private static void getImageInput(){
        System.out.println("Adding animal:");
        ArrayList<String> fileNames = FileUtils.getFileNames("res");
        int counter=1;
        System.out.println("Please input path to animal image:");
        //String path = kb.nextLine();    //NO! NOT LIKE THIS!
        for(String s:fileNames){
            if(s.endsWith(".png")){
                System.out.println(counter+"."+s);
            }
            counter++;
        }
        
        // How do you want the user to choose the image? SEE LECTURE PPT
        int input = getIntInput();
        String path=fileNames.get(input-1);
        //OK, when the user has chosen the image, you need to get the x,y,width,height,
        //and then call:
        System.out.println("You selected "+path);
        System.out.println("Please input image width:");
        int width=kb.nextInt();
        System.out.println("Please input image height:");
        int height=kb.nextInt();
        System.out.println("Please input location x:");
        int imageX=kb.nextInt();
        System.out.println("Please input location y:");
        int imageY=kb.nextInt();
        
        
        Zoo1.addImage(path, imageX, imageY, width, height);
    }
    
     private static void RemoveAnimal(){
        //System.out.println("Removing animal:");
        ArrayList<ImageDisplay> animalInZoos = Zoo1.getMyAnimals();
        int counter=1;
        System.out.println("Please input index to animal image:");
        //String path = kb.nextLine();    //NO! NOT LIKE THIS!
        for(ImageDisplay s:animalInZoos){
            System.out.println(counter+". "+s.toString());
            counter++;
        }
        
        // How do you want the user to choose the image? SEE LECTURE PPT
        int input = getIntInput();
        animalInZoos.remove(input-1);
        Zoo1.RefreshList(animalInZoos);
        //OK, when the user has chosen the image, you need to get the x,y,width,height,
        //and then call:
        System.out.println("You selected "+input+" to be removed.");
//        System.out.println("Please input image width:");
//        int width=kb.nextInt();
//        System.out.println("Please input image height:");
//        int height=kb.nextInt();
//        System.out.println("Please input location x:");
//        int imageX=kb.nextInt();
//        System.out.println("Please input location y:");
//        int imageY=kb.nextInt();
        
        
        //Zoo1.addImage(path, imageX, imageY, width, height);
     }
    
}
