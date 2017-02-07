package syerraBeyts.glava_18.habr_74639;

import java.math.*;
import java.rmi.*;
/**
 * Решать задачу будем так:
 * есть сервер, который будет «скармливать» числа на проверку «зарегистрировавшимся» клиентам,
 * посему взаимодействовать мы будем в обоих направлениях
 * (клиент -> сервер — регистрация,
 * сервер -> клиент — число на проверку),
 * для этого опишем 2 интерфейса
 * https://habrahabr.ru/post/74639/
 * @autor irinaff
 * @since 06.02.2017
 **/

//сервер -> клиент — число на проверку
//Сервер использует PrimeChecker для передачи клиенту числа на проверку
public interface PrimeChecker extends Remote {
    public boolean check (BigDecimal number) throws RemoteException;
}
