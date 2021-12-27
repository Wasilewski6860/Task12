package ru.vsu.baryshev;

import java.io.FileNotFoundException;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        if (args[0].equals("-i")) {
           int[] array = InputArgs.fileToArray(args[1]);
           int k = Integer.parseInt(args[2]);

            Consumer<int[]> callback = (int[] answer) -> { // Создаем callback
                for (int j = 0; j < k; j++)
                    System.out.print(answer[j] + " ");
            };

            logic.solution(array, k, callback); // Вызываем решение задачи

        } else{

            int[] arr = InputArgs.commandLineToArray(args);
        int k = Integer.parseInt(args[args.length - 1]);

        Consumer<int[]> callback = (int[] answer) -> { // Создаем callback
            for (int j = 0; j < k; j++)
                System.out.print(answer[j] + " ");
        };

        logic.solution(arr, k, callback); // Вызываем решение задачи
    }
    }

    //    int arr[]  ---> Исходный массив
//    int answer[] ---> Временный массив для хранения текущей комбинации
//    start / end ---> Начальный/Конечный индексы для обработки(перебора) масссива
//    index  ---> Текущий индекс в answer
//    k ---> наше k


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
