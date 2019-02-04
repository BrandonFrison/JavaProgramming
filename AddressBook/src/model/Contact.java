package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Contact {

	private String username;
	private Map<ContactMethod, String> contacts;

	public Contact(String username) {
		this.username = username;
		this.contacts = new HashMap<ContactMethod, String>();
	}

	public Contact() {
		this.username = Username.getRandomUsername() + (int) (Math.random() * 10);
		this.contacts = new HashMap<ContactMethod, String>();
	}

	/**
	 * Method for adding new contact for a user
	 * 
	 * @param method
	 * @param value
	 */
	public void addContactMethod(ContactMethod method, String value) {
		this.contacts.put(method, value);
	}

	/**
	 * Return available contact methods for specific person
	 * 
	 * @return
	 */
	public Set<ContactMethod> getAvailableContactMethodsForPerson() {
		return this.contacts.keySet();
	}

	/**
	 * If contact has ContactMethod, return it. If not, return message that you cannot contact person (indicate username) using proposed method
	 * @param method
	 * @return
	 */
	public String getContactInfo(ContactMethod method) {
		return contacts.containsKey(method) ? contacts.get(method) : "We cannot contact " + this.username + " by " + method;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
