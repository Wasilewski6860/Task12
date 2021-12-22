package ru.vsu.baryshev;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 3;

        Consumer<int[]> printer = (int[] answer) -> {
            for (int j = 0; j < k; j++)
                System.out.print(answer[j] + " ");
        };

        solution(arr, k, printer);
    }

//    int arr[]  ---> Исходный массив
//    int answer[] ---> Временный массив для хранения текущей комбинации
//    start / end ---> Начальный/Конечный индексы для обработки(перебора) масссива
//    index  ---> Текущий индекс в answer
//    k ---> наше k
    static void logic(int[] arr, int[] answer, int start, int end, int index, int k, Consumer<int[]> printer) {
        if (index == k) {
            printer.accept(answer);

            System.out.println();
            return;
        }

        for (int i = start; i <= end; i++) {
            answer[index] = arr[i];
            System.out.println(" i = "+i+" start ="+start+" index="+index);
            logic(arr, answer, i + 1, end, index + 1, k, printer);
        }
    }

    static void solution(int[] arr, int k, Consumer<int[]> printer) {
        int[] answer = new int[k];

        logic(arr, answer, 0, arr.length - 1, 0, k, printer);
    }
}
//        1 2 3S
//        1 2 4
//        1 2 5
//        1 3 4
//        1 3 5
//        1 4 5
//        2 3 4
//        2 3 5
//        2 4 5
//        3 4 5
