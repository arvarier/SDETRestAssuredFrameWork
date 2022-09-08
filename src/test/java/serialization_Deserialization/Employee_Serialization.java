package serialization_Deserialization;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

import pojoClassForSerializationAndDeserialization.Employee;

public class Employee_Serialization {
	public static void main(String[] args) throws Throwable, Throwable, Throwable {
		
	Employee emp=new Employee("akshay","emp123","akshay@gmail.com",99887766);
	
	ObjectMapper objMapper=new ObjectMapper();
	
	objMapper.writeValue(new File("./objMapper.json"), emp);
}
}
