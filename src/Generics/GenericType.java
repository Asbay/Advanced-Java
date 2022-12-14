package Generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericType<T> {


    /*
    E harfi element demektir collection gibi yapilarda kullanilir
    K harfi Key kelimesini sembol eder
    V harfi Value temsil eder  Map<K,V>
    N harfi number temsil eder
    T harfi Type yani int string genel olarak hepsi
    S , U , V ....     2. 3. 4. tipler icin
     */
    private T type; //field variale

    //getter setter
    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    //main method
    public static void main(String[] args) {
        //generic yapi kullanilarak ayni classdan iki farkli data türünde obje olusturalimG

        GenericType<String> obj1 = new GenericType<>();
        //Trick; diamond icine non primitive type kullanabiliriz
        obj1.setType("Generic Types");

        //GenericType<String> obj2 = new GenericType<>();
        //obj2.setType(65);  string girmem gerekirken int girdim dolayisiyla CTE verdi

        //not Cast probleminden nasil kurtulurum
        GenericType<Integer> obj3= new GenericType<>();
        obj3.setType(65);
        int a = obj3.getType(); //CAST probleminden kurtulduk

        //not classcastexception probleminden nasil kurtulurum
        List<String> list = new ArrayList<>();
        list.add("Alper");
        list.add("Halide");
        //list.add(22);   classcastexception dan kurtulduk

        Map<Integer, String >  map= new HashMap<>();
        map.put(1,"Generic");
        //map.put("generic",1); yazdigimizda hata oluyo uyariyo






    }
}
