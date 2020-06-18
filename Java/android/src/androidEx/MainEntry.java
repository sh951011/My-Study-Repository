package androidEx;

public class MainEntry{
	public static void main(String[] args) {
		Animal ani = new Animal();
		
		System.out.println("=====����Ŭ���� ����=====\n");
		
        iAnimal animal =
                (new iAnimal(){
                    public void sound(){
                        System.out.println("����");
                    }
                });
        animal.sound();

        animal=
                (new iAnimal(){
                    public void sound(){
                        System.out.println("�۸�");
                    }
                });

        animal.sound();
        
        /////////////
        
        System.out.println("\n=====�������� ����=====\n");
        
        ani.doSound();
        ani.setAnimal(new Dog());
        ani.doSound();
        ani.setAnimal(new Tiger());
        ani.doSound();
	}
}

class Dog implements iAnimal{
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("�۸�");
	}
}

class Tiger implements iAnimal{
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("����");
	}
}

class Animal{
	private iAnimal animal;

	public void doSound(){
		if(animal==null){
			System.out.println("nothing");
		}else{
			animal.sound();
		}
	}
	
	/* SET  */

	public void setAnimal(iAnimal animal) {
		this.animal = animal;
	}
	
	/* SET */
}