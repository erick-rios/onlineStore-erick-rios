package onlineShop.menu.impl;

import onlineShop.configs.ApplicationContext;
import onlineShop.menu.Menu;

public class SignOutMenu implements Menu{

    private ApplicationContext context;
	{
		context = ApplicationContext.getInstance();
	}
	
	@Override
	public void start() {
		printMenuHeader();
        context.setLoggedInUser(null);
        new MainMenu().start();

	}

	@Override
	public void printMenuHeader() {
		System.out.println("***********     SIGN OUT    ***********");	
        System.out.println("Have a nice day! Look forward to welcoming back!");	
	}

    
}