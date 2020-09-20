/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg8.object.inheritance;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Minhao.Jin17
 */
public class NewClass1 {
    public static String frequencySort(String s) {
        Map <Character,Integer> helper=new HashMap();
        String res="";
        for(char c:s.toCharArray()){
            helper.put(c,helper.getOrDefault(c, 0)+1);
        }
        List<Entry<Character, Integer>> list = new ArrayList<Entry<Character, Integer>>(helper.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				return (o2.getValue() - o1.getValue());
			}
		});
		
		for(Entry<Character, Integer> t:list){
			for(int i=0;i<t.getValue();i++){
                            res=res+t.getKey();
                        }
		}

        return res;
        
    }
    
    
    public static void main(String[] args){
        System.out.println(frequencySort("tree"));
             
}
    
}
