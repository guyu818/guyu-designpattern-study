package com.guyu.bridge;

public class Test {
    public static void main(String[] args) {
        Computer computer=new DeskTop(new lenvo());
        computer.print();
        Computer computer1=new Watch(new mac());
        computer1.print();
    }
}
