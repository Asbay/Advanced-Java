package Threads;

public class MultiThreading044 {

    // methodun icindeki kisimda  synchronized var
    public static void main(String[] args) throws InterruptedException {
        Brackets22 brackets2 = new Brackets22();

        long startTime = System.currentTimeMillis();

        // thread 1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1 ; i<=7; i++) {
                    brackets2.generateBrackets();
                }
            }
        });
        thread1.start();

        // thread 2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =1; i<=7; i++) {
                    brackets2.generateBrackets();
                }
            }
        });
        thread2.start();

        thread1.join();
        thread2.join();

        long endTime = System.currentTimeMillis();

        //System.out.println("Toplam geçen süre : " + (endTime-startTime)); // 3814
        System.out.println("Toplam geçen süre : " + (endTime-startTime)); // 1807

    }
}

class Brackets22 {
    public void generateBrackets(){
        synchronized (this) {
            for(int i=1; i<=10;i++) {
                if(i<=5) {
                    System.out.print("[");
                }else {
                    System.out.print("]");
                }
            } // endOf for
            System.out.println("");
        }

        for(int i=1;i<=5;i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


