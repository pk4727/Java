import java.util.*;
class looping_statement
{
    public static void main(String[] args)
    {
        Scanner sc=new  Scanner(System.in);
        System.out.print("enter no for which table is created:");
        int n= sc.nextInt();
        for(int i=1;i<11;i++)                                       //for loop
        {
            for(int l=i;l<i+1;l++)
            {
                System.out.print(n+" * "+l+" = ");
            }
            System.out.println(n*i);
        }
        System.out.println("while loop started !");
        int j=1;
        while(j<11)                                                 //while loop
        {
            System.out.println(n*j);
            j++;
        } 

        System.out.println("do-while loop started !");
        do                                                          //do-while loop
        {
            System.out.print(n+" ");
            --n;
        }
        while(n>0);
        System.out.println(" ");

        System.out.println("for-each loop started !");
        {
            int a[]={1,2,3,4};
            for(int i:a)                                               //for-each loop (for each i in a)
            {
                System.out.print(i+" ");
            } 
        } 
        sc.close();                                                   // close scannner 
    }
}