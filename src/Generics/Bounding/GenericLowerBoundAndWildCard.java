package Generics.Bounding;

import java.util.ArrayList;
import java.util.List;

public class GenericLowerBoundAndWildCard {

    public static void main(String[] args) {
        List<Object> ol= new ArrayList<>();
        addElements(ol);

        List<Number> nl = new ArrayList<>();
        addElements(nl);


        //List<Double> dl= new ArrayList<>();
        //addElements(dl);

        //******** printElement() methodlari
        printElements(new ArrayList<String>());
      //   yukardaki ile ayni isi yapar
        // List<String> st= new ArrayList<>();
      //  printElements(st);

        //******* printObj
        List<String> strList = new ArrayList<>();
       //printObj(strList);         //burasi com. t. exception verdi

        List<Object> objectList=new ArrayList<>();
        printObj(objectList);


    }



    // super Integer dan kasit bana Integerin parentlarini getir demek . en altta integera kadar inebilirim number ve object olabilir(parent)
    public static void addElements(List<? super Integer> list){
        //? :WildCard tipi bilinmeyen demek
        for(int i =1; i<=10; i++){
            list.add(i);

        }
    }
    //wildcard sinirlamalari
    public static void printElements(List<?> listOfUnknown) {

        //     listOfUnknown.add("java");   //burada hata verdi.. cünkü ? den dolayi datatürünü netlestirmeden add mahodu gibi islemleri yaptirmiyo
        //    listOfUnknown.add(null);  //bisey eklemek illa gerekirse sadece null gelebilir
        for (Object object : listOfUnknown) {
            System.out.println(object);
        }

    }

    // ? --> Object
    public static void printObj(List<Object> listOfObject) {
        listOfObject.add("Java");

        for (Object object: listOfObject) {
            System.out.println(object);
        }

    }




}
