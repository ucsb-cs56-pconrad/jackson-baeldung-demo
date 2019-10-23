package demo;

import lombok.Data;

@Data
public class Car {
    private String color;
    private String type;

    public Car(String color, String type) {
        setColor(color);
        setType(type);
    }
    public Car() {}
}
	
