package service;

import model.Contact;

public interface IUserService {
	
	Contact createNewUserWithRandomUsername();
	
	Contact createNewUserWithSpecifiedUsername(String username);

}
