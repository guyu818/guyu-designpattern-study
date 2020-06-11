package com.guyu.abstractfactory;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        IDataBaseUtil iDataBaseUtil=new Oracle();
        Icommend icommend = iDataBaseUtil.getIcommend();
        Iconnection iconnection = iDataBaseUtil.getIconnection();
        icommend.commend();
        iconnection.connection();
    }
}
//接口
interface Iconnection{
    public void connection();
}
interface Icommend{
    public void commend();
}
interface IDataBaseUtil{
    Iconnection getIconnection();
    Icommend getIcommend();
}

//Oracle的实现
class OracleConnection implements Iconnection{

    @Override
    public void connection() {
        System.out.println("Oracle connection");
    }
}
class OracleCommend implements Icommend{
    @Override
    public void commend() {
        System.out.println("Oracle commend");
    }
}

class Oracle implements IDataBaseUtil{

    @Override
    public Iconnection getIconnection() {
        return new OracleConnection();
    }
    @Override
    public Icommend getIcommend() {
        return new OracleCommend();
    }
}
//mysql的实现
class MysqlConnection implements Iconnection{

    @Override
    public void connection() {
        System.out.println("mysql connection");
    }
}
class MysqlCommend implements Icommend{
    @Override
    public void commend() {
        System.out.println("mysql commend");
    }
}

class Mysql implements IDataBaseUtil{

    @Override
    public Iconnection getIconnection() {
        return new MysqlConnection();
    }
    @Override
    public Icommend getIcommend() {
        return new MysqlCommend();
    }
}


