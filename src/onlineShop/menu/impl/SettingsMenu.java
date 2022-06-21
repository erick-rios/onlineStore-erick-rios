package onlineShop.menu.impl;

import java.util.Scanner;

import onlineShop.configs.ApplicationContext;
import onlineShop.menu.Menu;

public class SettingsMenu implements Menu {
    private static final String SETTINGS = "1. Change Password" + System.lineSeparator()
			+ "2. Change Email";

	private ApplicationContext context;

	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		Menu menuToNavigate = null;
        mainLoop : while(true){
            printMenuHeader();
            if(context.getLoggedInUser() == null){
                System.out.println("Sorry, you need to create an account to make any settings change");
                new MainMenu().start();
                return;
            }else{
                System.out.println(SETTINGS);
                System.out.println("Please enter an option or type 'menu' o navigate back to the main menu");
                Scanner sc = new Scanner(System.in);
                String userElection = sc.next();
                if(userElection.equalsIgnoreCase(MainMenu.MENU_COMMAND)){
                    menuToNavigate = new MainMenu();
                    break mainLoop;
                }else{
                    int userOption = Integer.parseInt(userElection);
                    switch(userOption){
                        case 1: 
                            menuToNavigate = new ChangePasswordMenu();
                            break mainLoop;
                        case 2:
                            menuToNavigate = new ChangeEmailMenu();
                            break mainLoop;
                        default:
                            System.out.println("Please, select 1 or 2 for a valid option");
                            continue;    
                    }
                }
            }
        }
        menuToNavigate.start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("**********  SETTINGS **********");
	}
    
}