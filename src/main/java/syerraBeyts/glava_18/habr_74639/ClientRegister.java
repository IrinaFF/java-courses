package syerraBeyts.glava_18.habr_74639;

import java.rmi.*;

/**
 * Решать задачу будем так:
 * есть сервер, который будет «скармливать» числа на проверку «зарегистрировавшимся» клиентам,
 * посему взаимодействовать мы будем в обоих направлениях
 * (клиент -> сервер — регистрация,
 * сервер -> клиент — число на проверку),
 * для этого опишем 2 интерфейса
 * @autor irinaff
 * @since 06.02.2017
 **/
//клиент -> сервер — регистрация
//Интерфейс ClientRegister ипользуется клиентом
// для регистрации себя на сервере в роли PrimeChecker`a.
public interface ClientRegister extends Remote {
    public void register (PrimeChecker checker) throws RemoteException;
}
