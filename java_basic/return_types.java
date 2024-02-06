class sum
{
    int add(int a,int b)
    {
        return(a+b);
    }
    int add(int a,int b,int c)
    {
        return(a+b+c);
    }
    double add(double a,double b)
    {
        return(a+b);
    }
    void add(int a,int b,String s)
    {
        System.out.println(s+""+(a+b));
    }
}
class return_types
{
    public static void main(String arg[])
    {
        sum s=new sum();
        System.out.println(s.add(1,6));
        System.out.println(s.add(7,9,2));
        System.out.println(s.add(5.23,2.77));
        s.add(3,4,"HELLO WORLD");
    }
}
