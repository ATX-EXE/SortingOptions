package local.nefedov.boxСomparison;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Box[] boxes = {
                new Box(10, 1, 1),
                new Box(1, 10, 10),
                new Box(2, 2, 2)
        };

        /**
         * Сортировка по объему implements Comparable<Box>
         */
//        Arrays.sort(boxes);

        /**
         * Первая реализация на основе inner Class
         */
//        Box.CompareByA cmp = new Box(0,0,0).new CompareByA();
//        Arrays.sort(boxes, cmp);

        /**
         * Вторая реализация через static inner class
         */
//        Arrays.sort(boxes, new Box.CompareByA());

        /**
         * Третья и четвертая реализации через локальный класс и
         */
        Arrays.sort(boxes, Box.compareByA());

        /**
         * Четвертая реализация через создание локального анонимного класса
         */

        /**
         * Пятая реализация через анонимный класс
         */
//        Arrays.sort(boxes, new Comparator<Box>() {
//            @Override
//            public int compare(Box b1, Box b2) {
//                return b1.getA() - b2.getA();
//            }
//        });

        /**
         * Шестая реализация через лямбда выражения
         */
        Arrays.sort(boxes, (b1, b2) -> b1.getA() - b2.getA());

        for (Box box: boxes) {
            System.out.println(box);
        }
    }
}
