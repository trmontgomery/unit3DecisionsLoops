import java.util.Scanner;
public class CircleOverlap
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);

      System.out.print("Input the radius of the first circle: ");
      double radius1 = in.nextDouble(); 
      double xcenter1 = 0;
      double ycenter1 = 0;
      System.out.print("Input the radius of the second circle: ");
      double radius2 = in.nextDouble(); 
      double xcenter2 = 40;
      double ycenter2 = 0;

    if (radius1 >= 40 + radius2 || radius2 >= 40 + radius1)
    {
        System.out.println("Circles are mutually contained"); 
    }
    if (radius1 + radius2 >= 40 && !(radius1 >= 40 + radius2 || radius2 >= 40 + radius1))
    {
        System.out.println("Circles overlap.");
    }
    if (radius1 + radius2 < 40)
    {
        System.out.println("Circles do not overlap.");
    }
   }
}
