package yc.shujujiegou;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Random;

public class YcBitset {
//    public static void main(String[] args) {
//
//        Random random = new Random();
//        BitSet bitSet = new BitSet(500);     // {}
//
//        System.out.print("生成的随机数：");
//
//        for (int i = 0; i < 5; i++) {
//            int r = random.nextInt(10);
//            System.out.print(r+" ");
//            bitSet.set(r);
//        }
//        System.out.println("\nbitset:" + bitSet);
//        for (int i = 0; i < 10; i++) {
//            System.out.print(bitSet.get(i) + " ");
//        }
//
//        System.out.println("\n0~10不在上述随机数中有" + bitSet.size());
//        for (int i = 0; i < 10; i++) {
//            if (!bitSet.get(i)) {
//                System.out.print(i + " ");
//            }
//        }
//    }


    public static void main(String args[]) {
        BitSet bits1 = new BitSet(16);
        BitSet bits2 = new BitSet(16);

        // set some bits
        for (int i = 0; i < 16; i++) {
            if ((i % 2) == 0) bits1.set(i);
            if ((i % 5) != 0) bits2.set(i);
        }
        System.out.println("Initial pattern in bits1: ");
        for (int i = 0; i < 16; i++) System.out.print(bits1.get(i) + " ");
        System.out.println("\nInitial pattern in bits2: ");
        for (int i = 0; i < 16; i++) System.out.print(bits2.get(i) + " ");

        // AND bits
        bits2.and(bits1);
        System.out.println("\nbits2 AND bits1: ");
        System.out.println(bits2);

        // OR bits
        bits2.or(bits1);
        System.out.println("\nbits2 OR bits1: ");
        System.out.println(bits2);

        // XOR bits
        bits2.xor(bits1);
        System.out.println("\nbits2 XOR bits1: ");
        System.out.println(bits2);
    }
}
