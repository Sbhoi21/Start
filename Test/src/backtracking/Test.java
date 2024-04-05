package backtracking;

class Animal {
	private String name;

	Animal() {
		this.name = name;
		System.out.println("Animal constructor: " + name);
	}

	void method() {
		System.out.println("Animal method");
	}
}

class Dog extends Animal implements inter2, TestInterface{
	private int age;

	Dog(String name, int age) {
		this.age = age;
		System.out.println("Dog constructor: " + name + ", " + age);
	}

	void method() {
		System.out.println("DOG method");
		String ab = "sddsd";
		System.out.println(ab);

		super.method();
		System.out.println(ab);

	}

	@Override
	public void methodinter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void methodinterTest() {
		// TODO Auto-generated method stub
		
	}

}

public class Test {
	public static void main(String[] args) {
		Dog myDog = new Dog("Buddy", 3);
		myDog.method();
	}
}
