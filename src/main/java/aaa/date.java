package aaa;

import java.util.*;
/**
 * To store the departure day and time 
 */
public class date {
    public int dd , mm ,yyyy;
    public int hrs , min ;
    /**
     * constructor parameterized
     * @param dd
     * @param mm
     * @param yyyy
     * @param hrs
     * @param min
     */
    public date(int dd ,int  mm ,int  yyyy,int  hrs , int min )
    {
        this.dd = dd;
        this.mm = mm;
        this.yyyy  = yyyy;
        this.hrs = hrs;
        this.min = min;
    }
    /**
     * constructing the object using interactive terminal window 
     * @param sc
     */
    public date(Scanner sc )
    {
        System.out.print("Enter date in dd mm yyyy format :");
        dd =sc.nextInt();
        mm =sc.nextInt();
        yyyy = sc.nextInt();

        System.out.print("Enter time in hrs min format :");
        hrs = sc.nextInt();
        min = sc.nextInt();
        
    }
}
