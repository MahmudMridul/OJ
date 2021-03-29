import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Mother_Class<E>
{
    public static void printArray(int[] a)
    {
        for(int elem : a)
        {
            out.print(elem+" ");
        }
        out.println();
    }
    
    public void printCollection(Collection<E> list)
    {
        if(list!=null)
        {
            Iterator it = list.iterator();
            while(it.hasNext())
            {
                out.print(it.next()+" ");
            }
            out.println();
        }
        else { out.println("Collection is null"); }
    }
    
    
    
    public static void printMatrix(int[][] mat)
    {
        for(int i=0;i<mat.length;++i)
        {
            for(int j=0;j<mat[i].length;++j)
            {
                out.print(mat[i][j]+" ");
            }
            out.println();
        }
    }
    
    public static int[] reverse(int[] a)
    {
        for(int i=0,j=a.length-1; i<j;++i,--j)
        {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        return a;
    }
    
    public static boolean[] generatePrime(int n)
    {
        boolean[] notPrime = new boolean[n+1]; notPrime[0] = notPrime[1] = true; int m = (int)Math.ceil(Math.sqrt(n));
        for(int i=3; i<=m; i+=2)
        {
            if(notPrime[i]==false && i*i<=n)
            {
                for(int j=i*i; j<=n; j+=2*i)
                {
                    notPrime[j] = true;
                }
            }
        }
        return notPrime;
    }
    
    public static int number_of_digits(int n)
    {
        return (int)Math.floor(Math.log10(n)) + 1;
    }
    public static boolean isPowerofTwo(int num)
    {
        return (num!=0) && ((num&(num-1)) == 0);
    }
    public static int smallestDivofOdd(int num)
    {
        int upto = (int)Math.ceil(Math.sqrt(num));
        for(int n = 3; n<=upto; n+=2)
        {
            if(num%n==0) { return n; }
        }
        return num;
    }
    
    public static int getRandomInteger(int min, int max)
    {
        return new Random().nextInt((max-min+1))+min;
    }
    
    public static double getRandomDouble(int min, int max)
    {
        return (new Random().nextInt(max-min+1)+min + new Random().nextDouble());
    }
    
    public static int[] generateArray_Int(int n, int min, int max)
    {
        int[] a = new int[n];
        
        for(int i=0;i<a.length;++i)
        {
            a[i] = new Random().nextInt((max-min+1))+min;
        }
        
        return a;
    }
    
    public static double[] generateArray_Double(int n, double min, double max)
    {
        double[] a = new double[n];
        int[] b = new int[n];
        
        for(int i=0;i<a.length;++i)
        {
            a[i] = new Random().nextDouble();
        }
        
        b = generateArray_Int(n, (int)min, (int)max);
        
        for(int i=0;i<a.length;++i)
        {
            a[i]+= b[i]*1.0;
        }
        
        return a;
    }
    
    public static void lowerCase(int n)
    {
        StringBuilder st = new StringBuilder();
        
        for(int i=0;i<n;++i)
        {
            int num = new Random().nextInt((122-97+1))+97;
            st.append((char)num);
        }
        
        out.println(st);
    }
    
    public static void upperCase(int n)
    {
        StringBuilder st = new StringBuilder();
        
        for(int i=0;i<n;++i)
        {
            int num = new Random().nextInt((90-65+1))+65;
            st.append((char)num);
        }
        
        out.println(st);
    }
    
    public static void mixCase(int n)
    {
        StringBuilder st = new StringBuilder();
        
        while(st.length()<n)
        {
            int num = new Random().nextInt((122-65+1))+65;
            
            if((num>=65 && num<=90) || (num>=97 && num<=122))
            {
                st.append((char)num);
            }
        }
        
        out.println(st);
    }
    
    
    public static void all_subset(int index, int[] a, int s)
    {
        if(index>=a.length) 
        { 
            if(s>0)
            return; 
        }
        
        all_subset(index+1, a, s+a[index]);
        all_subset(index+1, a, s);
        
    }
    
    public static void all_permutation(String s)
    {
        permutation(s,"");
    }
    
    private static void permutation(String s, String pre)
    {
        if(s.length()==0) { out.println(pre); }
        else
        {
            for(int i=0;i<s.length();++i)
            {
                String rem = s.substring(0, i) + s.substring(i+1);
                permutation(rem, pre+s.charAt(i));
            }
        }
    }
    
    public static ArrayList<StringBuilder> tokenize(StringBuilder str)
    {
        ArrayList<StringBuilder> tokens = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        
        for(int chr = 0; chr < str.length(); ++chr)
        {
            if(str.charAt(chr)==' ')
            {
                tokens.add(word);
                word = new StringBuilder();
            }
            else if(chr==str.length()-1)
            {
                word.append(str.charAt(chr));
                tokens.add(word);
            }
            else
            {
                word.append(str.charAt(chr));
            }
        }
        return tokens;
    }
    
    public static long[] stringHash(String str)
    {
        int mod_1 = 1000000007;
        int mod_2 = Integer.MAX_VALUE;
        int base_1 = 29;
        int base_2 = 31;
        long p1 = 1;
        long p2 = 1;
        
        long[] hash = {0,0};
        char[] array = str.toCharArray();
        
        for(int i=0;i<array.length;++i)
        {
            int digit = array[i] - 'a' + 1;
            long h_val = (digit * p1);
            hash[0] = (hash[0] + h_val) % mod_1;
            p1 = (p1 * base_1 ) % mod_1;
            
            h_val = (digit * p2) % mod_2;
            hash[1] = (hash[1] + h_val) % mod_2;
            p2 =  (p2 * base_2 ) % mod_2;
        }
        
        return hash;
    }
}
