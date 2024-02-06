class control_flow_statement
{
    static int sum(int a)
    {
       return a*a;                                // return statement
    }
    public static void main(String[] args)
    {
        System.out.println("break statement started !");
        for(int i=1;i<10;i++)                                                
        {
            if(i>5)
            {
                break;                             // break statement:-
            }                                      //  it break the process when condition reach
            else
            {
                System.out.println(i);
            }
        }

        System.out.println("continue statement started !");
        for(int i=1;i<10;i++)                                            
        {
            if(i>=5 && i<=8)
            {
                continue;                             // continue statement:-
            }                                         //  it skip the value which is under condition
            else
            {
                System.out.println(i);
            }
        }


        System.out.println("return statement started !");
        int r=sum(5);                                       //calling of return statement
        System.out.println("squre is "+r);
    }   
}