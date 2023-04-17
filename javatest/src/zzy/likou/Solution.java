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

    public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] dt = Solution.split(arriveAlice);
        int arriveAliceIndex = Solution.calculate(dt[0], dt[1]);
        dt = Solution.split(leaveAlice);
        int leaveAliceIndex = Solution.calculate(dt[0], dt[1]);
        dt = Solution.split(arriveBob);
        int arriveBobIndex = Solution.calculate(dt[0], dt[1]);
        dt = Solution.split(leaveBob);
        int leaveBobIndex = Solution.calculate(dt[0], dt[1]);

        int sameday = 0;

        for(int i = arriveAliceIndex;i<=leaveAliceIndex; i++){
            if(i<=leaveBobIndex&&i>=arriveBobIndex){
                sameday++;

            }
        }
        return sameday;
    }

    public static void main(String[] args) {
        System.out.println(Solution.countDaysTogether("08-12", "09-12", "08-15", "12-12"));

    }


}
