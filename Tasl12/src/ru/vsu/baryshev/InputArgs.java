package ru.vsu.baryshev;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.System.out;

public class InputArgs {

    public static int[] growingMassive(int[] array) {     // метод для увеличения массива, т.к. изначально при создании его длина конечна, ее увеличение происходит путем создания копий
        int[] help = new int[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            help[i] = array[i];
        }
        array = help;
        return array;
    }

    public static int[] commandLineToArray(String[] args){

        int[] answer = new int[0];

        for (int j=0;j<args.length-1;j++){

            int i = Integer.parseInt(args[j]);
            answer=growingMassive(answer);
            answer[j]=i;

        }
        return answer;
    }

    public static int[] fileToArray(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scn = new Scanner(file);

        if (file.length() == 0) { // Проверка на пустоту файла
            out.println("File if empty");
            return null;
        } else {

            String[] helpArray = scn.nextLine().split(" "); // Далее аналогично методу strToList
            int[] array = new int[helpArray.length];

            for (int i = 0; i < helpArray.length; i++) {

                try {

                    array[i] = Integer.parseInt(helpArray[i]);

                } catch (NumberFormatException nfe) {

                    //  out.println("Wrong Format");
                    return null;
                }
                ;
            }
        return array;
        }

    }

}
