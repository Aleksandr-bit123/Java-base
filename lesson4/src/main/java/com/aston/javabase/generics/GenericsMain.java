package com.aston.javabase.generics;

import com.aston.javabase.generics.animals.Animal;
import com.aston.javabase.generics.animals.Cat;
import com.aston.javabase.generics.animals.Dog;

import java.util.ArrayList;
import java.util.List;

public class GenericsMain {

    public static void main(String[] args) {

        System.out.println(getListWithDifferentTypes());

    }

    /*
     * У нас есть возможность хранить в списке разные типы
     */
    private static List getListWithDifferentTypes() {
        List commonList = new ArrayList();
        commonList.add("string example");
        commonList.add( 1 );
        return commonList;
    }

    /*
     * Нам требуется работать с коллекциями элементов одного типа
     * Такой код не скомпилируется и ошибка с добавлением данных не того типа
     * будет замечена еще на этапе компиляции.
     */
    private static List<String> getListWithSingleTypes() {
        List<String> singleTypeList = new ArrayList();
        singleTypeList.add("string example");
//        singleTypeList.add( 1 );
        return singleTypeList;
    }

    /*
     * Вся магия происходит на этапе компиляции.
     * В рантайме мы работаем с Object[] elementData
     */
    private static List<String> getListWithDifferentTypes2() {
        List<String> commonList = new ArrayList();
        commonList.add((String) "string example");
//        commonList.add((String) 1 );
        return commonList;
    }
}
