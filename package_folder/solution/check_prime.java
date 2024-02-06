// public class check
// {
//     public static void main(String[] args) 
//     {
//         p1.prime c=new p1.prime();
//         c.checkprime(100);
//     }
// }

// // or
public class check_prime {
    public static void main(String[] args) {
        for(int i=1; i<=100; i++) {
            if(prime.checkPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }
}