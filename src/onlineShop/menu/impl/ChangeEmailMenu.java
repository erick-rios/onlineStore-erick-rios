package onlineShop.menu.impl;

import java.util.Scanner;

import onlineShop.configs.ApplicationContext;
import onlineShop.menu.Menu;

public class ChangeEmailMenu implements Menu {
    private ApplicationContext context;

	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		
        printMenuHeader();
        Scanner sc = new Scanner(System.in);
        String userInput = sc.next();
        context.getLoggedInUser().setEmail(userInput);
        System.out.println("Your email has been succesfully changed");
        new MainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("**********  CHANGE EMAIL **********");
        System.out.print("Enter your new email:\n");
	}
    
}
