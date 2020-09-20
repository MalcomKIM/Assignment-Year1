/*
*Minhao Jin 1717576
*/
package garden;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import java.awt.Color;

/**
 *
 * @author Minhao.Jin17
 */
public class Garden {
    private static JFrame myWindow;
    private static ArrayList<ImageDisplay> myflowers = new ArrayList<>();
    private static ArrayList<bed_info> flowerbeds=new ArrayList<>();
    private static ArrayList<Integer> flowerbed_NO=new ArrayList<>();
    
    //This is the main method
    public static void main(String[] args) {
        myWindow = new JFrame();
        myWindow.setVisible(true);
        myWindow.setSize(800, 600);
        myWindow.getContentPane().setBackground(new Color(34,139,34));
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FileUtils.readFlowerFromFile();
        while(true)
        UserInterface.showMenu();
    }
    
    //"saveFlower" method is responsible for saving flowers and flowerbeds information to "flower.txt"
    protected static void saveFlower(){
        FileUtils.saveFlowerToFile(myflowers,flowerbeds);
    }
    
    
    //"addImage" method is responsible for creating a new "ImageDisplay" Object and display it on the screen 
    protected static void addImage(String imagePath, int x, int y, int width, int height,int myPattern,int flowerbed_NO){
        BufferedImage image = FileUtils.loadImage(imagePath);
        ImageDisplay myImage;
        myImage = new ImageDisplay(image, x, y, width,height,imagePath,myPattern,flowerbed_NO);
        myImage.setOpaque(false);
        myWindow.add(myImage);
        myflowers.add(myImage);
        myWindow.repaint();
    }
    
    //"addFlowerbeds" method is responsible for creating a new "bed_info" Object and display it on the screen
    protected static void addFlowerbeds(int myX, int myY, int myWidth, int myHeight,int flowerbed_NO){
        BufferedImage image = FileUtils.loadImage("res\\earth.jpg");
        bed_info bi=new bed_info (image,myX, myY, myWidth,  myHeight, flowerbed_NO);
        bi.setVisible(true);
        myWindow.add(bi);
        myWindow.repaint();
        flowerbeds.add(bi);
    }
    
    //"addFlowerbed_NO" method is responsible for saving the current number in the ArrayList "flowerbed_NO"
    protected static void addFlowerbed_NO(int fb_no){
        flowerbed_NO.add(fb_no);
    }

    //getMyWindow() is responsible for getting myWindow
    public static JFrame getMyWindow() {
        return myWindow;
    }
    
    //getMyflowers() is responsible for getting myflowers
    public static ArrayList<ImageDisplay> getMyflowers() {
        return myflowers;
    }
    
    //getFlowerbeds() is responsible for getting flowerbeds
    public static ArrayList <bed_info> getFlowerbeds(){
        return flowerbeds;
    }
    
    //getflowerbed_NO() is responsible for getting flowerbeds
    public static ArrayList<Integer> getflowerbed_NO(){
        return flowerbed_NO;
    }
    
    //"RefreshFlower" method is responsible for getting the new ArrayList of myflowers after removing
    public static void RefreshFlower(ArrayList<ImageDisplay> newArrayList){
        myflowers=newArrayList;
        
        myWindow.getContentPane().removeAll();
        myWindow.repaint();
        
        for(ImageDisplay s:myflowers){
            myWindow.add(s);
            myWindow.repaint();
        }        
    }
    
    //"Refreshflowerbed" method is responsible for getting the new ArrayList of flowerbeds after removing
    public static void Refreshflowerbed( ArrayList<bed_info> newArrayList){
        flowerbeds=newArrayList;
        
        for(bed_info s:flowerbeds){
            myWindow.add(s);
            myWindow.repaint();
        }
    }
    
    //"Refreshflowerbed_NO" method is responsible to get the new ArrayList of flowerbed_NO after removing
     public static void Refreshflowerbed_NO( ArrayList<Integer> newArrayList){
        flowerbed_NO=newArrayList;
    }
    
}
