package syerraBeyts.glava_18.p_646;

import java.rmi.*;

/**
 * Шаг первый: создаем удаленный интерфейс
 * @autor irinaff
 * @since 06.02.2017
 **/

public interface MyRemote extends Remote {
    //каждый вызов удаленного метода рассмтриввается как опасный
    //Аргументы и возвращаемые значения удаленного метода должны быть
    //либо примитивами, либо реализациями интерфейса Serializable.
    public String sayHello() throws RemoteException;
}
