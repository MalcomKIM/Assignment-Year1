/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author joelewis
 * A utility class to perform common file read, write, and other I/O
 */
public class FileUtils {
    
    public static BufferedImage loadImage(String imagePath){
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(imagePath));
            System.out.println("Image loaded: "+imagePath);
        } catch (IOException e) {
            System.out.println("Problem loading image: "+imagePath);
            e.printStackTrace();
        }
        return image;
    }
}
