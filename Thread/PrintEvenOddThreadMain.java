package Thread;

public class PrintEvenOddThreadMain {

    public static void main(String[] args) {

        PrintEvenOdd runnable1=new PrintEvenOdd(1);
        PrintEvenOdd runnable2=new PrintEvenOdd(0);

        Thread t1=new Thread(runnable1,"Thread 1");
        Thread t2=new Thread(runnable2,"Thread 2");

        t1.start();
        t2.start();
    }
}

//        Thread 2 outside sync -->  1
//        Thread 1 outside sync -->  1
//        Thread 2 inside sync -->  1
//        Thread 2 before wait sync -->  1
//        Thread 1 inside sync -->  1
//        Thread 1 result -->  1
//        Thread 1 outside sync -->  2
//        Thread 2 after wait sync -->  2
//        Thread 2 result -->  2
//        Thread 2 outside sync -->  3
//        Thread 1 inside sync -->  3
//        Thread 1 result -->  3
//        Thread 1 outside sync -->  4
//        Thread 2 inside sync -->  4
//        Thread 2 result -->  4
//        Thread 2 outside sync -->  5
//        Thread 1 inside sync -->  5
//        Thread 1 result -->  5
//        Thread 1 outside sync -->  6
//        Thread 2 inside sync -->  6
//        Thread 2 result -->  6
//        Thread 2 outside sync -->  7
//        Thread 1 inside sync -->  7
//        Thread 1 result -->  7
//        Thread 1 outside sync -->  8
//        Thread 2 inside sync -->  8
//        Thread 2 result -->  8
//        Thread 2 outside sync -->  9
//        Thread 1 inside sync -->  9
//        Thread 1 result -->  9
//        Thread 1 outside sync -->  10
//        Thread 2 inside sync -->  10
//        Thread 2 result -->  10
//        Thread 2 outside sync -->  11
//        Thread 1 inside sync -->  11
//        Thread 1 result -->  11
//        Thread 1 outside sync -->  12
//        Thread 2 inside sync -->  12
//        Thread 2 result -->  12
//        Thread 2 outside sync -->  13
//        Thread 1 inside sync -->  13
//        Thread 1 result -->  13
//        Thread 1 outside sync -->  14
//        Thread 2 inside sync -->  14
//        Thread 2 result -->  14
//        Thread 2 outside sync -->  15
//        Thread 1 inside sync -->  15
//        Thread 1 result -->  15
//        Thread 1 outside sync -->  16
//        Thread 2 inside sync -->  16
//        Thread 2 result -->  16
//        Thread 2 outside sync -->  17
//        Thread 1 inside sync -->  17
//        Thread 1 result -->  17
//        Thread 1 outside sync -->  18
//        Thread 2 inside sync -->  18
//        Thread 2 result -->  18
//        Thread 2 outside sync -->  19
//        Thread 1 inside sync -->  19
//        Thread 1 result -->  19
//        Thread 2 inside sync -->  20
//        Thread 2 result -->  20