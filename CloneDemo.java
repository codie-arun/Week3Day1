package week3day1;

public class CloneDemo {

	public static void main(String[] args) throws Exception{
		
		Car tesla = new Car();
		System.out.println(tesla.hashCode());
		Car bmw = tesla.getcarClone();
		System.out.println(bmw.hashCode());
		Car lexus = bmw;
		System.out.println(lexus.hashCode());
	}

}


class Car implements Cloneable{
	
	String type;
	int bhp;
	double torque;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getBhp() {
		return bhp;
	}
	public void setBhp(int bhp) {
		this.bhp = bhp;
	}
	public double getTorque() {
		return torque;
	}
	public void setTorque(double torque) {
		this.torque = torque;
	}
	
	public Car getcarClone() throws Exception{
		return (Car)super.clone();
	}
	
}