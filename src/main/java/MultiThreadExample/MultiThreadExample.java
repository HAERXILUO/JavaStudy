package MultiThreadExample;

public class MultiThreadExample {
    public static void main(String[] args) {
        // 创建新线程
        Thread thread1 = new Thread(new MyRunnable(), "Thread 1");
        Thread thread2 = new MyThread("Thread 2");

        // 启动线程
        thread1.start();
        thread2.start();

        // 线程状态
        Thread.State state1 = thread1.getState();
        Thread.State state2 = thread2.getState();
        System.out.println("Thread 1 state: " + state1);
        System.out.println("Thread 2 state: " + state2);

        // 中断线程
        thread1.interrupt();
        thread2.interrupt();

        // 守护线程
        Thread daemonThread = new Thread(new DaemonRunnable());
        daemonThread.setDaemon(true); // 将线程 daemonThread 设置为守护线程
        daemonThread.start();

        // 线程同步和同步方法
        Counter counter = new Counter();// 创建一个计数器对象 counter
        Thread incrementThread = new Thread(new IncrementRunnable(counter));// 创建一个新线程 incrementThread，使用 IncrementRunnable 类作为任务，传入计数器对象 counter
        Thread decrementThread = new Thread(new DecrementRunnable(counter));// 创建一个新线程 decrementThread，使用 DecrementRunnable 类作为任务，传入计数器对象 counter
        incrementThread.start();
        decrementThread.start();

        // 死锁
        Object lock1 = new Object();// 创建锁对象 lock1
        Object lock2 = new Object();// 创建锁对象 lock2
        Thread threadA = new Thread(new DeadlockRunnable(lock1, lock2));// 创建一个新线程 threadA，使用 DeadlockRunnable 类作为任务，传入锁对象 lock1 和 lock2
        Thread threadB = new Thread(new DeadlockRunnable(lock2, lock1));
        threadA.start();
        threadB.start();
//        在这个例子中，有两个线程分别尝试获取lock1和lock2这两个对象的锁。线程A首先获取到了lock1的锁，然后休眠一段时间。在此期间，线程B启动并尝试获取lock2的锁。
//        由于线程A持有lock1的锁，所以线程B无法获得该锁，它被阻塞。同时，线程A休眠结束后继续执行，并尝试获取lock2的锁。
//        但是，由于线程B持有lock2的锁，所以线程A也无法获得该锁，它也被阻塞。这样，线程A和线程B都被阻塞在了互相等待对方释放锁的状态，从而形成了死锁。
        daemonThread.interrupt();
    }

//    在Java中，创建线程有两种方式：一种是直接继承Thread类，重写run()方法；另一种是实现Runnable接口，将任务代码放在run()方法中。
//    相比继承Thread类，实现Runnable接口更为灵活，因为Java是单继承的，如果已经继承了其他类，则无法再直接继承Thread类，而通过实现Runnable接口可以避免这个限制，使代码更加灵活和可扩展。
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("Thread 1 is running.");
                Thread.sleep(2000);
                System.out.println("Thread 1 is finished.");
            } catch (InterruptedException e) {
                System.out.println("Thread 1 is interrupted.");
            }
        }
    }

    static class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                System.out.println(getName() + " is running.");
                Thread.sleep(3000);
                System.out.println(getName() + " is finished.");
            } catch (InterruptedException e) {
                System.out.println(getName() + " is interrupted.");
            }
        }
    }

    static class DaemonRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("Daemon thread is running.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Daemon thread is interrupted.");
                }
            }
        }
    }

//    使用synchronized关键字实现线程同步，并通过同步方法对计数器进行增加和减少操作。
    static class Counter {
        private int count = 0;

        public synchronized void increment() {
            count++;
        }

        public synchronized void decrement() {
            count--;
        }

        public synchronized int getCount() {
            return count;
        }
    }

    static class IncrementRunnable implements Runnable {
        private Counter counter;

        public IncrementRunnable(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                counter.increment();
            }
        }
    }

    static class DecrementRunnable implements Runnable {
        private Counter counter;

        public DecrementRunnable(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                counter.decrement();
            }
        }
    }

    static class DeadlockRunnable implements Runnable {
        private Object lock1;
        private Object lock2;

        public DeadlockRunnable(Object lock1, Object lock2) {
            this.lock1 = lock1;
            this.lock2 = lock2;
        }

        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " acquired lock1.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " is interrupted.");
                }
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " acquired lock2.");
                }
            }
        }
    }
}
