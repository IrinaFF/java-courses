package syerraBeyts.glava_11.ex_379;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 30.01.2017
 **/

public class ExTestDrive {

    public static void main (String [] args) {
        System.out.print("t");
        String test = args[0];
        try {
            doRisky(test);
            System.out.print("r");
            System.out.print("o");
        } catch (MyEx ex) {
            System.out.print("a");
        } finally {
            System.out.print("w");
            System.out.print("s");
        }
    }
    static void doRisky (String t) throws MyEx {
        System.out.print("h");
        if ("yes".equals(t)) {
            throw new MyEx();
        }
    }
}
