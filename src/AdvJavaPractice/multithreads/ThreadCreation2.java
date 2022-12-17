package AdvJavaPractice.multithreads;

public class ThreadCreation2 {

    //Task2:Runnable interfaceni implement eden Counter isminde sınıf oluşturup
    // bu sınıftan harfleri a dan z ye kadar yazdıran iki tane thread oluşturunuz.
    public static void main(String[] args) throws InterruptedException {

        System.out.println("yaris baslasin");


        Counter c1 = new Counter("Ayse");
        Counter c2 = new Counter("Ali");


        Thread thread1 = new Thread(c1);
        Thread thread2= new Thread(c2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("yaris bitti....");

        //Task3: Threadler başlamadan önce Yarış başlasın ve bitince Yarış bitti
        //yazdırın.


    }

}