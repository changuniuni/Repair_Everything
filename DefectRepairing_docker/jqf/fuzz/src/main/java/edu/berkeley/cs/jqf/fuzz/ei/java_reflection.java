package edu.berkeley.cs.jqf.fuzz.ei;

import java.io.File;

import edu.berkeley.cs.jqf.fuzz.junit.GuidedFuzzing;
import org.junit.runner.Result;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class java_reflection {

    public static void main(String[] args) {

	String testClassName = args[0].toString();

	try {

	    Class temp = Class.forName(args[0]);
	    Method[] m = temp.getDeclaredMethods();

	    String fileName = "method_list.txt";
	    try{

		// BufferedWriter 와 FileWriter를 조합하여 사용 (속도 향상)
		BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));

		for(int i=0; i<m.length;i++) {

		    String temp_method = m[i].toString();
		    temp_method = temp_method.substring(24);
		    String[] array = temp_method.split("\\(");
		    String testMethodName = array[0];

		    // 파일안에 문자열 쓰기
		    fw.write(testMethodName);
		    fw.write('\n');
		    fw.flush();

		}
		// 객체 닫기
		fw.close();


	    }catch(Exception e){
		e.printStackTrace();
	    }

	    

	}
	catch (ClassNotFoundException ex) {
	    ex.printStackTrace();
	}

    }

}
