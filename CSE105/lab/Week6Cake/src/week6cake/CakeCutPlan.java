/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6cake;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.awt.Image;
import javax.swing.ImageIcon;
/**
 *
 * @author Minhao.Jin17
 */
public class CakeCutPlan extends JFrame{
    int numSlices;   
    int cakeX,cakeY,cakeWidth,cakeHeight;   
    double sliceWidth,sliceHeight,slicePerSide;    
    Image image;
    
    public CakeCutPlan(int numSlices){
        super();
        System.out.println("cut1 "+numSlices);
        this.setSize(800, 800);
        cakeX=40;
        cakeY=40;
        cakeWidth=720;
        cakeHeight=720;
        this.numSlices=numSlices;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon=new ImageIcon("C:\\Users\\minhao.jin17\\Documents\\NetBeansProjects\\Week6Cake\\build\\cake.jpg");
        image=icon.getImage();
        //image=loadImage("cake.jpg");
        this.setVisible(true);
        
    }
    
    
    public void paint(Graphics g){
        super.paint(g);
        
        g.setColor(Color.black);
        g.drawRect(cakeX, cakeY, cakeWidth, cakeHeight);
        g.drawImage(image, cakeX, cakeY,cakeWidth, cakeHeight, rootPane);
        
            int n=(int)Math.sqrt(numSlices);
            for(int i=1;i<=n+2;i++){
                 g.drawLine(cakeX+cakeWidth/n*i,cakeY,cakeX+cakeWidth/n*i,cakeX+cakeHeight);
                 g.drawLine(cakeX,cakeY+cakeHeight/n*i,cakeX+cakeWidth, cakeY+cakeHeight/n*i);
            }
    }


}
