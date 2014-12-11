package google.com.campus;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Console {
	public static void info(Object object){
		BufferedWriter file = null ;
		try {
			file = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("A-large-practice.out", true)));
			file.write(object.toString() + "\r\n");
			file.close();
		} catch (Exception e) {
			// TODO: handle exception
			
		}finally{

		}
				
		System.out.println(object);
	}
	
	public static void error(Object Object){
		System.out.println(Object);
	}
	
	public static void log(Object object){
		System.out.println(object);
	}
}
