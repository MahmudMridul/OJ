
import static java.lang.System.out;
import java.util.Comparator;
import java.util.PriorityQueue;


public class PriorityQueue_Test 
{
    public static void main(String[] args) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new IntCom());
        
        
        
        Mother_Class mother = new Mother_Class();
        
        for(int i=0;i<10;++i) { pq.add(Mother_Class.getRandomInteger(1, 100)); }
        mother.printCollection(pq);
        
        
        while(!pq.isEmpty())
        {
            out.println(pq.poll());
        }
    }
}

class IntCom implements Comparator<Integer>
{
    /* for ascending order 1st - 2nd, for descending 2nd - 1st */
    @Override
    public int compare(Integer o1, Integer o2) 
    {
        return o1-o2;
    }
    
}