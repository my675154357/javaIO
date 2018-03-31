package com.yema2.demo;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author ：yema
 * @Description ：使用字节输入/输出流复制文件。 速度特别慢
 * @Date ：Create in 17:48 2018/3/29
 * @Edit ：by Intellij IDEA
 */
public class ByteCopyDemo {

    @Test
    public void fun1(){
        //定义2个流对象
        FileInputStream fis = null;
        FileOutputStream fos = null;
        //建立2个数据源，分别绑定数据源和数据目的地
        try {
            fis = new FileInputStream("F:\\data\\a.txt");
            fos = new FileOutputStream("F:\\data\\dir\\a.txt");

            //字节流读写
            int len = 0;
            while ((len = fis.read()) != -1){
                fos.write(len);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            throw new RuntimeException("文件复制失败");
        } finally {
            try {
                //遵守先开后关的原则
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                //e.printStackTrace();
                throw new RuntimeException("关闭资源失败");
            } finally {
                try {
                    if (fis != null) {
                        fis.close();
                    }
                } catch (IOException e) {
                    //e.printStackTrace();
                    throw new RuntimeException("关闭资源失败");
                }
            }
        }
    }
}
