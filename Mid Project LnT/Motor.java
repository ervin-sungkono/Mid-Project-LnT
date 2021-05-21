import java.util.Scanner;

public class Motor {
	
	private int helm,price;
	private String type;
	private static Scanner scan = new Scanner(System.in);

	public Motor(int helm, String type) {
		this.helm = helm;
		this.type = type;
	}
	
	public int getHelm() {
		return this.helm;
	}
	
	public void entertainmentSystem(String name) {
		System.out.println(name+" "+"is standing!");
		System.out.println("Insert Helm Price: ");
		price = scan.nextInt();
		scan.nextLine();
		System.out.println("Price: "+price);
	}
}
