//// package java.java_basic;
//
//import java.util.*;
//
//public class sum_of_complex_no {
//    int real, imaginary;
//
//    // static int count;
//    sum_of_complex_no() {
//        real = 0;
//        imaginary = 0;
//    }
//
//    sum_of_complex_no(int x, int y) {
//        real = x;
//        imaginary = y;
//        // count++;
//    }
//
//    sum_of_complex_no(Complex a) {
//        real = a.real;
//        imaginary = a.imaginary;
//    }
//
//    void display() {
//        System.out.println("SUM =" + real + "+i" + imaginary);
//        // System.out.println(count);
//    }
//
//    Complex add(Complex a, Complex b) {
//        Complex sum = new Complex();
//        sum.real = a.real + b.real;
//        sum.imaginary = a.imaginary + b.imaginary;
//        return sum;
//    }
//}
//
//class som_of_complex_no {
//    public static void main(String arg[]) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter 4 number ");
//        int input1 = sc.nextInt();
//        int input2 = sc.nextInt();
//        int input3 = sc.nextInt();
//        int input4 = sc.nextInt();
//        Complex c1 = new Complex(input1, input2);
//        Complex c2 = new Complex(input3, input4);
//        Complex c3 = new Complex(c1);
//        Complex c4 = new Complex();
//        c1.display();
//        c2.display();
//        c3.display();
//        c4 = c4.add(c1, c2);
//        c4.display();
//        sc.close(); // close scannner
//    }
//}
