package 死锁;

import 树.TreeNode;

/**
 * Created by huajian.yuan on 2017/8/5.
 */
public class DeadLock implements Runnable{

    private Object o1;
    private Object o2;

    public DeadLock(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    public void f(Object o1, Object o2) {
        synchronized (o1) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2) {
                System.out.println("死锁+++++++");
            }
        }
    }


    @Override
    public void run() {
        f(o1,o2);
    }

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        for (int i = 0; i < 100; i++) {
            Thread thread1 = new Thread(new DeadLock(o1, o2));
            Thread thread2 = new Thread(new DeadLock(o2, o1));

            thread1.start();
            thread2.start();
        }

    }

}
