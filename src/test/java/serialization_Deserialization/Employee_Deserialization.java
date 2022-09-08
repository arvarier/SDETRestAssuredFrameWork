package serialization_Deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassForSerializationAndDeserialization.Employee;

public class Employee_Deserialization {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper=new ObjectMapper();
		Employee emp1=objectMapper.readValue(new File("./objMapper.json"),Employee.class);
		System.out.println(emp1.getEmpName());
		System.out.println(emp1.getEmpId());
		System.out.println(emp1.getEmail());
		System.out.println(emp1.getPhoneNo());
	}

}
