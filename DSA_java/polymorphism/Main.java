package polymorphism;

public class Main {
    public static void main(String[] args) {
        // "runtime/dynamic time polymorphism" achieved by "method overriding"
        shapes s = new square(); // superclass -> subclass(dependent in) then override  => upcasting
        s.area(5); // if parent have no method area then give error

//
//        // "compile/static time polymorphism" achieved by "method/constructor overloading"
//        shapes s1 = new shapes();
//        shapes s2 = new shapes(1);
//        shapes s3 = new shapes(1,2);
//        shapes s4 = new shapes(1,2,3);
//        s1.area();
//        s1.area(1);
//        s1.area(1,2);
//        s1.area(1,2,3);


//        // child_class object = new child_class
//        circle c = new circle();
//        shapes sh = new shapes();
//        square sq = new square();
//        triangle t = new triangle();
//        c.area();
//        sh.area();
//        sq.area();
//        t.area();
//
//        // parent_class object = new child_class
//        shapes sc = new circle();
//        shapes ssh = new shapes();
//        shapes ssq = new square();
//        shapes st = new triangle();
//        sc.area();
//        ssh.area();
//        ssq.area();
//        st.area();
    }
}
