package com.guyu.dynamicproxy.v2;

import com.guyu.dynamicproxy.v1.Rent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * @Des 则合理可以写一个类似于万能的模板
 * @Author guyu
 * @Date 2020/4/12 13:21
 * @Param
 * @Return
 */
//待会我们这个类，自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    //被代理的接口
//    private Rent rent;
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    //    public void setRent(Rent rent) {
//        this.rent = rent;
//    }
    //生成得到的代理类
    public Object getProxy(){
        //这三个参数分别是本类的加载器，代理接口，和invocationHandler就是自己，因为实现了这个接口
//        return  Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
        return  Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    //这个方法必须要实现，这个方法事处理代理实例，并返回结果，一些附加操作什么的在这里面来加
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        seeHouse();
        //这里可以通过反射来获取方法的名字
        System.out.println(method.getName());
//        Object result = method.invoke(rent, args);
        Object result = method.invoke(target, args);

        fare();
        return result;
    }
    //附加操作
    public void seeHouse(){
        System.out.println("中介带你看房子");
    }
    public void fare(){
        System.out.println("中介收中介费");
    }

}
