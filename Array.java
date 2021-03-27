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
}
