package inheritance;

import encapsulation_abstraction.main_class;

public class diff_package_class {
    public static void main(String[] args) {
//        inside different package class
        int[] arr = {1,2,3};
        main_class hd = new main_class(5,"pk",20 ,arr);
//        System.out.println(hd.hidden_number); // error (private)
//        System.out.println(hd.name); // error (protected)
//        System.out.println(hd.age); // error (default)
        System.out.println(hd.arr[0]); // no error (public)
    }
}