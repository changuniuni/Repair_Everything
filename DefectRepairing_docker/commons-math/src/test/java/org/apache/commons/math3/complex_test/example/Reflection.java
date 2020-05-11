package example;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Reflection {

    //해당 클래스의 패키지 이름과 클래스 이름을 출력한다
    static void printPackageClassType(Object object) {

	System.out.println("printPackageClassType()");
	System.out.println("package.className :" + object.getClass().getName() +"\n");

    }

    //public 접근제한자를 가진 모든 멤버변수를 출력한다
    static void printFields(Object object) {

	System.out.println("printFields()");

	Field[] fieldList = object.getClass().getFields();
	for(Field field :fieldList) {
	    System.out.println("type: "+field.getType() + "/ name : " +field.getName());
	}

	System.out.println();

    }
    
    //public 접근 제한자를 가진 모든 메서드를 출력
    static void printMethods (Object object){

	System.out.println("printMethods()");

	Method [] methodList = object.getClass().getMethods();

	for(Method method : methodList){
	    System.out.println("method name : " +method.getName());
	}
    }
}
	

