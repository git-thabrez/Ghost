import java.util.Scanner;

public class StatePattern {

	public static void main(String[] args) {
		Fan fan = new Fan();
		System.out.println(fan.state);
		while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter to pull");
			scan.next();
			fan.pull();
		}
	}

}

class Fan{
	State state = new OffState();
	public void pull() {
		state.changeState(this);
	}
}

abstract class State {
	public abstract void changeState(Fan fan);
}

class OffState extends State{
	@Override
	public void changeState(Fan fan) {
		System.out.println("On state...");
		fan.state = new OnState();
	}
}

class OnState extends State {
	@Override
	public void changeState(Fan fan) {
		System.out.println("Low State");
		fan.state = new LowState();
	}
}

class LowState extends State {
	@Override
	public void changeState(Fan fan) {
		System.out.println("Medium State");
		fan.state = new MediumState();
	}
}

class MediumState extends State {
	@Override
	public void changeState(Fan fan) {
		System.out.println("High State");
		fan.state = new HighState();
	}
}

class HighState extends State {
	@Override
	public void changeState(Fan fan) {
		System.out.println("Off State");
		fan.state = new OffState();
	}
}
