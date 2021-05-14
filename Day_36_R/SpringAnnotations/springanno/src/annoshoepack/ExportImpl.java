package annoshoepack;

import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class ExportImpl extends DelegatingIntroductionInterceptor implements Exporter{
public ExportImpl() {
	// TODO Auto-generated constructor stub
}
@Override
	public void doExport() {
		System.out.println("shoe shop exporting shoe.............");
	}
}
