package com.guyu.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Currency;

/**
 * @Des 枚举类型实现单例模式
 * @Author guyu
 * @Date 2020/4/10 16:15
 * @Param 
 * @Return 
 */
public enum  EnumSIngleton {
    INSTANCE;
    public void print(){
        System.out.println(this.hashCode());
    }

}
class EnumTest{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, ClassNotFoundException {
        EnumSIngleton instance = EnumSIngleton.INSTANCE;
        EnumSIngleton instance1 = EnumSIngleton.INSTANCE;
        System.out.println(instance == instance1);
        //这种方式反射破坏不了,通过反编译javap -v -p EnumSIngleton.class更加详细的命令查到它默认调用构造方法，
        //  descriptor: (Ljava/lang/String;I)V在这里，发现构造方法需要String和int两个参数,吐过传入Interger参数就会报错，特别注意
//        Constructor<EnumSIngleton> declaredConstructor = EnumSIngleton.class.getDeclaredConstructor(String.class, int.class);
//        declaredConstructor.setAccessible(true);
//        EnumSIngleton instance2 = declaredConstructor.newInstance("INSTANCE", 0);
        //测试之后会发现，它不允许反射创建会报错Exception in thread "main" java.lang.IllegalArgumentException: Cannot reflectively create enum objects
        //	at java.lang.reflect.Constructor.newInstance(Constructor.java:417)

        //序列化形式
//        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("enumsingleton"));
//        oos.writeObject(instance);
//        oos.close();
        //反序列化,枚举方式创建的实例支持反序列化
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("enumsingleton"));
        EnumSIngleton object = ((EnumSIngleton) ois.readObject());

        System.out.println(object == instance);


    }
}

