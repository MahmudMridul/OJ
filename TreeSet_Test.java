
import static java.lang.System.out;
import java.util.TreeSet;


public class TreeSet_Test 
{
    
    public static void main(String[] args) 
    {
        TreeSet<Integer> set = new TreeSet<>();
        Mother_Class mother = new Mother_Class();
        
        for(int i=0;i<10;++i) { set.add(Mother_Class.getRandomInteger(10, 100)); }
        mother.printCollection(set);
        
        set.add(30);
        mother.printCollection(set);
        
        out.println(set.ceiling(12));
        
        out.println(set.floor(50)); 
        
        
        
    }
    
}
