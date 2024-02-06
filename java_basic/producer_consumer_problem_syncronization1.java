// prdoducer consumer problem   :-  producer produce an item and consumer consume it 

// with wait() and notify() method

class Q {
    int x;
    boolean value = false;

    synchronized void put(int a) {
        if (value) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        x = a;
        System.out.println("Produced: " + x);
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
        System.out.println("consumed: " + x);
        value = false;
        notify();
        return x;
    }
}

class producer implements Runnable {
    Q q;
    Thread t;

    producer(Q q1) {
        q = q1;
        t = new Thread(this, "Producer");
        t.start();
    }

    public void run() {
        int i = 10;
        while (i < 15) {
            q.put(i++);
        }
    }
}

class consumer implements Runnable {
    Q q;
    Thread t;

    consumer(Q q1) {
        q = q1;
        t = new Thread(this, "Consumer");
        t.start();
    }

    public void run() {
        int i = 10;
        while (i < 15) {
            q.get();
            i++;
        }
    }
}

class producer_consumer_problem_syncronization1 {
    public static void main(String arg[]) {
        Q q = new Q();
        new producer(q);
        new consumer(q);
    }
}

// without wait() and notify() method

// class Q extends Thread
// {
// int n;
// synchronized int get()
// {
// try
// {
// Thread.sleep(500);
// }
// catch(Exception e)
// {
// System.out.println(e);
// }
// return n;
// }
// synchronized void put(int x)
// {
// try
// {
// n = x;
// System.out.println( "Item is produced"+n);
// Thread.sleep(500);
// }
// catch(Exception e)
// {
// System.out.println(e);
// }
// }
// }

// class Producer implements Runnable
// {
// Q q;
// Thread t;
// Producer(Q q)
// {
// this.q = q;
// t = new Thread(this, "Producer");
// t.start();
// }
// public void run()
// {
// int i=10;
// while(i<15)
// {
// q.put(i++);
// }
// }
// }

// class Consumer implements Runnable
// {
// Q q;
// Thread t;
// Consumer(Q q)
// {
// this.q = q;
// t = new Thread(this, "Consumer");
// t.start();
// }
// public void run()
// {
// while(true)
// {
// System.out.println("consumer: "+q.get());
// }
// }
// }

// class PC
// {
// public static void main(String arg[])
// {
// Q q = new Q();
// System.out.println("Press Ctrl+c to stop");
// new Producer(q);
// new Consumer(q);
// }
// }
