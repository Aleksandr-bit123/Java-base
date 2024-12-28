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
/**MyArrayList - динамический массив **/

//TODO дописать описание класса
//TODO sort(Comparator<T> comparator)
//TODO clear()
//TODO quicksort(Comparator<T> comparator)
//TODO test
//TODO MyArrayListInterface

public class MyArrayList<T> {
    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;

    /**
    Добавляет новый элемент в список. При достижении размера внутреннего
    массива происходит его увеличение в два раза.
    **/

    public void add(T item) {
        if(pointer == array.length-1)
            resize(array.length*2);
        array[pointer++] = item;
    }

    /**
    Возвращает элемент списка по индексу.
    **/

    public T get(int index) {
        return (T) array[index];
    }

    /**
    Удаляет элемент списка по индексу. Все элементы справа от удаляемого
    перемещаются на шаг налево. Если после удаления элемента количество
    элементов стало в CUT_RATE раз меньше чем размер внутреннего массива,
    то внутренний массив уменьшается в два раза, для экономии занимаемого
    места.
    **/

    public void remove(int index) {
        for (int i = index; i<pointer; i++)
            array[i] = array[i+1];
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            resize(array.length/2);
    }

    /**Возвращает количество элементов в списке**/
    public int size() {
        return pointer;
    }

    /**Вспомогательный метод для масштабирования.**/
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }
}
