package syerraBeyts.glava_18.p_646;

import java.rmi.Naming;

/**
 * Заносим сервис в реестр RMI.
 * @autor irinaff
 * @since 06.02.2017
 **/

public class TestMyRemotelmpl {
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
            System.setProperty("java.rmi.server.hostname","192.168.88.45");
            Naming.rebind("RemoteHello", service);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
