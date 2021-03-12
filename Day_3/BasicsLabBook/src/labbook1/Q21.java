package labbook1;

public class Q21 {
	
	public static void main(String args[]) {
		
		int month = 5;
		int year = 2004;
		String monthName = "";
		int noOfDaysInMonth = 0;
		
		switch (month) {
        case 1:
        	monthName = "January";
        	noOfDaysInMonth = 31;
            break;
        case 2:
        	monthName = "February";
            if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            	noOfDaysInMonth = 29;
            } else {
            	noOfDaysInMonth = 28;
            }
            break;
        case 3:
        	monthName = "March";
        	noOfDaysInMonth = 31;
            break;
        case 4:
        	monthName = "April";
        	noOfDaysInMonth = 30;
            break;
        case 5:
        	monthName = "May";
        	noOfDaysInMonth = 31;
            break;
        case 6:
        	monthName = "June";
        	noOfDaysInMonth = 30;
            break;
        case 7:
        	monthName = "July";
        	noOfDaysInMonth = 31;
            break;
        case 8:
        	monthName = "August";
        	noOfDaysInMonth = 31;
            break;
        case 9:
        	monthName = "September";
        	noOfDaysInMonth = 30;
            break;
        case 10:
        	monthName = "October";
        	noOfDaysInMonth = 31;
            break;
        case 11:
        	monthName = "November";
        	noOfDaysInMonth = 30;
            break;
        case 12:
        	monthName = "December";
        	noOfDaysInMonth = 31;
    }
    
	}
}
