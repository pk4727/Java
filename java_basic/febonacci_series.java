import java.util.*;
class febonacci_series
{
    public static void main(String args[])
    {
        int a = 0, b = 1, c, n;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no. of terms");
        n = sc.nextInt();
        c = a+b;
        System.out.print(a+"\t"+b+"\t"+c);
        for(;n>3;n--)
        {
            a = b;
            b = c;
            c = a+b;
            System.out.print("\t"+c);
            sc.close();                                                   // close scannner 
        }
    }
}
