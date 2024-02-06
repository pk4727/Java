import java.util.*;
class sun
{
    int real;
    int imaginary;
    void input(int x, int y)
    {
    real = x;
    imaginary = y;
    }
    void display()
    {
    System.out.println("Complex = "+real+"+i"+imaginary);
    }
    sun add(sun a, sun b)
    {
    sun ans = new sun();
    ans.real = a.real+b.real;
    ans.imaginary = a.imaginary+b.imaginary;
    return ans;
    }
    void add(int a, int b)
    {
    System.out.println("Sum of two no. = "+(a+b));
    }
    void add(String m, String n)
    {
    System.out.println("Sum of two string = "+m+n);
    }
}
class sum_number_string_complex
{
    public static void main(String args[])
    {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter 4 no: ");
    int inp1 =sc.nextInt();
    int inp2 =sc.nextInt();
    int inp3 =sc.nextInt();
    int inp4 =sc.nextInt();
    sun c1 = new sun();
    sun c2 = new sun();
    sun c3 = new sun();
    c1.input(inp1,inp2);
    c2.input(inp3,inp4);
    c3=c3.add(c1,c2);
    c3.display();
    c3.add(4,6);
    c3.add("Pradhuman","Kumar");
    sc.close();                                                   // close scannner 
    }
}
