package zzy.likou;

import java.util.ArrayList;

public class Solution {
    static int[] time_days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static int[] split(String date) {
        String[] temp;
        temp = date.split("-");
        int mon = Integer.parseInt(temp[0]);
        int day = Integer.parseInt(temp[1]);
        int[] result = {mon, day};
        return result;
    }

    public static int calculate(int mon, int day) {
        int dayindex = 0;
        for (int i = 0; i < mon - 1; i++) {
            dayindex = dayindex + time_days[i];
        }
        return dayindex + day;
    }

    public static int Calculate_date(String date) {
        String[] temp = date.split("-");
        int mon = Integer.parseInt(temp[0]);
        int day = Integer.parseInt(temp[1]);

        int dayIndex = 0;
        for (int i = 0; i < mon - 1; i++) {
            dayIndex = dayIndex + time_days[i];
        }
        return dayIndex + day;
    }

    public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arriveAliceIndex = Solution.Calculate_date(arriveAlice);
        int leaveAliceIndex = Solution.Calculate_date(leaveAlice);
        int arriveBobIndex = Solution.Calculate_date(arriveBob);
        int leaveBobIndex = Solution.Calculate_date(leaveBob);
        int sameday = 0;
        for (int i = arriveAliceIndex; i <= leaveAliceIndex; i++) {
            if (i <= leaveBobIndex && i >= arriveBobIndex) {
                sameday++;
            }
        }
        return sameday;
    }

    public static void main(String[] args) {
        System.out.println(Solution.countDaysTogether("08-12", "09-12", "08-15", "12-12"));

    }


}
