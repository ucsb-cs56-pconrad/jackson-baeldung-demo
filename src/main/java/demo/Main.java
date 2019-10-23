package demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
	public static void main (String [] args) throws Exception {
		System.out.println("Main:");
		main3_1();
		main3_2();	
	}

	/**
	 * 3.1 Java Object to JSON
	 */
	public static void main3_1() throws Exception  {
		System.out.println("main3_1:");

		Car car = new Car("yellow", "renault");
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(new File("target/car.json"), car);
		
		String carAsString = objectMapper.writeValueAsString(car);
		System.out.println("Car Json: " + carAsString);
	}


	/**
	 * 3.2 JSON to Java Object
	 */
	public static void main3_2() throws Exception  {
		System.out.println("main3_2:");

		ObjectMapper objectMapper = new ObjectMapper();

		String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
		Car car = objectMapper.readValue(json, Car.class);  
		System.out.println("car="+car);
	}
}
