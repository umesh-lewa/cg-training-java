package day10;

import java.lang.reflect.Proxy;

public class SingletonWithProxy {

	public static void main(String arhs[]) {
		
		Object obj=new AImpl();
		
		Importer importObj=(Importer)obj;
		importObj.testA();
		
		Exporter exportImplObj=new ExporterImpl();
		
		obj=Proxy.newProxyInstance(importObj.getClass().getClassLoader(),
				new Class[] {Importer.class,Exporter.class,MegaExporter.class},
				new MyInvocationHandler(new Object[] {importObj,exportImplObj}));
		
		Importer iObj=(Importer)obj;
		
		Exporter eObj=(Exporter)obj;
		
		MegaExporter mObj=(MegaExporter)obj;
		
		iObj.testA();
		eObj.doExport();
		String result=mObj.doMegaExport("mega export...");
		System.out.println("The result....is..:"+result);
		
	}
		
}


class MyBusinessLogic implements Cloneable{
	
	String str;
	
	private MyBusinessLogic() {
		System.out.println("cons called...");		
	}
	
	private static MyBusinessLogic myb;
	
	synchronized public static MyBusinessLogic createObject() throws Exception{
		
		if(myb==null) {
			myb=new MyBusinessLogic();
		}
		
		return myb.createClone();		
	}
	
	public  MyBusinessLogic createClone()throws Exception {	
		
			return (MyBusinessLogic)super.clone();		
	}
	
}
