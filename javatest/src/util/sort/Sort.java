package util.sort;

import java.util.Arrays;

public class Sort {
    public static void bubbleSort(int[] array) {
        for (int j=0;j<array.length-1;j++){
            for (int i = 0; i < array.length - 1-j; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }
}
