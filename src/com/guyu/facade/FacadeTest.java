package com.guyu.facade;
/**
 * @Des 门面模式
 * @Author guyu
 * @Date 2020/4/11 19:27
 * @Param
 * @Return
 */
public class FacadeTest {
    public static void main(String[] args) {
        Client1 client1=new Client1();
        client1.doSomething1();
    }
}
class Client1{
    Facade facade=new Facade();
    public void doSomething1(){
        facade.doSomethingFacade();
    }
}

class Facade{
    SubSystem1 subSystem1=new SubSystem1();
    SubSystem2 subSystem2=new SubSystem2();
    SubSystem3 subSystem3=new SubSystem3();

    public void doSomethingFacade(){
        subSystem1.method1();
        subSystem2.method2();
        subSystem3.method3();
    }
}
//子系统类
class SubSystem1{
    public void method1(){
        System.out.println("SubSystem1.method1 executed");
    }
}
class SubSystem2{
    public void method2(){
        System.out.println("SubSystem1.method2 executed");
    }
}
class SubSystem3{
    public void method3(){
        System.out.println("SubSystem1.method3 executed");
    }
}
