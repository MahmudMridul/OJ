
import static java.lang.System.out;
import java.util.Comparator;
import java.util.PriorityQueue;


public class PriorityQueue_Test 
{
    public static void main(String[] args) 
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        
        
        Mother_Class mother = new Mother_Class();
        
        for(int i=0;i<10;++i) 
        {
            int x = Mother_Class.getRandomInteger(1, 50);
            int y = Mother_Class.getRandomInteger(51, 100);
            pq.add(new Pair(x,y)); 
        }
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
class Pair implements Comparable<Pair>
{
    public int first;
    public int second;

    public Pair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString()
    {
        return "{"+first+", "+second+"}";
    }

    @Override
    public int compareTo(Pair o) 
    {
        return this.second - o.second;
    }
}