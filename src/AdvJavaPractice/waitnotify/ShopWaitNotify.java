package AdvJavaPractice.waitnotify;

public class ShopWaitNotify {
    /*
TASK: Bir marketteki stok miktarını takip eden bir uygulama tasarlayınız.
      Markette yeterli ürün yoksa yeni ürün gelmesi beklensin.
      Yeni ürün eklenince ürün satışı gerçekleşsin.
*/

    public static volatile int stock =0;

    public static void main(String[] args) {
        ShopWaitNotify shop= new ShopWaitNotify();

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
           shop.consumeProdukt(3);
            }
        });
        consumerThread.setName("Tüketici");
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                shop.produceProduct(2);
            }
        });
        producerThread.setName("üretici");

        consumerThread.start();
        producerThread.start();

    }

    public synchronized void consumeProdukt(int amount){

        if(amount > stock){
            System.out.println(Thread.currentThread().getName()+ " ürün satin almak istiyor");
            System.out.println("yeterli ürün yok. Güncel ürün stogu: "+ stock);
            System.out.println();
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if(amount <= stock){
            System.out.println();

            System.out.println(Thread.currentThread().getName()+ " ürün satin almak istiyor");
            System.out.println("ürün satin alinda , stoktan düsürülüyor");
            stock = stock - amount;
            System.out.println("güncel stock: "+ stock);
        }else{
            System.out.println(Thread.currentThread().getName()+ " ürün satin almak istiyor");
            System.out.println("yeterli ürün yok. Güncel ürün stogu: "+ stock);
            System.out.println("yarin gel");
        }
    }

    public synchronized void produceProduct(int amount){
        System.out.println(Thread.currentThread().getName()+" ürün eklemek istiyor");
        System.out.println("yeni ürünler eklendi, stok güncelleniyor");
        stock = stock+ amount;
        System.out.println("Güncel stok: "+ stock);
        notify();
        System.out.println();
    }

}
