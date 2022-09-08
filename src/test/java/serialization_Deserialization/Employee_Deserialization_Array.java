package serialization_Deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pojoClassForSerializationAndDeserialization.Employee2;

public class Employee_Deserialization_Array {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper=new ObjectMapper();
		Employee2 emp2=objectMapper.readValue(new File("./objectMapperArr.json"),Employee2.class);
		System.out.println(emp2.getEmpName());
		System.out.println(emp2.getEmpId());
		System.out.println(emp2.getEmail()[0]);
		System.out.println(emp2.getPhoneNo()[1]);
		//for array type we should specify the index,otherwise we get address value of object only
	}

}
