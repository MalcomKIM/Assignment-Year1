/*
*Minhao Jin 1717576
*/
package garden;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Set;
import javax.imageio.ImageIO;

/**
 *
 * @author Minhao.Jin17
 */
public class FileUtils {

    //"loadImage" method is responsible for loading image
    public static BufferedImage loadImage(String imagePath) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            System.out.println("Problem loading image: " + imagePath);
            e.printStackTrace();
        }
        return image;
    }
    
    //"getFileNames" method is responsible for getting file names from the folder
    public static ArrayList<String> getFileNames(String dirPath) {
        ArrayList<String> names = new ArrayList<String>();
        File dir = new File(dirPath);
        if (dir.isDirectory()) {
            for (File f : dir.listFiles()) {
                names.add(f.getPath());
            }
        }
        return names;
    }

    //"saveFlowerToFile" method is responsible for saving the ArrayList of both ImageDisplay and bed_info into Flower.txt
    public static boolean saveFlowerToFile(ArrayList<ImageDisplay> toWrite1,ArrayList<bed_info> toWrite2) {
        try (FileWriter fw = new FileWriter("Flower.txt", false);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            for (ImageDisplay im : toWrite1) {
                out.println(im.toString());
            }
            
            for (bed_info bi : toWrite2) {
                out.println(bi.toString());
            }
            
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("Flower saved to file");
        return true;
    }

    //"readFlowerFromFile" is responsible for reading information in the Flower.txt line by line
    public static void readFlowerFromFile() {
        Path filePath = Paths.get("Flower.txt");
        if (!Files.exists(filePath)) {
            System.out.println("There is no file to read from.");
        }
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                if (line.startsWith("ImageDisplay")) {
                    flowerFromString(line);
                }
                else if (line.startsWith("flowerbed")) {
                    flowerbedFromString(line);
                    System.out.println(line);
                }
                else {
                    System.out.println("Bad line in file: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file:" + filePath);
            e.printStackTrace();
        }
    }

    //"flowerFromString" method is responsible for extracting all the data for flowers
    private static void flowerFromString(String line) {
        String data[] = line.split(",");
        String[] helper = new String[data.length];

        int myX = Integer.parseInt(data[1].substring(4));
        int myY = Integer.parseInt(data[2].substring(4));
        int myWidth = Integer.parseInt(data[3].substring(8));
        int myHeight = Integer.parseInt(data[4].substring(9));
        String myPath = data[5].substring(7);
        int myPattern = Integer.parseInt(data[6].substring(10));
        int flowerbed_No = Integer.parseInt(data[7].substring(13));

        Garden.addImage(myPath, myX, myY, myWidth, myHeight, myPattern, flowerbed_No);

    }
    
    //"flowerbedFromString" method is responsible for extracting all the data for flowerbedFrom
    private static void flowerbedFromString(String line){
        String data[] = line.split(",");
        String[] helper = new String[data.length];
        
        int flowerbed_No = Integer.parseInt(data[0].substring(13));
        int myX = Integer.parseInt(data[1].substring(4));
        int myY = Integer.parseInt(data[2].substring(4));
        int myWidth = Integer.parseInt(data[3].substring(8));
        int myHeight = Integer.parseInt(data[4].substring(9));

        Garden.addFlowerbeds(myX, myY, myWidth, myHeight, flowerbed_No);
        Garden.addFlowerbed_NO(flowerbed_No);
    }

}
