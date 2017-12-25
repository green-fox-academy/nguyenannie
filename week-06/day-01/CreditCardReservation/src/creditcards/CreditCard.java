package creditcards;

import java.util.Random;

public class CreditCard implements CreditCardy {
    private String cardHolderName;
    private String codeAccount;

    CreditCard(String cardHolderName) {
        codeAccount = generateCodeAccount();
        this.cardHolderName = cardHolderName;
    }

    @Override
    public int getSumCVV() {
        return computeSumCVV(codeAccount);
    }

    @Override
    public String getNameCardholder() {
        return cardHolderName;
    }

    private String generateCodeAccount() {
        String CC = "";
        Random r = new Random();
        for(int i = 0; i < 16; i++) {
            int num = r.nextInt(9);
            CC += Integer.toString(num);
        }
        return CC;
    }
    @Override
    public String getCodeAccount() {
        return this.codeAccount;
    }

    @Override
    public int computeSumCVV(String codeAccount) {
        int sum = 0;
        for(int i = 0; i < codeAccount.length(); i++) {
            sum += Character.getNumericValue(codeAccount.charAt(i));
        }
        return sum;
    }

    @Override
    public String toString() {
        return String.format("Name=%s CC#=%s CVV=%d", cardHolderName, getCodeAccount(), getSumCVV());
    }
}
