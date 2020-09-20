/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garden;

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
    private static int input;

    
    public static void showMenu(){
        kb = new Scanner(System.in);
        System.out.println("Please select:");
        System.out.println("1.\tAdd flowerbed");
        System.out.println("2.\tRemove flowerbed");  
        System.out.println("3.\tSave and exit");   
        int command = getIntInput();
        switch(command){
            case 1:
                getImageInput();
            break;
            
            case 2:
                System.out.println("Removing flowerbed:");
                Removeflowerbed();
            break;
            
            case 3:
                FileUtils.saveGardenToFile(Garden.getMyflowerbeds());
                System.exit(0);
            break;
            
               
            default:
                System.out.println("Please input a value from 1 to 3");
        }    
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
        
        ArrayList<String> fileNames = FileUtils.getFileNames("res");
        System.out.println("Adding flowerbeds:");
        System.out.println("Please input flowerbed width:");
        int width=kb.nextInt();
        System.out.println("Please input flowerbed height:");
        int height=kb.nextInt();
        System.out.println("Please input flowerbed location x:");
        int imageX=kb.nextInt();
        System.out.println("Please input flowerbed location y:");
        int imageY=kb.nextInt();

        
        System.out.println("Please choose one pattern:");
        System.out.println("1.\tVertical");
        System.out.println("2.\thorizontal");
        System.out.println("3.\tplain");
        
        int choice=kb.nextInt();
        
        switch(choice){
            case 1: 
                for(int i=imageX;i<imageX+width;i=i+20){
                    int input=chooseImage();
                    String path=fileNames.get(input-1);
                    System.out.println("You selected "+path);
                    Garden.addImage(path, i, imageY, 20, height,1);
                }
                break;
            case 2:
                for(int i=imageY;i<imageY+height;i=i+20){
                    int input=chooseImage();
                    String path=fileNames.get(input-1);
                    System.out.println("You selected "+path);
                    Garden.addImage(path,imageX, i, width, 20,2);
                }
                break;
                
            case 3:
                int input=chooseImage();
                String path=fileNames.get(input-1);
                System.out.println("You selected "+path);
                Garden.addImage(path,imageX, imageY, width, height,3);
        }
    }
    
    
    private static int chooseImage(){
        ArrayList<String> fileNames = FileUtils.getFileNames("res");
        int counter=1;
        System.out.println("Please input path to flower image:");
        
        for(String s:fileNames){
            if(s.endsWith(".jpg")){
                System.out.println(counter+"."+s);
            }
            counter++;
        }

        while(true){
            kb = new Scanner(System.in);
            input = getIntInput();
            if(input>fileNames.size()||input<=0){
                System.out.println("out of range!");  
                System.out.println("Please input path to flower image:");
            }
            else{
                break;
            }
        }
        return input;
    }
    
    
    
     private static void Removeflowerbed(){
        //System.out.println("Removing animal:");
        ArrayList<ImageDisplay> flowerbedInGarden = Garden.getMyflowerbeds();
        int counter=1;
        System.out.println("Please input index of the flowerbed:");
        //String path = kb.nextLine();    //NO! NOT LIKE THIS!
        for(ImageDisplay s:flowerbedInGarden){
            System.out.println(counter+". "+s.toString());
            counter++;
        }
        
        // How do you want the user to choose the image? SEE LECTURE PPT
        
        while(true){
            input = getIntInput();
            if(input>flowerbedInGarden.size()){
                System.out.println("out of range!");  
                System.out.println("Please input index of the flowerbed:");
            }
            else{
                break;
            }
        }
        flowerbedInGarden.remove(input-1);
        Garden.RefreshList(flowerbedInGarden);

        System.out.println("You selected "+input+" to be removed.");

     }
     
}
