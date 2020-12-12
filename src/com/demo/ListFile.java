package com.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author kotowaru
 * 列出文件夹中所有文件
 */
public class ListFile {
    /**
     * 只显示文件
     */
    public static void listFile(String dirPath){
        File file = new File(dirPath);
        for (File temp : file.listFiles()) {
            if(temp.isFile()){
                System.out.println(temp.getName());
            }
        }

    }

    /**
     * 文件夹中的文件也显现
     */
    public static void showFile(String dirPath){
        File file = new File(dirPath);

    }
    public static void showDir(File file){
        showFiles(file,0);
    }
    public static void showFiles(File file,int level){
        if(file.isDirectory()){
            for (File temp : file.listFiles()) {
                showFiles(temp,level+1);
            }
        }else {
            for (int i = 0;i < level - 1;i++){
                System.out.print("/t");
            }
        }
        System.out.println(file.getName());
    }

    /**
     * nio.2
     */
    public static void show(String dirPath) throws IOException{
        Path path = Paths.get(dirPath);
        Files.walkFileTree(path,new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.getFileName().toString());
                return super.visitFile(file, attrs);
            }
        });
    }
}
