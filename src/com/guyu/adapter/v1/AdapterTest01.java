package com.guyu.adapter.v1;
/**
 * @Des 实现方式1：对象适配 Object Adapter
 * @Author guyu
 * @Date 2020/4/11 20:59
 * @Param 
 * @Return 
 */
public class AdapterTest01 {
    public static void main(String[] args) {
        Adaptee adaptee=new Adaptee();

        Adapter adapter = new Adapter(adaptee);
        adapter.output5v();

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
class Adapter implements Target{

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int output5v() {
        int i=adaptee.output220v();
        // ........做某些操作
        System.out.println(String.format("原始电压：%d v -> 输出电压 ： %d v",i,5));
        return 5;
    }
}
