package day7;

public class Service {
	public static void main(String[] args) {
		Corporation corp=new Corporation();
		Health health=new Health();
		PWD pwd=new PWD();

		DeathCertificateRequest dc=new DeathCertificateRequest(corp,health,pwd);
		WaterConnectionRequest wc=new WaterConnectionRequest(corp,health,pwd);
		
		SewaCenter sc=new SewaCenter();
		
		sc.addSewaRequest(dc);
		sc.addSewaRequest(wc);
		
		sc.executeSewaRequests();
		
	}
}
class SewaCenter{
	Sewa sewaRequests[]=new Sewa[5];
	int count = 0;
	public SewaCenter() {
		/*
		for(int i=0;i<5;i++) {
			sewaRequests[i]=new DummySewa();
		}
		*/
	}
	
	public void addSewaRequest(Sewa sewa) {
		this.sewaRequests[count]=sewa;
		this.count++;
	}
	public void executeSewaRequests() {
		for(int i=0;i<sewaRequests.length - 1;i++) {
			if(this.sewaRequests[i] !=  null) {
				this.sewaRequests[i].execute();
			}
		}
		
		
	}
}

class DummySewa extends Sewa{
	@Override
	public void execute() {
		System.out.println("I am dummy yet to be operational...");
	}
}

abstract class Sewa{
	public Sewa() {

	}
	private Corporation corp;
	private Health health;
	private PWD pwd;
	
	public Sewa(Corporation corp, Health health,PWD pwd) {
		this.corp = corp;
		this.health = health;
		this.pwd = pwd;
	}
	public final Corporation getCorp() {
		return corp;
	}
	public final Health getHealth() {
		return health;
	}
	public final PWD getPwd() {
		return pwd;
	}

	public abstract void execute();
}
class DeathCertificateRequest extends Sewa{
	public DeathCertificateRequest(Corporation corp, Health health,PWD pwd) {
		super(corp,health,pwd);
	}

	public void execute() {
		System.out.println("getting death certifiacte");
		getHealth().getDeathCertificate();

	}
}
class WaterConnectionRequest extends Sewa{
	public WaterConnectionRequest(Corporation corp, Health health,PWD pwd) {
		super(corp,health,pwd);
	}
	
	public void execute() {
		System.out.println("getting water conn");
		getCorp().getWaterConnection();;

	}
}

class Corporation{
	public void getWaterConnection() {
		System.out.println("water conn");
	}
	public void getElectricityConnection() {
		System.out.println("electricity conn");
	}
}

class Health{
	public void getDeathCertificate() {
		System.out.println("death certificate");
	}
	public void getVaccine() {
		System.out.println("vaccine");
	}
}
class PWD{
	public void layRoad() {
		System.out.println("laying roads");
	}
	public void fixStreetLight() {
		System.out.println("fixing lights");
	}
}



