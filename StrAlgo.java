
import static java.lang.System.out;
import java.util.ArrayList;
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
public class StrAlgo 
{
    public void bruteForcePatternMatch(String string, String pattern)
    {
        for(int i=0;i<string.length();++i)
        {
            if(string.charAt(i)==pattern.charAt(0))
            {
                int stIn = i, pattIn = 0;
                while(pattIn<pattern.length())
                {
                    if(string.charAt(stIn)!=pattern.charAt(pattIn)) { break; }
                    ++stIn; ++pattIn;
                    if(stIn>=string.length()) { break; }
                }
                if(pattIn==pattern.length()) { out.println("Match found at: "+(i)); }
            }
        }
    }
    
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

class TrieNode
{
    char ch;
    ArrayList<Character> children;
    
    public TrieNode(char ch)
    {
        this.ch = ch;
    }
}

class StrTrie
{
    TrieNode root;
    
    public StrTrie()
    {
        root = new TrieNode('*');
        
    }
    
    public void buildTrie(String[] patts)
    {
        root.children = new ArrayList<>(patts.length);
        
        for(int i=0;i<patts.length;++i)
        {
            String pattern = patts[i];
            
            for(int ch=0;ch<pattern.length();++ch)
            {
                char chr = pattern.charAt(ch);
            }
        }
    }
}

class Run
{
    public static void main(String[] args) 
    {
        StrAlgo sf = new StrAlgo();
        String string = "1010100100";
        String pattern = "100";
        sf.bruteForcePatternMatch(string, pattern);
    }
}