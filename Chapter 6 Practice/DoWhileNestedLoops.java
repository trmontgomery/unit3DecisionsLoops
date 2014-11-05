
public class DoWhileNestedLoops
{
    
    public static void main(String[] args)
    {
        int i = 1;
        do 
        {
            int x = 1;
            do 
            {
                System.out.println(i + " " + x);
               x++;
            }
            while(x < 5);
            i++;
        }
        while(i < 3);
    }
}