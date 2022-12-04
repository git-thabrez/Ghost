
public class SingleTonPattern {

	public static void main(String[] args) {
		Resource obj = Resource.createSingleTonInstance();
		Resource obj2 = Resource.createSingleTonInstance();
		System.out.println(obj);
		System.out.println(obj2);
	}

}

class Resource {
	private static Resource obj;
	static {
		System.out.println("Static block called...");
	}
	private Resource() {
		
	}
	
	public static Resource createSingleTonInstance() {
		if(obj==null)
			obj = new Resource();
		return obj;
	}
}