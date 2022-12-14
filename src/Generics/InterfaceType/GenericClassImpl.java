package Generics.InterfaceType;

public class GenericClassImpl<T> implements GenericInterface<T>{

    //eger bir "generic interface " implement edecekseniz class da generic olmali

    @Override
    public void setValue(T t) {

    }

    @Override
    public T getValue() {
        return null;
    }
}
