package onlineShop.menu.impl;

import java.util.Scanner;

import onlineShop.configs.ApplicationContext;
import onlineShop.entities.Order;
import onlineShop.entities.impl.DefaultOrder;
import onlineShop.menu.Menu;
import onlineShop.services.OrderManagementService;
import onlineShop.services.impl.DefaultOrderManagementService;

public class CheckoutMenu implements Menu {
    private ApplicationContext                    context;
	private OrderManagementService orderManagementService;
    private double                             totalToPay;

	
	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}

    private boolean createOrder(String creditCardNumber){
        Order order = new DefaultOrder();
        if(order.isCreditCardNumberValid(creditCardNumber)){
            order.setCreditCardNumber(creditCardNumber);
            order.setCustomerId(context.getLoggedInUser().getId());
            order.setProducts(context.getSessionCart().getProducts());
            return true;
        }
        return false;
    }
	
	@Override
	public void start() {
        while(true){
            printMenuHeader();
            Scanner sc = new Scanner(System.in);
            String creditCardNumber = sc.next();
            if(createOrder(creditCardNumber)){
                context.getSessionCart().clear();
                break;
            }
            continue;
        }
        System.out.print("Thanks for your purchase, we will send the information to you email");
        new MainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("************   CHECKOUT MENU     ***********");
        System.out.println("Enter your credit card number and press enter if you confirm your purchase: ");

	}
}