package onlineShop.services;

import onlineShop.entities.Order;

public interface OrderManagementService {
    void addOrder(Order order);

	Order[] getOrdersByUserId(int userId);
	
	Order[] getOrders();
}
