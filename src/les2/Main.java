package les2;

import java.util.Random;

public class Main {

    int maxSize = 100000;
    //int maxSize = 1000000;
    Random random = new Random();
    MyArraylist<Integer> mal = new MyArraylist<>();
    MyArraylist<Integer> mal1 = new MyArraylist<>();
    MyArraylist<Integer> mal2 = new MyArraylist<>();

    public static void main(String[] args) {
        Main d = new Main();
        d.mainStart();
    }

    public void mainStart(){
        for (int i = 0; i < maxSize; i++) {
            mal.add(random.nextInt(maxSize));
            mal1.add(random.nextInt(maxSize));
            mal2.add(random.nextInt(maxSize));
        }
        System.out.println("Массив создан!");

        new Thread(() -> {
            System.out.println("Запуск сортировки выборкой");
            long a = System.currentTimeMillis();
            mal.selectionSort();
            long split = System.currentTimeMillis();
            System.out.println("Время сортировки выборой: "+ (split-a));
        }).start();
        new Thread(() -> {
            System.out.println("Запуск сортировки пузырьком");
            long a = System.currentTimeMillis();
            mal1.bubbleSort();
            long split = System.currentTimeMillis();
            System.out.println("Время сортировки пузырьком: "+ (split-a));
        }).start();
        new Thread(() -> {
            System.out.println("Запуск сортировки вставкой");
            long a = System.currentTimeMillis();
            mal1.insertionSort();
            long split = System.currentTimeMillis();
            System.out.println("Время сортировки вставкой: "+ (split-a));
        }).start();


    }
}
