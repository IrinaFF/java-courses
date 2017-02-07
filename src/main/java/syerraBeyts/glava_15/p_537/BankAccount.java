package syerraBeyts.glava_15.p_537;

/**
 * банковский счет
 * @autor irinaff
 * @since 03.02.2017
 **/

public class BankAccount {
    private int balance = 100;
    public int getBalance() {
        return balance;
    }
    public void withdraw (int amount) {
        balance = balance - amount;
    }
}
