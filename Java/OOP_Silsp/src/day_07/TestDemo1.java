package day_07;

public class TestDemo1 {
	public static void main(String[] args) {
		Car myCar = new Car("�׷���");
		Car yourCar = new Car("�׷���");
		
		System.out.println("myCar = " + myCar.toString());
		System.out.println("yourCar = " + yourCar.toString());
	}
}

class Car{
	private String model;
	public Car(String model) {
		this.model=model;
	}
	
	public String toString() {
		return "["+model+"]";
	}
}