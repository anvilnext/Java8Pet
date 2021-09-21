package my.java8pet;

import my.classes.Converter;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

/*        assessmentTask();
        assessmentTaskDesc();
        assessmentTaskList();
        lambdaConverter();
        functionalInterfaces();
        optionalsMethod();
        streamsMethod();
        timeMethod();*/

        //listMethod();
        //hashMapMethod();
        setMethod();
        //queueMethod();
    }

    //list
    private static void listMethod() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("afirst");
        arrayList.add("nsecond");
        arrayList.add("cthird");
        arrayList.add(2, "newthird");
        arrayList.sort(Comparator.reverseOrder());
        arrayList.forEach(System.out::println);

        System.out.println();

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("elem");
        linkedList.addFirst("first");
        linkedList.addLast("last");
        linkedList.add(1, "new");
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.size());
    }

    //hashmap
    private static void hashMapMethod() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("cat", "Jojo");
        hashMap.put("dog", "Baxter");
        hashMap.put("rhino", "Toto");

        hashMap.putIfAbsent("kangaroo", "Davy");
        hashMap.computeIfPresent("cat", (k, v) -> v + " added");

        System.out.println(hashMap.entrySet());
    }

    //set
    private static void setMethod() {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(5);
        hashSet.add(7);
        hashSet.add(5);
        if (!hashSet.isEmpty()) {
            hashSet.remove(7);
        }
        System.out.println(hashSet);

        System.out.println();

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.addAll(hashSet);
        System.out.println(treeSet.ceiling(4));
    }

    //queue
    private static void queueMethod() {
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add("first");
        queue.addFirst("newfirst");
        queue.push("another first");
        queue.addLast("just checking");

        System.out.println(queue);
        System.out.println(queue.element());
    }


    //from assessment - increment and sort by ascending
    private static void assessmentTask() {
        int[] a = {1, 3, 5, 7, 43, 15, 9, 7, 23, 2, 5};
        Arrays.stream(a).map(e -> e + 1).sorted().forEach(System.out::println);
    }

    //from assessment - increment and sort by descending
    private static void assessmentTaskDesc() {
        int[] a = {1, 3, 5, 7, 43, 15, 9, 7, 23, 2, 5};
        Arrays.stream(a).map(e -> e + 1).boxed().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    //from assessment - using list
    private static void assessmentTaskList() {
        List<Integer> a = Arrays.asList(1, 3, 5, 7, 43, 15, 9, 7, 23, 2, 5);
        a.stream().map(e -> e + 1).sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    //functional interface, method link
    private static void lambdaConverter() {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);

        Converter<String, Integer> converter2 = Integer::valueOf;
        Integer converted2 = converter2.convert("123");
        System.out.println(converted2);
    }

    //functional interfaces
    private static void functionalInterfaces() {
        //predicate
        Predicate<String> predicate = (s) -> s.length() > 3;
        System.out.println(predicate.test("123"));
        System.out.println(predicate.test("1234"));
        Predicate<String> isEmpty = String::isEmpty;
        System.out.println(isEmpty.negate().test("111"));

        //function
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        System.out.println(backToString.apply("123"));

        //unaryOperator
        UnaryOperator<Integer> square = x -> x*x;
        System.out.println(square.apply(5));

        //binaryOperator
        BinaryOperator<Integer> multiply = (x, y) -> x * y;
        System.out.println(multiply.apply(3, 5));

        //consumer
        Consumer<Integer> printer = x-> System.out.printf("amount of %d", x);
        printer.accept(100);
    }

    //optional
    private static  void optionalsMethod() {
        Optional<String> optional2 = Optional.of("123");
        System.out.println(optional2.orElse("456"));

        Optional<String> optional = Optional.ofNullable(null);
        System.out.println(optional.orElse("456"));
    }

    //streams
    private static void streamsMethod() {
        Integer[] a = {2, 7, 8, 1, 0, 8};
        Arrays.stream(a).filter(e -> e != 8).forEach(System.out::println);

        List<String> b = Arrays.asList("dacha", "dadas", "daddy", "dados", "abby", "baby");
        System.out.println(b.stream().allMatch(s -> s.startsWith("d")));
        System.out.println(b.stream().anyMatch(s -> s.startsWith("d")));
    }

    //time
    private static void timeMethod() {
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock);
        System.out.println(LocalTime.now(clock));

        LocalTime time1 = LocalTime.now(clock);
        LocalTime time2 = LocalTime.now(ZoneId.of("Europe/London"));
        System.out.println(ChronoUnit.HOURS.between(time1, time2));


        LocalDate birthday = LocalDate.of(1998, Month.JUNE, 19);
        System.out.println(birthday.plusDays(6).getDayOfWeek());


        LocalDateTime dateTime = LocalDateTime.of(2021, Month.JUNE, 6, 10, 0, 20);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy - HH:mm");
        LocalDateTime parsedDateTime = LocalDateTime.parse("Jun 06, 2021 - 10:00", formatter);
        System.out.println(dateTime.equals(parsedDateTime));
    }

}
