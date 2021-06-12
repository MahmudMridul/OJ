
import static java.lang.System.out;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class HashMap_Test 
{
    public static void main(String[] args) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(0, 5);
        map.put(1, 1);
        map.put(7, 7);
        map.put(2, 1);
        map.put(3, 21);
        map.put(10, 16);
        map.put(9, 13);
        Iterator<Entry<Integer, Integer>> iter = map.entrySet().iterator();
        while(iter.hasNext())
        {
            Entry<Integer, Integer> entry = iter.next();
            out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
