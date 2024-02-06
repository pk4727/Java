import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class comparing_object implements Comparable<comparing_object> {
    int rollno;
    float marks;

    public comparing_object(int rollno, float marks) {
        this.rollno = rollno;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return marks + "";
    }

    @Override
    public int compareTo(comparing_object o) {
        // System.out.println("comparator method call.");
        int diff = (int) (this.marks - o.marks);
        return diff;
    }
}

class Main {
    public static void main(String[] args) {
        comparing_object kunal = new comparing_object(12, 89.76f);
        comparing_object rahul = new comparing_object(5, 99.52f);
        comparing_object arpit = new comparing_object(2, 95.52f);
        comparing_object karan = new comparing_object(13, 77.52f);
        comparing_object sachin = new comparing_object(9, 96.52f);

        comparing_object[] list = { kunal, rahul, arpit, karan, sachin };

        System.out.println(Arrays.toString(list));
        Arrays.sort(list, new Comparator<comparing_object>() {
            @Override
            public int compare(comparing_object o1, comparing_object o2) {
                return -(int) (o1.marks - o2.marks);
            }
        }); // this or
        Arrays.sort(list, (o1, o2) -> -(int) (o1.marks - o2.marks)); // this
        System.out.println(Arrays.toString(list));

        for (comparing_object name : list) {
            ArrayList<Integer> an = new ArrayList<>();
            for (comparing_object cname : list) {
                int ans = name.compareTo(cname); // give integer value [ -> then +ve, <- then -ve , == then 0]
                an.add(ans);
                if (ans > 0) {
                    System.out.println(name + " has more marks then " + cname);
                } else if (ans == 0) {
                    System.out.println(name + " equal " + cname);
                } else {
                    System.out.println(name + " has less marks then " + cname);
                }
            }
            System.out.println(an + "\n");
        }
    }
}
