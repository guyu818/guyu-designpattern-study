package com.guyu.bridge;

public abstract class Computer {

    //选择组合注入，而不是继承，解耦合
    protected Brand brand;
    public Computer(Brand brand) {
        this.brand = brand;
    }

    void print() {
        brand.show();
    }
}
//这里为了省劲就不单独new其他类文件了
class DeskTop extends Computer{

    public DeskTop(Brand brand) {
        super(brand);
    }

    @Override
    void print() {
        super.print();
        System.out.println("台式");
    }
}
class Watch extends Computer{

    public Watch(Brand brand) {
        super(brand);
    }

    @Override
    void print() {
        super.print();
        System.out.println("手表");
    }
}
