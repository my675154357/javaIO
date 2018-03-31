package com.yema4.demo;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Author ：yema
 * @Description ：
 * @Date ：Create in 11:54 2018/3/31
 * @Edit ：by Intellij IDEA
 */
public class CommonsIODemo {

    /**
     * commons.io中的FilenameUtils;
     * String getExtension(String filename)
     * 获取文件后缀名
     */
    @Test
    public void fun1(){
        //获取文件后缀名
        String es = FilenameUtils.getExtension("a.txt");
        System.out.println(es);

        //获取文件名
        String name = FilenameUtils.getName("a.txt");
        System.out.println(name);

        //判断文件是否是特定后缀名为结尾，区分大小写。TXT就返回false
        boolean b = FilenameUtils.isExtension("a.txt", "txt");
        System.out.println(b);
    }

    /**
     * commons.io中的FileUtils;
     */
    @Test
    public void fun2() throws IOException {
        File file = new File("F:\\data\\a.txt");
        //读取文本中全部内容
        String content = FileUtils.readFileToString(file);
        System.out.println(content);

        //写文件
        FileUtils.writeStringToFile(file,"中文");

        //复制文件，任何文件，不仅限文本
        FileUtils.copyFile(new File("F:\\data\\a.txt"),new File("F:\\data\\dri\\a.txt"));

        //复制文件夹，包含文件夹中的所有内容
        FileUtils.copyDirectoryToDirectory(new File("F:\\data"),new File("F:\\data\\"));

    }
}
