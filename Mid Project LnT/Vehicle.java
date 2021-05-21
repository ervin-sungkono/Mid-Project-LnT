
public class Vehicle {
	
	public Motor motor;
	public Car car;
	public String vehicleType, type, brand, name, license;
	public int topSpeed, gasCap, wheel;

	public Vehicle(String vehicleType,String type, String brand, String name, String license, int topSpeed, int gasCap, int wheel, int extra) {
		
		this.vehicleType = vehicleType;
		if(this.vehicleType.equals("Car")) {
			this.car = new Car(extra,type);
		}
		else {
			this.motor = new Motor(extra,type);
		}
		this.type = type;
		this.brand = brand;
		this.name = name;
		this.license = license;
		
		this.topSpeed = topSpeed;
		this.gasCap = gasCap;
		this.wheel = wheel;
	}
}
