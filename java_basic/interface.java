interface a           // fully abstract 
{
    int aa=5;        // public static final
    void b(int a);   //public abstract
    void c(int b);   //public abstract
}

interface b{}
interface c{}

class bb implements a,b,c                     // can be implements more than one class
{
    // a.aa=55;
    public void d()
    {
        System.out.println(aa);
    }
    public void b(int a)
    {
        System.out.println(a);
    }
    public void c(int b)
    {
        System.out.println(b);
    }
}
class p
{
    public static void main(String[] args) {
        bb b=new bb();
        b.d();
        b.b(10);
        b.c(11);
    }
}