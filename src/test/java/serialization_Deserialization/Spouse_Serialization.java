package serialization_Deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassForSerializationAndDeserialization.EmployeeWithObject;
import pojoClassForSerializationAndDeserialization.Spouse;

public class Spouse_Serialization {
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
	
	
	ObjectMapper objectMapper=new ObjectMapper();
	Spouse spouse=new Spouse("vav@gmail.com","916153");
	EmployeeWithObject employeeWithObject=new EmployeeWithObject("vav","tyss123",spouse);
	objectMapper.writeValue(new File("./object.json"),employeeWithObject);
	

}
}