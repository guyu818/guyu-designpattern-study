package com.guyu.builder;
/**
 * @Des 标准的建造者模式
 * @Author guyu
 * @Date 2020/4/11 16:02
 * @Param 
 * @Return
 */
public class BuilderTest1 {
    public static void main(String[] args) {
//      ProductBuilder builder=new DefaultConcreteProductBuilder();
        //只是另一种创建者的创建方式
        ProductBuilder builder=new SpecialConcreteProductBuilder();
        Director director = new Director(builder);
        Product product = director.makeProduct("productname1", "part1", "part2", "part3", "part4");
        System.out.println(product);

    }
}

interface ProductBuilder{
    void builderProductName(String productName);
    void builderPart1(String part1);
    void builderPart2(String part2);
    void builderPart3(String part3);
    void builderPart4(String part4);
    Product build();
}

//默认的建造者，如果有其他的产品，只需将它换成其他的就好
class DefaultConcreteProductBuilder implements ProductBuilder{

    private String productName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;

    @Override
    public void builderProductName(String productName) {
        this.productName=productName;
    }

    @Override
    public void builderPart1(String part1) {
        this.part1=part1;
    }

    @Override
    public void builderPart2(String part2) {
        this.part2=part2;
    }

    @Override
    public void builderPart3(String part3) {
        this.part3=part3;
    }

    @Override
    public void builderPart4(String part4) {
        this.part4=part4;
    }

    @Override
    public Product build() {

        return new Product(this.productName,this.part1,this.part2,this.part3,this.part4);
    }
}
//默认的建造者，如果有其他的产品，只需将它换成其他的就好
class SpecialConcreteProductBuilder implements ProductBuilder{

    private String productName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;

    @Override
    public void builderProductName(String productName) {
        this.productName=productName;
    }

    @Override
    public void builderPart1(String part1) {
        this.part1=part1;
    }

    @Override
    public void builderPart2(String part2) {
        this.part2=part2;
    }

    @Override
    public void builderPart3(String part3) {
        this.part3=part3;
    }

    @Override
    public void builderPart4(String part4) {
        this.part4=part4;
    }

    @Override
    public Product build() {

        return new Product(this.productName,this.part1,this.part2,this.part3,this.part4);
    }
}
class Director{
    private ProductBuilder builder;

    public Director(){

    }
    public Director(ProductBuilder builder){
        this.builder=builder;
    }

    //在这里面控制他们建造的顺序
    public Product makeProduct(String productName, String part1, String part2, String part3, String part4){
        builder.builderProductName(productName);
        builder.builderPart1(part1);
        builder.builderPart2(part2);
        builder.builderPart3(part3);
        builder.builderPart4(part4);
        Product product = builder.build();
        return product;
    }

}
class Product{
    private String productName;
    private String part1;
    private String part2;
    private String part3;
    private String part4;

    public Product(){}

    public Product(String productName, String part1, String part2, String part3, String part4) {
        this.productName = productName;
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.part4 = part4;
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
        return "Product{" +
                "productName='" + productName + '\'' +
                ", part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3='" + part3 + '\'' +
                ", part4='" + part4 + '\'' +
                '}';
    }
}
