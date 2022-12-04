
public class StrategyPattern {

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.play(new Stick());
		dog.play(new Stone());
	}

}

class Dog {
	public void play(Item item) {
		item.execute();
	}
}

abstract class Item {
	public abstract void execute();
}

class Stone extends Item {
	@Override
	public void execute() {
		System.out.println("You throw I bite");
	}
}

class Stick extends Item {
	@Override
	public void execute() {
		System.out.println("You throw I catch");
	}
}
