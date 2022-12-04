package Basic;

public class VisitorPattern {

	public static void main(String[] args) {
		Child baby = new Child();
		Dog dog = new Dog();
		Item item = new Stone();
		baby.playWithDog(dog, item);
	}

}

class Child {
	public void playWithDog(Dog dog, Item item) {
		try {
			dog.play(item);
		}catch(DogException e) {
			e.visit();
		}
	}
}

class Dog {
	public void play(Item item) throws DogException {
		item.execute();
	}
}

abstract class Handler {
	public abstract void help(DogBiteException e);
	public abstract void help(DogBarkException e);
}

class HandlerUs extends Handler{
	@Override
	public void help(DogBarkException e) {
		System.out.println("Stay still dont worry");
	}
	@Override
	public void help(DogBiteException e) {
		System.out.println("Will send ambulance");
	}
}

abstract class Item {
	public abstract void execute()throws DogException;
}

class Stick extends Item {
	@Override
	public void execute() throws DogBiteException{
		throw new DogBiteException("You throw I Catch...");
	}
}

class Stone extends Item {
	@Override
	public void execute() throws DogBarkException {
		throw new DogBarkException("You throw I bite...");
	}
}

abstract class DogException extends Exception {
	public abstract void visit();
}

class DogBiteException extends DogException {
	String msg;
	public DogBiteException(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return msg;
	}
	public void visit() {
		new HandlerUs().help(this);
	}
}

class DogBarkException extends DogException {
	String msg;
	public DogBarkException(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return msg;
	}
	public void visit() {
		new HandlerUs().help(this);
	}
}
