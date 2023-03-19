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


    /**
     * 快排
     * @param array     数组
     * @param l         左临界值
     * @param r         右临界值
     * @return          返回数组
     */
   //{1,2}  l0,r-1; i0,j0;
    public static int[] quickSort(int[] array,int l ,int r){
        if(l>=r) return array;
        int i = l;
        int j = r;
        while(i<j) {
            while (array[i] < array[l] && i < j) i++;
            while (array[j] >= array[l] && j > i) j--;
            if (i < j) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        int key = array[l];
        array[l] = array[i];
        array[i] = key;
        array = quickSort(array,l,i-1);
        array = quickSort(array,j+1,r);
        return array;

    }


}
