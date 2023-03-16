import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> elements = Arrays.asList(1, 5, 2, 3, -67, 8, 4, 0, 212, 245, 9421, -2, -234,-362);

        Comparator<Integer> order = Integer::compareTo;
        BiConsumer<Integer, Integer> minMaxConsumer = (min, max)
                -> System.out.println("Минимальное значение = " + min + ", Максимальное значение = " + max);
        Stream<Integer> sorted = elements.stream();
        findMinMax(sorted, order, minMaxConsumer);

        sortedInt(elements.stream().sorted(order).collect(Collectors.toList()));
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<? extends T> sorted = stream.collect(Collectors.toList());
        T min = sorted.stream().min(order).orElse(null);
        T max = sorted.stream().max(order).orElse(null);
        minMaxConsumer.accept(min, max);
    }

    public static void sortedInt(List<Integer> list) {
        Predicate<Integer> sort = x -> x >= 0;
        List<Integer> sortedElements = list.stream().
                filter(sort)
                .collect(Collectors.toList());
        System.out.println(sortedElements);

    }
}