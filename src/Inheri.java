
class Vehicle {
	public void a() {
		System.out.println("In Vehicle");
	}
}

class Car extends Vehicle{
	public void b() {
		System.out.println("In Car");
	}
	
	public void a() {
		System.out.println("In Car Vehicle");
	}
}


class Moter {
	public void a(Vehicle vehicle) {
		System.out.println("In Vehicle Overloading");
		vehicle.a();
	}
	
	public void a(Car car ) {
		System.out.println("In Car Overloading");
		car.a();
	}
}

public class Inheri {
	
	public static void main(String[] args) {
		System.out.println("Hello");
		
		Vehicle v = new Vehicle();
		Car c = new Car();
		
		Vehicle v1 = new Car(); // Super vehicle class reference and sub car class object
		//Car c1 =  (Car) new Vehicle(); // Super Vehicle class can not be cast to Sub car class
		
		v.a();
		//v.b(); //Super vehicle class has not sub car class owned method
		
		c.a();
		c.b();
		
		v1.a();
		//v1.b(); //Super vehicle class has not sub car class owned method
		((Car) v1).b();
		
		//c1.a(); //Casting error
		//c1.b(); //Casting error
		
		System.out.println("Hello");
		
		Vehicle v2 = v1;
		//Vehicle v3 = c1;	//Casting error
		Car c2 = (Car) v1;
		//Car c3 = c1;	//Casting error
		
		v2.a();
		//v2.b(); //Super vehicle class has not sub car class owned method
		
		//v3.a();	//Casting error
		//v3.b();	//Casting error
		
		c2.a();
		c2.b();
		
		//c3.a();	//Casting error
		//c3.b();	//Casting error
		
		System.out.println("Hello");
		
		Moter m = new Moter();
		m.a(v);
		m.a(c);
		m.a(v1);
		
		
	}

}
