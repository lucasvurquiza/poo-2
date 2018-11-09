package builder;

import attributesClient.Client;

public class ClientBuilder {
	private String nameContact;
	private String emailContact;
	private String phoneContact;
	
	public ClientBuilder hasNameContact(String nameContact) {
		this.nameContact = nameContact;
		return this;
	}
	
	public ClientBuilder hasEmailContact(String emailContact) {
		this.emailContact = emailContact;
		return this;
	}
	
	public ClientBuilder hasPhoneContact(String phoneContact) {
		this.phoneContact = phoneContact;
		return this;
	}
	
	public Client build() {
		return new Client(nameContact, emailContact, phoneContact);
	}
}