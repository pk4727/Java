import java.util.*;
class Complex
    {
        int real,imaginary;
        //static int count;
        Complex()
        {
        real = 0;
        imaginary=0;
        //count++;
        }
        Complex(int x,int y)
        {
        real = x;
        imaginary = y;
        //count++;
        }
        void display()
        {
        System.out.println(real+"+i"+imaginary);
        //System.out.println(count);
        }
        Complex add(Complex a, Complex b)
        {
        Complex sum = new Complex();
        sum.real = a.real+b.real;
        sum.imaginary = a.imaginary+b.imaginary;
        return sum;
        }
    }
class complex_no_sum
{
    public static void main(String arg[])
    {
    Scanner sc= new Scanner(System.in);
    System.out.println("Enter 4 number ");
    int input1= sc.nextInt();
    int input2= sc.nextInt();
    int input3= sc.nextInt();
    int input4= sc.nextInt();
    Complex c1 = new Complex(input1,input2);
    Complex c2= new Complex(input3,input4);
    Complex c3 = new Complex();
    c3=c3.add(c1,c2);
    c3.display();
    sc.close();                                                   // close scannner 
    }
}
