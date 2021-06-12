import static java.lang.System.out;
import java.util.HashSet;


public class HashSet_Test 
{
    public static void main(String[] args) 
    {
        HashSet<Integer> set = new HashSet<>();
        
        
        
        for(int i=0;i<10000000;++i)
        {
            set.add(i);
        }
        long start = System.currentTimeMillis();
        
        out.println(set.contains(10000000));
        
        long end = System.currentTimeMillis();
        
        out.println((end-start)*1.0 / 1000);
       
    }
}
