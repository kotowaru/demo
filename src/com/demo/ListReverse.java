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
        Object remove = list.remove(list.size() - 1);
        newList.add(remove);
        return reverse(list,newList);
    }
}
