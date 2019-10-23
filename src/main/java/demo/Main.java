package demo;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
	public static void main(String[] args) throws Exception {
		System.out.println("Main:");
		main3_1();
		main3_2();
		main3_3();
		main3_4();
		main3_5();
		main4_1();
	}

	/**
	 * 3.1 Java Object to JSON
	 */
	public static void main3_1() throws Exception {
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
	public static void main3_2() throws Exception {
		System.out.println("main3_2:");

		ObjectMapper objectMapper = new ObjectMapper();

		String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
		Car car = objectMapper.readValue(json, Car.class);
		System.out.println("car=" + car);
	}

	/**
	 * 3.3 JSON to Jackson JsonNode
	 */
	public static void main3_3() throws Exception {
		System.out.println("main3_3:");

		ObjectMapper objectMapper = new ObjectMapper();

		String json = "{ \"color\" : \"Black\", \"type\" : \"FIAT\" }";
		JsonNode jsonNode = objectMapper.readTree(json);
		String color = jsonNode.get("color").asText();
		System.out.println("color=" + color);
	}

	/**
	 * 3.4 Creating a Java List from a JSON Array String
	 */
	public static void main3_4() throws Exception {
		System.out.println("main3_4:");

		ObjectMapper objectMapper = new ObjectMapper();

		String jsonCarArray = "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
		List<Car> listCar =
			objectMapper.readValue(
				jsonCarArray, 
				new TypeReference<List<Car>>() {}
			);

		System.out.println("listCar=" + listCar);
	}

	/**
	 * 3.5. Creating Java Map from JSON String
	 */

	 public static void main3_5() throws Exception {
		System.out.println("main3_5:");

		ObjectMapper objectMapper = new ObjectMapper();

		String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
		Map<String, Object> map = 
			objectMapper.readValue(
				json, 
				new TypeReference<Map<String,Object>>(){}
			);

		System.out.println("map=" + map);
	}
	/**
	 * 4.1. Configuring Serialization or Deserialization Feature
	 */
	 public static void main4_1() throws Exception {
		System.out.println("main4_1:");

		ObjectMapper objectMapper = new ObjectMapper();

		String jsonString = "{ \"color\" : \"Black\", \"type\" : \"Fiat\", \"year\" : \"1970\" }";


		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Car car = objectMapper.readValue(jsonString, Car.class);
 
		JsonNode jsonNodeRoot = objectMapper.readTree(jsonString);
		JsonNode jsonNodeYear = jsonNodeRoot.get("year");
		String year = jsonNodeYear.asText();
		System.out.println("car="+car);
		System.out.println("year="+year);
	 }
}
