package com.guyu.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Des 饿汉模式
 * @Author guyu
 * @Date 2020/4/10 11:56
 * @Param
 * @Return
 */
public class HungrySingletonTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton instance1 = HungrySingleton.getInstance();
        System.out.println(instance == instance1);

        Constructor<HungrySingleton> declaredConstructor = HungrySingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        HungrySingleton hungrySingleton = declaredConstructor.newInstance();

        HungrySingleton instance2 = HungrySingleton.getInstance();

        System.out.println(instance2 == hungrySingleton);
    }
}
class HungrySingleton{
    private static HungrySingleton instance=new HungrySingleton();
    private HungrySingleton(){
        //防止反射实例攻击
        if (instance!=null){
            throw  new RuntimeException("单例不能多个实例");
        }
    }
    public static HungrySingleton getInstance(){
      return  instance;
    }

}
