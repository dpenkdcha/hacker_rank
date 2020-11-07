
class Vehicle {
	public void a() {
		System.out.println("In Vehicle");
	}
}

class Car extends Vehicle{
	public void b() {
		System.out.println("In Car");
	}
}


public class Inheri {
	
	public static void main(String[] args) {
		System.out.println("Hello");
		
		Vehicle v = new Vehicle();
		Car c = new Car();
		
		Vehicle v1 = new Car();
		Car c1 =  (Car) new Vehicle();
		
		v.a();
		//v.b();
		
		c.a();
		c.b();
		
		v1.a();
		//v1.b();
		
		c1.a();
		c1.b();
		
		System.out.println("Hello");
		
		Vehicle v2 = v1;
		Vehicle v3 = c1;
		Car c2 = (Car) v1;
		Car c3 = c1;
		
		v2.a();
		//v2.b();
		
		v3.a();
		//v3.b();
		
		c2.a();
		c2.b();
		
		c3.a();
		c3.b();
		
		
	}

}
