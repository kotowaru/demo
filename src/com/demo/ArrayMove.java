package com.demo;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayMove {

    public static void main(String[] args) {
        Integer array[] = {1,2,3,4,5,6,7};
        System.out.println("原数组：");
        System.out.println(Arrays.toString(array));
        arr arr = new ArrayMove().new arr(array);
        arr2 arr2 = new ArrayMove().new arr2(array);
        int i = 1;
        while (i <= array.length){
            System.out.println("第" + i + "次调用");
            System.out.println("第一种方式：");
            arr.move();
            System.out.println("第二种方式：");
            arr2.move();
            i++;
        }
    }
    class arr{
        private Integer array[];

        public arr(Integer a[]){
            this.array = a;
        }
        public void move(){
            ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(array));
            Integer remove = integers.remove(integers.size() - 1);
            integers.add(0,remove);
            Integer[] objects = integers.toArray(new Integer[0]);
            this.array = objects;
            System.out.println(Arrays.toString(objects));
        }
        public void move2(){
            int temp = -1;
            for (int i = 0; i < array.length; i++) {
                temp = array[array.length - 1];
                array[array.length - 1] = array[i];
                array[i] = temp;
            }
            System.out.println(Arrays.toString(array));
        }
    }
    class arr2{
        private Integer array[];

        public arr2(Integer a[]){
            this.array = a;
        }
        public void move(){
            int temp = -1;
            for (int i = 0; i < array.length; i++) {
                temp = array[array.length - 1];
                array[array.length - 1] = array[i];
                array[i] = temp;
            }
            System.out.println(Arrays.toString(array));
        }
    }
}
