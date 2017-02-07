package syerraBeyts.glava_9.ex_295;

/**
 * @autor irinaff
 * @since 28.01.2017
 **/

public class GC {

    //создает
    public static GC doStaff() {
        GC newGC = new GC();
        doStaff2(newGC);
        return newGC;
    }

    public static void main (String [] args) {
        GC gc1; //не создает
        GC gc2 = new GC(); //создает
        GC gc3 = new GC(); //не создает
        GC gc4 = gc3; //копия ссылки
        gc1 = doStaff(); //создает
        //очистка объектов
        gc2 = null;
        gc1 = null;
        gc4 = null;
        gc3 = null;
    }

    //не создает нового объекта
    public static void doStaff2(GC copyGC) {
        GC localGC;
    }
}
