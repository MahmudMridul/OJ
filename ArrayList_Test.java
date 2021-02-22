
import static java.lang.System.out;
import java.util.ArrayList;

public class ArrayList_Test 
{
    public static void main(String[] args) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        Mother_Class mother = new Mother_Class();
        
        for(int i=0;i<10;++i)
        {
            list.add(i);
        }
        ArrayList<Integer> ar = new ArrayList<>();
        
        for(int i=10;i<=12;++i) { ar.add(i); }
        
        list.addAll(ar);
        
        mother.printCollection(list);
        
        out.println();
        
    }
}
