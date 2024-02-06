import java.util.*;
class tria
{
    int side1;
    int side2;
    int side3;
    tria(int x, int y, int z)
    {
    side1 = x;
    side2 = y;
    side3 = z;
    System.out.println("Triangle is Scaler, and sides are " + side1 + "," + side2 +"and" + side3);
    }
    tria(int x, int y)
    {
    side1 = side2 = x;
    side3 = y;
    System.out.println("Triangle is Isosceles, and sides are " + side1 + "," +side2
    + " and " + side3);
    }
    tria(int x)
    {
    side1 = side2 = side3 = x;
    System.out.println("Triangle is Equilateral, and sides are " + side1 + "," +
    side2 + " and " + side3);
    }
}
class triangle_types_check
{
    public static void main(String args[])
    {
        try
        {
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter 3 sides ");
            // int input1= sc.nextInt();
            // int input2= sc.nextInt();
            // int input3= sc.nextInt();
            // tria t1 = new tria(input1);
            // tria t2 = new tria(input1, input2);
            // tria t3 = new tria(input1, input2, input3);
            sc.close();                                        // close scannner
        }
        catch(Exception e)  
        {
            System.out.println(e);
        }
    }
}
