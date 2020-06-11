package com.guyu.templatemethod;
/**
 * @Des 模板方法模式
 * @Author guyu
 * @Date 2020/4/11 22:14
 * @Param
 * @Return
 */

public class TemplateMethodTest {
    public static void main(String[] args) {
        AbstractClass abstractClass=new SubClass1();
        abstractClass.operation();

    }
}
abstract class AbstractClass{
    public void operation(){
        //一些比较通用的步骤
        System.out.println("pre.....");
        System.out.println("step1");
        System.out.println("step2");

        templateMethod();
        //......其他通用操作
    }
    abstract protected void templateMethod();
}
class SubClass extends AbstractClass{

    @Override
    protected void templateMethod() {
        System.out.println("Subclass executed");
    }
}
class SubClass1 extends AbstractClass{

    @Override
    protected void templateMethod() {
        System.out.println("Subclass1 executed");
    }
}

