package local.nefedov.boxСomparison;

import java.util.Comparator;

public class Box implements Comparable<Box> {
    /**
     * Стороны коробки
     */
    private int a, b, c;

    /**
     * Конструктор
     * @param a Длина
     * @param b Ширина
     * @param c Глубина
     */
    public Box(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Переопределение toString()
     * @return (String) Box{a, b, c}
     */
    @Override
    public String toString() {
        return "Box{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
    }

    /**
     * Определение объема
     * @return (int) volume
     */
    public int volume() {
        return a * b * c;
    }

    /**
     * Getter для длины
     * @return (int) a
     */
    public int getA() {
        return a;
    }

    /**
     * Переопределение compareTo(Box rValue)
     * @param rValue
     * @return (int) Сравнение значения объема коробки с объемом другой переданной коробки
     */
    @Override
    public int compareTo(Box rValue) {
        return volume() - rValue.volume();
    }

    /**
     * Первая реализация через inner Class
     * Иннеркласс CompareByA с реализацией интерфейса
     * сортировка по стороне a
     */
//    public class CompareByA implements Comparator<Box> {
//        @Override
//        public int compare(Box b1, Box b2) {
//            return b1.a - b2.a;
//        }
//    }

    /**
     * Вторая реализация через static inner class
     * статик иннеркласс CompareByA с реализацией интерфейса
     * сортировка по стороне a
     */
    static public class CompareByA implements Comparator<Box> {
        @Override
        public int compare(Box b1, Box b2) {
            return b1.a - b2.a;
        }
    }

    /**
     * Третья реализация через создание локального класса
     * Статичный, но может быть и не статичным
     * @return Comporator<Box>
     */
//    static public Comparator<Box> compareByA() {
//        class CMP implements Comparator<Box> {
//            @Override
//            public int compare(Box b1, Box b2) {
//                return b1.a - b2.a;
//            }
//        }
//        return new CMP();
//    }

    /**
     * Четвертая реализация через создание локального анонимного класса
     * Статичный, но может быть и не статичным
     * @return Comporator<Box>
     */
    static public Comparator<Box> compareByA() {
        return new Comparator<Box>() {
            // Конструктор анонимного класса (инициализация экземпляром)
            // {
            // ...
            // }

            @Override
            public int compare(Box b1, Box b2) {
                return b1.a - b2.a;
            }
        };
    }
}
