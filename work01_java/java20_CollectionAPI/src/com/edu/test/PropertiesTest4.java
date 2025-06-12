package com.edu.test;

import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

/*
 * System 위에 탑재된 Java 관련 환경변수값들을
 * 전부 다 출력해봄
 */
public class PropertiesTest4 {

	public static void main(String[] args) {
		 Properties p = System.getProperties();
		 
		 Set set = p.keySet();
		 
		 for (Object key: set.toArray()) {
			 String value = p.getProperty((String)key);
			 System.out.println("key: " + key + ", Value: " + value);
		 }
		 
		 /*
		 Enumeration en = p.propertyNames();
		 
		 while (en.hasMoreElements()) {
			 String key = (String)en.nextElement();
			 String value = p.getProperty(key);
			 System.out.println("key: " + key + ", Value: " + value);
		 }
		 */
		 
		 
	}

}
