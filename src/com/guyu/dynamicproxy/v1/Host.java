package com.guyu.dynamicproxy.v1;

//代理角色
public class Host implements Rent{
    @Override
    public void rent() {
        System.out.println("房主出租房子");
    }
}
