package zzy.likou;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test {

    private static String roman;

    static <T> void print(T a) {
        System.out.println(a);
    }


    public static int solution(String s) {

        HashMap<String, Integer> romanMap = new HashMap<>();

        romanMap.put("I", 1);
        romanMap.put("V", 5);
        romanMap.put("X", 10);
        romanMap.put("L", 50);
        romanMap.put("C", 100);
        romanMap.put("D", 500);
        romanMap.put("M", 100);

        int target = 0;
        for (int i = 0; i < s.length(); i++) {
            String roman = s.substring(i, i + 1);
            // 当i是最后一个，直接加上
            if (i == s.length() - 1) {
                target += romanMap.get(roman);
            } else {
                String nextRoman = s.substring(i + 1, i + 2);
                // 当当前的roman数字的值小于下一个罗马数字，需要组合两个数，并且i要特殊的+1
                // 否则就是一个正常的罗马字符转数字
                if (romanMap.get(roman) < romanMap.get(nextRoman)) {
                    target += romanMap.get(nextRoman) - romanMap.get(roman);
                    i++;
                } else {
                    target += romanMap.get(roman);
                }
            }

        }

        return target;
    }

    public static void main(String[] args) {
        print("V：" + solution("V"));
        print("IV：" + solution("V"));
    }
}
