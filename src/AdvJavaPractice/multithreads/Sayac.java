package AdvJavaPractice.multithreads;

public class Sayac extends Thread{
    //Task1: Thread sınıfını extend eden Sayac isminde sınıf oluşturup
// bu sınıftan sayıları 1 den 100 e kadar yazdıran iki tane thread oluşturunuz.

    private String name;

    public Sayac(String name) {

        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name+ "basladi");
        for (int i = 1; i<=20; i++){
            System.out.println(this.name+ "-" + i);

        }
        System.out.println(this.name+ "bitirdi ");

    }
}
