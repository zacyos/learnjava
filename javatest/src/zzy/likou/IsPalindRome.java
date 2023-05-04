package zzy.likou;

import java.text.StringCharacterIterator;

public class IsPalindRome {
    public static boolean isPalindRome(int x) {
        if(x<0){
            return false;
        }
//        int x = 123123;
//        String temp = Integer.toString(x);
//        String[] xArray= temp.split("");
        String temp = Integer.toString(x);
//        字符串索引
        for (int i = 0;i<temp.length()/2;i++){
            if(temp.charAt(0) != temp.charAt(temp.length()-1-i)){
                return false;
            }
        }
//        int[] xAarry = new int[temp.length()];
//        for (int i = 0; i < temp.length(); i++) {
//            for (int j = 0; j == temp.length() - i; j--) {
//                if (i == j) {
//                    return true;
//                }
//            }
//        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(IsPalindRome.isPalindRome(-131));
    }
}
