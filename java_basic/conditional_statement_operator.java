import java.util.Scanner;                                              //   "operators"
class conditional_statement_operator
{
    public static void main(String[] args)

    {
        int password;
        System.out.print("enter password:");
        Scanner sc= new Scanner(System.in);
        password=sc.nextInt();
        if(password==2435)                                  // "=="            if statement  
        {
            System.out.print("congratulation ");
            System.out.println("pk ");
            System.out.println("Have a great day !");
        }
        else                                                                  //else statement
        {
            System.out.println("wrong password try again");
        }


        System.out.println("if else condition started !");
        System.out.print("enter 1st number:");
        int m=sc.nextInt();
        System.out.print("enter 2nd number:");
        int n=sc.nextInt();
        System.out.print("enter 3rd number:");
        int o=sc.nextInt();

        int r=(m>n)?(m>o?m:o):(n>o?n:o);                 // "?" =true     ":" =false                
        System.out.println(r+ " is greater");
        
        if(m>o)                                          //  ">"         if & else-if & else
        {
            if(m>n)                                                    // if-else & nested if-else 
            {
                System.out.println(m+" is greater than "+ n + " and " + o);
            }
            else
            { 
            System.out.println(m+" is greater than "+ o+ " but smaller then "+ n);
            }
        }
        else if(n>o)                                                            
        {
            if(n>m)                                                                
            {
                System.out.println(n+" is greater than "+m+" and "+o);
            }
            else
            {
            System.out.println(n+" is greater than "+o+" but smaller then "+m);
            }
        }
        else   
        {                                                                  
            System.out.println(o+" is greater than "+m+" and "+n);
        }


        System.out.println("switch statement started !");
        System.out.println(" ");
        System.out.println("options:-operation occur in 1st and 2nd no !");
        System.out.println("1.addition");
        System.out.println("2.subtraction");
        System.out.println("3.multiplication");
        System.out.println("4.division");
        System.out.println("5.modulo");
        System.out.println(" ");
        System.out.print("enter your choice number:");
        int cas=sc.nextInt();
        int p;
        switch(cas)                                                     //switch statement
        {
        case 1:p=m+n;                                                   //      "+"
            System.out.println("addition= "+p);
            break;
        case 2:p=m-m;                                                   //      "-"
            System.out.println("subtraction= "+p);
            break;
        case 3:p=m*n;                                                   //      "*"
            System.out.println("multiplication= "+p);
            break;
        case 4:p=m/n;                                                   //      "/"
            System.out.println("division= "+p);
            break;
        case 5:p=m%n;                                                   //      "%"
            System.out.println("modulo= "+p);
            break;
        default:
            System.out.println("invilide choice..?");
        }


        if(m!=n)                                                       //      "!="
        {
            System.out.println("not equalto ");
        }
        if(m<n)                                                        //      ">"
        {
            System.out.println("less than ");
        }
        if(m>=n)                                                        //      ">="
        {
            System.out.println("greater than equalto ");
        }
        if(m<=n)                                                        //      "<="
        {
            System.out.println("less than equalto ");
        }
        if(m>n && n!=m)                                                  //      "&&"
        {
            System.out.println("and ");
            System.out.println(m);
            System.out.println(m+" preincrement--> "+(++m));            //      "++X"
            System.out.println(m+" postincrement--> "+(m++));           //      "X++"
            System.out.println(m);  
            m+=1;
            System.out.println("m += 1 "+m);                         
        }
        if(m>n || m>o)                                                   //      "||"
        {
            System.out.println("or ");
            System.out.println(m);
            System.out.println(m+" predecrement--> "+(--m));               //      "--X"
            System.out.println(m+" postdecrement--> "+(m--));              //      "X--"
            System.out.println(m); 
            m-=1;
            System.out.println("m -= 1 "+m);                           
        }
        sc.close();                                                   // close scannner 
    }
}