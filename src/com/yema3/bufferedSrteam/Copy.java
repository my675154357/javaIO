package com.yema3.bufferedSrteam;

import java.io.*;

/**
 * @Author ：yema
 * @Description ：四种方式复制文件
 * @Date ：Create in 11:20 2018/3/30
 * @Edit ：by Intellij IDEA
 */
public class Copy {

    public static void main(String[] args) throws IOException{
        //byteCopy(new File("F:\\data\\demo.java"), new File("F:\\data\\dir\\demo.java"));
        //arrayCopy(new File("F:\\data\\demo.java"), new File("F:\\data\\dir\\demo.java"));
        //bufferByteCopy(new File("F:\\data\\demo.java"), new File("F:\\data\\dir\\demo.java"));
        bufferArrayCopy(new File("F:\\data\\demo.java"), new File("F:\\data\\dir\\demo.java"));
    }

    /**
     * 字节流复制单个字符
     * @param src
     * @param desc
     * @throws IOException
     */
    public static void byteCopy(File src, File desc) throws IOException{
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(desc);
        int len = 0;
        while ((len=fis.read()) != -1){
            fos.write(len);
        }
        fos.close();
        fis.close();
    }

    /**
     * 数组方式复制
     * @param src
     * @param desc
     * @throws IOException
     */
    public static void arrayCopy(File src, File desc) throws IOException{
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(desc);
        int len = 0;
        byte[] b = new byte[1024];
        while ((len=fis.read(b)) != -1){
            fos.write(b,0,len);
        }
        fos.close();
        fis.close();
    }

    /**
     * 字节流缓冲区复制单个字符
     * @param src
     * @param desc
     * @throws IOException
     */
    public static void bufferByteCopy(File src, File desc) throws IOException{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desc));
        int len = 0;
        while ((len=bis.read()) != -1){
            bos.write(len);
        }
        bos.close();
        bis.close();
    }

    /**
     * 缓冲区数组方式复制
     * @param src
     * @param desc
     * @throws IOException
     */
    public static void bufferArrayCopy(File src, File desc) throws IOException{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desc));
        int len = 0;
        byte[] b = new byte[1024];
        while ((len=bis.read(b)) != -1){
            bos.write(b,0,len);
        }
        bos.close();
        bis.close();
    }
}
