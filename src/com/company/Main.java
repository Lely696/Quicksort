package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void quickSort(int[] array, int start, int end) {


        //проверки
        if (array.length == 0 || start >= end)
            return;// длина массива равна 0, массив уже отсортирован

        // опорный элемент
        int middle = start + (end - start) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента

        int i = start, j = end;
        while (i <= j) {
            while (array[i] < opora) { //если любой элемент меньше опорного проверяем далее
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части без проверки не сортирует массив полностью
        if (start < j)
            quickSort(array, start, j);

        if (end > i)
            quickSort(array, i, end);

    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // Объявляем Scanner
        System.out.println("Введите размер массива: ");
        int size = input.nextInt(); // Читаем с клавиатуры размер массива и записываем в size
        int array[] = new int[size]; // Создаём массив int размером в size
        System.out.println("Введите элементы массива:");
        /*Пройдёмся по всему массиву, заполняя его*/
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt(); // Заполняем массив элементами, введёнными с клавиатуры
        }
        System.out.print("Это то, что вы ввели:");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + array[i]); // Выводим на экран, полученный массив
        }

        System.out.println(" Было: ");
//        for (int v : array)                        // так масив выводится в столбец
//            System.out.println(v);
        System.out.println(Arrays.toString(array)); // так масив выводится в строку и  нужна библиотека  Array

        int low = 0;
        int high = array.length - 1;

        quickSort(array, low, high);
        System.out.println("Стало: ");
//        for (int v : array)
//            System.out.println(v);
       System.out.println(Arrays.toString(array));
    }
}

