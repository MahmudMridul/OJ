
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static java.lang.System.out;
import java.util.Arrays;


public class InputTest 
{
    public static void main(String[] args) throws Exception
    {
        Reader read = new Reader("input.txt");
        long x = read.rint();
        out.println(x);
        long y = read.rlong();
        out.println(y);
    }
}

class Reader
{
    private DataInputStream dis;
    
    public Reader()
    {
        dis = new DataInputStream(System.in);
    }
    
    public Reader(String file) throws Exception
    {
        dis = new DataInputStream(new FileInputStream(file));
    }
    
    public int rint() throws Exception
    {
        int ret = 0;
        byte c = dis.readByte();
        while ((c <= 47 || c>=58) && c!=45) 
        {
            c = dis.readByte();
        }
        boolean neg = (c == '-');
        if (neg) { c = dis.readByte(); }
        do 
        {
            ret = ret * 10 + c - '0';
        } 
        while ((c = dis.readByte()) >= '0' && c <= '9');

        if (neg) { return -ret; }
        return ret;
    }
    
    public long rlong() throws Exception
    {
        long ret = 0;
        byte c = dis.readByte();
        while ((c <= 47 || c>=58) && c!=45) { c = dis.readByte(); }
        boolean neg = (c == '-');
        if (neg) { c = dis.readByte(); }
        do 
        {
            ret = ret * 10 + c - '0';
        } 
        while ((c = dis.readByte()) >= '0' && c <= '9');
        if (neg) { return -ret; }
        return ret;
    }
}