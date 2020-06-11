package com.guyu.staticproxy;

//代理角色，代理真实对象，一般会做一些附属操作-----》中介
public class Proxy {
    //******能组合就不要继承*****
    private Host host;

    public  Proxy(){

    }
    public Proxy(Host host) {
        this.host = host;
    }
    public void rent(){

        seeHouse();
        //代理对象做的事
        host.rent();
        finsh();
        fare();
    }
    //附加功能
    private void seeHouse(){
        System.out.println("中介带你看房子");
    }
    private void fare(){
        System.out.println("中介收中介费");
    }
    private void finsh(){
        System.out.println("中介何你签合同");
    }



}
