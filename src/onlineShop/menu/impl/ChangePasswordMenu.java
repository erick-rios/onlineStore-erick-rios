package onlineShop.menu.impl;

import java.util.Scanner;

import onlineShop.configs.ApplicationContext;
import onlineShop.menu.Menu;

public class ChangePasswordMenu implements Menu {
    private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);
        String newPassword = sc.next();
        context.getLoggedInUser().setPassword(newPassword);
        System.out.println("Your password has been successfully changed");
        new MainMenu().start();

	}

	@Override
	public void printMenuHeader() {
		System.out.println("**********  CHANGE PASSWORD **********");
        System.out.print("Enter your new password:\n");	
	}
}
