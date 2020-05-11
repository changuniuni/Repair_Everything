package example;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException {

		TargetClass targetClass = new TargetClass();
		Reflection.printPackageClassType(targetClass);
		Reflection.printFields(targetClass);
		Reflection.printMethods(targetClass);
	}
}
