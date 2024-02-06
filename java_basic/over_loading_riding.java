public class over_loading_riding 
{
    public void add(){}                 // method 
    public void add(int a){}            // method overloading
    public void add(int a,int b){}      // method overloading
}
class raugh1 extends over_loading_riding
{
    public void add(){}                 // method overriding
    public void add(int a){}            // method overriding
    public void add(int a,int b){}      // method overriding
}   
