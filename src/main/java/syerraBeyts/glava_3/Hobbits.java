package syerraBeyts.glava_3;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 14.01.2017
 **/

public class Hobbits {
    String name;
    public static void main(String[] args) {
        Hobbits[] h = new Hobbits[3];
        int z = 0;
        while ( z < h.length) {

            h[z] = new Hobbits();
            h[z].name = "Бильбо";

            if (z == 1) {
                h[z].name = "Фродо";
            }
            if (z == 2) {
                h[z].name = "Сэм";
            }
            System.out.println(h[z].name + " - " + "имя хорошего хоббита");
            z++;
        }
   }
}
