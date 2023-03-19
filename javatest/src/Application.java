import util.sort.Sort;

import java.util.Arrays;

class Application {

    public static void main(String[] args) {
        int[] array = {3, 2, 1, 5, 4, 3};
        array = Sort.insertSort(array);
        System.out.println(Arrays.toString(array));
    }



}