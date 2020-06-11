package com.guyu.staticproxy;
//房子的主人 真实角色 被代理的角色
public class Host implements Rent{
    @Override
    public void rent() {
        System.out.println("房东要出租房子");
    }
}
