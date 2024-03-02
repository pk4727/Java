package Stack_and_Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("\n================ Stack =================");
        stack s = new stack();
        s.push(15);
        s.push(25);
        s.push(15);
        s.push(25);
        s.push(15);
        s.push(25);
        s.push(15);
        s.push(25);
        s.push(15);
        s.push(25);
        s.push(15);
        s.display();
        System.out.println("Top element of stack : " + s.peek());
        System.out.println("Element removed from stack : " + s.pop());

        System.out.println("\n================ Queue =================");
        queue cuq = new queue();
        cuq.insert(1);
        cuq.insert(2);
        cuq.insert(3);
        cuq.insert(4);
        cuq.display();
        System.out.println("Element removed from queue : " +cuq.delete());
        System.out.println("Front element of queue : " +cuq.front());

        System.out.println("\n================ circular Queue =================");
        circularQueue ciq = new circularQueue();
        ciq.insert(11);
        ciq.insert(2);
        ciq.insert(23);
        ciq.insert(4);
        ciq.insert(10);
        ciq.insert(12);
        ciq.insert(23);
        ciq.insert(14);
        ciq.insert(15);
        ciq.insert(21);
        ciq.insert(5);
        System.out.println("Front element of queue : "+ciq.front());
        System.out.println("Element removed from circularQueue : " +ciq.delete());
        ciq.display();
        ciq.insert(50);
        ciq.display();

    }
}
