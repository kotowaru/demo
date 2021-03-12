package com.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kotowaru
 * 反转链表
 */
public class ListReverse {
    public static void main(String[] args) {
        List<String> old = new ArrayList<>();
        for (int i = 0;i<10;i++){
            old.add(i + "");
            System.out.print(i);
            System.out.print(",");
        }
        System.out.println();
        List newList = new ArrayList();
        newList = reverse(old,newList);
        newList.forEach( l -> {
            System.out.print(l.toString());
            System.out.print(",");
        });
    }

    public static List reverse(List list,List newList){
        if(list == null || list.size() == 0){
            return newList;
        }
        Object remove = list.remove(0);
        newList.add(0,remove);
        return reverse(list,newList);
    }
//    public ListNode ReverseList(ListNode head) {
//        ListNode p = new ListNode(0);
//        p.next = null;
//        while(head != null){
//            ListNode temp = head.next;
//            head.next = p.next;
//            p.next = head;
//            head = temp;
//        }
//        return p.next;
//    }
    /*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
}
