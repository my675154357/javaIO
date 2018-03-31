package com.yema3.bufferedSrteam;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author ：yema
 * @Description ：java.io.BufferedOutputStream 继承于 java.io.OutputStream
    提高了原有流的写入效率

 * @Date ：Create in 11:06 2018/3/30
 * @Edit ：by Intellij IDEA
 */
public class BufferedOutputStreamDemo {

    @Test
    public void fun1() throws IOException {
        //传递字节输出流，放谁就对谁高效
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("F:\\data\\demo.java"));

        bos.write("helloword".getBytes());
        bos.write("helloword".getBytes(),1,2);
        bos.close();

    }
}
