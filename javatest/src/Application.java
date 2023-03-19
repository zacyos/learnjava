import util.sort.Sort;

import java.util.Arrays;

class Application {

    public static void main(String[] args) {
        int[] array = {6, 2, 1, 5, 6, 6};
        array = Sort.quickSort(array,0, array.length-1);
        System.out.println(Arrays.toString(array));
    }



}