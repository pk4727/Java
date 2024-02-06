package ci_si_intrest;

public class si_intrest
{
    double p,r,t;
    public void input(double a,double b,double c) 
    {
        p=a;
        r=b;
        t=c;
    }
    public void si()
    {
        double i=(p*r*t)/100;
        System.out.println("simple intrest is ="+i);
    }
}