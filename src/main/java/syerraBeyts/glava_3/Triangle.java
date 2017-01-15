package syerraBeyts.glava_3;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 14.01.2017
 **/

public class Triangle {
    double area;
    int height;
    int length;
    void setArea() {
        this.area = (height * length) / 2;
    }
    public static void main(String[] args) {
        Triangle[] ta = new Triangle[4];
        int x = 0;
        int y = 0;
        while (x < ta.length) {
            ta[x] = new Triangle();
            ta[x].height = (x + 1) * 2;
            ta[x].length = x + 4;
            ta[x].setArea();
            if (x != ta.length - 1) {
                System.out.print("треугольник " + x + ", зона");
                System.out.println(" = " + ta[x].area);
            }
            else {
                System.out.print("треугольник " + x + ", зона");
                System.out.println(" = ____" );
            }

            x++;
        }
        x = 27;
        Triangle t5 = ta[2];
        ta[2].area = 342;
        System.out.print("y = " + y);
        System.out.println(", зона t5 = " + t5.area);
    }
}

