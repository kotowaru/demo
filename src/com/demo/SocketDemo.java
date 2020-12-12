package com.demo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kotowaru
 * 用Java的套接字编程实现一个多线程的回显（echo）服务器
 */
public class SocketDemo {

    private static final int SERVER_PORT = 6666;

    public static void main(String[] args){
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT);){
            System.out.println("服务启动");
            ExecutorService executorService = Executors.newFixedThreadPool(2);
            while (true){
                Socket socket = serverSocket.accept();
                executorService.submit(new Handler(socket));
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static class Handler implements Runnable{
        private Socket client;
        Handler(Socket client){
            this.client = client;
        }

        @Override
        public void run() {
            try (InputStream in = client.getInputStream();
                 InputStreamReader reader = new InputStreamReader(in);
                 BufferedReader bufferedReader = new BufferedReader(reader);
                 OutputStream outputStream = client.getOutputStream();
                 PrintWriter printWriter = new PrintWriter(outputStream);
            ){
                String msg = bufferedReader.readLine();
                System.out.println(msg + " " + client.getPort());
                printWriter.println(msg);
                printWriter.flush();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    client.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
