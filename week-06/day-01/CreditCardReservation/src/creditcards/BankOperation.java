package creditcards;

public class BankOperation {
    public static void main(String[] args) {
        CreditCardList cardList = new CreditCardList(10);

        for(CreditCard card : cardList.list) {
            System.out.println(card);
        }
    }
}
