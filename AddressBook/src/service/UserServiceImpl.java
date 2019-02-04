package service;

import model.Contact;

public class UserServiceImpl implements IUserService {

	@Override
	public Contact createNewUserWithRandomUsername() {
		return new Contact();
	}

	@Override
	public Contact createNewUserWithSpecifiedUsername(String username) {
		return new Contact(username);
	}

}
