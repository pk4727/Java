import java.util.Scanner;
class sum_of_complex_no

// using user input

{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("enter 1st no: ");

        int a= sc.nextInt();                    //for string value use nextLine() & for double/float use nextDouble()
        System.out.print("enter 2nd no: ");
        int b= sc.nextInt();
        int sum=a+b;
        System.out.print("sum="+sum);
        sc.close();
    }
}


// using initilization of value

// {
//     public static void main(String[] args)
//    {
//         int n=4;
//         int m=8;
//         int o=4;
//         int sum=n+m+o;
//         System.out.println("sum=" +sum);
//     }
// }