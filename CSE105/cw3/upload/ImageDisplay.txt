/*
*Minhao Jin 1717576
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
 * @author Minhao.Jin17
 */
public class ImageDisplay extends JPanel {
    private final int myX, myY;
    private final int myWidth, myHeight;
    private final String myPath;
    private final Image myImage;
    private int myPattern;
    private int flowerbed_NO;
    
    public ImageDisplay (Image image,
                        int myX, 
                        int myY, 
                        int myWidth, 
                        int myHeight,
                        String myPath,
                        int myPattern,
                        int flowerbed_NO){
        this.myX = myX;
        this.myY = myY;
        this.myWidth = myWidth;
        this.myHeight = myHeight;
        this.myImage = image;
        this.myPath = myPath; 
        this.myPattern = myPattern;
        this.flowerbed_NO=flowerbed_NO;
    }
    
    @Override
    public String toString(){
        return "ImageDisplay,"+"myX="+myX+",myY="+myY+",myWidth="+myWidth
                +",myHeight="+myHeight+",myPath="+myPath+",myPattern="+myPattern
                +",flowerbed No="+flowerbed_NO;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        switch(myPattern){
            case 1:
                for(int j=0;j<myHeight;j=j+20){
                    g.drawImage(myImage, 0, j, 20, 20, this);
                }
            break;
            
            case 2:
                for(int j=0;j<myWidth;j=j+20){
                    g.drawImage(myImage, j, 0, 20, 20, this);
                }
            break;
            
            case 3:
              for(int i=0;i<myWidth;i=i+20){
                for(int j=0;j<myHeight;j=j+20){
                    g.drawImage(myImage, i, j, 20, 20, this);
                }
            }
            break;
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
    
    public int getPattern(){
        return myPattern;
    }
      
    public int getflowerbed_NO(){
        return flowerbed_NO;
    }
    

}
