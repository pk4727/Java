class four_wheeler
{
    double h=50.0;
    double w=15055.0;
}
class public_transport extends four_wheeler
{
    int f;
    void f2(int fair)
    {
        f=fair;
    }
}
class bus extends public_transport
{
    int db;
    void f3(int duration)
    {
        db= duration;
        System.out.println("from bus:-");
        System.out.println("height "+h);
        System.out.println("weight "+w);
        System.out.println("fair "+f);
        System.out.println("duration "+db);
    }
}
class minibus extends public_transport
{
    void f4(String destination,String source)
    {
        String dmb=destination;
        String s=source;
        System.out.println("from minibus:-");
        System.out.println("height "+h);
        System.out.println("weigt "+w);
        System.out.println("fair "+f);
        System.out.println("destination "+dmb);
        System.out.println("source "+s);
    }
}
class private_transport extends four_wheeler
{
    double p;
    void f5(double petrol)
    {
        p=petrol;
    }
}
class tata extends private_transport
{
    String mfg;
    void f6(String mfg_place)
    {
        mfg=mfg_place;
        System.out.println("from tata:-");
        System.out.println("height "+h);
        System.out.println("weight "+w);
        System.out.println("petrol rate "+p);
        System.out.println("manufacturing place "+mfg);
    }
}
class maruti extends private_transport
{
    int m;
    void f7(int milage)
    {
        m=milage;
    }
}
class swift extends maruti
{
    void f8(int no_of_gear)
    {
        int n=no_of_gear;
        System.out.println("from swift:-");
        System.out.println("height "+h);
        System.out.println("weight "+w);
        System.out.println("petrol rate "+p);
        System.out.println("milage of maruti "+m);
        System.out.println("number of gear in maruti "+n);
    }
}
class desire extends maruti
{
    void f9(String color)
    {
        String c=color;
        System.out.println("from desir:-");
        System.out.println("height "+h);
        System.out.println("weight "+w);
        System.out.println("petrol rate "+p);
        System.out.println("milage of maruti "+m);
        System.out.println("color of desire "+c);
    }
}
class car_data
{
    public static void main(String[] args) {
        System.out.println(" ");
        bus b=new bus();
        b.f2(50);
        b.f3(2);

        System.out.println(" ");
        minibus m=new minibus();
        m.f2(50);
        m.f4("giridih", "pindatand");

        System.out.println(" ");
        tata t=new tata();
        t.f5(106.0);
        t.f6("jamsedpur");

        System.out.println(" ");
        swift s=new swift();
        s.f5(106.0);
        s.f7(45);
        s.f8(5);

        System.out.println(" ");
        desire d= new desire();
        d.f5(106.0);
        d.f7(45);
        d.f9("red");

        System.out.println(" ");
    }
}