
//// WAP in java in which one class put the date in digit and other class get the date in words by synchronization method ?
//
import java.util.Dictionary;
import java.util.Hashtable;

class synchronization3 {
    public static void main(String[] args) {
        QQQ q = new QQQ();
        new producerrr(q);
        new consumerrr(q);
    }
}

class QQQ {
    int m, n, o;
    boolean value = false;

    synchronized void put(int x, int y, int z) {
        if (value) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        m = x;
        n = y;
        o = z;
        System.out.println("produced " + m + "-" + n + "-" + o);
        value = true;
        notify();
    }

    synchronized int get() {
        if (!value) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        Dictionary<Integer, String> date = new Hashtable<>();
        date.put(1, "one");
        date.put(2, "two");
        date.put(3, "three");
        date.put(4, "four");
        date.put(5, "five");
        date.put(6, "six");
        date.put(7, "seven");
        date.put(8, "eight");
        date.put(9, "nine");
        date.put(10, "ten");
        date.put(11, "eleven");
        date.put(12, "twelve");
        date.put(13, "thirteen");
        date.put(14, "fourteen");
        date.put(15, "fifteen");
        date.put(16, "sixteen");
        date.put(17, "seventeen");
        date.put(18, "eighteen");
        date.put(19, "nineteen");
        date.put(20, "twenty");
        date.put(30, "thirty");

        Dictionary<Integer, String> week = new Hashtable<>();
        week.put(1, "january");
        week.put(2, "february");
        week.put(3, "march");
        week.put(4, "april");
        week.put(5, "may");
        week.put(6, "jun");
        week.put(7, "july");
        week.put(8, "august");
        week.put(9, "september");
        week.put(10, "october");
        week.put(11, "november");
        week.put(12, "december");
        if (m <= 20) {
            int d = o / 1000;
            int c = o % 1000;
            System.out.println("consumed   " + date.get(m) + " / " + week.get(n) + " / " + date.get(d) + " thousand "
                    + date.get(c));
        } else if (m < 31) {
            int d = o / 1000;
            int c = o % 1000;
            int a = m % 10;
            int b = m - a;
            if (a == 0) {
                System.out.println("consumed   " + date.get(m) + " / " + week.get(n) + " / " + date.get(d)
                        + " thousand " + date.get(c));
            } else {
                System.out.println("consumed   " + date.get(b) + " " + date.get(a) + " / " + week.get(n) + " / "
                        + date.get(d) + " thousand " + date.get(c));
            }
        }
        value = false;
        notify();
        return n;
    }
}

class producerrr implements Runnable {
    QQQ q;
    Thread t;

    producerrr(QQQ q1) {
        q = q1;
        t = new Thread(this, "producer");
        t.start();
    }

    public void run() {
        int i = 1;
        while (i < 31) {
            int j = i % 12 + 1;
            int k = j + 2008;
            q.put(i++, j++, k++);
        }
    }
}

class consumerrr implements Runnable {
    QQQ q;
    Thread t;

    consumerrr(QQQ q1) {
        q = q1;
        t = new Thread(this, "consumer");
        t.start();
    }

    public void run() {
        int i = 1;
        while (i < 31) {
            q.get();
            i++;
        }
    }
}