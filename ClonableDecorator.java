package week3day1;


public class ClonableDecorator {

	public static void main(String[] args) throws Exception{
		IceCream vanilla = Vannila.createObject();
		IceCream strawberry = StrawBerry.createObject();
		
		
		IceCream myRealIceCream = vanilla.getIceCreamClone(strawberry.getIceCreamClone());
		System.out.println(myRealIceCream.cost());
	}
	
}



abstract class IceCream{
	abstract int cost();
	abstract IceCream getIceCreamClone() throws Exception;
	abstract IceCream getIceCreamClone(IceCream icecream) throws Exception;
}

abstract class Creame extends IceCream{
	
}

abstract class IceCreamIngredients extends IceCream{
	
}





class Vannila extends Creame implements Cloneable{
	
	IceCream icecream;
	public static Vannila van;
	public Vannila() {
	
	}

	Vannila(IceCream icecream){
		this.icecream = icecream;
	}
	
	public int cost() {
		if(this.icecream == null)
			return 10;
		else
			return 10+this.icecream.cost();
	}
	
	public static Vannila createObject() {
		if(van == null)
			return new Vannila();
		return van;
	}
	
	public static Vannila createObject(IceCream icecream) {
		if(van == null)
			return new Vannila();
		return van;
	}
	
	public Vannila getIceCreamClone()throws Exception{
		return (Vannila)super.clone(); 
	}
	
	public Vannila getIceCreamClone(IceCream icecream) throws Exception{
		this.icecream = icecream;
		return (Vannila)super.clone();
	}
}

class StrawBerry extends Creame implements Cloneable{
	IceCream icecream;
	public static StrawBerry berry;
	public StrawBerry() {
	
	}

	StrawBerry(IceCream icecream){
		this.icecream = icecream;
	}
	
	public int cost() {
		if(this.icecream == null)
			return 10;
		else
			return 10+this.icecream.cost();
	}
	
	public static StrawBerry createObject() {
		if(berry == null)
			return new StrawBerry();
		return berry;
	}
	
	public static StrawBerry createObject(IceCream icecream) {
		if(berry == null)
			return new StrawBerry();
		return berry;
	}
	
	public StrawBerry getIceCreamClone()throws Exception{
		return (StrawBerry)super.clone(); 
	}
	
	public StrawBerry getIceCreamClone(IceCream icecream) throws Exception{
		this.icecream = icecream;
		return (StrawBerry)super.clone();
	}
}

class ButterScotch extends Creame implements Cloneable{
	
	IceCream icecream;
	public ButterScotch() {
		
	}

	ButterScotch(IceCream icecream){
		this.icecream = icecream;
	}
	
	public IceCream getIceCreamClone()throws Exception{
		return (IceCream)super.clone(); 
	}
	
	public IceCream getIceCreamClone(IceCream icecream) throws Exception{
		this.icecream = icecream;
		return (IceCream)super.clone();
	}
	
	public int cost() {
		if(this.icecream == null)
			return 10;
		else
			return 10+this.icecream.cost();
	}
}

class Nuts extends IceCreamIngredients implements Cloneable{
	
	IceCream icecream;
	public Nuts() {
		
	}
	
	Nuts(IceCream icecream){
		this.icecream = icecream;
	}
	
	public IceCream getIceCreamClone()throws Exception{
		return (IceCream)super.clone(); 
	}
	
	public IceCream getIceCreamClone(IceCream icecream) throws Exception{
		this.icecream = icecream;
		return (IceCream)super.clone();
	}
	
	public int cost() {
		if(this.icecream == null)
			return 10;
		else
			return 10+this.icecream.cost();
	}
}

