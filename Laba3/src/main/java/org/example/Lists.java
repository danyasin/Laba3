package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @author Синицин Данила
 */

public class Lists {
    List<Integer> linked = new LinkedList<Integer>();
    List<Integer> array = new ArrayList<Integer>();

    public final int arrayLenght = 2000; // длина массива, от нее зависит сколько раз выполнится операция
    private long start, finish; // окончательное и прошедшее время

    public long TimeLinkedList, TimeArrayList;// общее время, потраченное на соответствующие методы

    /*
     * Вывод времени, проведенного на каждом методе
     */
    public void ShowResult() {

        TimeLinkedList = arrListAdd(linked);
        TimeArrayList = arrListAdd(array);
        System.out.println("Add: \n LinkedList= " + TimeLinkedList + "  " + "ArrayList = " + TimeArrayList + " ");

        TimeLinkedList = arrListGet(linked);
        TimeArrayList = arrListGet(array);
        System.out.println("Get: \n LinkedList= " + TimeLinkedList + "  " + "ArrayList = " + TimeArrayList + " ");

        TimeLinkedList = arrListDelete(linked);
        TimeArrayList = arrListDelete(array);
        System.out.println("Delete: \n LinkedList= " + TimeLinkedList + "  " + "ArrayList = " + TimeArrayList + " ");

    }

    /*
     * Вызов метода add
     * @param value - переменная для случайного числа от 0 до 3000
     */

    public long arrListAdd(List<Integer> list) {

        int value = (int) (Math.random() * 3001);

        start = System.nanoTime();

        for (int i = 0; i < arrayLenght; i++) {
            list.add(i, value);
        }

        finish = System.nanoTime();

        return finish - start;
    }

    /*
     * Заполнение пустого массива
     */
    public void modulListGet() {
        randomInit();
        arrListGet(linked);
        arrListGet(array);
    }

    /*
     * Вызов метода get
     */
    private long arrListGet(List<Integer> list) {
        start = System.nanoTime();

        for (int i = 0; i < arrayLenght; i++) {
            int number = list.get(i);
        }

        finish = System.nanoTime();

        return finish - start;
    }

    /*
     * Заполнение пустого массива
     */
    public void modulListRemove() {
        randomInit();
        arrListDelete(linked);
        arrListDelete(array);
    }

    /*
     * В этом методе значение удаляется из массива
     * */
    private long arrListDelete(List<Integer> list) {
        start = System.nanoTime();
        for (int i = 0; i < arrayLenght / 2 - 1; i++) {
            list.remove(i);
        }
        finish = System.nanoTime();
        return finish - start;
    }


    /*
     * Этот метод заполняет массив случайными значениями
     * @param value - переменная для случайного числа от 0 до 3000
     * */
    private void randomInit() {
        for (int i = 0; i < arrayLenght; i++) {
            int value = (int) (Math.random() * 3001);
            linked.add(i, value);
        }
        for (int i = 0; i < arrayLenght; i++) {
            int value = (int) (Math.random() * 3001);
            array.add(i, value);
        }
    }
}
