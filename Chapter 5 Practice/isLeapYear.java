import java.util.Scanner;

public class isLeapYear
{
    public static void main(String[] args)
    {
       Scanner year = new Scanner(System.in);
       System.out.println("Input year: ");
       int leap = year.nextInt();
        if (leap % 4 == 0 && !(leap%100 == 0) || leap%400 == 0)
        {    
           System.out.println("This is a leap year");
        }
    }

}
