
import static java.lang.System.out;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

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
    boolean isLeaf;
    ArrayList<TrieNode> children;
    
    public TrieNode(char ch)
    {
        this.ch = ch;
        isLeaf = false;
    }
}

class StrTrie
{
    /* in a standard trie no pattern can be a prefix of other */
    TrieNode root;
    
    public StrTrie()
    {
        root = new TrieNode('*');
    }
    
    /* searches for a character in the list of children of a node, if found returns index
    otherwise returns -1 */
    public int search(ArrayList<TrieNode> children, char ch)
    {
        if(children==null) { return -1; }
        else
        {
            for(int i=0;i<children.size();++i)
            {
                if(children.get(i).ch==ch) { return i; }
            }
            return -1;
        }
    }
    
    public void buildTrie(String[] patts)
    {
        root.children = new ArrayList<>(patts.length);
        
        for(int i=0;i<patts.length;++i)
        {
            String pattern = patts[i];
            insert(root, pattern, 0);
        }
    }
    
    public void insert(TrieNode node, String pattern, int index)
    {
        if(index>=pattern.length()) { return; }
        else 
        {
            int ind = search(node.children, pattern.charAt(index));
            if(ind!=-1)
            {
                insert(node.children.get(ind), pattern, index+1);
            }
            else
            {
                TrieNode n = new TrieNode(pattern.charAt(index));
                if(node.children==null) { node.children = new ArrayList<>(10); }
                node.children.add(n);
                if(index+1>=pattern.length()) { n.isLeaf = true; return; }
                insert(n, pattern, index+1);
            }
        }
    }
    
    public void bfs()
    {
        Queue<TrieNode> que = new ArrayDeque();
        que.add(root);
        
        while(!que.isEmpty())
        {
            TrieNode curr = que.remove();
            out.println(curr.ch);
            
            ArrayList<TrieNode> children = curr.children;
            if(children!=null)
            {
                for(int i=0;i<children.size();++i)
                {
                    que.add(children.get(i));
                }
            }
        }
    }
    
    public void searchTrie(String string)
    {
        int strLen = string.length();
        TrieNode node = root;
        for(int i=0;i<strLen;++i)
        {
            char currChar = string.charAt(i);
            int currIndex = i;
            node = root;
            int index = search(node.children, currChar);
            if(index!=-1)
            {
                while(true)
                {
                    node = node.children.get(index);
                    if(node.isLeaf) { out.println("Pattern found at index "+i); break; }
                    
                    ++currIndex;
                    if(currIndex>=strLen) { break; }
                    
                    currChar = string.charAt(currIndex);
                    index = search(node.children, currChar);
                    
                    if(index==-1) { break; }
                }
            }
        }
    }
}

class Run
{
    public static void main(String[] args) 
    {
        StrAlgo sf = new StrAlgo();
        String[] string = {"anilo", "abde", "abcd", "bcfg", "bcon", "cmdi", "cmug", "anilm"};
        StrTrie trie = new StrTrie();
        trie.buildTrie(string);
        String str = "aniloabdeabcdbcfgbconcmdicmuganilm";
        trie.searchTrie(str);
        
    }
}