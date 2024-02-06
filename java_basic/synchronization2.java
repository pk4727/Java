// WAP in java in which one class put the number in digit and other class get the number in words by synchronization method ?

import java.util.Dictionary;
import java.util.Hashtable;

class synchronization2 {
    public static void main(String[] args) {
        QQ q = new QQ();
        new producerr(q);
        new consumerr(q);
    }
}

class QQ {
    int n;
    boolean value = false;

    synchronized void put(int a) {
        if (value) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        n = a;
        System.out.println("Produced: " + n);
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
        Dictionary<Integer, String> no = new Hashtable<>();
        no.put(0, "zero");
        no.put(1, "one");
        no.put(2, "two");
        no.put(3, "three");
        no.put(4, "four");
        no.put(5, "five");
        no.put(6, "six");
        no.put(7, "seven");
        no.put(8, "eight");
        no.put(9, "nine");
        no.put(10, "ten");
        no.put(11, "eleven");
        no.put(12, "twelve");
        no.put(13, "thirteen");
        no.put(14, "fourteen");
        no.put(15, "fifteen");
        no.put(16, "sixteen");
        no.put(17, "seventeen");
        no.put(18, "eighteen");
        no.put(19, "nineteen");
        no.put(20, "twenty");
        no.put(30, "thirty");
        no.put(40, "fourty");
        no.put(50, "fifty");
        no.put(60, "sixty");
        no.put(70, "seventy");
        no.put(80, "eighty");
        no.put(90, "ninety");
        no.put(100, "hundred");

        if (n <= 20 | n == 100) {
            System.out.println("consumed " + no.get(n));
        } else if (n < 100) {
            int m = n % 10;
            int o = n - m;
            if (m == 0) {
                System.out.println("consumed " + no.get(o));
            } else {
                System.out.println("consumed " + no.get(o) + " " + no.get(m));
            }
        }
        value = false;
        notify();
        return n;
    }
}

class producerr implements Runnable {
    QQ q;
    Thread t;

    producerr(QQ q1) {
        q = q1;
        t = new Thread(this, "producer");
        t.start();
    }

    public void run() {
        int i = 1;
        while (i < 101) {
            q.put(i++);
        }
    }
}

class consumerr implements Runnable {
    QQ q;
    Thread t;

    consumerr(QQ q1) {
        q = q1;
        t = new Thread(this, "consumer");
        t.start();
    }

    public void run() {
        int i = 1;
        while (i < 101) {
            q.get();
            i++;
        }
    }
}