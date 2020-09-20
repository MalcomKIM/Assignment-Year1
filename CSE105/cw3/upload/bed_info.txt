/*
*Minhao Jin 1717576
*/
package garden;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author minhao.jin17
 */
public class bed_info extends JPanel{
    private final int myX, myY;
    private final int myWidth, myHeight;
    private int flowerbed_NO;
    private final Image myImage;
     public bed_info (Image myImage,
                        int myX, 
                        int myY, 
                        int myWidth, 
                        int myHeight,
                        int flowerbed_NO){
        this.myImage=myImage;
        this.myX = myX;
        this.myY = myY;
        this.myWidth = myWidth;
        this.myHeight = myHeight;
        this.flowerbed_NO=flowerbed_NO;
     }
     
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(myImage, 0, 0, myWidth, myHeight, this);
    }
     

    public int getX() {
        return myX;
    }


    public int getY() {
        return myY;
    }


    public int getWidth() {
        return myWidth;
    }


    public int getHeight() {
        return myHeight;
    }
    
    public int getflowerbed_NO(){
        return flowerbed_NO;
    }
    
    @Override
     public String toString(){
        return "flowerbed No="+flowerbed_NO+",myX="+myX+",myY="+myY+",myWidth="+myWidth
                +",myHeight="+myHeight
                ;
    }
    
    
}
