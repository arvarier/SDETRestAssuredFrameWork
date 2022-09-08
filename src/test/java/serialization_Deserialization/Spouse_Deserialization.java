package serialization_Deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassForSerializationAndDeserialization.EmployeeWithObject;

public class Spouse_Deserialization {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper=new ObjectMapper();
		EmployeeWithObject employeeWithObject=objectMapper.readValue(new File("./object.json"),EmployeeWithObject.class);
		System.out.println(employeeWithObject.getEmpId());
		System.out.println(employeeWithObject.getEmpName());
		System.out.println(employeeWithObject.getSpouse());
		
	}

}
