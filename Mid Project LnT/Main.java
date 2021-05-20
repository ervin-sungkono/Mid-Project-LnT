import java.util.ArrayList;
import java.util.Scanner;

import java.util.regex.Matcher; 
import java.util.regex.Pattern;

public class Main {
	
	private static Scanner scan = new Scanner(System.in);
	private static ArrayList<Vehicle> vehicle = new ArrayList<>();
	
	public static void clrscr() {
		for(int i = 0 ; i < 60 ; i++) System.out.println("");
	}
	
	public static void view() {
		int n = vehicle.size();
		int choose;
		System.out.println("|.....|................|................|");
		System.out.printf("|%-5s|%-16s|%-16s|\n","No","Type","Name");
		System.out.println("|.....|................|................|");
		for(int i = 0 ; i < n ; i++) {
			System.out.printf("|%-5d|%-16s|%-16s|\n", i+1,vehicle.get(i).type,vehicle.get(i).name);
			System.out.println("|.....|................|................|");
		}
		System.out.print("Pick a vehicle number to test drive [Enter '0' to exit]: ");
		choose = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Brand: " + vehicle.get(choose-1).brand);
		System.out.println("Name: " + vehicle.get(choose-1).name);
		System.out.println("License: " + vehicle.get(choose-1).license);
		System.out.println("Type: " + vehicle.get(choose-1).type);
		System.out.println("Gas Capacity: " + vehicle.get(choose-1).gasCap);
		System.out.println("Top Speed: " + vehicle.get(choose-1).topSpeed);
		System.out.println("Wheel(s): " + vehicle.get(choose-1).wheel);
		System.out.println("Turning on entertainment system...");
		if(vehicle.get(choose-1).vehicleType.equals("Car")) {
			vehicle.get(choose-1).car.entertainmentSystem();
		}
		else {
			System.out.println("Helm: " + vehicle.get(choose-1).motor.getHelm());
			vehicle.get(choose-1).motor.entertainmentSystem(vehicle.get(choose-1).name);
		}
}
	
	public static void input() {
		String vehicleType, type, brand, name, license;
		int topSpeed, gasCap, wheel, entertainment, helm;
		do {
			System.out.print("Input type [Car | Motorcycle]: ");
			vehicleType = scan.nextLine();
		}while(!vehicleType.equals("Car") && !vehicleType.equals("Motorcycle"));
		
		do {
			System.out.print("Input brand [>= 5]: ");
			brand = scan.nextLine();
		}while(brand.length()<5);
		
		do {
			System.out.print("Input name [>= 5]: ");
			name = scan.nextLine();
		}while(name.length()<5);
		
		do{
			System.out.print("Input License: ");
			license = scan.nextLine();
			Matcher m = Pattern.compile("^[A-Z]\s\\d{4}\s[A-Z]{3}$").matcher(license);
			if(m.find()) break;
		}while(true);
		
		do {
			System.out.print("Input top speed [100 <= topSpeed <= 250]: ");	
			topSpeed = scan.nextInt();
			scan.nextLine();
		}while(topSpeed < 100 || topSpeed > 250);
		
		do {
			System.out.print("Input gas capacity [30 <= gasCap <= 60]: ");	
			gasCap = scan.nextInt();
			scan.nextLine();
		}while(gasCap < 30 || gasCap > 60);
		
		do {
			System.out.print("Input wheel [4 <= wheel <= 6]: ");	
			wheel = scan.nextInt();
			scan.nextLine();
		}while(wheel < 4 || wheel > 6);
		
		Vehicle newVehicle;
		if(vehicleType.equals("Car")) {
			do {
				System.out.print("Input type [SUV | Supercar | Minivan]: ");	
				type = scan.nextLine();
			}while(!type.equals("SUV") && !type.equals("Supercar") && !type.equals("Minivan"));
			
			do {
				System.out.print("Input entertainment system amount [>=1]: ");
				entertainment = scan.nextInt();
				scan.nextLine();
			}while(entertainment < 1);
			
			newVehicle = new Vehicle(vehicleType, type, brand, name, license
					,topSpeed, gasCap, wheel, entertainment);
		}
		
		else {
			do {
				System.out.print("Input type [Automatic | Manual]: ");	
				type = scan.nextLine();
			}while(!type.equals("Automatic") && !type.equals("Manual"));
			
			do {
				System.out.print("Input helm amount [>=1]: ");
				helm = scan.nextInt();
				scan.nextLine();
			}while(helm < 1);
			newVehicle = new Vehicle(vehicleType, type, brand, name, license
					,topSpeed, gasCap, wheel, helm);
		}
		
		vehicle.add(newVehicle);
		
		System.out.println("Input Completed!");
	}
	
	public static void main(String args[]) {
		int menu;
		do {
			clrscr();
			System.out.println("Menu:");
			System.out.println("1. Input");
			System.out.println("2. View");
			System.out.print("Choose Item: ");
			menu = scan.nextInt();
			scan.nextLine();
			clrscr();
			switch(menu) {
			case 1:
				input();
				scan.nextLine();				
				break;
			case 2:
				view();
				scan.nextLine();
				break;
			}
		}while(menu!=3);
		scan.close();
	}
}
