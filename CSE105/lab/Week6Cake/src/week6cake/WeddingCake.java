/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6cake;

/**
 *
 * @author Minhao.Jin17
 */
public class WeddingCake extends Week6Cake{
    private final int tiers;
    private final String inscription;
    private final String flowerColours;
    
    public WeddingCake(int tiers,
            String inscription,
            String flowerColours,
            String flavour,
            int slices,
            String colour){
        super(flavour,slices,colour,0);
        this.tiers=tiers;
        this.inscription=inscription;
        this.flowerColours=flowerColours;
        
       // System.out.println("wedding "+slices);
    }
    
    
}
