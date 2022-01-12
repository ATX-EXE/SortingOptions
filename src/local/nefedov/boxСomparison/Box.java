package local.nefedov.boxСomparison;

import java.util.Comparator;

public class Box implements Comparable<Box> {
    private int a, b, c;

    public Box(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Box{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
    }

    public int volume() {
        return a * b * c;
    }

    public int getA() {
        return a;
    }

    @Override
    public int compareTo(Box rValue) {
        return volume() - rValue.volume();
    }

    /**
     * Первая реализация через inner Class
     * иннеркласс CompareByA с реализацией интерфейса
     * сортировка по стороне a
     */
//    public class CompareByA implements Comparator<Box> {
//        @Override
//        public int compare(Box b1, Box b2) {
//            return b1.a - b2.a;
//        }
//    }

    /**
     * вторая реализация через static inner class
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
     * Третяя реализация через создание локального класса
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
            //констройктор анонимного класса (инициализация экземпляром)
            {
                //...
            }

            @Override
            public int compare(Box b1, Box b2) {
                return b1.a - b2.a;
            }
        };
    }
}
