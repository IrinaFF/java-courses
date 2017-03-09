package CollectionTest;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Locale;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 08.03.2017
 **/

public class StringTest {
    public static void main(String[] args) {
        //Создать строку очень просто. Например, можно так:
        String aboutCat = "Кот - это звучит гордо, а если наступить на хвост, то громко";

        //Можно создать массив строк:
        String[] cats = {"Васька", "Барсик", "Мурзик"};

        //Можно создать пустой объект класса String:
        String str = new String();

        //Можно создать строку через массив символов:
        char[] chars = { 'c', 'a', 't' };
        String str1 = new String(chars);

        //Есть ещё конструктор, позволяющий задать диапазон символьного массива. Вам нужно указать начало диапазона и количество символов для использования:
        char[] chars1 = {'c', 'a', 't', 'a', 'm', 'a', 'r', 'a', 'n' };
        String str2 = new String(chars1, 0, 3);

        //Можно создать объект класса String из объекта классов StringBuffer и StringBuilder при помощи следующих конструкторов:
        //String(StringBuffer объект_StrBuf)
        //String(StringBuilder объект_StrBuild)

        String strBarsik = "Барсик";
        String strPaws = "четыре";
        String strTail = "один";
        int year = 5;
        String strFinal = String.format("У кота по имени %1$s %2$s лапы, %3$s хвост. Ему %4$d лет", strBarsik, strPaws, strTail, year);
        System.out.println(strFinal);

        //Возвращает символ с указанным смещением в этой строке. Отсчёт идет от 0.
        // Не надо использовать отрицательные и несуществующие значения. Для извлечения нескольких символов используйте getChars().
        String testString = "Котёнок";
        char myChar = testString.charAt(2);
        System.out.println(Character.toString(myChar)); // выводит третий символ - т

        //Возвращает Unicode-символ в заданном индексе
        testString = "Котёнок";
        int myChar1 = testString.codePointAt(3);
        System.out.println(String.valueOf(myChar1)); // возвращает 1105

        //Возвращает Unicode-символ, который предшествует данному индексу
        testString = "Котёнок";
        myChar1 = testString.codePointBefore(4);
        System.out.println(String.valueOf(myChar1)); // возвращает 1105
        System.out.println(myChar1);

        //Вычисляет количество Unicode-символов между позициями start и end
        testString = "Котёнок";
        myChar1 = testString.codePointCount(0, 3);
        System.out.println(String.valueOf(myChar1)); // возвращает 3

        //Сравнивает указанную строку, используя значения символов Unicode и вычисляет,
        // какая из строк меньше, равна или больше следующей. Может использоваться при сортировке.
        // Регистр учитывается. Если строки совпадают, то возвращается 0, если меньше нуля,
        // то вызывающая строка меньше строки string, если больше нуля, то вызывающая строка больше строки string.
        // Слова с большим регистром стоят выше слова с нижним регистром.
        testString = "Котёнок";
        if (testString.compareTo("котёнок") == 0) {
            System.out.println("Строки равны");
        } else {
            System.out.println("Строки не равны. Возвращено"
                    + testString.compareTo("котёнок")); // возвращает -32
        }

        //Отсортируем массив строк через пузырьковую сортировку.
        String[] poem = { "Мы", "везём", "с", "собой", "кота" };
        for (int j = 0; j < poem.length; j++) {
            for (int i = j + 1; i < poem.length; i++) {
                if (poem[i].compareTo(poem[j]) < 0) {
                    String temp = poem[j];
                    poem[j] = poem[i];
                    poem[i] = temp;
                }
            }
            System.out.println(poem[j]);
        }

        //Сравнивает указанную строку, используя значения символов Unicode, без учета регистра.
        testString = "Котёнок";
        if (testString.compareToIgnoreCase("котёнок") == 0) {
            System.out.println("Строки равны"); // слова одинаковы, если не учитывать регистр
        } else {
            System.out.println("Строки не равны. Возвращено"
                    + testString.compareTo("котёнок"));
        }

        //Объединяет строку с указанной строкой. Метод выполняет ту же функцию, что и оператор +
        testString = "Сук";
        String newString = testString.concat("кот");
        System.out.println(newString);

        //Определяет, содержит ли строка последовательность символов в CharSequence
        testString = "котёнок";
        if(testString.contains("кот")){
            System.out.println("(contains) В слове котёнок содержится слово кот!");
        }

        //public boolean contentEquals(CharSequence cs)
        //Сравнивает CharSequence с этой строкой.
        testString = "кот";
        if(testString.contentEquals("кот")){
            System.out.println("кот = кот!");
        }

        //public boolean contentEquals(StringBuffer strbuf)
        //Сравнивает StringBuffer с этой строкой

        //public static String copyValueOf (char[] data, int start, int length)
        //Создаёт новую строку, содержащую указанные символы из массива Data начиная с позиции start (нумерация начинается с нуля) длинной length.
        char[] ch = {'c', 'a', 't', 'a', 'm', 'a', 'r', 'a', 'n' };
        String str3 = "";//new String();
        str3 = str3.copyValueOf(ch, 3, 2);
        System.out.println("str3: " + str3);

        //public static String copyValueOf(char[] data)
        //Создаёт новую строку, содержащую символы из указанного массива. Изменение массива после создания строки не изменяет созданную строку.
        str3 = str3.copyValueOf(ch);
        System.out.println("str3: " + str3);

        char[] Str1 = {'п', 'р', 'и', 'в', 'е', 'т', ' ', 'м', 'и', 'р'};
        String Str2 = "";

        Str2 = Str2.copyValueOf(Str1);
        System.out.println("Возвращаемая строка: " + Str2);

        Str2 = Str2.copyValueOf(Str1, 2, 6);
        System.out.println("Возвращаемая строка: " + Str2);

        //public boolean endsWith(String suffix)
        //Проверяет, заканчивается ли строка символами suffix.
        str1 = "Суккот";
        if(str1.endsWith("кот"))
            System.out.println("Слово заканчивается на котике");
        else
            System.out.println("Плохое слово. Нет смысла его использовать");

        //public boolean equals (Object string)
        //Сравнивает указанный объект и строку и возвращает true, если сравниваемые строки равны, т.е. содержит те же символы и в том же порядке с учётом регистра.
        //Не путать метод с оператором ==, который сравнивает две ссылки на объекты и определяет, ссылаются ли они на один и тот же экземпляр
        str1 = "Кот";
        str2 = "кот";
        if(str1.equals(str2))
            System.out.println("Строки совпадают");
        else
            System.out.println("Строки не совпадают");

        //public boolean equalsIgnoreCase(String string)
        //Сравнивает указанную строку с исходной строкой без учёта регистра и возвращает true, если они равны. Диапазон A-Z считается равным диапазону a-z.
        str1 = "Кот";
        str2 = "кот";
        if(str1.equalsIgnoreCase(str2))
            System.out.println("Строки совпадают");
        else
            System.out.println("Строки не совпадают");

        //public static String format(Locale locale, String format, Object... args)
        //Возвращает отформатированную строку, используя прилагаемый формат и аргументы, локализованных в данной области. Например дату или время
// выводим число типа float с двумя знаками после запятой
        float floatValue = 1.2367f;
        System.out.println(String.format("%.2f", floatValue));

        //Склеиваем два слова, которые выводятся с новой строки. При этом второе слово выводится в верхнем регистре.
        str1 = "Кот";
        str2 = "васька";
        String strResult = String.format("%s\n%S", str1, str2);
// выводим результат в TextView
        System.out.println(strResult);

        //Конвертируем число в восьмеричную систему.
        str1 = "8";
        int inInt = Integer.parseInt(str1); // конвертируем строку в число
        strResult = String.format("(Восьмеричное значение): %o\n", inInt);
        System.out.println(strResult);

        //По аналогии выводим в шестнадцатеричной системе
        str1 = "255";
        inInt = Integer.parseInt(str1);
        strResult = String.format("(Шестнадцатеричное значение): %x\n", inInt);
// число 255 будет выведено как ff
        System.out.println(strResult);

        //Для верхнего регистра используйте %X, тогда вместо ff будет FF.
        //Для десятичной системы используйте %d.
        // Дату тоже можно выводить по разному.
        Date now = new Date();
        Locale locale = Locale.getDefault();
        System.out.println(
                String.format(locale, "%tD\n", now) + // (MM/DD/YY)
                        String.format(locale, "%tF\n", now) + // (YYYY-MM-DD)
                        String.format(locale, "%tr\n", now) + // Full 12-hour time
                        String.format(locale, "%tz\n", now) + // Time zone GMT offset
                        String.format(locale, "%tZ\n", now)); // Localized time zone bbreviation

        //public byte[] getBytes(String charsetName)
        // Возвращает отформатированную строку, используя прилагаемый формат.
        //getBytes(String charsetName): кодирует данную строку в последовательность байтов, используя charsetName (кодировку), сохраняет результат в новый массив байтов.
        //getBytes(): кодирует данную строку в последовательность байтов по умолчанию с помощью платформы charset, сохраняет результат в новый массив байтов.

        str = new String("Добро пожаловать на ProgLang.su");

        try{
            byte[] strB = str.getBytes();
            System.out.println("strB.length: " + strB.length);
            System.out.println("Возвращаемое значение: " + strB );

            strB = str.getBytes("UTF-8");
            System.out.println("Возвращаемое значение: " + strB );

            strB = str.getBytes("ISO-8859-1");
            System.out.println("Возвращаемое значение: " + strB );

            //strB = str.getBytes("ProgLang.su");
            //System.out.println("Возвращаемое значение: " + strB );

        } catch( UnsupportedEncodingException e){
            System.out.println("Неподдерживаемая кодировка!");
        }

        //public void getBytes(int start, int end, byte[] data, int index) и другие перегруженные версии
        // Метод сохраняет символы в массив байтов, альтернатива методу getChars().
        // Часто используется при экспорте строк из различных источников, где используются другие символы Unicode.
        // Например, Java по умолчанию работает с 16-битовые символы Unicode, а в интернете часто строки используют 8-битовый код Unicode, ASCII и др.
        String unusualCat = "Котёнок по имени Гав";
        int start = 0;
        int end = 12;
        byte [] buf = new byte[end - start];
        unusualCat.getBytes(start, end, buf, 0);
        System.out.println("getBytes: " + new String(buf));

        //public void getChars(int start, int end, char[] buffer, int index)
        // Метод для извлечения нескольких символов из строки. Вам надо указать индекс начала подстроки (start),
        // индекс символа, следующего за концом извлекаемой подстроки (end).
        // Массив, который принимает выделенные символы находится в параметре buffer.
        // Индекс в массиве, начиная с которого будет записываться подстрока, передаётся в параметре index.
        // Следите, чтобы массив был достаточного размера, чтобы в нём поместились все символы указанной подстроки.

        unusualCat = "Котёнок по имени Гав";
        start = 5;
        end = 12;
        char[] buf1 = new char[end - start];
        unusualCat.getChars(start, end, buf1, 0);
        System.out.println("getChars: " + new String(buf1));

        //public int hashCode()
        // Возвращает целое число — хэш-код для данного объекта.
        System.out.println("hashCode: " + unusualCat.hashCode());

        //public int indexOf(int c)
        // Возвращает номер первой встречной позиции с указанным индексом с.
        testString = "котёнок";
        // символ ё встречается в четвёртой позиции (index = 3)
        System.out.println("indexOf: " + String.valueOf(testString.indexOf("ё")));

        //public int indexOf (int c, int start)
        // Ищет индекс с, начиная с позиции start
        testString = "котёнок";
        // вернёт -1, так как после 5 символа буквы ё нет
        System.out.println("indexOf: " + String.valueOf(testString.indexOf("ё", 4)));

        //public int indexOf (String string)
        // Ищет цепочку символов subString
        testString = "У окошка";
        System.out.println("indexOf: " + String.valueOf(testString.indexOf("кошка")));

        //public int indexOf (String subString, int start)
        // Ищет цепочку символов subString, начиная с позиции start
        testString = "У окошка";
        System.out.println("indexOf: " + String.valueOf(testString.indexOf("кошка", 2)));

        //public String intern () «Xэширует» строку
        System.out.println(("Vas" + "ya").intern());

        System.out.println("offsetByCodePoints:" + testString.offsetByCodePoints (1,5));

        String s1 = new String();
        System.out.println("new String(): " + s1.toString());

        //В Java используется пул строковых литералов. Одинаковые строковые литералы всегда ссылаются на один и тот же экземпляр класса String :
        String vasya = "Vasya", ya = "ya";
        System.out.println(vasya == "Vasya"); // 1
        System.out.println(vasya == ("Vas" + ya)); // 2
        System.out.println(vasya == ("Vas" + "ya")); // 3
        System.out.println(vasya == ("Vas" + ya).intern()); // 4
    }
}
