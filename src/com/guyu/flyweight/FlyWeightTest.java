package com.guyu.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * @Des 享元模式
 * @Author guyu
 * @Date 2020/4/11 19:29
 * @Param 
 * @Return 
 */
public class FlyWeightTest {
    public static void main(String[] args) {
        TreeNode treeNode1=new TreeNode(3,4,TreeFactory.getTree("xxx","xxxxxxxx"));
        TreeNode treeNode2=new TreeNode(4,5,TreeFactory.getTree("xxx","xxxxxxxx"));
        TreeNode treeNode3=new TreeNode(9,8,TreeFactory.getTree("yy","xxxxxxxx"));
        TreeNode treeNode4=new TreeNode(23,25,TreeFactory.getTree("yy","xxxxxxxx"));


    }
}
//获取树的工厂
class TreeFactory{
    //为了保证线程安全，因为享元模式就是共享，所以存在线程安全问题
    private static Map<String,Tree> map=new ConcurrentHashMap<>();

    public static Tree getTree(String name,String data){
        if(map.containsKey(name)){
            return map.get(name);
        }
        Tree tree = new Tree(name, data);
        map.put(name,tree);
        return tree;
    }
}

//树的坐标
class TreeNode{
    private int x;
    private int y;
    private Tree tree;

    public TreeNode(int x, int y, Tree tree) {
        this.x = x;
        this.y = y;
        this.tree = tree;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }
}
//为了节省空间和内存，树的信息
class Tree{
    private String name;
    private String data;

    public Tree(String name, String data) {
        System.out.println("naame"+name+"data"+data);
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }
}