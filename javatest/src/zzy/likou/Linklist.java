package zzy.likou;


import util.likou.ListNode;

public class Linklist {


    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        return null;
    }

    public static void main(String[] args) {
        ListNode l3 = new ListNode(4);
        ListNode l2 = new ListNode(2, l3);
        ListNode list1 = new ListNode(1, l2);

        list1.print();

        ListNode b = new ListNode(4);
        ListNode a = new ListNode(3, b);
        ListNode list2 = new ListNode(1, a);
        list2.print();

mergeTwoLists(list1,list2).print();





    }
}