package Complete_Concurrent_Collections.SingletonPattern;


import java.lang.reflect.Constructor;

import static Complete_Concurrent_Collections.SingletonPattern.EnumSingleton.*;

public class ReflectionSingletonTest2 {

	public static void main(String[] args) {
		EnumSingleton instanceOne = EnumSingleton.getInstance();
		EnumSingleton instanceTwo = null;
		try {
			Constructor[] constructors = EnumSingleton.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				// This code will destroy the singleton pattern
				constructor.setAccessible(true);
				instanceTwo = (EnumSingleton) constructor.newInstance();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
	}

}
