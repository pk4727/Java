import java.util.*;
class triangle
{
    double a,b,c;
    double area,peri;
    void input(double x,double y,double z)
    {
        a=x;b=y;c=z;}
    void area()
    {
        if(a==c&&b==c)
            area=(Math.sqrt(3)/4)*a*a;
        else if(a==b&&b!=c)
            area=(1.0/4)*c*(Math.sqrt((4*a*a)-(c*c)));
else if(b==c&&c!=a)
        area=(1.0/4)*a*(Math.sqrt((4*b*b)-(a*a)));
else if(a==c&&a!=b)
        area=(1.0/4)*b*(Math.sqrt((4*a*a)-(b*b)));
else
        {
            double s=(a+b+c)/2.0;
            area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
        }
    }
    void perimeter()
    {
        peri=a+b+c;
    }
    void display()
    {
        System.out.println("Area = "+area);
        System.out.println("Perimeter = "+peri);
    }
}
class area_perimeter_circle
{
   public static void main(String args[])
   {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter the sides:\n");
    double a=sc.nextDouble();
    double b=sc.nextDouble();
    double c=sc.nextDouble();
    triangle t=new triangle();
    t.input(a,b,c);
    t.area();
    t.perimeter();
    t.display();
    sc.close();                                                   // close scannner 
   }
}
