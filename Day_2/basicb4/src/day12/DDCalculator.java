package day12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DDCalculator {
	
	public static void main(String args[]) {
		
		CalcUtil calc = new CalcUtil(LocalDate.of(2021,02,12),"",10000,40,9);
		System.out.println(calc.getDeliveryDate().toString());
	}
}

class CalcUtil{
	
	LocalDate startDate;
	int totalDistanceToCover = 0;
	int distanceCoverablePerDay = 0;
	
	/**
	 * 
	 * @param startDate
	 * @param startTime
	 * @param distance in Kms
	 * @param travelSpeed in Km/Hr
	 * @param workingHoursPerDay in Hrs
	 */
	CalcUtil(LocalDate startDate,String startTime,int distance,int travelSpeed,int workingHoursPerDay){
		
		this.startDate = startDate;
		this.totalDistanceToCover = distance;
		this.distanceCoverablePerDay = travelSpeed * workingHoursPerDay;
		
		System.out.println("distanceCoverablePerDay : "+distanceCoverablePerDay);
		
	}
	
	/**
	 * 
	 * @return Delivery Date in LocalDate Format
	 */
	public LocalDate getDeliveryDate() {
		
		int totalWorkingDaysRequired = 0;
		LocalDate nextDate = this.startDate.plus(1, ChronoUnit.DAYS);
		boolean flag = true;
		
		while(flag) {
			
			nextDate = nextDate.plus(1, ChronoUnit.DAYS);
			
			if(nextDate.getDayOfWeek().equals( DayOfWeek.SUNDAY )) {
				System.out.println("Encountered a Sunday...!!!");
				continue;
			}
			
			boolean isHoliday = false;
			
			LocalDate ld = Holidays.H1.getLocalDate() ;
			
	        for (Holidays h : Holidays.values()) {
	        	
	            //System.out.println(h);
	            
	            if(nextDate.isEqual(h.getLocalDate())) {
	            	
	            	isHoliday = true;
	            }
	            
	        }

			
			if(isHoliday) {
				System.out.println("Encountered a Holiday...!!!");
				continue;
			}
			
			this.totalDistanceToCover = this.totalDistanceToCover - distanceCoverablePerDay;
			
			System.out.println("totalDistanceToCover : "+totalDistanceToCover);
			
			
			
			if(this.totalDistanceToCover <= 0) {
				flag = false;
			}

			totalWorkingDaysRequired++;
		}
		
		return nextDate;
		
	}
	
}

enum Holidays{
	
	H1(LocalDate.of(2021,01,01)),
	H2(LocalDate.of(2021,01,14)),
	H3(LocalDate.of(2021,01,26)),
	H4(LocalDate.of(2021,04,02)),
	H5(LocalDate.of(2021,04,14)),
	H6(LocalDate.of(2021,05,14)),
	H7(LocalDate.of(2021,9,10)),
	H8(LocalDate.of(2021,10,14)),
	H9(LocalDate.of(2021,10,15)),
	H10(LocalDate.of(2021,11,04));
	
	
	private LocalDate localDate;

    // Constructor
    private Holidays(LocalDate ld) {
        
        this.localDate = ld ;
    }

    // Getter
    public LocalDate getLocalDate() {
        return this.localDate ;
    }
	
	
}
