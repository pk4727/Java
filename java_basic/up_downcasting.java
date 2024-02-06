class parent
{
    void show()
    {
        System.out.println("show parent");
    }
    void v()
    {
        System.out.println("v parent");
    }
}

class child extends parent
{
    void show()
    {
        System.out.println("show child");
    }
    void vv()
    {
        System.out.println("vv child");
    }
}

class up_downcasting
{
    public static void main(String[] args) 
    {
        parent pp=new parent();         //                      ------> normal object process
        pp.show();                      // show parent
        pp.v();                         // v parent

        parent p=new child();           //                      ------> upcasting
        p.show();                       // show child
        p.v();                          // v parent
        ((child)p).vv();                // vv child             ------> downcasting without reference variable

        child c=(child)p;               //                      ------> downcasting with reference variable
        c.show();                       // show child
        c.v();                          // v parent
        c.vv();                         // vv child
    }
}