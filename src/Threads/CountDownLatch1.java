package Threads;

import java.util.concurrent.CountDownLatch;

public class CountDownLatch1 {


    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(4); // 4 thread göndercem bunlari calistir digerlerini durdur
        //threadler olusturuluyo
        WorkerThreads worker1 = new WorkerThreads("Worker-1",5000,latch);
        WorkerThreads worker2 = new WorkerThreads("Worker-2",7000,latch);
        WorkerThreads worker3 = new WorkerThreads("Worker-3",9000,latch);
        WorkerThreads worker4 = new WorkerThreads("Worker-4",11000,latch);

        //start() methodlarini cagir
        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();
        //System.out.println(Thread.currentThread().getName()+ " has finished");
        try {
            latch.await();  //countdown sifira inene kadar bekletir
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // bu kod yukaridaki threadler bitene kadar calismaz main thread bekletilir digerlerinin isi bitene kadar
        System.out.println(Thread.currentThread().getName()+ " has finished");
        /*output
        Worker-1 calisiyor
        Worker-2 calisiyor
        Worker-3 calisiyor
        Worker-4 calisiyor
        main has finished
*/


    }
}

     class WorkerThreads extends  Thread{

     private int delay;
     private CountDownLatch latch;


         public WorkerThreads(String name, int delay, CountDownLatch latch) {
             super(name);
             this.delay = delay;
             this.latch = latch;
         }

         @Override
         public void run() {
             try {
                 Thread.sleep(delay);//mainden burada ne kadar bekleyecegini belirleyecegiz
                 System.out.println(Thread.currentThread().getName()+ " calisiyor");
                 latch.countDown(); // Thread saysisi 4 dü sayi sifira düsünce diger bekleyen threadlere gecis yapilacak geciyor
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
         }
     }
