package week3day1;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
public class References {
	
	
	public static void main(String[] args) {
		
		Runtime r = Runtime.getRuntime();
		System.out.println(r.freeMemory());
		
		
		Person p = new Person();
		
//		System.out.println("After person birth ......."+r.freeMemory());
//		p = null;
//		System.out.println(r.freeMemory());
//		System.out.println("calling gc");
//		r.gc();
//		System.out.println("After gc called     :"+r.freeMemory());
//		r.gc();
//		System.out.println("After gc called     :"+r.freeMemory());
		
		
//		System.out.println("After peron created  :"+r.freeMemory());
//		WeakReference weakref = new WeakReference(p);
//		System.gc();
//		System.out.println("After system gc() call :"+r.freeMemory());
//		System.out.println(p);
		
		
		System.out.println("After peron created  :"+r.freeMemory());
		SoftReference softref = new SoftReference(p);
		//WeakReference weakref = new WeakReference(p);
		p = null;
		System.gc();
		System.out.println(p);
		System.out.println("After system gc() call :"+r.freeMemory());
		p = (Person)softref.get();
		System.out.println(p);
	}
	
}


class Person{
	
	private String gold = "in the box";
	String space;
	
	public Person() {
		for(int  i= 0;i<10000;i++) {
			space = new String(" "+i);
		}
	}
	
	protected String getGold() {
		return gold;
				
	}
	
	public void finalize() throws Throwable{
		System.out.println("Person's gold : "+gold);
	}
}




/*************************************/