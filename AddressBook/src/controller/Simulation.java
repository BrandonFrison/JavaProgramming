package controller;

import java.util.ArrayList;
import java.util.List;

import model.Contact;
import model.ContactMethod;
import service.UserServiceImpl;

/**
 * 1. Add constructor in Contact class, that will initizalize Contact with random username
 * 2. Implement empty methods in a Contact class
 * 3. Create arraylist with contacts and use UserServiceImpl to add two users (random and specified username)
 * 4. Implement method that will display all contacts and available contact methods
 * 5. Implement method that will add contacts methods to existing contacts and then try to contact them
 * @author michal
 *
 */
public class Simulation {

	private static List<Contact> contacts = new ArrayList<>();
	private static UserServiceImpl service = new UserServiceImpl();

	public static void main(String[] args) {
		contacts.add(service.createNewUserWithRandomUsername());
		contacts.add(service.createNewUserWithSpecifiedUsername("user"));
		addContactsForUser(0);
		addContactsForUser(1);
		showContacts();
		contactUserByEmail(1);
		contactUserByMail(0);
	}

	private static void contactUserByMail(int i) {
		System.out.println(contacts.get(i).getContactInfo(ContactMethod.Mail));

	}

	private static void contactUserByEmail(int i) {
		System.out.println(contacts.get(i).getContactInfo(ContactMethod.Email));
	}

	private static void addContactsForUser(int index) {
		contacts.get(index).addContactMethod(ContactMethod.Email, "email@email.com");
		contacts.get(index).addContactMethod(ContactMethod.Phone, "1234567899");
	}

	private static void showContacts() {
		for (Contact c : contacts) {
			System.out.println("Username: " + c.getUsername() + ", contact methods: " + c.getAvailableContactMethodsForPerson());
		}

	}

}
