package javarush.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Irina on 18.02.2017.
 * https://metanit.com/java/tutorial/8.9.php
 * используется общий ресурс CommonResource, для управления которым создается пять потоков.
 * На входе в критическую секцию устанавливается заглушка
 */
class CountThread implements Runnable{

    CommonResource res;
    ReentrantLock locker;

    CountThread(CommonResource res, ReentrantLock lock){
        this.res=res;
        locker = lock;
    }
    public void run(){

        locker.lock(); // устанавливаем блокировку
        try{
            res.x=1;
            for (int i = 1; i < 5; i++){
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                res.x++;
                Thread.sleep(100);
            }
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        finally{
            locker.unlock(); // снимаем блокировку
        }
    }
}
