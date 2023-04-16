import util.sort.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

class Application {

    //    public static void main(String[] args) {
//        int[] array = {6, 2, 1, 5, 6, 6};
//        array = Sort.quickSort(array,0, array.length-1);
//        System.out.println(Arrays.toString(array));
//    }
    public static void main(String[] args) {
//        ArrayList<Object> sites = new ArrayList<Object>();
//        sites.add(123);
//        sites.add("Runoob");
//        sites.add("Taobao");
//        sites.add("Weibo");
//        System.out.println(sites);

        ArrayList<String> sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Zhihu");

        // 获取迭代器
        Iterator<String> it = sites.iterator();
        it.next();
        // 输出集合中的第一个元素
        System.out.println(it.next());
    }


}


