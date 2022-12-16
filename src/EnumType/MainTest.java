package EnumType;

public class MainTest {

    public static void main(String[] args) {

        useConstantMethod(1);
        useConstantMethod(2);
        useConstantMethod(3);
        useConstantMethod(4);
        useConstantMethod(100);
        useConstantMethod(5);  //CTE vermiyor
// 5 degeri yok ama hata vermiyor  sen bunu yazamazsin demesi lazim ama demiyor enum iste bunu sagliyor ve olmayan degeri girdirmiyo


    }

    //eski tarz
    private static void useConstantMethod(int i) {

        if (i == TransactionTypeConstant.DEPOSIT) {
            System.out.println("Money is depositing");
        } else if (i == TransactionTypeConstant.WITHDRAW) {
            System.out.println("Money is withdrawing");
        } else if (i == TransactionTypeConstant.TRANSFER) {
            System.out.println("Money is transfering");
        } else if (i == TransactionTypeConstant.PAYMENT) {
            System.out.println("Money is being made ");
        } else if (i == TransactionTypeConstant.OTHER) {
            System.out.println("other transaction");
        }
    }

    // enum yapıyla
    private static void useEnumMethod(TransactionType transactionType) {
        if (transactionType == TransactionType.DEPOSIT) {
            System.out.println("Money is depositing");
        } else if (transactionType == TransactionType.PAYMENT) {
            System.out.println("Money is being made");
        } else if (transactionType == TransactionType.WITHDRAW) {
            System.out.println("Money is withdrawing");

        } else if (transactionType == TransactionType.TRANSFER) {
            System.out.println("Money is tranfering");
        } else if (transactionType == TransactionType.OTHER) {
            System.out.println("Other transaction");
        }

    //not: Enum yapiya has methodlar
        System.out.println("Enum name : "+ transactionType.name());  //Enum ismini ekrana yazdirir
        System.out.println("Enum Coder Value : "+ transactionType.getTransactionCode());  // numeric deger yazdiracak
        System.out.println("Enum Ordinal : "+ transactionType.ordinal()); //

}
}




