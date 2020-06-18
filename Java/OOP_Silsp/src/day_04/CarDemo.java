package day_04;

public class CarDemo {
	public static void main(String[] args) {
		Car c1 = new Car("Red");
		Car c2= new Car("Blue");
		Car c3= new Car("red");
		
		System.out.println("�ڵ����� : "+Car.getNumOfCar()+", ������ �ڵ��� �� : " + c1.getNumOfRedCar());	
	}
}

class Car{
	private String name;
	private static int numOfCar=0;
	private static int numOfRedCar=0;
	public Car(String name){
		numOfCar++;
		
		
		
		if(name.compareToIgnoreCase("red")==0)	// case �����ϰ� ���ؼ� ������ 0 ��ȯ
			numOfRedCar++;
		
		this.name=name;
	}
	
	public static int getNumOfCar() {
		return numOfCar;
	}
	public static void setNumOfCar(int numOfCar) {
		Car.numOfCar = numOfCar;
	}
	public int getNumOfRedCar() {
		return numOfRedCar;
	}
	public void setNumOfRedCar(int numOfRedCar) {
		this.numOfRedCar = numOfRedCar;
	}
	
	
}