// package java.java_basic;

abstract class A           
{
    protected int p=10;
    static final int f=100;
    abstract void put();
    void show()
    {
        System.out.println("public show pk");
    }
    static void show(int a)
    {
        System.out.println("static show pk");
    }
}
class B extends A                               // cant extend more than one class
{
    public void put()
    {
        System.out.println("put pk");
    }
    public static void main(String[] args) 
    {
        B b=new B();
        System.out.println(b.p);          // not static so give object of class  b
        System.out.println(A.f);          // static so give referance of class   A
        b.show();                         // not static so give object of class  b 
        A.show(10);                       // static so give referance of class   A
        b.put();
    }
}