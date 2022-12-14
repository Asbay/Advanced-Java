package Generics;

public class NonGenericType {



    private Object o ;

    //getter - setter
    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }


    //main methodu
    public static void main(String[] args) {
        NonGenericType obj1 = new NonGenericType();
        NonGenericType obj2 = new NonGenericType();

        obj1.setO("Mirac"); // string ile set edildi
        obj2.setO(65);    //bütün int lar ayni zamanda obj dolayisiyla o object oldugu icin hepsini yazabilirim

        String str1 = (String) obj1.getO();
        System.out.println(str1);

        String str2= (String) obj2.getO(); //run time exception aticak yani calistiktan sonra hata verecek. ClassCastException
        //String.valueOf(obj2.getO());
        //Integer.parseInt(String);
        System.out.println(str2); //burda hata alicaz parseInt daha hizli calisir.
    }
}
