package com.yema2.demo;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

/**
 * @Author ：yema
 * @Description ：字符输入流，所有字符输入流的父类。同Writer，只能读文本文件
 *                  java.io.Reader
 *                  read()能读字符和字符数组。不能读字符串，因为字符串是无限大的，无法界定大小。
 * @Date ：Create in 18:54 2018/3/29
 * @Edit ：by Intellij IDEA
 */
public class ReaderDemo {

    @Test
    public void fun1() throws IOException {
        FileReader fr = new FileReader("F:\\data\\a.txt");
        int len = 0;
        char[] c = new char[1024];
        /*while ((len=fr.read()) != -1){
            System.out.print((char)len);
        }*/
        while ((len=fr.read(c)) != -1){
            System.out.print(new String(c,0,len));
        }
        fr.close();
    }
}
