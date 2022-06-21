package onlineShop.services.impl;

import java.util.Arrays;

import onlineShop.entities.Order;
import onlineShop.services.OrderManagementService;


public class DefaultOrderManagementService implements OrderManagementService{
    private static final int DEFAULT_ORDER_CAPACITY = 10;

	private static DefaultOrderManagementService instance;
	private Order[]                                orders;
	private int                            lastOrderIndex;

	{
		orders = new Order[DEFAULT_ORDER_CAPACITY];
	}

	
	
	public static OrderManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultOrderManagementService();
		}
		return instance;
	}

	@Override
	public void addOrder(Order order) {
		if (order == null)return;
		if(lastOrderIndex <= orders.length){
			orders =  Arrays.copyOf(orders, orders.length * 2);
		}
		orders[lastOrderIndex++] = order;
	}

	@Override
	public Order[] getOrdersByUserId(int userId) {
		
		int amountOfOrdersByUserId = 0;
		
		for(Order order : orders){
			if(order != null && order.getCustomerId() == userId)amountOfOrdersByUserId++;
		}
		Order[] notNullOrdersByUser = new Order[amountOfOrdersByUserId];
		int index = 0;
		for(Order order : orders){

			if(order != null && order.getCustomerId()==userId) notNullOrdersByUser[index++] = order;
		}
		return notNullOrdersByUser;
	}

	@Override
	public Order[] getOrders() {

		int notNullOrders = 0;
		for(Order order : orders){
			if(order != null) notNullOrders++;
		}
		Order[] ordersFiltered = new Order[notNullOrders];
		int index = 0;
		for(Order order : orders){
			if(order != null) ordersFiltered[index++] = order;
		}
		return ordersFiltered;
	}
	
	void clearServiceState() {
		lastOrderIndex = 0;
		orders = new Order[DEFAULT_ORDER_CAPACITY];
	}
}