package com.guyu.adapter.v2;

/**
 * @Des 类的适配器模式
 * @Author guyu
 * @Date 2020/4/11 21:01
 * @Param
 * @Return
 */
public class AdapterTest02 {
    public static void main(String[] args) {
        //这里可以看出问题来了，使用类继承的方式实现类的适配器，这会导致接口污染，既可以带调用5v的方法
        //也可以调用220的接口，
        Adapter adapter=new Adapter();
        adapter.output5v();
        System.out.println(adapter.output220v());
    }
}
class Adaptee{
    public int output220v(){
        return 220;
    }
}
interface Target{
    int output5v();
}
class Adapter extends Adaptee implements Target{

    @Override
    public int output5v() {
        int i=output220v();
        // ........做某些操作
        System.out.println(String.format("原始电压：%d v -> 输出电压 ： %d v",i,5));
        return 5;
    }
}
