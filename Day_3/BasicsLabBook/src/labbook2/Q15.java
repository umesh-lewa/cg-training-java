package labbook2;

public class Q15 {
	
	public static void main(String args[]) {
		
		House houseOj = new House(4,15);
		int totalCost = houseOj.calcHouseCost();
	}
		
}

class Door{
	
	int area = 1;
	int costPerSqArea = 4;
	
	public int calcCost() {
		
		return this.area * this.costPerSqArea;
	}
}

class Window{
	
	int area = 1;
	int costPerSqArea = 6;
	
	public int calcCost() {
		
		return this.area * this.costPerSqArea;
	}
}

class House{
	
	int noOfDoors = 0;
	int noOfWindows = 0;
	Door door = new Door();
	Window window = new Window();

	
	House(int noOfDoors, int noOfWindows){
		this.noOfDoors = noOfDoors;
		this.noOfWindows = noOfWindows;
	}
	
	public int calcHouseCost() {
		
		//int totalDoorCost = 0;
		//int totalWindowCost = 0;
		
		int costPerDoor = door.calcCost();
		int costPerWindow = window.calcCost();
		
		
		return (this.noOfDoors * costPerDoor) + (this.noOfWindows * costPerWindow);
	}
	
}
