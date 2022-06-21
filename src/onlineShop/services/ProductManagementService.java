package onlineShop.services;

import onlineShop.entities.Product;

public interface ProductManagementService {
    Product[] getProducts();

	Product getProductById(int productIdToAddToCart);
}
