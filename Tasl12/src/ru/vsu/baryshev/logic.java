package ru.vsu.baryshev;

import java.util.function.Consumer;

public class logic {
    static void logic(int[] arr, int[] answer, int start, int end, int index, int k, Consumer<int[]> printer) { // Оновной метод, логика которого была обговорена на занятии

        if (index == k) {
            printer.accept(answer);

            System.out.println();
            return;
        }

        for (int i = start; i <= end; i++) {
            answer[index] = arr[i];
            //  System.out.println(" i = " + i + " start =" + start + " index=" + index);
            logic(arr, answer, i + 1, end, index + 1, k, printer);
        }
    }

    static void solution(int[] arr, int k, Consumer<int[]> printer) {  // Метод, с которым работает пользователь
        int[] answer = new int[k];

        logic(arr, answer, 0, arr.length - 1, 0, k, printer);
    }
}
