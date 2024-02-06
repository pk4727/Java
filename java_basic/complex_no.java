import java.util.*;
class complex
{
    int real,imagin;
    void input(int x,int y)
    {
        real=x;
        imagin=y;
    }
    void display()
    {
        System.out.println(real+"+"+imagin+"i");
    }
    complex add(complex a,complex b)
    {
        complex result=new complex();
        result.real=a.real+b.real;
        result.imagin=a.imagin+b.imagin;
        return result;
    }
}
class cp
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter real and imaginary part of Complex Number 1:\n");
        int a=sc.nextInt();
        int b=sc.nextInt();
        complex obj1=new complex();
        obj1.input(a,b);
        obj1.display();
        System.out.println("Enter real and imaginary part of complex number 2:\n");
        int c=sc.nextInt();
        int d=sc.nextInt();
        complex obj2=new complex();
        obj2.input(c,d);
        obj2.display();
        complex obj3=new complex();
        obj3=obj3.add(obj1,obj2);
        System.out.println("The result:\n");
        obj3.display();
        sc.close();                                                   // close scannner 
    }
}
