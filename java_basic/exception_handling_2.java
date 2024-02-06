// exception handling is use to give an message, when the programe is compile but in execution time
//  it gives error in the output and hence the remaining programe will not execute which is right so
//  we use this with the help of "try,catch,throw,throws,finally" etc


public class exception_handling_2
{
    public static void main(String[] args)
    {
        int a=0;
        int b=10;
         try{
        int c=b/a;
        System.out.println(c);
        }
        catch(Exception e){
            System.out.println("exception is ("+e+")");
        }
    }
}