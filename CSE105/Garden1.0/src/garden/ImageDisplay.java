/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garden;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.IIOException; 
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author joelewis
 */
public class ImageDisplay extends JPanel {
    private final int myX, myY;
    private final int myWidth, myHeight;
    private final String myPath;
    private final Image myImage;
    
    
    public ImageDisplay (Image image,
                        int myX, 
                        int myY, 
                        int myWidth, 
                        int myHeight,
                        String myPath){
        this.myX = myX;
        this.myY = myY;
        this.myWidth = myWidth;
        this.myHeight = myHeight;
        this.myImage = image;
        this.myPath = myPath; 
    }
    
    @Override
    public String toString(){
        return "ImageDisplay,"+"myX="+myX+",myY="+myY+",myWidth="+myWidth
                +",myHeight="+myHeight+",myPath="+myPath;
    }
    

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i=0;i<myWidth;i=i+20){
            for(int j=0;j<myHeight;j=j+20){
                g.drawImage(myImage, i, j, 20, 20, this);
            }
        }
    }
    

    @Override
    public int getX() {
        return myX;
    }

    @Override
    public int getY() {
        return myY;
    }

    @Override
    public int getWidth() {
        return myWidth;
    }

    @Override
    public int getHeight() {
        return myHeight;
    }

      
    
}
