package com.guyu.decorator;
/**
 * @Des 装饰器模式
 * @Author guyu
 * @Date 2020/4/11 21:36
 * @Param 
 * @Return 
 */
public class DecoratorTest01 {
    public static void main(String[] args) {
        Component component=new ConcreteDecorator2(new ConcreteDecorator1(new ConcreteComponent()));
        component.operation();

    }
}
interface Component{
    void operation();
}
class ConcreteComponent implements Component{

    @Override
    public void operation() {
        System.out.println("拍照");
    }
}
abstract class Decorator implements Component{
    Component component;

    public Decorator(Component component) {
        this.component = component;
    }
}
class ConcreteDecorator1 extends Decorator{

    public ConcreteDecorator1(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("添加美颜");
        component.operation();
    }
}
class ConcreteDecorator2 extends Decorator {

    public ConcreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("添加滤镜");
        component.operation();
    }
}
