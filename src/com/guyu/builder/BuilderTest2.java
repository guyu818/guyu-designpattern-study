package com.guyu.builder;
/**
 * @Des 建造者模式跟不可变对象使用
 * @Author guyu
 * @Date 2020/4/11 16:02
 * @Param 
 * @Return 
 */
public class BuilderTest2 {
    public static void main(String[] args) {
        Product1.Builder builder = new Product1.Builder().productName("谷雨").part1("谷雨1").part2("谷雨2");

        //可以做一些判断再builder，比较灵活
        Product1.Builder builder1 = builder.part3("谷雨3");

        Product1 product1 = builder1.build();
        System.out.println(product1);
    }
}
class Product1{
    private final String productName;
    private final String part1;
    private final String part2;
    private final String part3;
    private final String part4;

    //这个函数不能加，我们不希望他修改，希望他赋值一次就不变
    //public Product1(){}

    public Product1(String productName, String part1, String part2, String part3, String part4) {
        this.productName = productName;
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
    }

    //静态内部类实现建造者模式
    static class Builder{
        private String productName;
        private String part1;
        private String part2;
        private String part3;
        private String part4;

        public Builder productName(String productName){
            this.productName=productName;
            return this;
        }
        public Builder part1(String part1){
            this.part1=part1;
            return this;
        }
        public Builder part2(String part2){
            this.part2=part2;
            return this;
        }
        public Builder part3(String part3){
            this.part3=part3;
            return this;
        }
        public Builder part4(String part4){
            this.part4=part4;
            return this;
        }

        //给产品赋值并且返回
        Product1 build(){
            Product1 product1 = new Product1(this.productName, this.part1, this.part2, this.part3, this.part4);
            return product1;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3='" + part3 + '\'' +
                ", part4='" + part4 + '\'' +
                '}';
    }
}
