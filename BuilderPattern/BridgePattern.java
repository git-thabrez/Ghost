
public class BridgePattern {

	public static void main(String[] args) {
		Shape tri = new Triangle(new RedColor());
		tri.applyColor();
		Shape sq = new Square(new GreenColor());
		sq.applyColor();
	}

}

interface Color {
	public void applyColor();
}

class RedColor implements Color {
	@Override
	public void applyColor() {
		System.out.println("red");
	}
}

class GreenColor implements Color {
	@Override
	public void applyColor() {
		System.out.println("Green");
	}
}

abstract class Shape {
	protected Color color;
	public Shape(Color color) {
		this.color = color;
	}
	public abstract void applyColor();
}

class Triangle extends Shape {
	public Triangle(Color color) {
		super(color);
	}
	@Override
	public void applyColor() {
		System.out.print("Triangle is filled with ");
		color.applyColor();
	}
}

class Square extends Shape {
	public Square(Color color) {
		super(color);
	}
	@Override
	public void applyColor() {
		System.out.print("Square is filled with ");
		color.applyColor();
	}
}