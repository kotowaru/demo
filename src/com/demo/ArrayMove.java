package com.demo;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayMove {
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
    }
    public static void main(String[] args) {
        Integer array[] = {1,2,3,4,5,6,7};
        for (int i1 = 0; i1 < array.length; i1++) {
            System.out.print(array[i1]);
        }
        arr arr = new ArrayMove().new arr(array);
        int i = 1;
        while (i <= array.length){
            System.out.println("第" + i + "次调用");
            arr.move();
            i++;
        }
    }

}
