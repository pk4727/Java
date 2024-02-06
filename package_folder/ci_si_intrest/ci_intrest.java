package ci_si_intrest;

public class ci_intrest
{
    double p,r,t,n;
    public void input(double a,double b,double c) 
    {
        p=a;
        r=n=b;
        t=c;
    }
    public void ci()
    {
        double i= p * (Math.pow((1 + r / 100), t)) - p;
        System.out.println("compound intrest is ="+i);
    }
}
