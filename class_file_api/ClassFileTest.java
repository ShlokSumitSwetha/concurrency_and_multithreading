package Complete_Concurrent_Collections.class_file_api;

import java.lang.constant.ClassDesc;
import java.lang.constant.MethodTypeDesc;
import java.nio.file.Files;
import java.nio.file.Path;
import jdk.internal.classfile.*;
import java.nio.file.*;

public class ClassFileTest {
	public static void main(String[] args) throws Exception {
		Path path = Path.of("Example.class"); // Your compiled .class file
		ClassModel classModel = Classfile.of().parse(Files.readAllBytes(path));

		System.out.println("Class Name: " + classModel.thisClass().name());
		System.out.println("Super Class: " + classModel.superclass().get().name());
		System.out.println("Methods:");
		classModel.methods().forEach(m ->
				System.out.println(" - " + m.methodName().stringValue() + " " + m.methodType().stringValue())
		);
	}
}
