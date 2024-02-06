class initiate {
    int a;
    boolean val = true;

    synchronized void pro(int x) {

        if (!val) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        a = x;
        System.out.println("Clock: " + a);
        val = false;
        notify();
    }

    synchronized void con() {
        if (val) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        System.out.println("Counter: " + bin(a));
        val = true;
        notify();
    }

    String bin(int a) {
        if (a % 9 == 0)
            return "000";
        else if (a > 9)
            a = a % 9;
        else {
            if (a - 1 == 0)
                return "000";
            else
                a = a - 1;
        }
        String s = " ";
        while (a > 0) {
            s = String.valueOf(a % 2) + s;
            a = a / 2;
        }
        return s;
    }
}

class producerrrr implements Runnable {
    initiate p;
    Thread t;

    producerrrr(initiate k) {
        p = k;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        for (int i = 1; i <= 15; i++)
            p.pro(i);
    }
}

class consumerrrr implements Runnable {
    initiate p;
    Thread t;

    consumerrrr(initiate k) {
        p = k;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        for (int i = 1; i <= 15; i++)
            p.con();
    }
}

class manage {
    public static void main(String[] args) {
        initiate i = new initiate();
        new producerrrr(i);
        new consumerrrr(i);
    }
}