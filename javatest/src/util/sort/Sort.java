package util.sort;

import java.util.Arrays;

public class Sort {
    public static int[] bubbleSort(int[] array) {
        for (int j = 0; j < array.length - 1; j++) {
            for (int i = 0; i < array.length - 1 - j; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] chooseSort(int[] array) {
//        for (int j=0;j<array.length-1;j++){
//            for(int i = 0;i<array.length - 1 -j;i++) {
//                if(array[i]>array[array.length-1-j]){
//                    int temp = array[i];
//                    array[i] = array[array.length-1-j];
//                    array[array.length-1-j] = temp;
//                }
//
//
//            }
//        }
        for (int j = 0; j < array.length - 1; j++) {
            for (int i = 1 + j; i < array.length; i++) {
                if (array[j] > array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }

    public static int[] insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            int temp = array[i];
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        return array;
    }

}
