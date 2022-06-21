package onlineShop.entities.impl;

import java.util.Arrays;

import onlineShop.entities.Order;
import onlineShop.entities.Product;

public class DefaultOrder implements Order{
    private static final double CREDIT_CARD_NUMBER_LENGTH = 16;
    
    private String creditCardNumber;
    private Product[] products;
    private int customerId;
    

    @Override
    public boolean isCreditCardNumberValid(String userInput) {
        return userInput.toCharArray().length == CREDIT_CARD_NUMBER_LENGTH  && Long.parseLong(userInput) > 0 &&  !userInput.contains(" ");
    }

    @Override
    public void setCreditCardNumber(String userInput) {
        if(userInput != null) this.creditCardNumber = userInput;
    }

    @Override
    public void setProducts(Product[] products) {
        this.products = products;
    }

    @Override
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
        
    }

    @Override
    public int getCustomerId() {
        return this.customerId;
    }
    
    @Override
    public String toString(){
        return "[Credit Card Number : " + creditCardNumber + ", \tProducts: " + Arrays.toString(products) + ", \tCustomer ID: " + customerId +"]";
    }
}
