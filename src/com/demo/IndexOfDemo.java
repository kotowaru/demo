package com.demo;

/**
 * @author kotowaru
 * 实现类似String中indexOf()方法
 */
public class IndexOfDemo {
    public static void main(String[] args) {
        System.out.println(indexOf("abcabd","abd"));
    }

    public static int indexOf(String str,String f){
        char[] chars = str.toCharArray();
        char[] chars1 = f.toCharArray();
        int index = -1;
        int temp = 0;
        int sy = -1;
        for (int i = 0; i < chars1.length; i++) {
            for (int i1 = temp + i; i1 < chars.length; i1++) {
                if(chars1[i] == chars[i1]){
                    if(temp == 0){
                        temp = i1;
                    }
                    sy = i1;
                    break;
                }else {
                    if (temp != 0){
                        temp = i1;
                        i = 0;
                        sy = -1;
                        index = -1;
                        break;
                    }
                }
            }
            if(temp != -1 && sy != -1){
                if(chars1[i] != chars[sy]){
                    index = -1;
                    break;
                }else {
                    index = temp;
                }
            }
        }
        return index;
    }
}
