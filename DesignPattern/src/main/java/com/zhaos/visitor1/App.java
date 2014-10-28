package com.zhaos.visitor1;

/**
 * Hello world!
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
