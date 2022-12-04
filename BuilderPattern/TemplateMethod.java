
public class TemplateMethod {

	public static void main(String[] args) {
		DominoPizza dominos = new AmericanDominoPizza();
		dominos.orderPizza();
	}

}

abstract class DominoPizza {
	private final void shape() {
		System.out.println("round...");
	}
	private final void make() {
		System.out.println("Made as per domino recipe...");
	}
	public abstract void collectMoney();
	public abstract void deliverPizza();
	
	public final void orderPizza() {// Template method
		collectMoney();
		shape();
		make();
		deliverPizza();
	}
}

class IndianDominoPizza extends DominoPizza {
	@Override
	public void collectMoney() {
		System.out.println("Collected in rupee...");
	}
	@Override
	public void deliverPizza() {
		System.out.println("Delivered in bike");
	}
}

class AmericanDominoPizza extends DominoPizza {
	@Override
	public void collectMoney() {
		System.out.println("Collected in dollars...");
	}
	@Override
	public void deliverPizza() {
		System.out.println("Delivered in drone...");
	}
}
