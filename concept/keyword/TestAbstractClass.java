package keyword;

abstract class A {
	public void print() {
		System.out.println("public void print()");
	}
	
	abstract public void abstractPrint(); //Abstract methods do not specify a body
}

abstract class B extends A {
	
}

// If you are not a abstract class, you must implements the abstract methods
class C extends B {

	@Override
	public void abstractPrint() {
		
	}
	
}

interface D{
	public void print();
}

public class TestAbstractClass {

	public static void main(String[] args) {
		A a = new C();
		a.print();
	}

}
