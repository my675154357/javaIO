package com.yema1.A_demo;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
 * @Author ：yema
 * @Description ：File类位于 java.io.File。 File类具有与系统无关性
 *                  将操作系统中的文件、目录（文件夹）、路径，封装成File对象
 *                  文件：file；目录：directory；路径：path
 * @Date ：Create in 18:08 2018/3/28
 * @Edit ：by Intellij IDEA
 */
public class FileDemo {

    //static String pathSeparator  与系统有关的路径分隔符，为了方便，它被表示为一个字符串。
    @Test
    public void fun1(){
        //File类静态成员变量
        //与系统有关的路径分隔符
        String separator = File.pathSeparator;
        //输出一个 ; 分号。参考path环境变量，以分号结束。如果在linux环境下运行，就是: 冒号
        System.out.println(separator);
        //----------------------------------
        //与系统有关的默认名称分隔符
        separator = File.separator;
        //向右的 \ ，目录的分隔符。linux下是 / 向左分隔符
        System.out.println(separator);
    }

    /**
     * File类的构造方法，三种
     */
    @Test
    public void fun2_1(){
        /**
         * File(String pathName)  不管路径或文件是否真实存在
         * 传递路径名，可以写文件名也可以写文件夹名
         * 将路径封装成File类型对象
         */
        //windows下的文件、文件夹、路径名称不区分大写小。但是linux区分大小写
        File file = new File("F:\\data");
        System.out.println(file.exists());
    }

    @Test
    public void fun2_2(){
        /**
         * File(String parent, String child)  不管路径或文件是否真实存在
         * 传路径名，字符串父路径、子路经
         * 和上面的相比，这个路径更灵活。可以单独操作父路径、子路经
         */
        File file = new File("F:","data");
        System.out.println(file);
    }

    @Test
    public void fun2_3(){
        /**
         * File(File parent, String child)  不管路径或文件是否真实存在
         * 传路径名，File类型父路径，字符串子路经
         * 好处：父路径是File类型，可以直接调用File类的方法
         */
        File parent = new File("F:");
        File file = new File(parent, "data");
        System.out.println(parent.exists());
        System.out.println(file);
    }

    @Test
    /**
     * File类的创建文件功能，不能创建文件夹
     * boolean createNewFile()
     * 创建的文件路径和文件名，返回是否创建成功。如果文件存在，这不会创建成功
     */
    public void fun3() throws IOException {
        File file = new File("F:\\data\\a.txt");
        boolean b = file.createNewFile();
        System.out.println(b);
    }

    /**
     * 创建文件夹boolean mkdir()创建单层文件夹。mkdirs()创建多级文件夹
     */
    @Test
    public void fun4() {
        File file = new File("F:\\data\\dir\\dd");
        boolean b = file.mkdirs();
        System.out.println(b);
    }

    /**
     * File类的删除功能，删除文件或文件夹
     * boolean delete() 直接从硬盘中删除，不会进windows的回收站，谨慎运行。
     * 如果删除的目录存在子目录，不能删除
     */
    @Test
    public void fun5() {
        File file = new File("F:\\data\\dir");
        boolean b = file.delete();
        System.out.println(b);
    }

    /**
     * File类的获取功能
     * String getName() 返回路径中表示的文件或最后一层文件夹的名称。不管路径或文件是否真实存在
     */
    @Test
    public void fun6() {
        File file = new File("F:\\data\\dir\\dd");
        String name = file.getName();
        System.out.println(name);
        //返回路径
        String path = file.getPath();
        System.out.println(path);
        System.out.println(file);
    }

    /**
     * long length() 返回路径中表示的文件的字节数
     */
    @Test
    public void fun7() {
        File file = new File("F:\\data\\a.txt");
        long length = file.length();
        System.out.println(length);
    }

    /**
     * 传入文件或文件夹的路径
     * String getAbsolutePath() 获取绝对路径
     * File getAbsoluteFile() 获取绝对路径  常用这个
     * 如果写的是一个相对路径，会获得工程根目录
     */
    @Test
    public void fun8() {
        File file = new File("src");
        File absoluteFile = file.getAbsoluteFile();
        System.out.println(absoluteFile);
    }

    /**
     * 传入文件或文件夹的路径
     * String getParent() 获取父路径
     * File getParentFile() 获取父路径  常用这个
     */
    @Test
    public void fun9() {
        File file = new File("F:\\data\\a.txt");
        File parentFile = file.getParentFile();
        System.out.println(parentFile);
    }

    /**
     * 判断功能
     * Boolean exists() 判断构造方法中封装的路径是否存在
     */
    @Test
    public void fun10() {
        File file = new File("F:\\data\\a.txt");
        boolean b = file.exists();
        System.out.println(b);
    }

    /**
     * 判断功能
     * Boolean isDirectory() 判断构造方法中封装的路径是否是目录
     * Boolean isFile() 判断构造方法中封装的路径是否是文件
     */
    @Test
    public void fun11() {
        File file = new File("F:\\data\\a.txt");
        boolean b = file.isDirectory();
        System.out.println(b);
    }

    /**
     * 获取功能
     * String[] list() 获取File构造方法中发了个装路径的文件和文件夹名（相当于遍历某个目录）
     * 全都会获取到，包括受系统保护的和隐藏的文件夹
     */
    @Test
    public void fun12() {
        File file = new File("F:\\");
        String[] arrays = file.list();
        for(String array : arrays){
            System.out.println(array);
        }
    }

    /**
     * 获取功能
     * File[] listFiles() 获取File构造方法中发了个装路径的文件和文件夹名（相当于遍历某个目录）
     * 返回文件夹或文件的全路径
     */
    @Test
    public void fun13() {
        File file = new File("F:\\");
        File[] files = file.listFiles();
        for(File f : files){
            System.out.println(f);
        }
        //获取系统中所有根目录
        File[] roots = File.listRoots();
        for(File root : roots){
            System.err.println(root);
        }
    }

    /**
     * 文件获取过滤器
     * 遍历目录时只获取满足条件的文件或文件夹
     * 遍历目录的方法 listFiles()重载形式
     * listFiles(FileFilter filter) 接口类型
     * 传递FileFilter接口实现类，重写抽象方法发
     */
    @Test
    public void fun14() {
        File file = new File("F:\\data\\");
        /**
         * accept()方法接的参数pathname，是由listFiles传递进来的。
         * listFiles返回文件或目录的数组，每获取到一个文件或目录，就把这个文件或目录传递进FileFilter的pathname参
         * 数过。符合条件的，内部类返回true并装进数组，否则返回false，过滤掉。
         */
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                //endsWith(".java");判断一个字符串的结尾是不是.java。另一个方法startsWith(); 判断字符串的开头。
                return pathname.getName().endsWith(".java");
            }
        });
        for(File f : files){
            System.out.println(f);
        }
    }
}