package com.zhaos.visitor1;

/**
 * 顾客在超市将选择的商品，如苹果、图书等放在购物车上，然后到收银员处付款，在购物过程中
 * 顾客需要对这些商品进行访问，以便确认这些商品的质量，之后收银员计算价格时也需要购物车
 * 内顾客选择的商品。
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BuyBasket buyBasket = new BuyBasket();
        Product product1 = new Book();
        Product product2 = new Apple();
        
        buyBasket.getProductList().add(product1);
        buyBasket.getProductList().add(product2);

        Visitor visitor = new Customer();
        visitor.setName("John");
        
        buyBasket.notify(visitor);
    }
}
