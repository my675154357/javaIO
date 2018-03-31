package com.yema2.demo;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author ：yema
 * @Description ：字符输入/输出流，复制文件，必须是文本文件
 *                  字符流默认查询本机的编码表，简体中文GBK
 *                  FileReader数去数据源
 *                  FileWriter写入到数据目的地
 * @Date ：Create in 19:22 2018/3/29
 * @Edit ：by Intellij IDEA
 */
public class ReaderCopy {

    @Test
    public void fun(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("F:\\data\\a.txt");
            fw = new FileWriter("F:\\data\\dri\\a.txt");
            char[] c = new char[1024];//2kb
            int len = 0;
            while ((len = fr.read(c)) != -1){
                fw.write(c,0,len);
                fw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("复制失败");
        } finally {
            try {
                //遵守先开后关的原则
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                //e.printStackTrace();
                throw new RuntimeException("关闭资源失败");
            } finally {
                try {
                    if (fr != null) {
                        fr.close();
                    }
                } catch (IOException e) {
                    //e.printStackTrace();
                    throw new RuntimeException("关闭资源失败");
                }
            }
        }
    }
}
