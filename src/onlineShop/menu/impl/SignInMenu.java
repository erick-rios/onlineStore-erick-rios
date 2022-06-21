package onlineShop.menu.impl;

import java.util.Scanner;

import onlineShop.configs.ApplicationContext;
import onlineShop.entities.User;
import onlineShop.menu.Menu;
import onlineShop.services.UserManagementService;
import onlineShop.services.impl.DefaultUserManagementService;

public class SignInMenu implements Menu {
    private ApplicationContext context;
	private UserManagementService userManagementService;

	{
		context = ApplicationContext.getInstance();
		userManagementService = DefaultUserManagementService.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your email:");
        String email = sc.next();
        System.out.println("Enter your password");
        String password = sc.next();

        User user = userManagementService.getUserByEmail(email);

        if(user != null && user.getPassword().equals(password)){
            System.out.printf("Glad to see you back %s %s", user.getFirstName(),
					user.getLastName() + System.lineSeparator());
			context.setLoggedInUser(user);
		} else {
			System.out.println("Unfortunately, such login and password doesn't exist");
		}
		context.getMainMenu().start();
        
	}

	@Override
	public void printMenuHeader() {
		System.out.println("************    SIGN IN MENU    ***********");	
	}
}