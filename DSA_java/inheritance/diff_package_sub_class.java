package inheritance;

import encapsulation_abstraction.main_class;

public class diff_package_sub_class extends main_class{
    public diff_package_sub_class(int hidden_number, String name, float age, int[] arr) {
        super(hidden_number, name, age, arr);
    }

    public static void main(String[] args) {
//        inside different package subclass
        int[] arr = {1,2,3};
        diff_package_sub_class hd = new diff_package_sub_class(5,"pk",20 ,arr);
//        System.out.println(hd.hidden_number); // error (private)
        System.out.println(hd.name); // no error (protected)
//        System.out.println(hd.age); // error (default)
        System.out.println(hd.arr[0]); // no error (public)
    }
}
