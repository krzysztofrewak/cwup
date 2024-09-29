import lab05.Car;
import lab05.Truck;

public class Main {
  public static void main(String[] args) {
	Car[] vehicles = {
		new Car("Volkswagen Passat"),
		new Truck("Volkswagen Transporter"),
	};

	for(Car car : vehicles) {
		System.out.println(car.getName() + ": " + getPayment(car) + "zł");
	}
  }

  protected static double getPayment(Car car) {
  	return switch(car) {
  		case Truck t -> 5.0;
  		default -> 4.0;
  	};
  }
}
