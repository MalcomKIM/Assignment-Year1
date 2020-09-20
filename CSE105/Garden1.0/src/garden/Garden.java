/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garden;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import javax.swing.JFrame;
/**
 *
 * @author Minhao.Jin17
 */
public class Garden {
    private static JFrame myWindow;
    private static ArrayList<ImageDisplay> myflowerbeds = new ArrayList<>();
    
    
     
    public static void main(String[] args) {
        myWindow = new JFrame();
        myWindow.setVisible(true);
        myWindow.setSize(800, 600);
        myWindow.getContentPane().setBackground(java.awt.Color.GREEN);
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FileUtils.readGardenFromFile();
        while(true)
        UserInterface.showMenu();
    }
      protected static void saveZoo(){
        FileUtils.saveGardenToFile(myflowerbeds);
    }
    
    protected static void addImage(String imagePath){
        BufferedImage image = FileUtils.loadImage(imagePath);
        ImageDisplay myImage;
        myImage = new ImageDisplay(image, 100, 100, 100,100,imagePath);
        myImage.setBackground(java.awt.Color.DARK_GRAY);
        myWindow.add(myImage);
        myflowerbeds.add(myImage);
        System.out.println("Image added: "+ imagePath);
        myWindow.repaint();
        //System.out.println(myWindow.getComponentCount()); 
    }
    
    protected static void addImage(String imagePath, int x, int y, int width, int height){
        BufferedImage image = FileUtils.loadImage(imagePath);
        ImageDisplay myImage;
        myImage = new ImageDisplay(image, x, y, width,height,imagePath);
        myImage.setBackground(java.awt.Color.DARK_GRAY);
        myWindow.add(myImage);
        myflowerbeds.add(myImage);
        System.out.println("Image added: "+ imagePath);
        myWindow.repaint();
        //System.out.println(myWindow.getComponentCount());
    }
    


    public static JFrame getMyWindow() {
        return myWindow;
    }

    public static ArrayList<ImageDisplay> getMyflowerbeds() {
        return myflowerbeds;
    }
    
    public static void RefreshList(ArrayList<ImageDisplay> newArrayList){
        myflowerbeds = newArrayList;
        myWindow.getContentPane().removeAll();
        myWindow.repaint();
        
        for(ImageDisplay s:myflowerbeds){
            myWindow.add(s);
            myWindow.repaint();
        }        
    }
}
