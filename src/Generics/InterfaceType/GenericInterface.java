package Generics.InterfaceType;

public interface GenericInterface<T> {

    void setValue(T t);
    //Generic: Data türünden bağımsız yapılar oluşturmamızı sağlar
    T getValue();

}
