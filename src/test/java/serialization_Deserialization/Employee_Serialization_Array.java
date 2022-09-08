package serialization_Deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassForSerializationAndDeserialization.Employee2;

public class Employee_Serialization_Array {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
	
	String name="akshay";
	String id="abc123";
	String []mail={"akshay@gmail.com","akshay1@gmail.com"};
    String []mob={"987654","123456"};
	
	Employee2 emp2=new Employee2(name,id,mail,mob);
	ObjectMapper objectMapper=new ObjectMapper();
	objectMapper.writeValue(new File("./objectMapperArr.json"), emp2);

}
}