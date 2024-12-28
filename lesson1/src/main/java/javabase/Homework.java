package javabase;

import java.util.*;

public class Homework {
    // Перевернуть строку и вывести на консоль
    //  String string = "I love Java";
    public static void turnString(String string) {
        StringBuilder builder = new StringBuilder(string);
        System.out.println(builder.reverse().toString());
    }

    // int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
    // Удалить дубликаты из массива и вывести в консоль
    public static void getDistinctNumbers(int[] ints) {
        Set<Integer> set = new HashSet<>();
        for (int i : ints) {
            set.add(i);
        }
        System.out.println(set.toString());
    }

    // Дан массив, заполненный уникальными значениями типа int.
    // int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
    // Необходимо найти элемент, который меньше максимума, но больше всех остальных.
    public static Integer findSecondMaxElement(int[] arr) {
        arr = Arrays.stream(arr).sorted().toArray();
        return arr[arr.length - 2];
    }

    // Найти длину последнего слова в строке. В строке только буквы и пробелы.
    // "Hello world" - 5
    // "    fly me    to the moon    " - 4
    public static Integer lengthOfLastWord(String string) {
        String[] words = string.split(" ");
        return words[words.length - 1].length();
    }

    // Определить, что строка является палиндромом
    // Сложность по памяти O(1), не создавать новые String, StringBuilder
    // Примеры:
    // abc - false
    // 112233 - false
    // aba - true
    // 112211 - true
    public static boolean isPalindrome(String string) {
        for (int i = 0; i < string.length() / 2; i++) {
            if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        turnString("I love Java");
        getDistinctNumbers(new int[]{1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9});
        System.out.println(findSecondMaxElement(new int[]{10, 15, 23, 11, 44, 13, 66, 1, 6, 47}));
        System.out.println(lengthOfLastWord("    fly me    to the moon    "));
        System.out.println(isPalindrome("aabaa"));
    }
}
