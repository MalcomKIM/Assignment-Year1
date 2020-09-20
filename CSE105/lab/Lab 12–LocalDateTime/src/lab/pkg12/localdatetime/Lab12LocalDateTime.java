/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg12.localdatetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author minhao.jin17
 */
public class Lab12LocalDateTime {
    static ArrayList<Event> events=new ArrayList();
    static Scanner kb=new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Event party = new Event("Party with friends",LocalDateTime.of(2017, Month.JULY, 25, 18, 0),LocalDateTime.of(2017, Month.JULY, 26, 0, 0));
        events.add(party);
        Event Summer_holiday = new Event("Summer holiday",LocalDateTime.of(2017, Month.AUGUST, 11, 0, 0),LocalDateTime.of(2017, Month.SEPTEMBER, 1, 0, 0));
        events.add(Summer_holiday);
        Event Spring_Semester = new Event("Spring Semester",LocalDateTime.of(2017, Month.FEBRUARY, 1, 0, 0),LocalDateTime.of(2017, Month.JUNE, 14, 0, 0));
        events.add(Spring_Semester);
        Event eating_lunch = new Event("eating_lunch",LocalDateTime.of(2017, Month.DECEMBER, 1, 12, 0),LocalDateTime.of(2017, Month.DECEMBER, 1, 13, 0));
        events.add(eating_lunch);
        Event eating_dinner = new Event("eating_dinner",LocalDateTime.of(2017, Month.DECEMBER,1, 5, 30),LocalDateTime.of(2017, Month.DECEMBER,1, 6, 30));
        events.add(eating_dinner);
        
        Iterator it=events.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());
            System.out.println("\t***");
        }
        
        System.out.println("Looking for event that happens on");
        String target=kb.nextLine();
        
        System.out.println(search(target));

        
        
    }
    
    public static String search(String target){
  
        String data[]=target.split("-");
        int year =Integer.parseInt(data[0]);
        int month=Integer.parseInt(data[1]);
        int day=Integer.parseInt(data[2]);
        
        LocalDate t=LocalDate.of(year, month, day);
            for(Event i:events){
                if(i.periodOverlaps(t)){
                    return i.toString()+" ";
                }
            }
        
        return "No events on the chosen date"+target;
    }
    
}
