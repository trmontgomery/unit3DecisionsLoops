import java.util.Scanner;

public class FindFirstMatch
{
   /**
    * Computes the index of the first space (' ') in the string, if any
    */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string.");
        String str = in.nextLine();
        
        char ch = '$';
        int index = 0;
        while (index < str.length() )
        {
            char ch = str.charAt(index);
            if (ch == ' ')
            {
                break;
            }
            
            index++;
        }
        
        if(ch == ' ')
        {
            System.out.println("Index of first space: " + index);
        }
    }

}
