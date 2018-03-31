package com.yema4.demo;

import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * @Author ：yema
 * @Description ：集合对象类java.util.Properties 继承自 hashTable，线程安全， 实现Map接口
 *                  可以和IO对象结合使用，实现数据持久化存储
 * @Date ：Create in 17:51 2018/3/30
 * @Edit ：by Intellij IDEA
 */
public class PorpertiesDemo {

    /*
     使用Properties存储键值对，键和值都是String类型，不能加泛型
     setProperty(String,String)等同于MAp接口的put（）
     getProperty(String) 等同于MAp接口的get（）
     */
    @Test
    public void fun1(){
        Properties pro = new Properties();
        pro.setProperty("a","1");
        pro.setProperty("b","2");
        pro.setProperty("c","3");
        System.out.println(pro);

        String value = pro.getProperty("c");
        System.out.println(value);

        //stringPropertyNames，将集合中的键存到Set中，类似Map中的keySet方法
        Set<String> set = pro.stringPropertyNames();
        for(String s : set){
            System.out.println(s+"..."+pro.getProperty(s));
        }
    }

    /**
     * Properties节后特有的方法load
     * load(InputStream in)
     * load(Reader r)
     * 传递任意的直接或者字符输入流
     * 流对象读取文件中键值对保存到集合
     */
    @Test
    public void fun2() throws IOException{
        Properties pro = new Properties();
        FileReader fr = new FileReader("F:\\data\\pro.properties");
        //调用几个的load方法
        pro.load(fr);
        fr.close();
        System.out.println(pro);
    }

    /**
     * Properties节后特有的方法store
     * store(Write w)
     * store(OutputStream out)
     * 接收所有的字节或字符的输出流，将集合中的键值对写回到文件中
     */
    @Test
    public void fun3() throws IOException{
        Properties pro = new Properties();
        pro.setProperty("name","xiaohua");
        pro.setProperty("age","18");
        pro.setProperty("tel","188");
        FileWriter fw = new FileWriter("F:\\data\\proo.properties");
        //调用几个的store方法
        pro.store(fw,"");//第二个参数是注释，但不要写中文，会被转换换成unicod编码
        fw.close();
    }
}
