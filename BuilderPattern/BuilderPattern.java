
public class BuilderPattern {

	public static void main(String[] args) {
		ComputerFactory cf = new LenovoFactory();
		ComputerShop poorvika = new ComputerShop();
		poorvika.setFactory(cf);
		System.out.println(poorvika.sellComputer());
		
	}

}

class ComputerShop {
	ComputerFactory cf;
	public void setFactory(ComputerFactory cf) {
		this.cf = cf;
	}
	public Computer sellComputer() {
		return cf.make();
	}
}

abstract class ComputerFactory {// Abstract Factory
	public abstract Computer make(); // Factory method
}

class LenovoFactory extends ComputerFactory { // Factory
	@Override
	public Computer make() {
		return new Computer.ComputerBuilder().setBrand("Lenovo").setRam("8 gb").build();
	}
}

class DellFactory extends ComputerFactory {
	@Override
	public Computer make() {
		return new Computer.ComputerBuilder().setBrand("Dell").setRam("8 gb").build();
	}
}

class Computer {
	private String ram;
	private String brand;
	public Computer(ComputerBuilder cb) {
		ram = cb.ram;
		brand = cb.brand;
	}
	@Override
	public String toString() {
		return brand;
	}
	static class ComputerBuilder {
		private String ram;
		private String brand;
		public ComputerBuilder setRam(String ram) {
			this.ram = ram;
			return this;
		}
		public ComputerBuilder setBrand(String brand) {
			this.brand = brand;
			return this;
		}
		public Computer build() {
			return new Computer(this);
		}
	}
}
