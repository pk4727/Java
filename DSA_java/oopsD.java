public class oopsD {
    public class singleton {
        private singleton() {
            System.out.println(
                    "singleton class have 'constructor' as 'private' such that it can't be access by other class rather then itself.");
        }
        // private static singleton instance;
        // public static singleton getInstance(){ // how its work is this
        // if (instance==null){
        // instance = new singleton();
        // }
        // return instance;
        // }
    }

    public class innerClass {
        void show(int number, String name) {
            System.out.println(number + "." + name);
        }
    }

    enum Week implements A { // we can use as dictionary
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday; // these are enum constants which is always public, static and final
        void display() { //method
        }

        Week() { // constructor
            System.out.println("Constructor called for " + this);
        }

        @Override
        public void hello() { // implements
            System.out.println("hey how are you");
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Week week; // object creation
        week = Week.Monday; // initialization
        week.hello(); // parent method is override
        System.out.println(week.ordinal()); // return index value
        for (Week day : Week.values()) { // return original value
            System.out.println(day);
        }

        oopsD obj = new oopsD(); // Creating an instance of outer class
        oopsD.innerClass ic = obj.new innerClass(); // Creating an instance of inner class
        ic.show(1, "pk");

        student.Student("pk", 12, 85); // without Creating an instance of static inner class
        System.out.println(student.name);
        System.out.println(student.roll);
        System.out.println(student.marks);

        Human h1 = new Human("Rina", 24, 2000, true); // Creating an instance of static class
        Human h2 = new Human("dk", 4, 1000, false);
        Human h3 = new Human("kk", 2, 500, false);
        System.out.println(h3.population);

        // object cloning
        Human x = new Human(h1); // cloning manually
        System.out.println(x.population);
        Human x1 = (Human) (h1.clone()); // cloning by Cloneable interface

        x1.arr[0] = 51; // deep/shallow copying effect
        System.out.println(x1.arr[0]);
        System.out.println(h1.arr[0]);
    }

    public static class student {
        static String name;
        static int roll;
        static float marks;

        static void Student(String n, int r, float m) {
            name = n;
            roll = r;
            marks = m;
        }
    }

    public static class Human implements Cloneable {
        public Human(Human h1) {
        } // used for object cloning manually

        // object cloning by Cloneable interface
        @Override // this or
        public Object clone() throws CloneNotSupportedException { // used for shallow copy (original object also
                                                                  // changed)
            return super.clone();
        }

        // @Override // this
        // public Object clone() throws CloneNotSupportedException{ // used for deep
        // copy (original object not changed)
        // Human twin = (Human)super.clone(); // this is actually shallow copy
        // // make a deep copy
        // twin.arr = new int[twin.arr.length];
        // for (int i = 0; i < twin.arr.length; i++) {
        // twin.arr[i] = this.arr[i];
        // }
        // return twin;
        // }

        String name;
        int age;
        int salary;
        boolean married;
        static long population;
        int[] arr = { 5, 4, 8, 3, 2, 9 };

        public Human(String name, int age, int salary, boolean married) {
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.married = married;
            Human.population += 1;
        }
    }
}

interface A {
    void hello();
}