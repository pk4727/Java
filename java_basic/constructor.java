class constructor
{
    int a,b;
    constructor()
    {
        a=b=1;
    }
    constructor(int x,int y)
    {
        a=x;
        b=y;
    }
    constructor(constructor x)
    {
        a=x.a;
        b=x.b;
    }
    void display()
    {
        System.out.println("value of:\na= "+a+"\nb="+b);
    }
    public static void main(String args[])
    {
        constructor c1=new constructor();
        constructor c2=new constructor(5,6);
        constructor c3=new constructor(c1);
        System.out.println("for 1st object:");
        c1.display();
        System.out.println("for 2nd object:");
        c2.display();
        System.out.println("for 3rd object:");
        c3.display();
    }
}
