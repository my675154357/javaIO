package com.yema4.demo;

import java.io.Serializable;

/**
 * @Author ：yema
 * @Description ：
 * @Date ：Create in 18:35 2018/3/30
 * @Edit ：by Intellij IDEA
 */
public class Person implements Serializable{

    /**
     * 关于这个serialVersionUID属性，序列化冲突的原因：
     *  如果没有显示写这个属性，编译器会根据源码自动生形成序列号。但是在序列化的过程中，假如，先进行了序列化写对象。则
     *  会把对象写入到流中临时的文件中，这个文件中包含了序列号，此时.class文件中和临时文件中的序列号是一致的。如果此
     *  时修改了源码，虚拟机会重新编译，根据源码重新生成序列号，此时.class中的序列号必然与刚才的临时文件中的序列号不
     *  一致。在反序列化的时候流中临时文件的序列号与.class的序列号进行比较，一致则可以进行反序列化，不一致则会抛出异常
     *  InvalidCastException。
     *  解决：显示的写出这个属性，编译器就不会再计算序列号了。则序列号就是不变的了，无论怎么修改源码序列号都不会变
     */
    private static final long serialVersionUID = -8869200033478637652L;
    /**
     * Serializable这个接口，没有任何属性和方法。这种就属于标记型接口，任何实现了这个接口的类都会被标记，虚拟机见到
     * 了这个标记就知道该对象需要进行序列化。
     * Clone也是标记型接口
     */
    private String name;
    /**
     * transient 关键字是阻止成员变量序列化。用static修饰也不会被序列化，但是和static不同，这个关键字是瞬态的，只
     有这一个作用，并不会影响到别的
     */
    private /*transient*/ int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
