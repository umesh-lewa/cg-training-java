package codaannopack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
public class AnnoTest {
	@Autowired
	@Qualifier("servicetwo")
	private ParentService myservice;

	public ParentService getMyservice() {
		return myservice;
	}

	public void setMyservice(ParentService myservice) {
		this.myservice = myservice;
	}
	
	public void doBusiness() {
		System.out.println("do business logic called...");
		myservice.doService();
	}
}

interface ParentService{
	public void doService();
}
@Service("servicetwo")
class MyServiceTwo implements ParentService{
	
	@Autowired
	private MyRepoDAO myrepo;

	public MyRepoDAO getMyrepo() {
		return myrepo;
	}

	public void setMyrepo(MyRepoDAO myrepo) {
		this.myrepo = myrepo;
	}
	public void doService() {
		System.out.println("service2  method called...");
		myrepo.doDAOLogic();
	}
}
@Service("serviceone")
class MyService implements ParentService{
	
	@Autowired
	private MyRepoDAO myrepo;

	public MyRepoDAO getMyrepo() {
		return myrepo;
	}

	public void setMyrepo(MyRepoDAO myrepo) {
		this.myrepo = myrepo;
	}
	public void doService() {
		System.out.println("service method called...");
		myrepo.doDAOLogic();
	}
}

@Repository
class MyRepoDAO{
	public void doDAOLogic() {
		System.out.println("repo dao logic called...........");
	}
}