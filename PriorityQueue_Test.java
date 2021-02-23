
import static java.lang.System.out;
import java.util.Comparator;
import java.util.PriorityQueue;


public class PriorityQueue_Test 
{
    public static void main(String[] args) 
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new CustomCompare());
        
        
        
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

class CustomCompare implements Comparator<Pair>
{

    @Override
    public int compare(Pair o1, Pair o2) 
    {
        return o2.first - o1.first;
    }
    
}

class Pair
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
}