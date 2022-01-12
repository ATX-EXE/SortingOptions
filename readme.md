# Варианты реализации сортировки

## Стандартная сортировка
Реализована сортировка по объему.
```java
public class Main {
    public static void main(String[] args) {
        Box[] boxes = {
                new Box(10, 1, 1),
                new Box(1, 10, 10),
                new Box(2, 2, 2)
        };
        Arrays.sort(boxes);
    }
}
```

## Вариант 1 - inner class

Реализована сортировка по стороне a.
Внутренний, или вложенный класс (англ. inner class) — в объектно-ориентированном программировании класс, целиком определённый внутри другого класса.
```java
public class Main {
    public static void main(String[] args) {
        Box[] boxes = {
                new Box(10, 1, 1),
                new Box(1, 10, 10),
                new Box(2, 2, 2)
        };
        Box.CompareByA cmp = new Box(0, 0, 0).new CompareByA();
        
        Arrays.sort(boxes, cmp);
    }
}
```

```java
public class Box implements Comparable<Box> {
    public class CompareByA implements Comparator<Box> {
        @Override
        public int compare(Box b1, Box b2) {
            return b1.a - b2.a;
        }
    }
}
```

## Вариант 2 - static inner class

Реализована сортировка по стороне b.

```java
public class Main {
    public static void main(String[] args) {
        Box[] boxes = {
                new Box(10, 1, 1),
                new Box(1, 10, 10),
                new Box(2, 2, 2)
        };
        Box.CompareByA cmp = new Box(0, 0, 0).new CompareByA();
        
        Arrays.sort(boxes, new Box.CompareByA());
    }
}
```

```java
public class Box implements Comparable<Box> {
    static public class CompareByA implements Comparator<Box> {
        @Override
        public int compare(Box b1, Box b2) {
            return b1.a - b2.a;
        }
    }
}
```

## Вариант 3 - создание локального класса

Реализована сортировка по стороне b.
```java
public class Main {
    public static void main(String[] args) {
        Box[] boxes = {
                new Box(10, 1, 1),
                new Box(1, 10, 10),
                new Box(2, 2, 2)
        };
        Box.CompareByA cmp = new Box(0, 0, 0).new CompareByA();

        Arrays.sort(boxes, Box.compareByA());
    }
}
```
```java
public class Box implements Comparable<Box> {
    static public Comparator<Box> compareByA() {
        class CMP implements Comparator<Box> {
            @Override
            public int compare(Box b1, Box b2) {
                return b1.a - b2.a;
            }
        }
        return new CMP();
    }
}
```

## Вариант 4 - создание локального анонимного класса

Реализована сортировка по стороне b в классе box.
```java
public class Box implements Comparable<Box> {
    static public Comparator<Box> compareByA() {
        return new Comparator<Box>() {
            @Override
            public int compare(Box b1, Box b2) {
                return b1.a - b2.a;
            }
        };
    }
}
```

## Вариант 5.1 - создание анонимного класса

Реализована сортировка по стороне b.

```java
public class Main {
    public static void main(String[] args) {
        Box[] boxes = {
                new Box(10, 1, 1),
                new Box(1, 10, 10),
                new Box(2, 2, 2)
        };
        Box.CompareByA cmp = new Box(0, 0, 0).new CompareByA();

        Arrays.sort(boxes, new Comparator<Box>() {
            @Override
            public int compare(Box b1, Box b2) {
                return b1.getA() - b2.getA();
            }
        });
    }
}
```

## Вариант 5.2 - лямбда выражение

Реализована сортировка по стороне b.

```java
public class Main {
    public static void main(String[] args) {
        Box[] boxes = {
                new Box(10, 1, 1),
                new Box(1, 10, 10),
                new Box(2, 2, 2)
        };
        Box.CompareByA cmp = new Box(0, 0, 0).new CompareByA();

        Arrays.sort(boxes, (b1, b2) -> b1.getA() - b2.getA());
        for (Box box: boxes) {
            System.out.println(box);
        }
    }
}
```