package com.yema1.B_each;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

/**
 * @Author ：yema
 * @Description ：
 * @Date ：Create in 14:41 2018/3/29
 * @Edit ：by Intellij IDEA
 */
public class RecursionEach {

    public static void main(String[] args) {
        //fun1(new File("F:\\data"));
        //System.out.println(fun2(10));
        //System.out.println(fun3(6));
        fun4(new File("F:data\\"));
    }

    /**
     * 实现目录全遍历
     */
    public static void fun1(File dir){
        //调用方法 listFiles();对目录file进行遍历
        File[] files = dir.listFiles();
        for(File f : files){
            System.out.println(f);
            if (f.isDirectory()){
                fun1(f);
            }
        }
    }

    /**
     * 举一反三，写个递归阶乘
     * 实际开发基本上禁止使用递归，因为在jvm中，栈的空间小且有限，一旦递归嵌套的方法多了未及时释放内存，会抛出
     * StackOverflowError。而堆的内存较大且大小可变。
     * 方法和局部变量存在栈中，对象和数组存在堆中，静态变量静态方法存在方法区。
     * 讲个题外话，jvm的垃圾回收，分为三种：标记清除法、标记复制法、标记整理法。
     * 标记清除法：将未使用的变量标记为垃。缺点就是容易产生内存碎片，一旦有个变量需要开辟的空间比较大，而剩余的连续内
     * 存不足以开辟，就会抛出内存溢出。扫描两次
     * 标记复制法：
     * 栈中的变量生存周期非常小，经常会被回收，因此采用的标记复制法。堆采用标记整理法。
     *
     */
    public static int fun2(int num){
        if (num == 1){
            return 1;
        }
        return num * fun2(num-1);
    }

    /**
     * 递归计算斐波那契额数列:1,1,2,3,5,8,13   n = (n-1) + (n-2)
     * @return
     */
    public static int fun3(int n){
        if (n <= 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }else if (n == 2){
            return 1;
        }else {
            return fun3(n-1)+fun3(n-2);
        }
    }

    /**
     * 递归全遍历目录，获取目录下所有的.java文件
     */
    public static void fun4(File dir){
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory()) {
                    fun4(pathname);
                }
                //endsWith()区分大小写，但windows不区分，a.java和a.JAVA是同一个文件。
                return pathname.getName().toLowerCase().endsWith(".java");
            }
        });
        for (File f : files){
            System.out.println(f);
        }
    }
}
