package syerraBeyts.glava_15.p_537;

/**
 * общая задача Райана и Моники
 * проверка балагса и снятие наличных
 * @autor irinaff
 * @since 03.02.2017
 **/

public class RyanAndMonicaJob implements Runnable {
    //Одина общий банковский счет
    private BankAccount account = new BankAccount();

    public static void main (String [] args) {
        //один экземпляр задачи
        RyanAndMonicaJob theJob = new RyanAndMonicaJob();
        //два потока которые будут работать с одним экземпляром счета
        Thread one = new Thread (theJob) ;
        Thread two = new Thread (theJob) ;
        one.setName("Райан") ;
        two. setName ("Моника") ;
        one.start() ;
        two.start();
    }

    public void run() {
        //поток зацикливается и в каждой итерации пытается снять деньги со счета
        //после снятия он еще раз проверяет баланс
        for (int i = 0; i < 10; i++) {
            makeWithdrawal(10);
            if (account.getBalance() < 0) {
                System.out.println( "Превышение лимита " + account.getBalance());
            }
        }
    }

    //проверка баланса и снятие наличных
    private synchronized void makeWithdrawal (int amount) {
        //проверяем баланс, если денег недостаточно - выводим сообщение
        //если достаточно - приостанавливаем поток, затем делаем транзакцию
        if (account.getBalance() >= amount) {
            System.out.println( Thread.currentThread().getName() +
                    " собирается снять деньги " + amount +
                    " (" + account.getBalance() + ")");
            try {
                System.out.println( Thread.currentThread().getName() +
                        " идет подремать");
                Thread.sleep(500);
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println( Thread.currentThread().getName() +
                    " просыпается");
            account.withdraw(amount);
            System.out.println( Thread.currentThread().getName() +
                    " заканчивает транзакцию");

        } else {
            System.out.println( "Извините, для клиента " +
                    Thread.currentThread().getName() +
                    " недостаточно средств: " + account.getBalance());
        }
    }
}
