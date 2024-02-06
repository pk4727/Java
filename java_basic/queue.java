class queue
{
     int array[];
     int front;
     int rear;
     queue(int size)
     {
          array = new int [size];
          front   = -1;
          rear = -1;
     }
     void insert(int item)
     {
          if((front == 0)&&(rear == array.length -1))
          {
               System.out.println("queue is full");
          }
          else
          {
               if(front<0)
               {
	               front = 0;
                    rear++;
                    array[rear] =  item;
               }
          }
     }
     int delete()
     {
          int element ;
          if(front<0)
          {
               System.out.println("queue is empty");
               return 0;
          }
          else
          {
               element = array[front];
               if(front>=rear)
               {
                    front = -1;
                    rear = -1;
               }
               else
               {
                    front++;
               }
               return element;
          }
     }
}
class testque
{    
     public static void main(String args[])
     {
          queue q1 = new queue(5);
          queue q2 = new queue(10);
          q1.insert(32);
          q1.insert(44);
          q1.insert(21);
          q1.insert(55);
          q1.insert(12);
          for( int i=0;i<8;i++)
          {
               q2.insert(i);
          }
          System.out.println(q1.delete());
          System.out.println(q2.delete());
          System.out.println(q2.delete());
     }
}
