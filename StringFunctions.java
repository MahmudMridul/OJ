
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
public class StringFunctions 
{
    public void KMP(String string, String pattern)
    {
        int[] lps = lps(pattern);
        int ins = 0, inp = 0;
        while(ins<string.length())
        {
            if(string.charAt(ins)==pattern.charAt(inp)) { ++ins; ++inp; }
            if(inp==pattern.length())
            {
                out.println("found at: "+(ins-inp));
                inp = lps[inp-1];
            }
            else if(ins<string.length() && string.charAt(ins)!=pattern.charAt(inp))
            {
                if(inp!=0)
                {
                    inp = lps[inp-1];
                }
                else{ ++ins; }
            }
        }
    }
    
    public int[] lps(String pattern)
    {
        int[] lps = new int[pattern.length()];
        
        if(pattern.length()>1)
        {
            int i = 0, j = 1;
            lps[0] = 0;
            while(j<lps.length)
            {
                if(pattern.charAt(i)==pattern.charAt(j))
                {
                    lps[j] = i+1; ++i; ++j;
                }
                else
                {
                    if(i!=0) { i = lps[i-1]; }
                    else { lps[j] = i; ++j; }
                }
            }
            return lps;
        }
        else 
        {
            return lps;
        }
    }
}

class Run
{
    public static void main(String[] args) 
    {
        StringFunctions sf = new StringFunctions();
        String string = "AAAAABAAABA";
        String pattern = "AAAA";
        sf.KMP(string, pattern);
    }
}