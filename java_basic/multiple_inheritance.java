class multiple_inheritance
{
    public static void main(String[] args)
    {
        son s=new son();
        System.out.println(" ");
        s.main1("talo mahto", "out of world");
        System.out.println(" ");
        s.main2("khirodhar mahto","patna");
        System.out.println(" ");
        s.main3("pradhuman kumar", "kolkata");
        System.out.println(" ");
    }
}
class grandfather
{
    int am=10000;
    void main1(String n,String l)
    {  
        System.out.println("name="+n); 
        System.out.println("location="+l); 
        System.out.println("totalamount="+am); 
    }
}
class father extends grandfather
{
    int p1=(40*am)/100;
    void main2(String n,String l)
    {  
        System.out.println("name="+n); 
        System.out.println("location="+l); 
        System.out.println("totalamount="+p1); 
    }
}
class son extends father
{
    void main3(String n,String l)
    {
        int p2=(40*p1)/100; 
        System.out.println("name="+n); 
        System.out.println("location="+l); 
        System.out.println("totalamount="+p2);  
    }
}

// // or ---------------------------------------------------------------------------------------------------------------------------------------------

// class money_cal
// {
//     public static void main(String[] args)
//     {
//         money s=new money();
//         System.out.println(" ");
//         s.grandfather("talo mahto", "out of world");
//         System.out.println(" ");
//         s.father("khirodhar mahto","patna");
//         System.out.println(" ");
//         s.son("pradhuman kumar", "kolkata");
//         System.out.println(" ");
//     }
// }
// class money
// {
//     int a=10000;
//     void grandfather(String n,String l)
//     {
//         System.out.println("name="+n); 
//         System.out.println("location="+l); 
//         System.out.println("totalamount="+a);   
//     }
//     void father(String n,String l)
//     {
//         int p1=(40*a)/100; 
//         System.out.println("name="+n); 
//         System.out.println("location="+l); 
//         System.out.println("totalamount="+p1);  
//     }
//     void son(String n,String l)
//     {
//         int p2=(((40*a)/100)*40)/100; 
//         System.out.println("name="+n); 
//         System.out.println("location="+l); 
//         System.out.println("totalamount="+p2);  
//     }
// }