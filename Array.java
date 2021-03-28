
import static java.lang.System.out;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Array 
{
    
    public int[] reverseArray(int[] arr)
    {
        int left = 0, right = arr.length-1;
        while(left<right)
        {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            ++left; --right;
        }
        return arr;
    }
    
    public int[] max_min(int[] arr)
    {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;++i)
        {
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }
        return new int[] {min, max};
    }
    
    public int[] kth_maxmin(int[] arr, int k)
    {
        if(k>=0 && k<=arr.length)
        {
            Arrays.sort(arr);
            return new int[] { arr[k+1], arr[arr.length-k] };
        }
        else
        {
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };
        }
        
    }
    
    public int[] arrayofZeroOneTwo(int[] ar)
    {
        int current = 0;
        for(int elem = 0; elem<3;++elem)
        {
            for(int i=0;i<ar.length;++i)
            {
                if(ar[i]==elem)
                {
                    int temp = ar[current];
                    ar[current] = ar[i];
                    ar[i] = temp;
                    ++current;
                }
            }
        }
        return ar;
    }
}

class Run
{
    public static void main(String[] args) 
    {
        Array array = new Array();
        int[] a = {1,2,0,2,1,0,2,1,1,2,0,1};
        a = array.arrayofZeroOneTwo(a);
        out.println(Arrays.toString(a));
    }
}