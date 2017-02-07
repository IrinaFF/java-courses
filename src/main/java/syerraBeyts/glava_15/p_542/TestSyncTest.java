package syerraBeyts.glava_15.p_542;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 03.02.2017
 **/

public class TestSyncTest {

    public static void main (String [] args) {
        TestSync job = new TestSync();
        Thread a = new Thread(job);
        Thread b = new Thread(job);
        //a.setName("a") ;
        //b. setName ("b") ;
        a.start() ;
        b. start() ;
    }
}
