package onlineShop.menu.impl;

import onlineShop.configs.ApplicationContext;
import onlineShop.entities.Order;
import onlineShop.menu.Menu;
import onlineShop.services.OrderManagementService;
import onlineShop.services.impl.DefaultOrderManagementService;

public class MyOrdersMenu implements Menu {
    private ApplicationContext context;
	private OrderManagementService orderManagementService;

	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}

	@Override
	public void start() {
        if(context.getLoggedInUser() == null){
            System.out.println("Please, sign in or sign up to get your orders");
            new MainMenu().start();
            return;
        }else{
            int userId = context.getLoggedInUser().getId();
		    Order[] orders = orderManagementService.getOrdersByUserId(userId);
            if(orders == null){
                System.out.println("We are sorry, you do not have any orders. Navigate back to Main Menu to place new order");
            }else{
                for(Order order : orders){
                    System.out.println(order.toString());
                }
            }
            
	    }
        new MainMenu().start();
    }

	@Override
	public void printMenuHeader() {
		System.out.println("***********    MY ORDERS    ***********");	
	}
}
