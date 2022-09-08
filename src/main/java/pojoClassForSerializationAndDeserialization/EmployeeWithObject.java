package pojoClassForSerializationAndDeserialization;

public class EmployeeWithObject {
	
	String empName;
	String empId;
	Object spouse;
	
	public EmployeeWithObject(String empName, String empId, Object spouse) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.spouse = spouse;
	}

	public EmployeeWithObject() {
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

	public Object getSpouse() {
		return spouse;
	}

	public void setSpouse(Object spouse) {
		this.spouse = spouse;
	}
	
	
	
	

}
