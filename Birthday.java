//This is a Birthday Finder
import java.util.*;
public class Birthday {
   static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int b=0;
        System.out.println("---Birthday Guesser !---");
        for(int i=-0;i<sets.length;i++)
        {
            System.out.println("Does your Birthdate present in this table ? Y for yes and No for no");
            for(int j=0;j<sets[i].length;j++)
            {
                System.out.print(sets[i][j] + " ");
                if(((j+1)%4)==0) System.out.println();
            }
            String s=sc.nextLine();
            if (s.equalsIgnoreCase("y") || s.equalsIgnoreCase("n"))
            {
            if(s.equalsIgnoreCase("y")) {
                b+=(1<<i);
            }
        }
        else{
            System.out.println("Invalid Output-- Redirecting again");
            i--;
        }

        }
        System.out.println("Your Birhday is on : " + b);
    }
    static int[][] sets = {
        {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31},
        {2, 3, 6, 7, 10, 11, 14, 15, 18, 19, 22, 23, 26, 27, 30, 31},
        {4, 5, 6, 7, 12, 13, 14, 15, 20, 21, 22, 23, 28, 29, 30, 31},
        {8, 9, 10, 11, 12, 13, 14, 15, 24, 25, 26, 27, 28, 29, 30, 31},
        {16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31}
    };
    
}
