// use one keyword from this all code at a time.

 // static variable / method -----------------------------------------------------------------------------------------------------

 public class keywordss
 {
     public static void main(String[] args)
     {
         aaa.ar(10, 10);
     }
 }
 class aaa
 {
     static int a=12;
     public static int ar(int l,int b)
     {
         System.out.println(a++);
         return l*b;
     }
 }


// // final variable / method / class -----------------------------------------------------------------------------------------------
// // 
// public class raugh
// {
//     final void a()
//     {
//         System.out.println("final method");
//     }
//     public static void main(String[] args) 
//     {
//         final int b=10; 
//         b=b+10;     //not possible to change final variable
//         System.out.println(b);
//     }
// }
// final class a extends raugh
// {
//     void a()            //Cannot override the final method from raugh
//     {
//         System.out.println("other class final");
//     }
// }
// class b extends a       //The type b cannot subclass the final class a
// {
//     void aa()
//     {
//         System.out.println("other final class");
//     }
// }


// // this keyword (refer to the current class object)-------------------------------------------------------------------------------
// // super keyword (refer to the parent class object)

// class raugh
// {
//     raugh()
//     {
//         System.out.println("from raugh");
//     }
//     int a=15;
//     void aa()
//     {
//         System.out.println("from raugh");
//     }
// }
// class a extends raugh
// {
//     a()
//     {
//         super();
//         System.out.println("from a");
//     }
//     int a=20;
//     void aa()
//     {
//         System.out.println("from a");
//     }
//     void show(int a)
//     {
//         System.out.println(a);          // 30
//         System.out.println(this.a);     // 20
//         System.out.println(super.a);    // 15
//         aa();                           // from a
//         super.aa();                     // from raugh
//     }
//     public static void main(String[] args) 
//     {
//         a ao=new a();                    // from raugh
//                                          // from a
//         ao.show(30);
//     }
// }


// // try_catch blocks (for defined exception handling)----------------------------------------------------------------------------------

// class a
// {
//     public static void main(String[] args) 
//     {
//         a aa=new a();
//         aa.aa();

//         int a=100,b=0,c;
//         try
//         {
//         c=a/b;
//         System.out.println(c);
//         }
//         catch(Exception e){System.out.println(e);}
//         System.out.println("main");
//     }
//     void aa()
//     {
//         try
//         {
//         int a=100,b=0,c;
//         c=a/b;
//         System.out.println(c);
//         }
//         catch(Exception e)
//         {
//             System.out.println(e);
//         }
//         System.out.println("method");
//     }
// }


// // finally block (always executed either exception occur or not) ----------------------------------------------------------------

// class a
// {
//     public static void main(String[] args) 
//     {
//         a aa=new a();
//         aa.aa();
//     }
//     void aa()
//     {
//         try
//         {
//         // int a=100,b=10,c;     // try run
//         int a=100,b=0,c;      // catch run
//         c=a/b;
//         System.out.println("try "+c);
//         }
//         catch(Exception e)
//         {
//             System.out.println("catch\n "+ e);
//         }
//         finally
//         {
//         System.out.println("finally");
//         }
//     }
// // }


// // throw keyword (for costumized exception create by user with the help of extending RuntimeException but not handle exception so
// // call by creating object of custumized exception class and handel by try_catch)------------------------------------------------------

// import java.util.Scanner;
// class exception extends RuntimeException
// // {
//     exception(String msg)
//     {
//         super(msg);
//     }
// // }
// class a 
// // {
//     public static void main(String[] args)
//     {
//         Scanner sc= new Scanner(System.in);
//         System.out.println("enter age");
//         int a=sc.nextInt();
//         sc.close();
//         try
//         {
//         if(a<18)
//         {
//             System.out.println("yes < 18");
//             throw new exception("error in age less than 18");
//         }
//         else
//         {
//             System.out.println("yes > 18");
//         }
//         }
//         catch(exception e)
//         {
//             e.printStackTrace();
//         }
//         System.out.println("Done");
//     }
// }


// // throws keywords (for defined exception handling used with method and handel when call method) -------------------------------------------------

// class a
// {
//     void aa() throws ArithmeticException
//     {
//         int a=100,b=0,c;
//         c=a/b;
//         System.out.println(c);
//     }
//     public static void main(String[] args)
//     {
//         a aa=new a();
//         try
//         {
//             aa.aa();
//         }
//         catch(Exception e)
//         {
//             System.out.println(e);
//         }
//     }
// }


// // constructor ------------------------------------------------------------------------------------------------

// class a
// {
//     String n,j;
//     int i,k;

//     // a()                     // default constructor created by compiler when constructor is created by user
//     // {
//         // super();
//     // }  
    
//     a()                     // no argument constructor
//     {
//         int a=100;
//         String s=" kk ";
//         System.out.println("no argument--> "+ s + a);
//     }  

//     a(String n,int i)       // parameterized constructor
//     {
//         this.n=n;
//         this.i=i;
//         System.out.println("parameterized--> "+ n + i);
//     }

//     a(a aa)                 // copy constructor
//     {
//         j=aa.n;
//         k=aa.i;
//         System.out.println("copy--> "+ j + k);
//     }

//     public static void main(String[] args) 
//     {
//         // a an=new a();                               // no argument constructor call
//         // a ap=new a("pk ",87);                   // parameterized constructor call
//         // a ac=new a(ap);                             // copy constructor call
//     }
// }