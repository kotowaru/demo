package com.demo;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author kotowaru
 * 排序
 */
public class SortDemo {

    public static void main(String[] args) {

    }

    /**
     * 冒泡
     */
    public static <T extends Comparable<T>> T[] sort1(T[] list){
        boolean swap = true;
        int len = list.length;
        for (int i = 1; i < len && swap; i++) {
            swap = false;
            for (int j = 0; j < len - 1; j++) {
                if(list[j].compareTo(list[j+1]) > 0){
                    T temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                    swap = true;
                }
            }
        }
        return list;
    }

    /**
     *     二分法，只适用于排序后的
     */
    public static <T extends Comparable<T>> int sort2(T[] list,T key){
        int low = 0;
        int high = list.length - 1;
        while (low <= high){
            int mid = low + (high-low)/2;
            int com = list[mid].compareTo(key);
            if(com > 0){
                high = mid -1;
            }else if ( com < 0){
                low = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分法 递归
     */
    public static <T extends Comparable<T>> int sort3(T[] list,int high,int low,T key){
        if(low <= high){
            int mid = low + ((high - low)>>1);
            int com = list[mid].compareTo(key);
            if(com < 0){
                sort3(list,high,mid+1,key);
            }else if(com > 0){
                sort3(list,mid-1,low,key);
            }else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 获取给定数组，最小的k个数
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        int temp;
        for(int i = 0;i<input.length;i++){
            for(int j=0;j<input.length-i;j++){
                if(input[i]>input[j]){
                    temp = input[j];
                    input[j] = input[i];
                    input[i] = temp;
                }
            }
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0;i<k;i++){
            arr.add(input[i]);
        }
        return arr;
    }
}
