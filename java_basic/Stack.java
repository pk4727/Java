class Stac
{
     int array[];
     int top;
     Stac(int size)
     {
          array = new int [size];
          top = -1;
     }
     void push(int item)
     {
          if(top>array.length-1)
          {
               System.out.println("STACK is full");
          }
          else
          {
               top++;
               array[top] = item;
          }
     }
     int pop()
     {
          if(top<0)
          {
               System.out.println("STACK is empty");
               return 0;
          }
          else
          {
               return array[top--];
               //top--;
          }
     }
}
class Stack
{
     public static void main(String[] args)
     {
          Stac s1 =new Stac(5);
          Stac s2 = new Stac(10);
          s1.push(32);
          s1.push(44);
          s1.push(21);
          s1.push(55);
          s1.push(12);
          for( int i=0;i<8;i++)
          {
               s2.push(i);
          }
          System.out.println(s1.pop());
          System.out.println(s2.pop());
          System.out.println(s2.pop());
     }
}
