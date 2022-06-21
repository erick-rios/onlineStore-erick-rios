package onlineShop.entities.impl;

import java.util.Arrays;

import onlineShop.entities.Cart;
import onlineShop.entities.Product;

public class DefaultCart implements Cart{
    private static final int DEFAULT_AMOUNT_OF_PRODUCTS = 10;
    
    private Product[] products;
    private int       lastIndexProducts;

    {
        products = new Product[DEFAULT_AMOUNT_OF_PRODUCTS];
    }

    @Override
    public boolean isEmpty() {
		if(products == null || products.length == 0) return true;
        for(Product product : products){
            if(product != null) return false;
        }
        return true;
	}

    @Override
    public void addProduct(Product product){
        if(product == null) return;
        if(products.length <= lastIndexProducts) Arrays.copyOf(products, products.length * 2);
        products[lastIndexProducts++] = product;
    }

    @Override
    public Product[] getProducts(){
        int amountOfNoNullProducts = 0;
        if(products == null) return null;
        for(Product product : products){
            if(product != null) amountOfNoNullProducts++;
        }
        Product[] productsNotNull = new Product[amountOfNoNullProducts];
        int index = 0;
        for(Product product : products){
            if(product != null) productsNotNull[index++] = product;
        }
        return productsNotNull;
    }

    @Override
    public void clear(){
        products = new Product[DEFAULT_AMOUNT_OF_PRODUCTS];
    }
}
