package xyz.qalcyo.mango;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Lists {

    /**
     * @param <T> The type to be used by the array list.
     * @return The created array list.
     */
    public static <T> ArrayList<T> newArrayList(List<T> parent) {
        return new ArrayList<>(parent);
    }

    /**
     * @param <T> The type to be used by the array list.
     * @return The created array list.
     */
    @SafeVarargs
    public static <T> ArrayList<T> newArrayList(T... elements) {
        return newArrayList(Arrays.asList(elements));
    }

    /**
     * @param <T> The type to be used by the array list.
     * @return The created array list.
     */
    public static <T> ArrayList<T> newArrayList() {
        return newArrayList(new ArrayList<>());
    }

    /**
     * @param <T> The type to be used by the linked list.
     * @return The created linked list.
     */
    public static <T> LinkedList<T> newLinkedList(List<T> parent) {
        return new LinkedList<>(parent);
    }

    /**
     * @param <T> The type to be used by the linked list.
     * @return The created linked list.
     */
    @SafeVarargs
    public static <T> LinkedList<T> newLinkedList(T... elements) {
        return newLinkedList(Arrays.asList(elements));
    }

    /**
     * @param <T> The type to be used by the linked list.
     * @return The created linked list.
     */
    public static <T> LinkedList<T> newLinkedList() {
        return newLinkedList(new LinkedList<>());
    }

    /**
     * @param <T> The type to be used by the copy-on-write array list.
     * @return The created copy-on-write array list.
     */
    public static <T> CopyOnWriteArrayList<T> newCopyOnWriteArrayList(List<T> parent) {
        return new CopyOnWriteArrayList<>(parent);
    }

    /**
     * @param <T> The type to be used by the copy-on-write array list.
     * @return The created copy-on-write array list.
     */
    public static <T> CopyOnWriteArrayList<T> newCopyOnWriteArrayList(T... elements) {
        return newCopyOnWriteArrayList(Arrays.asList(elements));
    }

    /**
     * @param <T> The type to be used by the copy-on-write array list.
     * @return The created copy-on-write array list.
     */
    public static <T> CopyOnWriteArrayList<T> newCopyOnWriteArrayList() {
        return newCopyOnWriteArrayList(new CopyOnWriteArrayList<>());
    }

    public static <T> T[] toArray(Iterable<? extends T> iterable, Class<T> type) {
        Collection<T> collection = Lists.toCollection((Iterable<T>) iterable);
        T[] array = (T[]) Array.newInstance(type, collection.size());
        return collection.toArray(array);
    }

    public static <T> Collection<T> toCollection(Iterable<T> iterable) {
        return (iterable instanceof Collection) ?
                (Collection<T>) iterable :
                null;
    }

    /**
     * Sorts a list by its elements' string values.
     *
     * @param list The list to sort.
     */
    public static <T> void sortByString(List<T> list) {
        list.sort(Comparator.comparing(T::toString));
    }

    /**
     * Sorts a list by its elements' string values reversed.
     *
     * @param list The list to sort.
     */
    public static <T> void sortByStringReversed(List<T> list) {
        list.sort(Comparator.comparing(T::toString).reversed());
    }

}