package com.yema3.bufferedSrteam;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author ：yema
 * @Description ：java.io.BufferedInputStream 继承于 java.io.InputStream
    提高了原有流的读出效率

 * @Date ：Create in 11:06 2018/3/30
 * @Edit ：by Intellij IDEA
 */
public class BufferedInputStreamDemo {

    @Test
    public void fun1() throws IOException {
        //传递字节输入流，放谁就对谁高效
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("F:\\data\\demo.java"));

        byte[] b = new byte[10];
        int len = 0;
        while ((len=bis.read(b)) != -1){
            System.out.print(new String(b,0,len));
        }
        bis.close();
    }
}
