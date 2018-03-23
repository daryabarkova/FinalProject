package by.dbarkova.entities;

import java.util.Date;

public class Event {
	
	private Date date;
	private String eventCreator;
	private String creatorCareTeamRole;
	private String eventType;
	
	public Event() {}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEventCreator() {
		return eventCreator;
	}

	public void setEventCreator(String eventCreator) {
		this.eventCreator = eventCreator;
	}

	public String getCreatorCareTeamRole() {
		return creatorCareTeamRole;
	}

	public void setCreatorCareTeamRole(String creatorCareTeamRole) {
		this.creatorCareTeamRole = creatorCareTeamRole;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	@Override
	public String toString() {
		return "Event [date=" + date + ", eventCreator=" + eventCreator + ", creatorCareTeamRole=" + creatorCareTeamRole
				+ ", eventType=" + eventType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creatorCareTeamRole == null) ? 0 : creatorCareTeamRole.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((eventCreator == null) ? 0 : eventCreator.hashCode());
		result = prime * result + ((eventType == null) ? 0 : eventType.hashCode());
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
		Event other = (Event) obj;
		if (creatorCareTeamRole == null) {
			if (other.creatorCareTeamRole != null)
				return false;
		} else if (!creatorCareTeamRole.equals(other.creatorCareTeamRole))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (eventCreator == null) {
			if (other.eventCreator != null)
				return false;
		} else if (!eventCreator.equals(other.eventCreator))
			return false;
		if (eventType == null) {
			if (other.eventType != null)
				return false;
		} else if (!eventType.equals(other.eventType))
			return false;
		return true;
	}
	
	
	
}
