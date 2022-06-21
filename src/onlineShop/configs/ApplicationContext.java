package onlineShop.configs;

import onlineShop.entities.Cart;
import onlineShop.entities.User;
import onlineShop.entities.impl.DefaultCart;
import onlineShop.menu.Menu;

public class ApplicationContext {
    private static ApplicationContext instance;
	
	private User loggedInUser;
	private Menu mainMenu;
	private Cart sessionCart;
	
	private ApplicationContext() {
	}
	
	public void setLoggedInUser(User loggedInUser) {
		if (this.sessionCart != null) {
			this.sessionCart.clear(); // we have to clear session cart when new user is logged in
		}
		this.loggedInUser = loggedInUser;
	}
	
	public User getLoggedInUser() {
		return this.loggedInUser;
	}
	
	public void setMainMenu(Menu mainMenu) {
		this.mainMenu = mainMenu;
	}
	
	public Menu getMainMenu() {
		return this.mainMenu;
	}
    
	public static ApplicationContext getInstance() {
		if (instance == null) {
			instance = new ApplicationContext();
		}
		return instance;
	}

	public Cart getSessionCart() {
		if (this.sessionCart == null) {
			this.sessionCart = new DefaultCart();
		}
		return this.sessionCart;
	}
}