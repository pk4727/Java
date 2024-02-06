package encapsulation_abstraction;

public class sub_class extends main_class{
    public sub_class(int hidden_number, String name, float age, int[] arr) {
        super(hidden_number, name, age, arr);
    }

    public static void main(String[] args) {
//        inside same package subclass
            int[] arr = {1,2,3};
            sub_class hd = new sub_class(5,"pk",20 ,arr);
//        System.out.println(hd.hidden_number); // error (private)
            System.out.println(hd.name); // no error (protected)
            System.out.println(hd.age); // no error (default)
            System.out.println(hd.arr[0]); // no error (public)
        }
}