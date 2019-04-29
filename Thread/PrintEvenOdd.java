package Thread;

public class PrintEvenOdd implements Runnable{

    public int MAX=20;
    static int  num=1;
    int remainder;
    static Object lock=new Object();

    PrintEvenOdd(int remainder)
    {
        this.remainder=remainder;
    }

    @Override
    public  void run() {
        while (num < MAX) {
            System.out.println(Thread.currentThread().getName() + " outside sync -->  " + num);
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " inside sync -->  " + num);
                while (num % 2 != remainder) { // wait for numbers other than remainder
                    try {
                        System.out.println(Thread.currentThread().getName() + " before wait sync -->  " + num);
                        lock.wait();
                        System.out.println(Thread.currentThread().getName() + " after wait sync -->  " + num);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " result -->  " + num);
                num++;
                lock.notifyAll();
            }
        }
    }
}