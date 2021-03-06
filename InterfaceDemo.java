package week3day1;

import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;

public class InterfaceDemo {
	
	public static void main(String[] args) {
		
		Object human = new Human();
		Scanner s = new Scanner(System.in);
		s.next();
		
		MMC madrasMC = new MMC();
		SiddhaMC sid = new SiddhaMC();
		JetAcademy jet = new JetAcademy();
		
		
		Object obj = Proxy.newProxyInstance(Human.class.getClassLoader(), new Class[] {Doctor.class,Pilot.class},new MyInvocationHandler(new Object [] {madrasMC,jet,sid}));
		
		Doctor doctor = (Doctor)obj;
		doctor.doCure();
		
		Pilot pilot = (Pilot)doctor;
		pilot.doFly();
	}
	
}


class MyInvocationHandler implements InvocationHandler{

	Object[] obj;
	
	
	public MyInvocationHandler(Object[] obj) {
		this.obj = obj;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("invoke method called.....");
		Object oo = null;
		for(Object o:obj) {
			Method m[] = o.getClass().getDeclaredMethods();
			for(Method met:m) {
				if(met.getName().equals(method.getName())) {
					met.setAccessible(true);
					oo = method.invoke(o, args);
				}
			}
		}
		return oo;
	}
	
}

class Human{
	
}

interface Doctor{
	void doCure();
}

class MMC implements Doctor{

	@Override
	public void doCure() {
		
		System.out.println("Alopathy treatment");
		// TODO Auto-generated method stub
		
	}
	
}

class SiddhaMC implements Doctor{

	@Override
	public void doCure() {
		System.out.println("Siddha treatment");
		// TODO Auto-generated method stub
		
	}
	
	
}

interface Pilot{
	void doFly();
}

class JetAcademy implements Pilot{

	@Override
	public void doFly() {
		System.out.println("Fly plane");
		// TODO Auto-generated method stub
		
	}
}



/************/