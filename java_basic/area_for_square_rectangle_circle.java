class figure
{
    double create(double a)
    {
        return(a*a);
    }
    double create(double a,double b)
    {
        return(a*b);
    }
    double create(double r,String s)
    {
        return(3.14*r*r);
    }
}
class area_for_square_rectangle_circle
{
    public static void main(String args[])
    {
        figure f=new figure();
        System.out.println("Area of Square : "+f.create(5));
        System.out.println("Area of rectangle : "+f.create(10.0,8.0));
        System.out.println("Area of circle : "+f.create(7.0,"c"));
    }
}
