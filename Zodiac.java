//This is  a simple zodiac sign finder 
import java.util.*;
public class Zodiac {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("---Zodiac Sign Finder---");
        int day=day();
        int mon=mon();
        find(mon,day);

    }
    public static int day()
    {
        System.out.println("Enter your birth day(1-31)");
        int day=sc.nextInt();  
        if(day <1 || day>31)
        {
            System.out.println("wrong input try again !");
            day();
        } 
        return day;
    }
    public static int mon()
    {
        System.out.println("Enter your birth month(1-12)");
        int mon=sc.nextInt();   
        if(mon <1 || mon>12)
        {
            System.out.println("wrong input try again !");
            day();
        } 
        return mon;
    }
    public static void find(int mon, int day)
    {
        String zod="";
        String sym="";
        String ele="";
        if (mon == 3 && day >= 21 || mon == 4 && day <= 19) {
    zod = "Aries"; sym = "Ram"; ele = "Fire";
} else if (mon == 4 && day >= 20 || mon == 5 && day <= 20) {
    zod = "Taurus"; sym = "Bull"; ele = "Earth";
} else if (mon == 5 && day >= 21 || mon == 6 && day <= 20) {
    zod = "Gemini"; sym = "Twins"; ele = "Air";
} else if (mon == 6 && day >= 21 || mon == 7 && day <= 22) {
    zod = "Cancer"; sym = "Crab"; ele = "Water";
} else if (mon == 7 && day >= 23 || mon == 8 && day <= 22) {
    zod = "Leo"; sym = "Lion"; ele = "Fire";
} else if (mon == 8 && day >= 23 || mon == 9 && day <= 22) {
    zod = "Virgo"; sym = "Maiden"; ele = "Earth";
} else if (mon == 9 && day >= 23 || mon == 10 && day <= 22) {
    zod = "Libra"; sym = "Scales"; ele = "Air";
} else if (mon == 10 && day >= 23 || mon == 11 && day <= 21) {
    zod = "Scorpio"; sym = "Scorpion"; ele = "Water";
} else if (mon == 11 && day >= 22 || mon == 12 && day <= 21) {
    zod = "Sagittarius"; sym = "Archer"; ele = "Fire";
} else if (mon == 12 && day >= 22 || mon == 1 && day <= 19) {
    zod = "Capricorn"; sym = "Goat"; ele = "Earth";
} else if (mon == 1 && day >= 20 || mon == 2 && day <= 18) {
    zod = "Aquarius"; sym = "Water Bearer"; ele = "Air";
} else if (mon == 2 && day >= 19 || mon == 3 && day <= 20) {
    zod = "Pisces"; sym = "Fish"; ele = "Water";
} else {
    zod = "Invalid"; sym = "-"; ele = "-";
}

        System.out.println("----------\n---Predicting Zodiac Sign---");
        System.out.println("Based on you Birthdate : " + day + "-" + mon + "\nYour Zodiac Sign will be :" + zod + "\nElement : " + ele + "\nSymbol : " + sym);
        System.out.println("----------");
    }
}
