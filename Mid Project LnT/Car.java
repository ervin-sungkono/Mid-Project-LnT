
public class Car {
	
	private int entertainment;
	private String type;

	public Car(int entertainment, String type) {
		this.entertainment = entertainment;
		this.type = type;
	}
	
	public int getEntertainment() {
		return this.entertainment;
	}
	
	public void entertainmentSystem() {
		if(type.equals("Supercar")) System.out.println("Boosting!");
	}
}
