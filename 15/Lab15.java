// package lab15;

class Counter {
    synchronized public void printCount() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Counter --- " + i);
            }
        } catch (Exception e) {
            System.out.println("Thread interrupted.");
        }
    }
}

class MyThread extends Thread {
    private final String threadName;
    private final Counter counter;

    MyThread(String name, Counter counter) {
        threadName = name;
        this.counter = counter;
    }

    public void run() {
        synchronized(counter){
            counter.printCount();
            System.out.println("Thread " + threadName + " exiting.");
        }
    }

    public void start() {
        System.out.println("Starting " + threadName);
        Thread newThread = new Thread(this, threadName);
        newThread.start();
    }
}

public class Lab15 {
    public static void main(String[] args) {
        Counter MT = new Counter();
        MyThread T = new MyThread("Thread - 1 ", MT);
        MyThread T1 = new MyThread("Thread - 2 ", MT);
        T.start();
        T1.start(); // wait for threads to end
        try {
            T.join();
            T1.join();
        } catch (Exception e) {
            System.out.println("Interrupted");
        }
    }
}

// Starting Thread - 1
// Starting Thread - 2
// Counter --- 5
// Counter --- 4
// Counter --- 3
// Counter --- 2
// Counter --- 1
// Thread Thread - 1  exiting.
// Counter --- 5
// Counter --- 4
// Counter --- 3
// Counter --- 2
// Counter --- 1
// Thread Thread - 2  exiting.