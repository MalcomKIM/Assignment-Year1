/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6cake;

import java.io.IOException;

/**
 *
 * @author Minhao.Jin17
 */
public class Week6Cake {
    private final String flavour;
    private final int slices;
    private final String colour;
    private final int candles;
    
    public Week6Cake(String flavour,int slices,String colour,int candles){
        this.flavour=flavour;
        this.slices=slices;
        this.colour=colour;
        this.candles=candles;
        
        CakeCutPlan ccp =new CakeCutPlan(slices);
        //System.out.println("week6 "+slices);
    }
    public String getFlavour(){
        return flavour;
    }
    
    public int getSlices(){
        return slices;
    }
    
    public String getColour(){
        return colour;
    }
    
    public int getCandles(){
        return candles;
    }
    

}
