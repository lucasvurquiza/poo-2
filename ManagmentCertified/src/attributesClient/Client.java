package attributesClient;

public class Client {
	private String nameContact;
	private String emailContact;
	private String phoneContact;
	
	public Client(String nameContact, String emailContact, String phoneContact) {
		super();
		this.nameContact = nameContact;
		this.emailContact = emailContact;
		this.phoneContact = phoneContact;
	}

	public String getNameContact() {
		return nameContact;
	}

	public String getEmailContact() {
		return emailContact;
	}

	public String getPhoneContact() {
		return phoneContact;
	}

	public void setNameContact(String nameContact) {
		this.nameContact = nameContact;
	}

	public void setEmailContact(String emailContact) {
		this.emailContact = emailContact;
	}

	public void setPhoneContact(String phoneContact) {
		this.phoneContact = phoneContact;
	}

	@Override
	public String toString() {
		return "Client [getNameContact()=" + getNameContact() + ", getEmailContact()=" + getEmailContact()
				+ ", getPhoneContact()=" + getPhoneContact() + "]";
	}
}
