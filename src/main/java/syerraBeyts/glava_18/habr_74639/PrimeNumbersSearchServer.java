package syerraBeyts.glava_18.habr_74639;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import syerraBeyts.glava_18.habr_74639.ClientRegister;
import syerraBeyts.glava_18.habr_74639.PrimeChecker;
/**
 * реализация сервера (полный код):
 * @autor irinaff
 * @since 06.02.2017
 **/



public class PrimeNumbersSearchServer implements ClientRegister {
    /** checkers queue */
    private BlockingQueue<PrimeChecker> availableCheckers =
            new LinkedBlockingQueue<PrimeChecker> ();

    /** current number */
    private BigDecimal number = BigDecimal.ONE;

    public void register(PrimeChecker checker) throws RemoteException {
        availableCheckers.add(checker);
    }

    public void startSearch () {
        while (true) {
            try {
                final PrimeChecker checker = availableCheckers.take();
                final BigDecimal numberToCkeck = increment();

                new Thread(new Runnable () {
                    public void run () {
                        try {
                            if (checker.check(numberToCkeck)) {
                                System.out.println (numberToCkeck);
                            }
                            availableCheckers.add (checker);
                            System.out.println ("size: " + availableCheckers.size());
                        } catch (RemoteException e) {
                            System.out.println ("Client disconnected or unknown error occured");
                        }
                    }
                }).start();

            } catch (InterruptedException e) {

            }
        }
    }

    private synchronized BigDecimal increment () {
        number = number.add(BigDecimal.ONE);
        return number;
    }

    public static void main(String[] args) {
        PrimeNumbersSearchServer server = new PrimeNumbersSearchServer();

        try {
            //Экспортируем удалённый объект и получаем stub,
            // посредством которого клиент будет вызывать методы нашего объекта.
            //Второй параметр exportObject — порт,
            // который будет использоваться для соеденения с удалённым объектом
            //0 — выбор любого свободного порта.
            ClientRegister stub = (ClientRegister)UnicastRemoteObject.exportObject(server, 0);
            //stub нужно передать клиенту. Тут возможны совершенно разные варианты.
            //Можно даже передать stub клиенту на дискете 3.5''
            //Мы воспользуемся RMI-регистратором. Его можно как создать внутри нашей vm,
            // так и использовать «внешний», представляемый утилитой rmiregistry.
            //использовал первый вариант
            Registry registry = LocateRegistry.createRegistry(12345);
            //Создаём регистратор и связываем наш stub с именем ClientRegister
            //Регистратор будет принимать соеденения на 12345 порту
            registry.bind("ClientRegister", stub);

            server.startSearch();
        } catch (Exception e) {
            System.out.println ("Error occured: " + e.getMessage());
            System.exit (1);
        }
    }
}