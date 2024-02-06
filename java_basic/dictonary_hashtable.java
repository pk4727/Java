import java.util.Dictionary;
import java.util.Hashtable;

public class dictonary_hashtable 
{
    public static void main(String[] args) 
    {
        Dictionary<Integer, String> no= new Hashtable<>();
        no.put(0,"zero");
        no.put(1,"one");
        no.put(2,"two");
        no.put(3,"three");
        no.put(4,"four");
        no.put(5,"five");
        no.put(6,"six");
        no.put(7,"seven");
        no.put(8,"eight");
        no.put(9,"nine");
        no.put(10,"ten");
        no.put(20,"twenty");
        no.put(30,"thirty");
        no.put(40,"fourty");
        no.put(50,"fifty");
        no.put(60,"sixty");
        no.put(70,"seventy");
        no.put(80,"eighty");
        no.put(90,"ninety");
        no.put(100,"hundred");
        
        System.out.println("1 "+no.get(1));
        no.remove(100);
        System.out.println("size "+ no.size());
        no.put(100,"hundred");

        // //loop iterate over the keys stored in the dictionary 
        // System.out.println("\nDictionary values are: \n"); 
        // for(Enumeration e = no.elements(); e.hasMoreElements();)  
        // {        
        //     System.out.println(e.nextElement());  
        // }  
        
        // System.out.println("\nDictionary keys are: \n");   
        // for(Enumeration e = no.keys(); e.hasMoreElements();)  
        // {      
        //     System.out.println(e.nextElement());  
        // }  
    }
}
