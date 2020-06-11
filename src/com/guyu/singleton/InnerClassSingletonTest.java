package com.guyu.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InnerClassSingletonTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, ClassNotFoundException {
    //        InnerClassSingleton instance = InnerClassSingleton.getInstance();
    //        InnerClassSingleton instance1 = InnerClassSingleton.getInstance();
    //        System.out.println(instance == instance1);
    //        //测试多线程安全-
    //        new Thread(()->{
    //            System.out.println(InnerClassSingleton.getInstance());
    //        }).start();
    //        new Thread(()->{
    //            System.out.println(InnerClassSingleton.getInstance());
    //        }).start();
//            反射攻击创建实例
        //注意这里是getDeclaredConstructor()，因为它的构造方法是私有的
//        Constructor<InnerClassSingleton> constructor = InnerClassSingleton.class.getDeclaredConstructor();
//        constructor.setAccessible(true);//设置为不检测，否则报错
//        InnerClassSingleton innerClassSingleton = constructor.newInstance();
        //上面是反射创建实例
//
//        InnerClassSingleton instance = InnerClassSingleton.getInstance();
//          这里是通过正常方式创建实例

//        System.out.println(instance == innerClassSingleton);
        //结果为false

        //如何解决呢，可以在构造方法中加一个判断
        //防止反射实例攻击
//        if(InnerClassHolder.instance!=null){
//            throw new RuntimeException("单例不允许多例");
//        }
        //序列化反序列化创建实例
        InnerClassSingleton instance = InnerClassSingleton.getInstance();

        //序列化代码
//        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("Serializabletest"));
//        oos.writeObject(instance);
//        oos.close();
        //反序列化代码
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("Serializabletest"));
        InnerClassSingleton object = ((InnerClassSingleton) ois.readObject());

        System.out.println(instance == object);

    }
}
//为了可以序列化，这里需要实现了serializable接口
class InnerClassSingleton implements Serializable {

    //加上版本号，不然的话jvm自己给你加，一旦你修改代码，版本就不同，就破坏了单例模式，加上版本号之后，
    // 修改代码的时候版本号不会变，反序列化获取的实例便可以相同，便维护了单例模式

    static final long serialVersionUID = 42L;

    private static class InnerClassHolder{
        private static InnerClassSingleton instance=new InnerClassSingleton();
    }
    private InnerClassSingleton(){
        //防止反射实例攻击
        if(InnerClassHolder.instance!=null){
            throw new RuntimeException("单例不允许多例");
        }
    }
    public static InnerClassSingleton getInstance(){
        return InnerClassHolder.instance;
    }
    //必须家伙是那个这一行，不然的话它永远不会去拿到对应的实例
    Object readResolve() throws ObjectStreamException{
        return InnerClassHolder.instance;
    }
}
