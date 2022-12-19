package Threads;

public class DeadLockDemo {




    public static void main(String[] args) {


        final String lock1 = "lock1";
        final String lock2 = "lock2";

        //thread1
        Thread thread1= new Thread(new Runnable() {
            @Override
            public void run() {
           synchronized (lock1){
               System.out.println("Thread1, lock1 degiskeni kilitlendi");

               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               synchronized (lock2){
                   System.out.println("Thread1 lock2 degiskeni kitlendi");
               }//lock2 yi burda birakiyo
           }    //lock1 i burda birakiyo
            }
        });
        thread1.start();

        //thread2
        /* //BU KODu bu sekilde yazarsak  SONSUZ DÖNGÜDE IKISIDE BIRBIRINI BEKLer o yüzden asagidaki gibi yazacagiz
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2){
                    System.out.println("Thread2, lock2 degiskeni kilitlendi");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (lock1){
                        System.out.println("Thread2 lock2 degiskeni kitlendi");
                    }//lock2 yi burda birakiyo
                }    //lock1 i burda birakiyo

            }
        });
*/

        //bu kisim deadlock bu duruma göre düzenleyip öyle calistiracagiz
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1){
                    System.out.println("Thread2, lock2 degiskeni kilitlendi");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (lock2){
                        System.out.println("Thread2 lock2 degiskeni kitlendi");
                    }//lock2 yi burda birakiyo
                }    //lock1 i burda birakiyo

            }
        });
        thread2.start();
    }
}