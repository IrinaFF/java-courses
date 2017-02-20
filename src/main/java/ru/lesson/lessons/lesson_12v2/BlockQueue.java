package ru.lesson.lessons.lesson_12v2;

import java.util.LinkedList;

/**
 * реализация блокирующей очереди
 * @autor irinaff
 * @since 22.10.2016
 **/

//public class BlockQueue<T> {
public class BlockQueue<T> {
    //реализация линкед-листа может работать в качестве очереди
    //эта реализация не синхронизарована, не дает гарантию работы автономности
    public final LinkedList<T> gueue = new LinkedList<T>();
    /**
     * потоки - продьюсеры, которые пишут в очередь
     **/
    public void push(final T t) {
        //блок synchronized - блокировка
        synchronized (this.gueue) {
            //данные записывает
            this.gueue.add(t);
            //сообщение монитору что все кто ждал появления новых данных должен проснуться
            //метод notifyAll говорит треду wait - проснуться
            this.gueue.notifyAll();
        }
    }
    /**
     * потоки - которые читают из очереди
     **/
    public T poll() {
        //блок synchronized - блокировка
        synchronized (this.gueue) {
            //если очередь пустая
            //цикл while позволяет избежать ситуации когда
            // мы пытаемся данные считать
            //а данные уже кто-то считал
            while (this.gueue.isEmpty()) {
                try {
                    //мы должны нашего кастомера заблочить
                    //он будет ждать пока наша очередь наполнится
                    //разблокируем очередь
                    //Метод wait выключает тред, спящий режим
                    this.gueue.wait();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //если данные появились их еще никто не забрал
            // выходим из цикла и считываем данные
            return this.gueue.remove();
        }
    }
}
