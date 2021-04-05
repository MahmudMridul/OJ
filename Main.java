import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.out;
import java.util.*;
import java.util.Map.Entry;



public class Main 
{
    
    
    public static void main(String[] args) throws Exception
    {
        
        FileWriter writer = new FileWriter("input.txt");
        for(int i=1;i<=10000000;++i)
        {
            long a = Mother_Class.getRandomInteger(1, 100000000);
            long b = Mother_Class.getRandomInteger(1, 100000000);
            writer.write(a+" "+b+"\n");
        }        
        writer.close();
        
        
        
        long start = System.currentTimeMillis();
        
        Reader read = new Reader("input.txt");
        for(int i=0;i<200000;++i)
        {
            long a = read.rlong(), b = read.rlong();
        }
        
        long end = System.currentTimeMillis();
        out.println("Execution Time: "+(end-start)+"ms");
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
        return o1.first - o2.first;
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
        din = new DataInputStream(
            new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String rstr() throws IOException
    {
        byte[] buf = new byte[500000]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1) 
        {
            if (c == '\n') 
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
        while (c <= ' ') 
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
        while (c <= ' ') { c = read(); }
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
        while (c <= ' ') { c = read(); }
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


