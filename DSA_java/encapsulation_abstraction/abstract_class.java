package encapsulation_abstraction;

public abstract class abstract_class {
    abstract void circle(int radius); // abstract method

    abstract void rectangle(int length, int breadth);

    // this all are not abstract and access by class name.variable/method
    static int n;
    public int a;
    private int b;
    protected int c;
    final int radius = 55;

    static void show() {
        System.out.println("from abstract class");
    }

    public void show2() {
        System.out.println("from abstract class");
    }

    protected void show3() {
        System.out.println("from abstract class");
    }

    final void show4() {
        System.out.println("from abstract class");
    }

    // abstract int a; // no abstract variable
    // abstract abstract_class(){ } // no abstract constructor can be created
    // final abstract void area(); // no public/private/protected/final/static
    // abstract method can be created
    // public static void main(String[] args) {
    // abstract_class a = new abstract_class(); // no object created of abstract
    // class
    // }
}

class abstractSubclass extends abstract_class {
    @Override
    void circle(int radius) {
        System.out.println("perimeter = " + (2 * 3.14 * radius));
    }

    @Override
    void rectangle(int length, int breadth) {
        System.out.println("perimeter = " + (2 * (length + breadth)));
    }
}

class abstractSubclass2 extends abstract_class {
    @Override
    void circle(int radius) {
        System.out.println("area = " + (3.14 * radius * radius));
    }

    @Override
    void rectangle(int length, int breadth) {
        System.out.println("area = " + (length * breadth));
    }
}

class MAin {
    public static void main(String[] args) {
        abstractSubclass a = new abstractSubclass();
        abstractSubclass2 a2 = new abstractSubclass2();
        abstract_class.show();
        a.circle(5);
        a.rectangle(5, 6);
        a2.circle(5);
        a2.rectangle(5, 6);
    }
}