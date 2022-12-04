
public class DecoratorPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IbacoIcecream icecream = new Vanilla(new Nuts(new Gems()));
		System.out.println(icecream);
		System.out.println(icecream.cost());
	}

}

abstract class IbacoIcecream {
	public abstract int cost();
}

abstract class Cream extends IbacoIcecream {
	
}

class Vanilla extends Cream {
	IbacoIcecream ic;
	public Vanilla() {
		
	}
	public Vanilla(IbacoIcecream ic) {
		this.ic = ic;
	}
	public int cost() {
		return (ic==null)?20:20 + ic.cost(); 
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Vanilla " + ic;
	}
}

abstract class AddOns extends IbacoIcecream {
	
}

class Nuts extends AddOns {
	IbacoIcecream ic;
	public Nuts() {
		
	}
	public Nuts(IbacoIcecream ic) {
		this.ic = ic;
	}
	public int cost() {
		return (ic==null)?10:10 + ic.cost();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nuts " + ic;
	}
}
class Gems extends AddOns {
	IbacoIcecream ic;
	public Gems() {
		
	}
	public Gems(IbacoIcecream ic) {
		this.ic = ic;
	}
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return (ic==null)?5:5 + ic.cost();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Gems " + ic;
	}
}