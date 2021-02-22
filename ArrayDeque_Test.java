
import java.util.ArrayDeque;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class ArrayDeque_Test 
{
    public static void main(String[] args) 
    {
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        Mother_Class mother = new Mother_Class();
        
        
        for(int i=0;i<10;++i) { deq.add(i); }
        mother.printCollection(deq);
        
        deq.addFirst(100);
        deq.addLast(200);
        
        mother.printCollection(deq);
        
        deq.pollFirst();
        deq.pollLast();
        
        mother.printCollection(deq);
    }
}
