
public class NestedWhileLoops
{
    
    public static void main(String[] args)
    {
        int i = 1;
        
        while (i < 3)
        {
            int x = 1;
            while (x < 5)
            {
                System.out.println(i + " " + x);
                x++;
            }
            i++;
        }
    }

}
