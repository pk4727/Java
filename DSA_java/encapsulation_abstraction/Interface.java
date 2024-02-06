package encapsulation_abstraction;

public interface Interface { // multiple interface can be inherited (implements keyword) and interface can extend any class
    // variable are static and final by default
    static final int price = 500000; // or int price = 500000;
    default void Start(){
        System.out.println("interface is used here");
    }
    void start();

    void stop();

    void acc();

}

interface interface2 {
    void brake();

    void start();

    void stop();

}

interface interface3 {
    void brake();
}

class interfaceClass implements Interface, interface2, interface3 {
    @Override
    public void brake() {
        System.out.println("i brake car.");
    }

    @Override
    public void start() {
        System.out.println("i start car.");
    }

    @Override
    public void stop() {
        System.out.println("i stop car.");
    }

    @Override
    public void acc() {
        System.out.println("i accelerate car.");
    }
}

class Main {
    public static void main(String[] args) {
        interfaceClass ic = new interfaceClass();
        System.out.println("price = " + Interface.price);
        ic.start();
        ic.stop();
        ic.acc();
        ic.brake();
    }
}