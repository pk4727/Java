class variable_datatype
{                                               // variable:-/message             datatype:-
    int a=5;                                    //instance variable               integer
    static float b=4;                           //static variable                 float
    public static void main(String pk[])
    {
        String c="a";                           //local variable                  string
        boolean d=true;                         //                                boolean
        char   e = 'e';                         //inside single cote              charecter
        System.out.println(b);                   //access of static variable
        System.out.println(c);                   //access of local variable
        System.out.println(d);
        System.out.println(e);
         // System.out.println(a);               // it throw an error because we dont access instance
                                                 // variable directly.so we need object for access

        variable_datatype a1=new variable_datatype();            //object for instance variable
        System.out.println(a1.a);                //access of instance variable
    }
}