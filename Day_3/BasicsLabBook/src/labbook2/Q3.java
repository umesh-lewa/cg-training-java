package labbook2;

public class Q3 {
	
	public static void main(String[] args) {
		
		Employee employee = new Employee("Guy05", "5", 5, 5, 2020);
		Worker worker = new Worker("Guy1", "1", 1, 1, 2010);
		SalesPerson salesperson = new SalesPerson("Guy2", "2", 2, 2, 2015);
		SalesManger manager = new SalesManger("Guy3", "3", 2, 3, 2013);
		SalesTerritoryManger territotyManager = new SalesTerritoryManger("Guy4", "4", 4, 4, 2019);
		
	}
	
}

class Employee{
	
	String name;
	String employeeId;
	Date dateOfJoining;
	
	public Employee(String name, String employeeId, int date, int month, int year) {
		this.name = name;
		this.employeeId = employeeId;
		this.dateOfJoining = new Date(date, month, year);
	}
}

class SalesPerson extends Employee {
		
	public SalesPerson(String name, String employeeId, int date, int month, int year) {
		super(name, employeeId, date, month, year);

	}
	
}

class Worker extends Employee {
	
	public Worker(String name, String employeeId, int date, int month, int year) {
		super(name, employeeId, date, month, year);

	}
	
}

class SalesManger extends SalesPerson {
	
	public SalesManger(String name, String employeeId, int date, int month, int year) {
		super(name, employeeId, date, month, year);
	}
	
}

class SalesTerritoryManger extends SalesManger {
	
	public SalesTerritoryManger(String name, String employeeId, int date, int month, int year) {
		super(name, employeeId, date, month, year);
	}
	
}

class Date{
	
	int date;
	int month;
	int year;
	
	Date(int date, int month, int year){
		this.date = date;
		this.month = month;
		this.year = year;
	}
	
}
