package AdvJavaPractice.volatilekeyword;

public class Numerator {

    private volatile static int counter=0;
    //volatile keyword u  degiskenin main memory de saklanmasini garanti eder ancak
    // tüm threadlerin degiskene ayni anda ulasmasindan kaynakli cakismayi cozme garantisi yoktur
    //bunun icin synchronized key wordude kullanilmai

    public synchronized  void getOrder(){
        String name=Thread.currentThread().getName();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        counter++;
        System.out.println("Sayın "+name+" sıranız: "+counter);
    }
}