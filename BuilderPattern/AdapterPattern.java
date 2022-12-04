
public class AdapterPattern {

	public static void main(String[] args) {
		IndianSocket sakthi = new SakthiSocket();
		AmericanPlug lenovo = new LenovoPlug();
		IndianAdapter ip = new IndianAdapter();
		ip.ap = lenovo;
		sakthi.pinHole(ip);
	}

}

abstract class IndianSocket {
	public abstract void pinHole(IndianPlug ip);
}

class SakthiSocket extends IndianSocket {
	@Override
	public void pinHole(IndianPlug ip) {
		ip.work();
	}
}

abstract class IndianPlug {
	public abstract void work();
}

class IndianAdapter extends IndianPlug{
	AmericanPlug ap;
	public void work() {
		ap.work();
	}
}

abstract class AmericanPlug {
	public abstract void work();
}

class LenovoPlug extends AmericanPlug {
	@Override
	public void work() {
		System.out.println("Lenovo plug inserted...");
	}
}