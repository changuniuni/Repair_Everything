class TargetClass {

	public String memverVariable1;

	public Integer memverVariable2;

	public TargetClass() {
	}

	public TargetClass(String field) {
		this.memverVariable1 = field;
	}

	public void method1() {
		System.out.println("call method A");
	}

	public void method2(String str) {
		System.out.println("call method B : " + str);
	}
}
