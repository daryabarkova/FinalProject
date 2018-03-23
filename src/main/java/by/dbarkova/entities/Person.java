package by.dbarkova.entities;

public abstract class Person {
	
	private String firstName;
	private String lastName;
	private int ssn;
	private String email;
	private String phoneNumber;
	private String addressCity;
	private String addressStreet;
	private int addressZipcode;
	private String addressState;
	private String relatedCommunity;
	private String relatedOrganization;
	
	public Person() {}
	
	public Person(String firstName, String lastName, String relatedOrganization) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.relatedOrganization = relatedOrganization;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getRelatedCommunity() {
		return relatedCommunity;
	}

	public void setRelatedCommunity(String relatedCommunity) {
		this.relatedCommunity = relatedCommunity;
	}

	public String getRelatedOrganization() {
		return relatedOrganization;
	}

	public void setRelatedOrganization(String relatedOrganization) {
		this.relatedOrganization = relatedOrganization;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSSN() {
		return ssn;
	}

	public void setSSN(int ssn) {
		this.ssn = ssn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public int getAddressZipcode() {
		return addressZipcode;
	}

	public void setAddressZipcode(int addressZipcode) {
		this.addressZipcode = addressZipcode;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", ssn=" + ssn + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", addressCity=" + addressCity + ", addressStreet=" + addressStreet
				+ ", addressZipcode=" + addressZipcode + ", addressState=" + addressState + ", relatedCommunity="
				+ relatedCommunity + ", relatedOrganization=" + relatedOrganization + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressCity == null) ? 0 : addressCity.hashCode());
		result = prime * result + ((addressState == null) ? 0 : addressState.hashCode());
		result = prime * result + ((addressStreet == null) ? 0 : addressStreet.hashCode());
		result = prime * result + addressZipcode;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((relatedCommunity == null) ? 0 : relatedCommunity.hashCode());
		result = prime * result + ((relatedOrganization == null) ? 0 : relatedOrganization.hashCode());
		result = prime * result + ssn;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (addressCity == null) {
			if (other.addressCity != null)
				return false;
		} else if (!addressCity.equals(other.addressCity))
			return false;
		if (addressState == null) {
			if (other.addressState != null)
				return false;
		} else if (!addressState.equals(other.addressState))
			return false;
		if (addressStreet == null) {
			if (other.addressStreet != null)
				return false;
		} else if (!addressStreet.equals(other.addressStreet))
			return false;
		if (addressZipcode != other.addressZipcode)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (relatedCommunity == null) {
			if (other.relatedCommunity != null)
				return false;
		} else if (!relatedCommunity.equals(other.relatedCommunity))
			return false;
		if (relatedOrganization == null) {
			if (other.relatedOrganization != null)
				return false;
		} else if (!relatedOrganization.equals(other.relatedOrganization))
			return false;
		if (ssn != other.ssn)
			return false;
		return true;
	}
		
}
