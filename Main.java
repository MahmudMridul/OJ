import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.out;
import java.util.*;



public class Main 
{
    
    public static void main(String[] args) throws Exception
    {
        
        long start = System.currentTimeMillis();
        
        /*
        FileWriter writer = new FileWriter("input.txt");
        
        for(int i=0;i<1000;++i)
        {
            int val = Mother_Class.getRandomInteger(1, 100000);
            writer.write(val+"\n");
            for(int j=0;j<val;++j)
            {
                writer.write(j+" ");
            }
            writer.write("\n");
        }
        
        writer.close();
        */
        
        
        Reader read = new Reader("input.txt");
        
        int profile = 0, pairs = 0;
        profile = read.inte();
        pairs = read.inte();
      
        if(profile==pairs) { out.println(profile); }
        else if(pairs==0) { out.println(profile); }
        else
        {
            HashSet<Integer>[] flist = new HashSet[profile+1];
        
            for(int i=1;i<=pairs;++i)
            {

                int u = read.inte(), v = read.inte();

                if(flist[u]==null) { flist[u] = new HashSet(); }
                if(flist[v]==null) { flist[v] = new HashSet(); }

                flist[u].add(v); flist[v].add(u);
            }

            /*
            for(int i=0;i<flist.length;++i)
            {
                new Mother_Class<>().printCollection((Collection)flist[i]);
            }*/

            int count = 0;
            for(int i=1;i<=profile-1;++i)
            {
                for(int j=i+1;j<=profile;++j)
                {
                    for(int k=1;k<=profile;++k)
                    {
                        if(flist[i]!=null && flist[j]!=null)
                        {
                            if( (flist[i].contains(k) && flist[j].contains(k)) || (!flist[i].contains(k) && !flist[j].contains(k)) )
                            {
                                ++count; break;
                            }
                        }
                    }
                }
            }
            out.println(count);
        }
        
        
        
        long end = System.currentTimeMillis();
        
        out.println((end-start)*1.0 / 1000);
        
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

    public String stren() throws IOException
    {
        byte[] buf = new byte[500]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') {
                if (cnt != 0) {
                    break;
                }
                else {
                    continue;
                }
            }
            buf[cnt++] = (byte)c;
        }
        return new String(buf, 0, cnt);
    }

    public String strsp() throws IOException
    {
        byte[] buf = new byte[500]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == ' ' || c == '\n') {
                if (cnt != 0) {
                    break;
                }
                else {
                    continue;
                }
            }
            buf[cnt++] = (byte)c;
        }
        return new String(buf, 0, cnt);
    }

    public int inte() throws IOException
    {
        int ret = 0;
        byte c = read();
        while (c <= ' ') {
            c = read();
        }
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');

        if (neg)
            return -ret;
        return ret;
    }

    public long lon() throws IOException
    {
        long ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg)
            return -ret;
        return ret;
    }

    public double dbl() throws IOException
    {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();

        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');

        if (c == '.') {
            while ((c = read()) >= '0' && c <= '9') {
                ret += (c - '0') / (div *= 10);
            }
        }

        if (neg)
            return -ret;
        return ret;
    }

    private void fillBuffer() throws IOException
    {
        bytesRead = din.read(buffer, bufferPointer = 0,
                             BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws IOException
    {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }

    public void close() throws IOException
    {
        if (din == null)
            return;
        din.close();
    }
}