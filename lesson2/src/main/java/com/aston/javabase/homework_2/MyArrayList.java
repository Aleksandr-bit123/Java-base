/*
1. Реализовать MyArrayList.
Методы, обязательные к реализации:
    - добавить элемент: add(T element),
    - добавить элемент по индексу: add(int index, T element),
    - получить элемент: get(int index),
    - удалить элемент remove(int index),
    - очистить всю коллекцию: clear(),
    - отсортировать коллекцию: sort(Comparator<T> comparator),
остальное по желанию.

2. Реализовать алгоритм quicksort для реализованного вами MyArrayList.
Ваш QuickSort должен принимать список любого типа и сортировать его. Использовать:
    ○ Java generics
    ○ Comparable, Comparator

3. Документировать код. Что, зачем и как. Все классы и интерфейсы должны быть
задокументированы на уровне класса (class-level javadoc). Все публичные
методы ваших реализаций должны содержать javadoc. Документация должна
быть в полном объёме и представлять исчерпывающее и интуитивно понятное
руководство пользования вашим кодом для другого разработчика.

4. Необходимо убедиться, что методы могут корректно отрабатывать с различными
типами данных и большим количеством данных.

5. Прочитать “Грокаем алгоритмы” (если еще не читали).

6. До деталей изучить иерархию коллекций, сложность операций (Big O) и самые
популярные реализации Java Collections Framework. В том числе: LinkedList,
HashSet, TreeSet, понять применения Comparable, Comparator.*/

package com.aston.javabase.homework_2;

import java.util.*;

/**
 * MyArrayList - динамический массив
 **/

//TODO дописать описание класса
//TODO quicksort(Comparator<T> comparator)
//TODO test
//TODO MyArrayListInterface

public class MyArrayList<T> {
    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;

    /**
     * Добавляет новый элемент в список. При достижении размера внутреннего
     * массива происходит его увеличение в два раза.
     **/

    public void add(T item) {
        if (pointer == array.length - 1)
            resize(array.length * 2);
        array[pointer++] = item;
    }

    /**
     * Возвращает элемент списка по индексу.
     **/

    public T get(int index) {
        return (T) array[index];
    }

    /**
     * Удаляет элемент списка по индексу. Все элементы справа от удаляемого
     * перемещаются на шаг налево. Если после удаления элемента количество
     * элементов стало в CUT_RATE раз меньше чем размер внутреннего массива,
     * то внутренний массив уменьшается в два раза, для экономии занимаемого
     * места.
     **/

    public void remove(int index) {
        for (int i = index; i < pointer; i++)
            array[i] = array[i + 1];
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            resize(array.length / 2);
    }

    /**
     * Возвращает количество элементов в списке
     **/
    public int size() {
        return pointer;
    }

    /**
     * Вспомогательный метод для масштабирования.
     **/
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }

    /**
     * Очищает весь список. Восстанавливает длину массива до INIT_SIZE
     **/
    public void clear() {
        for (int to = pointer, i = pointer = 0; i < to; i++)
            array[i] = null;
        resize(INIT_SIZE);
    }

    public void sort(Comparator<? super T> c) {
        try {
            if (array != null && Arrays.stream(Arrays.copyOf(array, pointer)).noneMatch(Objects::isNull)) {
                Arrays.sort((T[]) array, 0, pointer, c);
            }
        } catch (Exception e) {
            throw new RuntimeException("Что-то пошло не так=(", e);
        }
    }


    public void quickSort(Comparator<? super T> c) {
        try {
            if (array != null && Arrays.stream(Arrays.copyOf(array, pointer)).noneMatch(Objects::isNull)) {
                quickSortRecursive((T[]) array, 0, pointer - 1, c);
            }
        } catch (Exception e) {
            throw new RuntimeException("Что-то пошло не так=(", e);
        }
    }

    private void quickSortRecursive(T[] arr, int low, int high, Comparator<? super T> c) {
        if (low < high) {
            int pi = partition(arr, low, high, c);

            quickSortRecursive(arr, low, pi - 1, c);
            quickSortRecursive(arr, pi + 1, high, c);
        }
    }

    private int partition(T[] arr, int low, int high, Comparator<? super T> c) {

        int middle = low + (high - low) / 2;
        T pivot = arr[middle];


        T temp = arr[middle];
        arr[middle] = arr[high];
        arr[high] = temp;

        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (c.compare(arr[j], pivot) < 0) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, pointer));
    }

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(3);
        myArrayList.add(2);
        myArrayList.add(6);
        myArrayList.add(2);
        myArrayList.add(2);
        myArrayList.add(0);
        System.out.println(myArrayList);
        myArrayList = null;
//        myArrayList.sort(Integer::compareTo);
//        myArrayList.quickSort(Integer::compareTo);
        System.out.println(myArrayList);

    }
}
