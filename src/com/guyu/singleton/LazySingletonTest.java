package com.guyu.singleton;

import sun.plugin2.gluegen.runtime.CPU;

public class LazySingletonTest {
    public static void main(String[] args) {
        /*多线程出问题 测试结果为true
        LazySingleton instance = LazySingleton.getInstance();
        LazySingleton instance1 = LazySingleton.getInstance();
        System.out.println(instance == instance1);*/
        //多线测试
        new Thread(()->{
            System.out.println(LazySingleton.getInstance());
        }).start();
        new Thread(()->{
            System.out.println(LazySingleton.getInstance());
        }).start();
        //测试结果
//        com.guyu.singleton.LazySingleton@7db811c1
//        com.guyu.singleton.LazySingleton@5e5035fb
        //解决方式1：getInstance方法上加锁，缺点损耗性能

    }
}
class LazySingleton{
    private volatile static LazySingleton instance;
    private LazySingleton(){

    }
    public  static LazySingleton getInstance(){
        if(instance==null){
            //当instance为空时进行加锁初始化
            synchronized (LazySingleton.class){
                //一个线程初始化后，为了不让另一个同时和他进入的线程对它重新初始化
                //加一个判断
                if (instance==null) {
                    instance=new LazySingleton();
                    //字节码层面大概分了三步
                    //1.分配空间
                    //2.初始化
                    //3.引用赋值
//                    在编译的时候 JIT即时编译、CPU、编译器等都有可能对上面的指令进行重排进行优化
//                    就像上面的，第一步肯定是先执行的，2，3步可以进行交换
//                    这种重排对单线程没啥影响，多线程的话就会出现问题
//                    比如，当线程一进入的实例化的时候，指令发生重排，先进行了引用赋值，
//                    这时候，线程二刚好进来，然后发现instance不为空，直接就返回instance了
//                    这时候就造成了没有初始化的一些问题，比如空值异常之类的
//                    这时候怎么解决呢，就是用volatile修饰instance防止重排序
                    //private volatile static LazySingleton instance;
                }
            }

        }
        return instance;
    }
    /*public synchronized static LazySingleton getInstance(){
        if(instance==null){
            try {
                Thread.sleep(2000);//测试多线程时防止太快，加了个睡眠的时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance=new LazySingleton();
        }
        return instance;
    }*/

}