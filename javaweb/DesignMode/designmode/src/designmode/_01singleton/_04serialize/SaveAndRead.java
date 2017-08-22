package designmode._01singleton._04serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveAndRead {
	public static void main(String[] args) {
		Myobject myobject = Myobject.getInstence();
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(new File("a.txt"));
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(myobject);
			objectOutputStream.close();
			fileOutputStream.close();
			System.out.println("¥Ê¥¢:" + myobject.hashCode());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream fileInputStream = new FileInputStream(new File("a.txt"));
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Myobject myobject2 = (Myobject)objectInputStream.readObject();
			objectInputStream.close();
			fileInputStream.close();
			System.out.println("∂¡»°:" + myobject2.hashCode());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
		}
	}
}
