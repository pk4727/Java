import java.util.*;
public class result {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Length and Breadth of Room");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Enter the Length and Breadth of Tiles");
        int c = sc.nextInt();
        int d = sc.nextInt();
        RoomArea r = new RoomArea(a, b);
        System.out.println("\nThe Number of Tiles = " + r.countTiles(c, d));
        sc.close(); // close scannner
    }
}
class Room {
    double l, b;

    Room() {
        l = 0.0;
        b = 0.0;
    }

    Room(double x, double y) {
        l = x;
        b = y;
    }
}

class RoomArea extends Room {
    RoomArea(double x, double y) {
        super(x, y);
    }

    double countTiles(double a, double b) {
        System.out.println("room Area= " + (super.l * super.b));
        return (Math.ceil((super.l * super.b) / (a * b)));
    }
}