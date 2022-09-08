package pojoClassForSerializationAndDeserialization;

public class Employee {
	String empId;
	String empName;
	String email;
	int phoneNo;
	
	public Employee(String empId, String empName, String email, int phoneNo) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	public Employee() {
		super();
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public String getEmail() {
		return email;
	}

	public int getPhoneNo() {
		return phoneNo;
	}
	
	
	

}
