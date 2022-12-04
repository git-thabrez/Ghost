
public class CommandPattern {

	public static void main(String[] args) {
		Father father = new Father();
		Servant servant = new Servant();
		father.setCommand(servant);
		father.eatKadalaMittai(servant);
	}

}

class Father {
	public void setCommand(Servant servant) {
		servant.setCommand(new EatKadalaMittai(), 1);
		servant.setCommand(new PlayTTSingles(), 2);
		servant.setCommand(new PlayTTDoubles(), 3);
	}
	public void eatKadalaMittai(Servant servant) {
		servant.executeCommand(1);
	}
}

class Servant {
	Command[] c= new Command[5];
	public Servant() {
		for(Command c : c) {
			c = new DummyCommand();
		}
	}
	public void setCommand(Command command,int slot) {
		c[slot] = command;
	}
	public void executeCommand(int slot) {
		c[slot].execute();
	}
}

abstract class Command {
	public abstract void execute();
}

class DummyCommand extends Command {
	@Override
	public void execute() {
		System.out.println("This is a dummy command");
	}
}

class EatKadalaMittai extends Command {
	@Override
	public void execute() {
		Lift lift = new Lift();
		lift.operate();
		Car car = new Car();
		car.drive();
		PottiKadai pk = new PottiKadai();
		pk.buyKadalaMittai();
	}
}

class PlayTTSingles extends Command {
	@Override
	public void execute() {
		Tv tv = new Tv();
		tv.swithOn();
		tv.changeChannel();
		VGame v = new VGame();
		v.playTTSingle();
	}
}

class PlayTTDoubles extends Command {
	@Override
	public void execute() {
		Tv tv = new Tv();
		tv.swithOn();
		tv.changeChannel();
		VGame v = new VGame();
		v.playTTDouble();
	}
}

class Lift {
	public void operate() {
		System.out.println("Lift operated...");
	}
}

class Car {
	public void drive() {
		System.out.println("Diving car...");
	}
}

class PottiKadai {
	public void buyKadalaMittai() {
		System.out.println("Kadala mittai bought...");
	}
}
class Tv {
	public void swithOn() {
		System.out.println("Tv switched on...");
	}
	public void changeChannel() {
		System.out.println("Channel changed...");
	}
}

class VGame {
	public void playTTSingle() {
		System.out.println("TT singles");
	}
	public void playTTDoubles() {
		System.out.println("TT doubles");
	}
}
