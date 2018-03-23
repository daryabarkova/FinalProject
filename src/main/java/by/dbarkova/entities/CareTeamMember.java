package by.dbarkova.entities;

public class CareTeamMember extends Contact {
	
	private String careTeamRole;
	private String description;
	
	public CareTeamMember () {}
	
	public CareTeamMember (String firstName, String lastName, String careTeamRole, String description, String organization) {
		super(firstName, lastName, organization);
		this.careTeamRole =  careTeamRole;
		this.description = description;	
	}

	public String getCareTeamRole() {
		return careTeamRole;
	}

	public void setCareTeamRole(String careTeamRole) {
		this.careTeamRole = careTeamRole;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "CareTeamMember [firstName= " + super.getFirstName() + ", lastName= " + super.getLastName() + ", careTeamRole= " + careTeamRole + ", description= " + description + ", relatedOrganization= " + super.getRelatedOrganization() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((super.getFirstName() == null) ? 0 : super.getFirstName().hashCode());
		result = prime * result + ((super.getLastName() == null) ? 0 : super.getLastName().hashCode());
		result = prime * result + ((careTeamRole == null) ? 0 : careTeamRole.hashCode());
		result = prime * result + ((super.getRelatedOrganization() == null) ? 0 : super.getRelatedOrganization().hashCode());
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
		CareTeamMember other = (CareTeamMember) obj;
		if (super.getFirstName() == null) {
			if (other.getFirstName() != null)
				return false;
		} else if (!super.getFirstName().equals(other.getFirstName()))
			return false;
		if (super.getLastName() == null) {
			if (other.getLastName() != null)
				return false;
		} else if (!super.getLastName().equals(other.getLastName()))
			return false;
		if (careTeamRole == null) {
			if (other.careTeamRole != null)
				return false;
		} else if (!careTeamRole.equals(other.careTeamRole))
			return false;
		if (super.getRelatedOrganization() == null) {
			if (other.getRelatedOrganization() != null)
				return false;
		} else if (!super.getRelatedOrganization().equals(other.getRelatedOrganization()))
			return false;
		return true;
	}
	
}
