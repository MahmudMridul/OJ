
import static java.lang.System.out;
import java.util.TreeSet;


public class TreeSet_Test 
{
    
    public static void main(String[] args) 
    {
        TreeSet<Integer> set = new TreeSet<>();
        
        long start = System.currentTimeMillis();
        
        for(int i=0; i<10000000;++i) { set.add(i); }
        
        out.println(set.contains(10000000));
        
        
        
        long end = System.currentTimeMillis();
        out.println((end-start)*1.0 / 1000);
        out.println();
        
        
        
    }
    
}
