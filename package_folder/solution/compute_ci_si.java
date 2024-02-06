class compute
{
    public static void main(String[] args) 
    {
        p1.si_intrest s=new p1.si_intrest();
        p1.ci_intrest t=new p1.ci_intrest();
        s.input(10000.0, 10.0, 5.0);
        s.si();
        t.input(10000.0, 10.0, 5.0);
        t.ci();
        System.out.println("computation done");
    }
}