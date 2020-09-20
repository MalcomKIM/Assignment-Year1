/*
*Minhao Jin 1717576
*/
package garden;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Minhao.Jin17
 */
public class UserInterface {
    private static Scanner kb;
    private static int input;

    // showMenu() is a menu for user to choose functions 
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
                FileUtils.saveFlowerToFile(Garden.getMyflowers(),Garden.getFlowerbeds());
                System.exit(0);
            break;
            
               
            default:
                System.out.println("Please input a value from 1 to 3");
        }    
    }
    
    //getIntInput() ensures that an input must be a digit not a letter
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
    
    //getImageInput() let the user to choose the position, width, height and pattern of a flowerbed
    private static void getImageInput(){
        ArrayList<String> fileNames = FileUtils.getFileNames("res");
        int width=0;
        int height=0;
        int imageX=0;
        int imageY=0;
        int choice=0;
        
        System.out.println("Adding flowerbeds:");
        
        System.out.println("Please give a number to the current flowerbed:");
        int flowerbed_No=0;
        while(true){
            kb = new Scanner(System.in);
            flowerbed_No = getIntInput();
            if(Garden.getflowerbed_NO().contains(flowerbed_No)){
                System.out.println("The number is already there.");  
                System.out.println("Please input again.");
            }
            else{
                break;
            }
        }

        while(true){
            System.out.println("Please input flowerbed width:");
            width=getIntInput();
            System.out.println("Please input flowerbed height:");
            height=getIntInput();
            
            if(width<20||height<20){
                System.out.println("The flowerbed is too small for flowers.");
                System.out.println("The minimum size is 20*20");
                continue;
            }
            
            System.out.println("Please input flowerbed location x:");
            imageX=getIntInput();
            System.out.println("Please input flowerbed location y:");
            imageY=getIntInput();
            
            if(width+imageX<=800&&height+imageY<=600){
                break;
            }
            else{
                System.out.println("The flowers cannot be seen in current window");
                System.out.println("The size of the garden is 800*600. Please input again.");
            }
        }

        
        
        System.out.println("Please choose one pattern:");
        System.out.println("1.\tVertical");
        System.out.println("2.\thorizontal");
        System.out.println("3.\tplain");
        
        while(true){
            choice=getIntInput();
            if(choice<=0||choice>=4){
                System.out.println("Please input a value from 1 to 3");
            }
            else{
                break;
            }
        }
        
        switch(choice){
            case 1: 
                for(int i=imageX;i<imageX+width;i=i+20){
                    int input=chooseImage();
                    String path=fileNames.get(input-1);
                    System.out.println("You selected "+path);
                    Garden.addImage(path, i, imageY, 20, height,1,flowerbed_No);
                }
                Garden.addFlowerbeds(imageX, imageY, width, height, flowerbed_No);
                Garden.addFlowerbed_NO(flowerbed_No);
                break;
            case 2:
                for(int i=imageY;i<imageY+height;i=i+20){
                    int input=chooseImage();
                    String path=fileNames.get(input-1);
                    System.out.println("You selected "+path);
                    Garden.addImage(path,imageX, i, width, 20,2,flowerbed_No);
                }                
                Garden.addFlowerbeds(imageX, imageY, width, height, flowerbed_No);
                Garden.addFlowerbed_NO(flowerbed_No);
                break;
                
            case 3:
                int input=chooseImage();
                String path=fileNames.get(input-1);
                System.out.println("You selected "+path);
                Garden.addImage(path,imageX, imageY, width, height,3,flowerbed_No);
                Garden.addFlowerbeds(imageX, imageY, width, height, flowerbed_No);
                Garden.addFlowerbed_NO(flowerbed_No);
                break;
                
                default:
                System.out.println("Please input a value from 1 to 3");
        }
    }
    
    //chooseImage() ensures that the path which the user choose is valid
    private static int chooseImage(){
        ArrayList<String> fileNames = FileUtils.getFileNames("res");
        int counter=1;
        System.out.println("Please input path to flower image:");
        
        for(String s:fileNames){
            if(s.endsWith(".png")){
                System.out.println(counter+"."+s);
            }
            counter++;
        }

        while(true){
            kb = new Scanner(System.in);
            input = getIntInput();
            if(input>fileNames.size()-1||input<=0){
                System.out.println("out of range!");  
                System.out.println("Please input path to flower image:");
            }
            else{
                break;
            }
        }
        return input;
    }
    
    
    //Removeflowerbed() is responsible for removing a flowerbed from window
     private static void Removeflowerbed(){
        ArrayList<bed_info> flowerbedInGarden = Garden.getFlowerbeds();
        ArrayList<ImageDisplay> flowerInGarden = Garden.getMyflowers();
        ArrayList<Integer> flowerbed_NO=Garden.getflowerbed_NO();
        
        
        int counter=1;
        System.out.println("Please input index of the flowerbed:");
        for(bed_info s:flowerbedInGarden){
            System.out.println(counter+". "+s.toString());
            counter++;
        }
        
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
        
        int removenum=flowerbedInGarden.get(input-1).getflowerbed_NO();

        
        
        Iterator it=flowerInGarden.iterator();
        while(it.hasNext()){
            ImageDisplay im = (ImageDisplay) it.next();
            if(im.getflowerbed_NO()==removenum){
                it.remove();
            }
        }
        Garden.RefreshFlower(flowerInGarden);
        
        
        flowerbedInGarden.remove(input-1);
        Garden.Refreshflowerbed(flowerbedInGarden);
        
        Iterator fbno=flowerbed_NO.iterator();
         while(fbno.hasNext()){
            int num = (int) fbno.next();
            if(num==removenum){
                fbno.remove();
            }
        }
        Garden.Refreshflowerbed_NO(flowerbed_NO);

        System.out.println("You selected "+input+" to be removed.");

     }
     
}
