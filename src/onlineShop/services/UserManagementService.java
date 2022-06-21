package onlineShop.services;

import onlineShop.entities.User;

public interface UserManagementService {
    String registerUser(User user);
	
	User[] getUsers();

	User getUserByEmail(String userEmail);
}
