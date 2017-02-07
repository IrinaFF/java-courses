package syerraBeyts.glava_18.habr_74639;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import syerraBeyts.glava_18.habr_74639.ClientRegister;
import syerraBeyts.glava_18.habr_74639.PrimeChecker;

/**
 * клиент
 * @autor irinaff
 * @since 06.02.2017
 **/

public class PrimeNumbersSearchClient implements PrimeChecker {

    public boolean check(BigDecimal number) throws RemoteException {
        boolean isPrime = true;
        BigDecimal i = new BigDecimal (2);

        /* mistaken? */
        BigDecimal sqrt = new BigDecimal (Math.sqrt(number.doubleValue()));
        BigDecimal div = number.divide (sqrt, BigDecimal.ROUND_UP);
        /* sqrt must be equal or greater than root of number */
        if(div.compareTo (sqrt) == 1) {
            sqrt = div;
        }

        /* while i less than sqrt */
        while(i.compareTo(sqrt) == -1) {
            if(number.divideAndRemainder(i)[1].compareTo(BigDecimal.ZERO) == 0) {
                isPrime = false;
                break;
            }
            i = i.add(BigDecimal.ONE);
        }

        System.out.println (number + ((isPrime) ? " is prime" : " is not prime"));

        try {
            Thread.sleep(100);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        return isPrime;
    }

    public static void main(String[] args) {
        PrimeNumbersSearchClient client = new PrimeNumbersSearchClient();

        try {
            //Клиенту нужно получить серверный stub, чтобы зарегистрироваться
            //Находим удалённый регистратор и запрашиваем у него stub связанный с именем «ClientRegister».
            //Первый параметр LocateRegistry.getRegistry(null, 12345) — хост (null — localhost), второй — порт.
            Registry registry = LocateRegistry.getRegistry(null, 12345);
            ClientRegister server = (ClientRegister)registry.lookup("ClientRegister");

            //Далее экспортируем клиентский удалённый объект и
            //передадим серверу stub (уже клиентский) — зарегистрируемся.
            //Сервер добавит клиента в очередь доступных checker'ов и начнёт передавать ему числа для проверки.
            //После проверки, если она завершилась без ошибок, клиент снова попадает в очередь и т.д.
            PrimeChecker stub = (PrimeChecker)UnicastRemoteObject.exportObject(client, 0);
            server.register(stub);

        } catch (Exception e) {
            System.out.println ("Error occured: " + e.getMessage());
            System.exit (1);
        }
    }
}
