package com.guyu.staticproxy;

//客户访问代理对象的人
public class Client {
    public static void main(String[] args) {
        //真实角色
        Host host=new Host();
        //代理对象
        Proxy proxy=new Proxy(host);
        proxy.rent();
    }
}
