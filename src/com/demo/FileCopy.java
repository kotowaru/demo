package com.demo;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author kotowaru
 * 文件拷贝
 */
public class FileCopy {
    public static void flieCopy(String source,String target) throws IOException {
        try(InputStream in = new FileInputStream(source)) {
            try (OutputStream out = new FileOutputStream(target)){
                byte[] buffer = new byte[4096];
                int l;
                while ((l = in.read(buffer)) != -1){
                    out.write(buffer,0,l);
                }
            }
        }
    }
    public static void flieCopyNio(String source, String target) throws IOException {
        try (FileInputStream in = new FileInputStream(source)){
            try (FileOutputStream out = new FileOutputStream(target)){
                FileChannel inChannel = in.getChannel();
                FileChannel outChannel = out.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(4096);
                while (inChannel.read(buffer) != -1){
                    buffer.flip();
                    outChannel.write(buffer);
                    buffer.clear();
                }
            }
        }
    }
}
