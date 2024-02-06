import java.util.Scanner;

class AA
{
    void check(double A,double B)
    {
        try
        {
            double f=(9*A+B*3.14)/(A-B);
            System.out.println("value is "+f);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
class f
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the value of A: ");
        double A=sc.nextDouble();
        System.out.println("enter the value of B: ");
        double B=sc.nextDouble();
        AA a=new AA();
        a.check(A,B);
        sc.close();
    }
}