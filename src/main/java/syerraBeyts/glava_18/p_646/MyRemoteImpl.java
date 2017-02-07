package syerraBeyts.glava_18.p_646;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;

/**
 * Шаг второй: создаем реализацию удаленного интерфейса
 * при запуске приложения указать программный аргумент
 * -Djava.security.policy=server.policy
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
    /*
         Теперь, когда вы получили удаленный сервис, требуется сделать его
     доступным для удаленных клиентов. Создайте экземпляр сервиса
     и поместите его в реестр RMI (который должен в это время работать,
     иначе выделенная строка приведет к ошибке). При регистрации
     сервисного объекта RMI на самом деле помещает в реестр «заглушку»,
     так как именно она нужна клиенту. Весь процесс осуществляется
     с помощью статического метода rebind() из класса java.rmi.Naming
         */
    public static void main(String[] args) {

        //Заносим сервис в реестр RMI
        try {
            MyRemote service = new MyRemoteImpl();
            //делать не нужно, происходит при создании объекта с extends UnicastRemoteObject
            //MyRemote stub = (MyRemote)UnicastRemoteObject.exportObject(service, 0);
            Registry registry = LocateRegistry.createRegistry(12345);
            registry.bind("Remote Hello", service);
            //Naming.rebind("RemoteHello", service);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
