package Threads;

public class MultiThreading02 {


    //threadler ayni kaynaga ulasmak isterlerse ne olacak
    public static int counter=0;

    public static void main(String[] args) {

        //ayri iki thread oluturup ayni kaynagaerismesini saglayalim
        Thread thread1= new Thread(new Runnable() {
            @Override
            public void run() {
                Counter.count();
                System.out.println("Thread1 calisti");
            }
        });
        thread1.start();
        //2.thread olustur
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Counter.count();
                System.out.println("Thread2 calisti");
            }
        });
        thread2.start();

    }
}


     class Counter{


    public synchronized static void count(){// synchronized ile bu metoda giren threadleri sıraya koymuş olduk
        // method içine aynı anda sadece 1 thread girebilecek
//synchronized  yazdigimizda methodun icine sadece bir tane thread girebilir
        for( int i =1; i<=10; i++){


            MultiThreading02.counter++;
        }
        System.out.println("Counter : "+ MultiThreading02.counter);

    }
     }