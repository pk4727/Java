package encapsulation_abstraction;

public class other_class{
    public static void main(String[] args) {
//        inside same package subclass
        int[] arr = {1,2,3};
        main_class hd = new main_class(5,"pk",20 ,arr);
        hd.setHidden_number(15); // pass value to private member
        System.out.println(hd.getHidden_number()); // access private member
//        System.out.println(hd.hidden_number); // error (private member)
        System.out.println(hd.name); // no error (protected)
        System.out.println(hd.age); // no error (default)
        System.out.println(hd.arr[0]); // no error (public)
    }
}