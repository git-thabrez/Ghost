
public class PrototypePattern {

	public static void main(String[] args)throws Exception {
		Sheep sheep = new Sheep();
		Sheep dolly = sheep.createClone();
		sheep.name = "sheep";
		dolly.name = "dolly";
		System.out.println(sheep.name);
		System.out.println(dolly.name);
	}

}

class Sheep implements Cloneable{
	String name;
	public Sheep createClone() throws CloneNotSupportedException{
		return (Sheep)super.clone();
	}
}
