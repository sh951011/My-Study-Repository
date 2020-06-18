package str;

class Dog implements animal_1{
	@Override
	public void sound() {
		System.out.println("�۸�");
	}
}

class Cat implements animal_1{
	@Override
	public void sound() {
		System.out.println("�Ŀ�");
	}
}

class rabbit implements animal_1{
	@Override
	public void sound() {
		System.out.println("�ٴϹٴ�");
	}
}

class Animal{
	void run(animal_1 ani){
		System.out.println("¢��!");
		ani.sound();
		System.out.println("That`s a good boy");
	}
	
}

public class Strategy {
	public static void main(String[] args) {
		Animal ani = new Animal();
		
		ani.run(new Dog());
		ani.run(new Cat());
		ani.run(new rabbit());
	}
}