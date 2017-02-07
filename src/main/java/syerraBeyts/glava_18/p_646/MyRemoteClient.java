package syerraBeyts.glava_18.p_646;

import java.rmi.*;

/**
 * Полная версия кода клиента
 * @autor irinaff
 * @since 06.02.2017
 **/

public class MyRemoteClient {
    /*
    на момент поиска клиент должен иметь класс «заглушки»
    (который вы сгенерировали с помощью rmic),
    иначе он не сможет ее десериализовать.
     */


    public static void main(String[] args) {
        new MyRemoteClient().go();
    }

    public void go () {
        try {
            //ищем в реестре сервис с именем RemoteHello
            //реестр возвращает значение класса Object
            MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
            String s = service.sayHello();
            System.out.println(s);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
