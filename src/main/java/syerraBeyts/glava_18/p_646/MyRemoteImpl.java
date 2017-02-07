package syerraBeyts.glava_18.p_646;

import java.rmi.*;
import java.rmi.server.*;

/**
 * Шаг второй: создаем реализацию удаленного интерфейса
 * @autor irinaff
 * @since 06.02.2017
 **/

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    //Реализуем удаленный интерфейс.
     public String sayHello() {
        return "Сервер говорит: 'Привет'";
    }
    //Расширяем UnicastRemoteObject
    //Создаем конструктор без аргументов,
    // объявляя исключение RemoteException.
    public MyRemoteImpl() throws RemoteException {
    }

    public static void main(String[] args) {
        //Заносим сервис в реестр RMI
        try {
            MyRemote service = new MyRemoteImpl();
            //System.setProperty("java.rmi.server.hostname","192.168.88.45");
            Naming.rebind("Remote Hello", service);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
