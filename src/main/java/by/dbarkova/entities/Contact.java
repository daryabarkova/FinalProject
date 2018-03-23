package by.dbarkova.entities;

public class Contact extends Person {
	
	private String loginEmail;
	private String systemRole;
	private String faxNumber;
	private String secureEmail;
	
	public Contact() {}
	
	public Contact(String firstName, String lastName, String relatedOrganization) {
		super(firstName, lastName, relatedOrganization);
	}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getSystemRole() {
		return systemRole;
	}

	public void setSystemRole(String systemRole) {
		this.systemRole = systemRole;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getSecureEmail() {
		return secureEmail;
	}

	public void setSecureEmail(String secureEmail) {
		this.secureEmail = secureEmail;
	}

	@Override
	public String toString() {
		return "Contact [loginEmail=" + loginEmail + ", systemRole=" + systemRole + ", faxNumber=" + faxNumber
				+ ", secureEmail=" + secureEmail + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((faxNumber == null) ? 0 : faxNumber.hashCode());
		result = prime * result + ((loginEmail == null) ? 0 : loginEmail.hashCode());
		result = prime * result + ((secureEmail == null) ? 0 : secureEmail.hashCode());
		result = prime * result + ((systemRole == null) ? 0 : systemRole.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (faxNumber == null) {
			if (other.faxNumber != null)
				return false;
		} else if (!faxNumber.equals(other.faxNumber))
			return false;
		if (loginEmail == null) {
			if (other.loginEmail != null)
				return false;
		} else if (!loginEmail.equals(other.loginEmail))
			return false;
		if (secureEmail == null) {
			if (other.secureEmail != null)
				return false;
		} else if (!secureEmail.equals(other.secureEmail))
			return false;
		if (systemRole == null) {
			if (other.systemRole != null)
				return false;
		} else if (!systemRole.equals(other.systemRole))
			return false;
		return true;
	}
	
}

	