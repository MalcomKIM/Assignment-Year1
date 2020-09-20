/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author joelewis
 */
public class Zoo1 {
    private JFrame myWindow;
    private int myWidth = 600;
    private int myHeight = 400;

    public static void main(String[] args) {
        long starTime= System.currentTimeMillis();
        Zoo1 z1 = new Zoo1();
        long endTime= System.currentTimeMillis();
        System.out.println(endTime-starTime);
    }
    
    public Zoo1(){
        myWindow = new JFrame("Joe's Zoo");
        myWindow.setVisible(true);
        myWindow.setSize(myWidth, myHeight);
        //myWindow.getContentPane().setBackground(new Color(20,100,20));
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        for(int i=0;i<myWidth;i+=100)
            for(int j=0;j<myHeight;j+=100)
        addImage("cow150.png",i,j,100,50);
        
    }
    
    private void addImage(String imagePath,int x,int y,int width,int height){
        BufferedImage myImage = FileUtils.loadImage(imagePath);
        ImageDisplay myImageDisplay = 
                new ImageDisplay(myImage, x, y, width,height);
        myWindow.add(myImageDisplay);
        myWindow.repaint();
    }
    
    
    
}
