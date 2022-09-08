package pojoClassForSerializationAndDeserialization;

public class Spouse {
	
	String spouseEmail;
	String spousePhoneNo;
	public Spouse(String spouseEmail, String spousePhoneNo) {
		super();
		this.spouseEmail = spouseEmail;
		this.spousePhoneNo = spousePhoneNo;
	}
	public Spouse() {
		super();
	}
	public String getSpouseEmail() {
		return spouseEmail;
	}
	public void setSpouseEmail(String spouseEmail) {
		this.spouseEmail = spouseEmail;
	}
	public String getSpousePhoneNo() {
		return spousePhoneNo;
	}
	public void setSpousePhoneNo(String spousePhoneNo) {
		this.spousePhoneNo = spousePhoneNo;
	}
	
	

}
