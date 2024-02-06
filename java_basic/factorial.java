// package java.java_basic;

import java.util.*;
class factorial
{
    public static void main(String[] args)
    {
        int f=1,n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        n=sc.nextInt();
        while(n>0)
        {
            f=f*n;
            n--;
        }
        System.out.println("the factorial is"+f);
        sc.close();                                                   // close scanner
    }
}
