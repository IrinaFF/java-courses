public class Calculate {
	
	public static void main(String[] arg) {

    /*
    курс https://github.com/peterarsentev/java-courses
    ДЗ 1
    Создать класс Calculate.
    Добавить арифметические вычисления + - * / ^
    Сделать его адаптивным для типов int, short, long, double, double
    */
        System.out.println("arg[0]=" + arg[0] + "; arg[1]=" + arg[1]);
		System.out.println("int...");
        {
            int first = Integer.valueOf(arg[0]);
            int second = Integer.valueOf(arg[1]);
            int summ = first + second;
            int diff = first - second;
            int mult = first * second;
            int div = first / second;
            int inv = (int) (Math.pow(first, second));
            System.out.println("summ=" + summ + "; diff=" + diff + "; mult=" + mult + "; div=" + div + "; inv=" + inv);
        }
        {
            System.out.println("short...");
            short first = Short.valueOf(arg[0]);
            short second = Short.valueOf(arg[1]);
            short summ = (short) (first + second);
            short diff = (short) (first - second);
            short mult = (short) (first * second);
            short div = (short) (first / second);
            short inv = (short) (Math.pow(first, second));
            System.out.println("summ=" + summ + "; diff=" + diff + "; mult=" + mult + "; div=" + div + "; inv=" + inv);
        }
        {
            System.out.println("long...");
            long first = Long.valueOf(arg[0]);
            long second = Long.valueOf(arg[1]);
            long summ = (long) (first + second);
            long diff = (long) (first - second);
            long mult = (long) (first * second);
            long div = (long) (first / second);
            long inv = (long) (Math.pow(first, second));
            System.out.println("summ=" + summ + "; diff=" + diff + "; mult=" + mult + "; div=" + div + "; inv=" + inv);
        }
        {
            System.out.println("float...");
            float first = Float.valueOf(arg[0]);
            float second = Float.valueOf(arg[1]);
            float summ = (float) (first + second);
            float diff = (float) (first - second);
            float mult = (float) (first * second);
            float div = (float) (first / second);
            float inv = (float) (Math.pow(first, second));
            System.out.println("summ=" + summ + "; diff=" + diff + "; mult=" + mult + "; div=" + div + "; inv=" + inv);
        }
        {
            System.out.println("double...");
            double first = Double.valueOf(arg[0]);
            double second = Double.valueOf(arg[1]);
            double summ = (double) (first + second);
            double diff = (double) (first - second);
            double mult = (double) (first * second);
            double div = (double) (first / second);
            double inv = (double) (Math.pow(first, second));
            System.out.println("summ=" + summ + "; diff=" + diff + "; mult=" + mult + "; div=" + div + "; inv=" + inv);
        }
	}
}