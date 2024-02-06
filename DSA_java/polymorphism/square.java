package polymorphism;

public class square extends shapes{
    void area(){
        System.out.println("i am from square class ");
    }
    @Override // annotation (override depend on object but not static so static content not override)
    public void area(int radius) {
        System.out.println("area of square = " + (radius * radius));
    }
}
