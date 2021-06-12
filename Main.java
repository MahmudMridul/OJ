import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.Map.Entry;



public class Main 
{
    public static int longestCommonSubstring(String s1, String s2)
    {
        char a[] = s1.toCharArray(), b[] = s2.toCharArray();
        int m = s1.length(), n = s2.length();
        
        int lookup[][] = new int[m+1][n+1];
        
        for(int i=1;i<=m;++i)
        {
            for(int j=1;j<=n;++j)
            {
                if(a[i-1]==b[j-1])
                {
                    lookup[i][j] = lookup[i-1][j-1] + 1;
                }
            }
        }
        int max = 0;
        
        for(int i=0;i<=m;++i)
        {
            for(int j=0;j<=n;++j)
            {
                max = Math.max(lookup[i][j], max);
            }
        }
        return max;
    }
    
    public static void main(String[] args) throws Exception
    {
        /*
        FileWriter writer = new FileWriter("input.txt");
        for(int i=1;i<=10000000;++i)
        {
            long a = Mother_Class.getRandomInteger(1, 100000000);
            long b = Mother_Class.getRandomInteger(1, 100000000);
            writer.write(a+" "+b+"\n");
        }        
        writer.close();*/
        
        long start = System.currentTimeMillis();
        Reader r = new Reader("input.txt");
        Print p = new Print();
        
        int test = r.rint();
        while(test-- >0)
        {
            String a = r.rstren(), b = r.rstren();
            
            int max = longestCommonSubstring(a, b);
            
            p.println((a.length()-max)+(b.length()-max));
        }
        
        
        
        long end = System.currentTimeMillis();
        p.println("Execution Time: "+(end-start)+"ms");
        p.close();
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

class CustomCompare implements Comparator<Pair>
{

    @Override
    public int compare(Pair o1, Pair o2) 
    {
        return o2.first - o1.first;
    }
    
}

class Triplet
{
    public int first;
    public int second;
    public int third;

    public Triplet(int first, int second, int third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public String toString()
    {
        return "{"+first+", "+second+", "+third+"}";
    }
}



class Reader 
{
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader()
    {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public Reader(String file_name) throws IOException
    {
        din = new DataInputStream(new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String rstren() throws IOException
    {
        byte[] buf = new byte[500000]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1) 
        {
            if (c=='\n' || c==13) 
            {
                if (cnt != 0) 
                {
                    break;
                }
                else 
                {
                    continue;
                }
            }
            buf[cnt++] = (byte)c;
        }
        return new String(buf, 0, cnt);
    }

    public int rint() throws IOException
    {
        int ret = 0;
        byte c = read();
        while ((c <= 47 || c>=58) && c!=45) 
        {
            c = read();
        }
        boolean neg = (c == '-');
        if (neg) { c = read(); }
        do 
        {
            ret = ret * 10 + c - '0';
        } 
        while ((c = read()) >= '0' && c <= '9');

        if (neg) { return -ret; }
        return ret;
    }

    public long rlong() throws IOException
    {
        long ret = 0;
        byte c = read();
        while ((c <= 47 || c>=58) && c!=45) { c = read(); }
        boolean neg = (c == '-');
        if (neg) { c = read(); }
        do 
        {
            ret = ret * 10 + c - '0';
        } 
        while ((c = read()) >= '0' && c <= '9');
        if (neg) { return -ret; }
        return ret;
    }

    public double rdouble() throws IOException
    {
        double ret = 0, div = 1;
        byte c = read();
        while ((c <= 47 || c>=58) && c!=45) { c = read(); }
        boolean neg = (c == '-');
        if (neg) { c = read(); }
        do 
        {
            ret = ret * 10 + c - '0';
        } 
        while ((c = read()) >= '0' && c <= '9');

        if (c == '.') 
        {
            while ((c = read()) >= '0' && c <= '9') 
            {
                ret += (c - '0') / (div *= 10);
            }
        }
        if (neg) { return -ret; }
        return ret;
    }

    private void fillBuffer() throws IOException
    {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1) { buffer[0] = -1; }
    }

    private byte read() throws IOException
    {
        if (bufferPointer == bytesRead) { fillBuffer(); }
        return buffer[bufferPointer++];
    }

    public void close() throws IOException
    {
        if (din == null) { return; }
        din.close();
    }
}

class Print
{
    private final BufferedWriter bw;
    public Print()
    {
        this.bw=new BufferedWriter(new OutputStreamWriter(System.out));
    }
    public void print(Object object)throws IOException
    {
        bw.append(""+object);
    }
    public void println(Object object)throws IOException
    {
        print(object);
        bw.append("\n");
    }
    public void close()throws IOException
    {
        bw.close();
    }
}
