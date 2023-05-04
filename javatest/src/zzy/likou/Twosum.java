package zzy.likou;

import java.util.Arrays;

public class Twosum {
    public static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int targetIndex = nums[i] + nums[j];
                if (targetIndex == target && i != j) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] index = new int[]{2, 5, 6, 9, 3};
        System.out.println(Arrays.toString(Twosum.twoSum(index, 9)));
    }


}

