package onlineShop.entities.impl;

import onlineShop.entities.User;

public class DefaultUser implements User{
    private static int uniqueUserId = 0;

    private String firstName;
    private String  lastName;
    private String  password;
    private String     email;
    private int           id;

    {
        id = uniqueUserId++;
    }

    public DefaultUser() {
	}
	
	public DefaultUser(String firstName, String lastName, String password, String email) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.password  = password;
        this.email     = email;
	}

	@Override
	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public String getLastName() {
		return this.lastName;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getEmail() {
		return this.email;
	}
	
	@Override
	public String toString() {
		return "[First Name = "+ firstName + "\tLast Name = " + lastName + "\tEmail = " + email + "]";
	}

	@Override
	public void setPassword(String password) {
        if(password != null) this.password = password;
	}

	@Override
	public void setEmail(String email) {
        if(email != null) this.email = email;
	}

	@Override
	public int getId() {
		return this.id;
	}
	
	void clearState() {
        uniqueUserId = 0;
	}
}
