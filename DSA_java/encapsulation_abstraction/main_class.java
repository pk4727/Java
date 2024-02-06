package encapsulation_abstraction;

public class main_class {
    private int hidden_number;
    protected String name;
    float age;
    public int[] arr;
    public main_class(int hidden_number, String name,float age, int[] arr) {
        this.hidden_number = hidden_number;
        this.name = name;
        this.age = age;
        this.arr = arr;
    }

    public int getHidden_number() { // by this method we access private member of this class by other class
        return hidden_number;
    }
    public void setHidden_number(int hidden_number) { // by this method we set value to private member of this class by other class
        this.hidden_number = hidden_number;
    }

    public static void main(String[] args) {
//        inside same package subclass
        int[] arr = {1,2,3};
        main_class hd = new main_class(5,"pk",20 ,arr);
        System.out.println(hd.hidden_number); // no error (private)
        System.out.println(hd.name); // no error (protected)
        System.out.println(hd.age); // no error (default)
        System.out.println(hd.arr[0]); // no error (public)
    }
}
