package onlineShop.menu.impl;

import java.util.Scanner;

import onlineShop.configs.ApplicationContext;
import onlineShop.entities.impl.DefaultUser;
import onlineShop.menu.Menu;
import onlineShop.services.UserManagementService;
import onlineShop.services.impl.DefaultUserManagementService;

public class SignUpMenu implements Menu {
    private UserManagementService userManagementService;
	private ApplicationContext context;

	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();

		Scanner sc = new Scanner(System.in);
			
		System.out.println("First name:");
		String firstName = sc.next();
		System.out.println("Last name: ");
		String lastName = sc.next();
		System.out.println("Email name:");
		String email = sc.next();

		sc = new Scanner(System.in);

		System.out.println("Password: ");
		String password = sc.next();

		DefaultUser newUser = new DefaultUser(firstName,lastName,password,email);
		String errorOfNewUser = userManagementService.registerUser(newUser);

		if(errorOfNewUser == null || errorOfNewUser.isEmpty()){
			context.setLoggedInUser(newUser);
			System.out.println("New user created");
		}else{
			System.out.println(errorOfNewUser);
		}
		
		new MainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***********    SIGN UP MENU    ************");
	}
}
