package com.guyu.prototype;

import java.io.*;

/**
 * @Des 原型模式
 * @Author guyu
 * @Date 2020/4/11 16:46
 * @Param
 * @Return
 */
public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        //获得一个产品
        //需求比如实验室需要用相同的对象或者差别不大的对象100个
//        Product product = new Product("谷雨", "part1", "part2", "part3", "part4");
        //正常的方式
        //new Product ……
        //利用原型模式来实现，首先要实现Cloneable接口，并重写里面的clone方法，将需要返回的克隆对象修改一下
//        Product clone=  product.clone();

//        System.out.println("original"+product);
//        System.out.println("clone"+clone);
        //问题出现了，当里面含有引用类型属性的时候，如果直接克隆将导致克隆对象也指向原对象引用的对象，
        // 一旦原对象修改引用对象的数据，那么克隆对象也受影响
        //因此如何解决呢？
        //解决办法使用深拷贝
        //极其复杂的情况下可以使用序列化和反序列化来实现对象的拷贝，这里思想感觉借助了原型模式
        //下面便是测试，添加一个baseinfo类
        BaseInfo baseInfo = new BaseInfo("谷雨");
        Product product = new Product("谷雨", "part1", "part2", "part3", "part4",baseInfo);

        Product clone = product.clone();

        System.out.println("original"+product);
        System.out.println("clone"+clone);

        product.getBaseInfo().setName("哈哈哈哈");
        System.out.println("original"+product);
        System.out.println("clone"+clone);
        //当然你也可以自定义克隆接口
        //测试结果
        /*
        original621009875 ]Product{productName='谷雨', part1='part1', part2='part2', part3='part3', part4='part4', baseInfo=1265094477] BaseInfo{name='谷雨'}}
        clone1072408673 ]Product{productName='谷雨', part1='part1', part2='part2', part3='part3', part4='part4', baseInfo=1531448569] BaseInfo{name='谷雨'}}
        original621009875 ]Product{productName='谷雨', part1='part1', part2='part2', part3='part3', part4='part4', baseInfo=1265094477] BaseInfo{name='哈哈哈哈'}}
        clone1072408673 ]Product{productName='谷雨', part1='part1', part2='part2', part3='part3', part4='part4', baseInfo=1531448569] BaseInfo{name='谷雨'}}

         */

    }
}
//它想要被拷贝的话，也需要实现Cloneable接口
//使用序列化和反序列化实现深拷贝都需要实现Serializable接口
class BaseInfo implements Cloneable,Serializable{
    private String name;
    //这个凡是实现序列化接口时都加上吧
    static final long serialVersionUID = 42L;

    public BaseInfo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected BaseInfo clone() throws CloneNotSupportedException {
        return ((BaseInfo) super.clone());
    }

    @Override
    public String toString() {
        return super.hashCode()+"] BaseInfo{" +
                "name='" + name + '\'' +
                '}';
    }
}
//使用序列化和反序列化实现深拷贝都需要实现Serializable接口
class Product implements Cloneable ,Serializable{
    private String productName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;
    private BaseInfo baseInfo;

    //这个凡是实现序列化接口时都加上吧
    static final long serialVersionUID = 42L;

    public Product() {
    }

    public Product(String productName, String part1, String part2, String part3, String part4,BaseInfo baseInfo) {
        this.productName = productName;
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
        this.baseInfo=baseInfo;
    }

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public String getPart3() {
        return part3;
    }

    public void setPart3(String part3) {
        this.part3 = part3;
    }

    public String getPart4() {
        return part4;
    }

    public void setPart4(String part4) {
        this.part4 = part4;
    }

    @Override
    public String toString() {
        return super.hashCode()+" ]Product{" +
                "productName='" + productName + '\'' +
                ", part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3='" + part3 + '\'' +
                ", part4='" + part4 + '\'' +
                ", baseInfo=" + baseInfo +
                '}';
    }

    //重写Cloneable接口的这个方法
    @Override
    protected Product clone() throws CloneNotSupportedException {
//        Product product = ((Product) super.clone());
//        BaseInfo clone = baseInfo.clone();
//        product.setBaseInfo(clone);
        //下面演示一波，如和使用系列化和反序列化来实现深拷贝
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos=new ObjectOutputStream(byteArrayOutputStream);
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

        try {
            ObjectInputStream ois=new ObjectInputStream(byteArrayInputStream);
            try {
                Product product = ((Product) ois.readObject());
                return product;//成功在这里直接返回
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}