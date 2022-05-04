
// Класс JvmComprehension загружается с помощью ClassLoaders
// Данные об этом классе перемещаются для хранения в Metaspace

public class JvmComprehension {
    // В стеке (Stack Memory) создаётся фрейм(кадр) main()
    public static void main(String[] args) {
        // 1 В фрейме метода main() создается переменная i примитивного типа int, i присваивается значение 1
        int i = 1;
        // 2 Создается экземпляр класса Object в куче (heap), в стеке в фрейме метода main() создается ссылка на объект
        Object o = new Object();
        // 3 Создается объект Integer со значением 2 в куче, в стеке в фрейме метода main() создаётся ссылка на него
        Integer ii = 2;
        // 4 Создаётся фрейм printAll() в стеке, в фрейм добавляются ссылки на о, ii и переменная i
        printAll(o, i, ii);
        // 7  Создаётся фрейм println() в стеке, добавляется объект типа String в кучу, в фрейм передается ссылка на объект
        // со значением "finished"
        System.out.println("finished");
    }

    // Периодически, во время выполнения программы, сборщик мусора (Garbage Collector) собирает
    // уже не используемые объекты из памяти путем обхода графа достижимых объектов.

    private static void printAll(Object o, int i, Integer ii) {
        // 5 Создаётся новый фрейм printAll() в стеке, в куче появлется объект Integer со значением 700,
        // во фрейм printAll() помещается ссылка на объект
        Integer uselessVar = 700;
        // 6 Создаётся фрейм println() в стеке, в фрейм добавляются ссылка на Object из кучи, i из фрейма main()
        // и ссылка на Integer ii из кучи. Создаётся фрейм toString() в стеке.
        System.out.println(o.toString() + i + ii);
    }

}
