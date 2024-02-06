//    for execute this code remove comment of class oops and if any module is requre then remove comment from that given in starting line
//    after that remove comment of required code from one separation to other

// import java.util.Scanner; // import scanner for user input
// import java.io.*; // import input output package
// import java.util.ArrayList; // import array
// import java.util.LinkedList; // import linked list
// import java.util.Stack; // import stack
import java.util.ArrayDeque; // import arraydeque

public class oops // main class
 {
 public static void main(String[] args) {
 ArrayDeque<String> ad = new ArrayDeque<>(); // initilize arraydeque and
// create object
 ad.add("pradhuman kumar"); // insert given item in arraydeque
 ad.add("deepak kumar");
 ad.push("khirodhar mahto"); // insert given item in arraydeque
 ad.push("talo mahto");
 ad.push("kawel mahto");
 System.out.println(ad);
 ad.pop(); // delete item from arraydeque
 System.out.println(ad);
 ad.pop();
 ad.remove("kawel mahto"); // delete item from arraydeque
 System.out.println(ad);
 }
 }

// //--------------------------------------------------------------------------------------------------------------------------------------------------

// {
// public static void main(String[] args)
// {
// Stack<String> s=new Stack<String>(); // initilize stack and create object
// s.push("khirodhar mahto"); // insert given item in stack
// s.push("talo mahto");
// s.push("kawel mahto");

// System.out.println(s);
// s.pop(); // delete item from stack
// System.out.println(s);
// s.pop();
// s.add(0,"kanhiya kumar");
// s.add(1,"deepanshu kumar");
// s.add("pradhuman kumar"); // insert given item in stack by add
// s.add("deepak kumar");
// s.remove("kawel mahto"); // delete item of given index from stack by remove
// s.remove(1);
// System.out.println(s);
// }
// }

// //------------------------------------------------------------------------------------------------------------------------------------------------

// {
// public static void main(String[] args)
// {
// LinkedList<String> l=new LinkedList<>(); // initilize linkedlist and create
// object
// l.add("talo mahto"); // insert given item in linkedlist by add (default from
// last)
// l.add("khirodhar mahto");
// l.add("nandkishor verma");
// l.add("mamraj verma");
// l.add("late om-prakesh verma");
// // System.out.println(l);
// l.add("deepak verma");
// l.add("pradhuman kumar");
// l.addFirst("kawel mahto"); // add item in linkedlist at first by addfirst
// System.out.println(l);
// l.remove(1); // delete item of given index from linkedlist by remove
// l.remove(); // delete item from linkedlist by remove (default from start)
// l.remove("late om-prakesh verma"); // delete given item from linkedlist by
// remove of given name
// l.add("deepanshu kumar");
// System.out.println(l);
// l.addLast("kanhiya kumar"); // insert item in linkedlist in last by addlast
// System.out.println(l);
// System.out.println(l.get(0)); // print item of given index by get
// for(String str:l) // print item of given linkedlist by for each loop
// {
// System.out.println(str);
// }
// }
// }

// //--------------------------------------------------------------------------------------------------------------------------------------------------

// {
// public static void main(String[] args)
// {
// ArrayList<String> arr=new ArrayList<String>(); // initilize array and create
// object
// arr.add("talo mahto"); // insert given item in array by add (default in last)
// arr.add("khirodhar mahto");
// arr.add("nandkishor verma");
// arr.add("mamraj verma");
// arr.add("late om-prakesh verma");
// System.out.println(arr);
// arr.add("deepak verma");
// arr.add("pradhuman kumar");
// arr.add(0,"kawel mahto"); // add item in array at given index by add
// System.out.println(arr);
// arr.remove(0); // delete item from given index by remove
// arr.remove("late om-prakesh verma"); // delete given item from array by
// remove
// arr.add("deepanshu kumar");
// System.out.println(arr);
// arr.remove(0);
// arr.add("kanhiya kumar");
// System.out.println(arr);
// arr.set(1,"sumitra devi"); // replace given item by given index by set
// System.out.println(arr.get(0)); // print item of given index of array by get
// arr.clear(); // delete all item of array by clear
// System.out.println(arr);
// }
// }

// // multithreading( 1.extending thread --> 2.implementing runnable )
// //----------------------------------------------------------------------------------------------------------------------------------------------
// // compulsary line for thread

// implements Runnable // runnable is a package in java.lang |
// {
// public void run() // from runnable package |
// {
// try // for exception handling in runtime |
// {
// for(int i=1; i<=10; i++)
// {
// System.out.println(i);
// Thread.sleep(1000); // for time delay of 1sec
// }
// }
// catch(Exception e) // |
// {
// System.out.println(e);
// }
// }
// }
// class B
// {
// public static void main(String[] args) throws Exception // |
// {
// oops o=new oops(); // object of implemented class |
// Thread t=new Thread(o); // object for thread because here no start method
// present |
// t.start(); // starting thread |
// for(int i=1;i<=10;i++)
// {
// System.out.println("pk");
// Thread.sleep(1000);
// }
// }
// }

// //----------------------------------------------------------------------------------------------------------------------------------------------------

// // compulsury line for thread
// extends Thread // thread is a package in java.lang for threading |
// { // |
// @Override // that for checking run is in thread |
// public void run() // that |
// // void num() // this check for smple then active this and comment that
// {
// try // for exception handling in runtime |
// {
// for(int i=1; i<=10; i++)
// {
// System.out.println(i);
// Thread.sleep(1000); // for time delay of 1sec
// }
// }
// catch(Exception e) // |
// {
// System.out.println(e);
// }
// }
// }
// class B
// {
// public static void main(String[] args) throws Exception // |
// {
// int n=10;
// oops o=new oops(); // object of thread class |
// o.start(); //that starting thread by this keyword |
// // o.num(); //this if method is simple then 20 sec is taken for exection else
// 10sec for this code
// for(int i=1;i<=n;i++)
// {
// System.out.println("pk");
// Thread.sleep(1000);
// }
// }
// }

// // file handling ( 1.read data -->2. write data --> 3.create file )
// //-----------------------------------------------------------------------------------------------------------------------------------------------

// {
// public static void main(String[] args) throws Exception // exception handling
// {
// FileReader f=new
// FileReader("C:\\Users\\Pradhuman_kumar(pk)\\OneDrive\\Desktop\\pk.txt"); //
// read file from given path and file
// try // exception handling
// {
// int i;
// while((i=f.read())!=-1) // for store data in i
// {
// System.out.print((char)i); // for print data of i
// }

// }
// finally
// {
// f.close();
// }
// System.out.println("\nreading done..........");
// }
// }

// //
// //----------------------------------------------------------------------------------------------------------------------------------------------------

// {
// public static void main(String[] args) throws Exception // exception handling
// {
// FileWriter f=new
// FileWriter("C:\\Users\\Pradhuman_kumar(pk)\\OneDrive\\Desktop\\pk.txt"); //
// create file if not available and write in given path
// try // if code have no error then execute
// {
// f.write("myself pk from pindatand"); // write in file
// }
// finally // always execute
// {
// f.close(); // close file
// }
// System.out.println("writing done........");
// }
// }

// //-------------------------------------------------------------------------------------------------------------------------------------------------

// {
// public static void main(String[] args) //throws Exception // if try block in
// not useed
// {
// try // for error checking
// {
// File f=new File("C:\\Users\\Pradhuman_kumar(pk)\\OneDrive\\Desktop\\pk.txt");
// // object file module
// if(f.createNewFile()) //file create if not available
// {
// System.out.println("file created........");
// }
// else // if available
// {
// System.out.println("file is already available.......... ");
// }
// }
// catch(Exception e) // for error handling
// {
// System.out.println("error = "+e);
// }
// }
// }

// // exception handling ( try&catch )
// //-----------------------------------------------------------------------------------------------------------------------------------------------------

// {
// int c; // global variable
// void div(int a,int b)
// { // try Exception handling
// try
// {
// c=a/b;
// System.out.println("div= "+c);
// }
// catch(Exception e) // catch block for try block
// {
// System.out.println(e);
// }
// System.out.println("a= "+a);
// System.out.println("b= "+b);
// }
// public static void main(String[] args)
// {
// System.out.println(" ");
// oops o=new oops();
// o.div(10,0); // if b=0 then error comes out (java.lang.ArithmeticException: /
// by zero) else return any value
// System.out.println(" ");
// }
// }

// // polymorphism ( 1.compile time --> 2.runtime )
// //----------------------------------------------------------------------------------------------------------------------------------------------------------

// {
// public static void main(String[] args)
// {
// B a=new A(); // we can also make object of subclass and with referance of
// superclass
// a.show(); // show is override in class A from class B
// }
// }
// class A extends B
// {
// @Override // if this is present but in class B show in not present then error
// comes out
// void show()
// {
// // super.show(); // if super is active then both method call from one object
// System.out.println("extended class");
// }
// }
// class B
// {
// void show()
// {
// System.out.println("normal class");
// }

// }

// //-----------------------------------------------------------------------------------------------------------------------------------------------------

// {
// void compile() // default parameter method (non-return type)
// {
// int a=10,b=12,c=15;
// System.out.println("add= "+(a+b+c));
// }
// void compile(int d,int e) // two same parameter method (non-return type)
// {
// System.out.println("div= "+d/e);
// }
// void compile(int f,Double g) // two different parameter method (non-return
// type)
// {
// System.out.println("multi= "+f*g);
// }
// int compile(int h,int i,int j) // three same parameter method (return type)
// {
// int k=h-i-j;
// return k;
// }
// public static void main(String[] args)
// {
// oops o=new oops(); // oblect of class compile
// o.compile(); // call of default parameter method (non-return type)
// int l=o.compile(45,12,15); // call of three same parameter method (return
// type) and store it in l
// System.out.println("sub="+l); // printing l
// o.compile(13,11.55); // call of two different parameter method (non-return
// type)
// o.compile(20,10); // call of two same parameter method (non-return type)
// }
// }

// // inheritance( 1.hierarchical -> multiple -> 3.multilevel -> 4.siglelevel )
// //-----------------------------------------------------------------------------------------------------------------------------------------------------

// extends superr // subclass 2 inherite superclass
// {
// void show2()
// {
// System.out.println("branch: "+branch+"\nsection:"+section); // variable call
// from superclass
// }
// private void show3() // private method of subclass 2
// {
// System.out.println("good luck.....");
// }
// public static void main(String[] args)
// {
// // System.out.println("age"+age); // variable is private so don't accessable
// outside the class
// oops o=new oops(); // object of subclass 2
// sub1 s=new sub1(); // object of subclass 1
// System.out.println("name: "+o.name); // variable call from superclass
// o.show2(); // method of sublass 2
// s.show1(); // method of sublass 1
// // o.age(); // method of superlass and private so don't accessable outside
// class
// o.show3(); // private method of subclass 2 so it is access inside the class
// }
// }
// class sub1 extends superr // subclass 1 inherite superclass
// {
// void show1()
// {
// System.out.println("roll: "+roll+"\nmarks: "+marks); // variable call from
// superclass
// }
// }
// class superr // superclass
// {
// private int agee; // private variable so cant accessable outside class
// int roll,marks;
// String name, section="A",branch="AIML";
// private void age() // private method of superclass
// {
// System.out.println("age"+agee);
// }
// {
// roll=87; marks=90; name="pk";
// }
// }

// //------------------------------------------------------------------------------------------------------------------------------------------------

// implements A,B // if we use extrect then error comes out
// {
// public void show() // private + static so write public
// {
// System.out.println("implements....A & B......");
// }
// public void display()
// {
// System.out.println("implements......A.......");
// }
// public void main()
// {
// System.out.println("implements......B.......");
// }
// public static void main(String[] args)
// {
// oops o=new oops(); // object of subclss which implements the both superclass
// o.display();
// o.main();
// o.show();
// }
// }
// interface A // use interface keyword in place of class for interface &
// implement
// {
// void show();
// void display();
// }
// interface B
// {
// void show(); //public + abstract
// void main();
// }

// //-----------------------------------------------------------------------------------------------------------------------------------------------------

// extends sub1 // subclass 2 inherite subclass 1
// {
// void show2()
// {
// section="A";
// System.out.println("branch: "+branch); // variable call from subclass 1
// }
// public static void main(String[] args)
// {
// oops o=new oops(); // object of subclass 2
// o.name(); // method of superclass
// o.show2(); // method of subclass 2
// System.out.println("section: "+o.section); // variable call from subclass 2
// o.show1(); // method of subclass1
// }
// }
// class sub1 extends superr // subclass 1 inherite superclass
// {
// String branch="AIML";
// void show1()
// {
// System.out.println("roll: "+roll+"\nmarks: "+marks); // variable call from
// superclass
// }
// }
// class superr // superclass
// {
// int roll,marks; String name,section;
// void name()
// {
// roll=87; marks=90; name="pk";
// System.out.println("name: "+name);
// }
// }

// //--------------------------------------------------------------------------------------------------------------------------------------------------------------

// extends superr //sub class
// {
// void show()
// {
// System.out.println("roll: "+roll+" marks: "+marks); //variable call from
// super class
// }
// public static void main(String[] args)
// {
// oops o=new oops(); //object of sub class
// o.name(); //method of super class
// o.show(); //method of sub-class
// }
// }
// class superr // super class
// {
// int roll,marks;
// String name;
// void name()
// {
// roll=87; marks=90; name="pk";
// System.out.println("name: "+name);
// }
// }

// // interface
// //-----------------------------------------------------------------------------------------------------------------------------------------------------------

// {
// public static void main(String[] args)
// {
// funct.speed(); // call without object
// details d= new details(); // object of extended class
// System.out.println(d.speed); // call of static variable
// System.out.println(" ");
// d.start(); // call of extended class method
// d.stop();
// d.color(); // call with object of extended class
// System.out.println(" ");
// }
// }
// interface funct // interface class
// {
// int speed=100;
// String name="HERO"; // (public + static + final) variable
// String model="1+";
// default void color()
// {
// System.out.println("color is red.");
// }
// static void speed()
// {
// System.out.println("speed is (in km/h): "+speed);
// }
// void start(); // (public + abstract) method
// void stop();
// }
// class details implements funct // extended interface class
// {
// public void start()
// {
// //name="hero"; // The final field funct.name cannot be assigned
// System.out.println("name is "+name); // access variable as public
// System.out.println("start:insert key and rotate 25 degree in clockwise then
// press start button.");
// }
// public void stop()
// {
// System.out.println("model is "+model);
// System.out.println("stop:rotate 25 degree key in anticlockwise direction and
// then remove key.");
// }
// }

// // abstract class
// //----------------------------------------------------------------------------------------------------------------------------------

// {
// public static void main(String[] args)
// {
// dogs d=new dogs();
// cats c=new cats();
// d.eat(); d.sound(); d.legs();
// c.eat(); c.sound(); c.legs();
// }
// }
// abstract class animal // abstract class
// {
// void legs() // non abstract method
// {
// System.out.println("4 legs ");
// }
// abstract void sound(); // abstract method
// abstract void eat(); // abstract method
// }
// class dogs extends animal // extended abstract class
// {
// void sound() // use of abstract method 1st time
// {
// System.out.print("bhow bhow... ");
// }
// void eat() // use of abstract method 1st time
// {
// System.out.print("(meat)haadi.... ");
// }
// }
// class cats extends animal
// {
// void sound() // use of abstract method 2nd time
// {
// System.out.print("mew mew.... ");
// }
// void eat() // use of abstract method 2nd time
// {
// System.out.print("(meat)rat... ");
// }
// }

// //-------------------------------------------------------------------------------------------------------------------------------------

// abstract class bankdata
// {
// public String name="pk Bank";
// public String ifsc="pk8487";
// public void bankdetail()
// {
// System.out.println("Bank name: "+name+" , IFSC code: "+ifsc);
// }
// // password=123
// abstract void deposite();
// abstract void withdrawl();
// abstract void checkbalance();
// }
// class oops extends bankdata
// {
// private long balance=50000;
// private int password;
// public void deposite(long money)
// {
// System.out.println("Enter amount you want to deposite: ");
// Scanner sc=new Scanner(System.in);
// System.out.println("Enter password: ");
// password=sc.nextInt();
// if (password==123)
// {
// balance=balance+money;
// System.out.println("Deposited money: "+money);
// System.out.println("Total amount: "+balance);
// }
// else
// {
// System.out.println("Invilide password try again....!");
// }
// }
// public void withdrawl(long money)
// {
// System.out.println("Enter amount you want to deposite: ");
// Scanner sc=new Scanner(System.in);
// System.out.println("Enter password: ");
// password=sc.nextInt();
// if (password==123)
// {
// balance=balance-money;
// System.out.println("Withdrowl money: "+money);
// System.out.println("Total amount: "+balance);
// }
// else
// {
// System.out.println("Invilide password try again....!");
// }
// }
// public void checkbalance()
// {
// System.out.println("Total balance: "+balance);
// }
// public static void main(String[] args)
// {
// oops o=new oops();
// o.bankdetail();
// System.out.println("1.Deposite");
// System.out.println("2.Withdrawl");
// System.out.println("3.Checkbalance");
// System.out.print("Enter your choose: ");
// Scanner sc=new Scanner(System.in);
// int ch=sc.nextInt();
// switch(ch)
// {
// case 1: System.out.print("Enter Amount: ");
// long m=sc.nextLong();
// o.deposite(m);
// break;
// case 2: System.out.print("Enter Amount: ");
// long n=sc.nextLong();
// o.withdrawl(n);
// break;
// case 3:o.checkbalance();
// break;
// default:
// System.out.println("Invilide choose....!");
// break;
// }
// }
// }

// // Encapsulation (binding many metod in one class)
// //-----------------------------------------------------------------------------------------------------------------------------------------

// {
// private long balance=50000;
// private int password;
// public void deposite(long money)
// {
// System.out.println("Enter amount you want to deposite: ");
// Scanner sc=new Scanner(System.in);
// System.out.println("Enter password: ");
// password=sc.nextInt();
// if (password==123)
// {
// balance=balance+money;
// System.out.println("Deposited money: "+money);
// System.out.println("Total amount: "+balance);
// }
// else
// {
// System.out.println("Invilide password try again....!");
// }
// }
// public void withdrawl(long money)
// {
// System.out.println("Enter amount you want to deposite: ");
// Scanner sc=new Scanner(System.in);
// System.out.println("Enter password: ");
// password=sc.nextInt();
// if (password==123)
// {
// balance=balance-money;
// System.out.println("Withdrowl money: "+money);
// System.out.println("Total amount: "+balance);
// }
// else
// {
// System.out.println("Invilide password try again....!");
// }
// }
// public void checkbalance()
// {
// System.out.println("Total balance: "+balance);
// }
// public static void main(String[] args)
// {
// oops o=new oops();
// System.out.println("1.Deposite");
// System.out.println("2.Withdrawl");
// System.out.println("3.Checkbalance");
// System.out.print("Enter your choose: ");
// Scanner sc=new Scanner(System.in);
// int ch=sc.nextInt();
// switch(ch)
// {
// case 1: System.out.print("Enter Amount: ");
// long m=sc.nextLong();
// o.deposite(m);
// break;
// case 2: System.out.print("Enter Amount: ");
// long n=sc.nextLong();
// o.withdrawl(n);
// break;
// case 3:o.checkbalance();
// break;
// default:
// System.out.println("Invilide choose....!");
// break;
// }
// }
// }

// //----------------------------------------------------------------------------------------------------------------------------------------------------

// {
// int a=10;
// static String s="pk";
// oops()
// {
// System.out.println("CONSTRUCTOR");
// }
// static
// {
// System.out.println("static block");
// System.out.println(s); // access only static variable
// // System.out.println(a); // can't access non static variable
// }
// {
// System.out.println("INSTANCE BLOCK");
// System.out.println(s); // access static variable
// System.out.println(a); // access non static variable
// }
// public static void main(String[] args)
// {
// System.out.println("series of execution");
// oops o=new oops();
// }
// }

// // this keyword
// //--------------------------------------------------------------------------------------------------------------------------------------------------------

// {
// public static void main(String[] args)
// {
// A a=new A(50); //point1,2
// System.out.println("obj "+a); //point1
// a.show(); //point1
// a.show1(); //point2
// A ar=new A("pk"); //point3
// A arr=new A(77.77); //point4
// }
// }
// class A
// {
// int a;
// A(Double r)
// {
// this(70,"pk"); // for calling parametrized constructor(point 4)
// System.out.println(r);
// }
// A(int p,String q)
// {
// System.out.println(q);
// System.out.println(p);
// }
// A()
// {
// a=10;
// System.out.println("default " +a);
// }
// A(String s)
// {
// this(); // for calling default constructor(point 3)
// System.out.println("this " +s);
// }
// A(int a)
// {
// // a=a; //0
// this.a = a; //50 // for selection of local and instance variable(point 2)
// }
// void show1()
// {
// System.out.println("this " +a);
// }
// void show()
// {
// System.out.println("this " +this); // for referance number of object(point 1)
// }
// }

// // super keyword
// //--------------------------------------------------------------------------------------------------------------------------------------------------------

// {
// public static void main(String[] args)
// {
// B b=new B();
// b.show();
// }
// }
// class A
// {
// int a=10;
// A(int a)
// {
// System.out.println("super c pk "+a);
// }
// void show()
// {
// System.out.println("super m pk");
// }
// }
// class B extends A
// {
// int a=20; //variable
// B() //constructor
// {
// super(5); //super constructor
// System.out.println("sub c pk");
// }
// void show() //method
// {
// super.show(); // super method
// System.out.println("subclass "+a);
// System.out.println("superclass "+super.a); // super variable
// }
// }

// // constractor
// //-----------------------------------------------------------------------------------------------------------------------------------------------

// extends Base2
// {
// oops(){
// super(10);
// System.out.println("I am a derived class constructor");
// }
// public static void main(String[] args){
// oops d = new oops();
// }
// }
// class Base2
// {
// Base2(){
// System.out.println("I am a constructor");
// }
// Base2(int a){
// System.out.println("I am an overloaded constructor with a value of a as: "+
// a);
// }
// }

// //--------------------------------------------------------------------------------------------------------------------------------------------------

// extends Base2
// {
// oops()
// {
// super(10);
// System.out.println("I am a derived class constructor");
// }
// oops(int x, int y)
// {
// super(x);
// System.out.println("I am an overloaded constructor of Derived with value of y
// as: "+ y);
// }
// public static void main(String[] args)
// {
// oops d = new oops(14,9);
// }
// }
// class Base2
// {
// Base2()
// {
// System.out.println("I am a constructor");
// }
// Base2(int a)
// {
// System.out.println("I am an overloaded constructor with a value of a as: "+
// a);
// }
// }

// //-------------------------------------------------------------------------------------------------------------------------------------------------------

// {
// static int a;
// static String b;
// static double c;
// private oops() //(private constructor)
// {
// a=10; b="pk"; c=30.45;
// System.out.println("value of a= "+a+" value of b= "+b+" value of c= "+c);
// }
// static void pk(int p,float k)
// {
// a=p; c=k;
// System.out.println((a*c));
// }
// public static void main(String[] args)
// {
// oops a1=new oops(); //value of a= 10 value of b= pk value of c= 30.45
// pk(10,20); //200.0
// }
// }
// // class A
// // {
// // public static void main(String[] args)
// // {
// // oops a1=new oops(); // oops() has private access in oops (class)
// // // oops a1=new oops();
// // // ^ (1 error)
// // }
// // }

// //--------------------------------------------------------------------------------------------------------

// {
// public static void main(String[] args)
// {
// A a1=new A();
// A a2=new A(a1); //(copy constructor initilization)
// }
// }
// class A
// {
// int a;
// String b;
// A()
// {
// a=10; b="pk";
// System.out.println("real value "+a+" "+b);
// }
// A(A ref) //(copy constructor)
// {
// a=ref.a;
// b=ref.b;
// System.out.println("copy value "+a+" "+b);
// }
// }

// //-------------------------------------------------------------------------------------------------------

// {
// public static void main(String[] args)
// {
// A a1=new A(10,20); // pass value in constructor
// A a2=new A(10,"pk");
// a2.show1(); //use this also
// a1.show2(); //use this also
// }
// }
// class A
// {
// int x,y;
// String z;
// A(int p,String q) //(parameterized constructor) having some parameter
// {
// x=p; z=q;
// System.out.println(z+" "+x);
// }
// void show1()
// {
// System.out.println(z+" "+x);
// }
// A(int p,int q) //(parameterized constructor) having some parameter
// {
// x=p; y=q;
// System.out.println("sum of num is "+(x+y));
// }
// void show2()
// {
// System.out.println(x+y);
// }
// }

// //-------------------------------------------------------------------------------------------------------

// {
// public static void main(String[] args)
// {
// A a=new A();
// // a.show1(); //use this also
// }
// }
// class A
// {
// int a;
// String b;
// A() //(default constractor) if it is not present then-
// { //-compiler auto add default constractor
// a=0;
// b=null;
// System.out.println(a+" "+b);
// }
// void show1()
// {
// System.out.println(a+" "+b);
// }
// }

// // method/object
// //-----------------------------------------------------------------------------------------------------

//{
//    int age = 20; // variable
//    int weight = 65; // variable
//
//    void name() // method
//    {
//        System.out.print("name is pradhuman ");
//    }
//
//    void village() // method
//    {
//        System.out.print("in pindatand ");
//    }
//
//    void address() // method
//    {
//        System.out.println("from giridih,jharkhand,815316"); // statement
//    }
//
//    public static void main(String[] args) // main function
//    {
//        System.out.println(" ");
//        oops add = new oops(); // object
//        add.name(); // object call method
//        System.out.print("& age is " + add.age); // object call variable
//        System.out.println(" & weight is " + add.weight + " kg");
//        add.village();
//        add.address();
//        System.out.println(" ");
//    }
//}