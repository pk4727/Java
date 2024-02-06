package polymorphism;

public class shapes {
    public shapes() {
        System.out.println("\ni am from shapes class");
    }

    public shapes(int radious) {
        System.out.println("i am circle shapes");
    }

    public shapes(int base, float height) {
        System.out.println("i am triangle shapes");
    }

    public shapes(int lenght, int breadth, int height) {
        System.out.println("i am cuboid shapes");
    }

    void area() {
        System.out.println("\ni am area from shape");
    }
    
    public void area(int radius) {
        System.out.println("area of circle = " + (3.14 * radius * radius));
    }

    public void area(int base, int height) {
        System.out.println("area of triangle = " + ((base * height) / 2));
    }

    public void area(int lenght, int breadth, int height) {
        System.out.println("area of cuboid = " + (lenght * breadth * height));
    }
}
