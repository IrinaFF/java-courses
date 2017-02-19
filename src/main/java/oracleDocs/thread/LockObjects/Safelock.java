package oracleDocs.thread.LockObjects;

/**
 * Created by Irina on 17.02.2017.
 * Here is the source code for the improved model, Safelock.
 * To demonstrate the versatility of this idiom, we assume that Alphonse and Gaston are so
 * infatuated with their newfound ability to bow safely that they can't stop bowing to each other:
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;

public class Safelock {
    static class Friend {
        private final String name;
        private final Lock lock = new ReentrantLock();

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public boolean impendingBow(Friend bower) {
            Boolean myLock = false;
            Boolean yourLock = false;
            try {
                myLock = lock.tryLock();
                System.out.println("myLock " + myLock);
                yourLock = bower.lock.tryLock();
                System.out.println("yourLock " + myLock);
            } finally {
                if (! (myLock && yourLock)) {
                    if (myLock) {
                        lock.unlock();
                    }
                    if (yourLock) {
                        bower.lock.unlock();
                    }
                }
            }
            return myLock && yourLock;
        }

        public void bow(Friend bower) {
            if (impendingBow(bower)) {
                System.out.println("получили обе блокировки");
                try {
                    //System.out.format("%s: %s has"
                                    //+ " bowed to me!%n",
                            //this.name, bower.getName());
                    System.out.println(" туда bow от " + this.name +  " кому " + bower.getName());
                    bower.bowBack(this);
                } finally {
                    lock.unlock();
                    bower.lock.unlock();
                }
            } else {
                //System.out.format("%s: %s started"
                                //+ " to bow to me, but saw that"
                                //+ " I was already bowing to"
                                //+ " him.%n",
                        //this.name, bower.getName());
                System.out.println("bow  else от " + this.name +  " кому " + bower.getName());
            }
        }

        public void bowBack(Friend bower) {
            //System.out.format("%s: %s has" +
                           // " bowed back to me!%n",
                    //this.name, bower.getName());
            System.out.println("обратно bowBack от " + this.name +  " кому " + bower.getName());
        }
    }

    static class BowLoop implements Runnable {
        private Friend bower;
        private Friend bowee;

        public BowLoop(Friend bower, Friend bowee) {
            this.bower = bower;
            this.bowee = bowee;
        }

        public void run() {
            Random random = new Random();
            for (int i =0;  i< 5; i++) {
                System.out.println("i = " + i);
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {}
                bowee.bow(bower);
            }
        }
    }


    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston =   new Friend("Gaston");
        new Thread(new BowLoop(alphonse, gaston)).start();
        new Thread(new BowLoop(gaston, alphonse)).start();
    }
}
