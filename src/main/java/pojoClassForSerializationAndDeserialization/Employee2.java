package pojoClassForSerializationAndDeserialization;

public class Employee2 {
	String empName;
	String empId;
	String[]email;
	String[]phoneNo;
	public Employee2(String empName, String empId, String[] email, String[] phoneNo) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.email = email;
		this.phoneNo = phoneNo;
	}
	public Employee2() {
		super();
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String[] getEmail() {
		return email;
	}
	public void setEmail(String[] email) {
		this.email = email;
	}
	public String[] getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String[] phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	

}
