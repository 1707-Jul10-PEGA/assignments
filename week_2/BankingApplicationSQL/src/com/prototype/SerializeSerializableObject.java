package com.prototype;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeSerializableObject {
	private static String fileName = "obj.txt";

	public void writeObject(SerializableObject o){
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
			oos.writeObject(o);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public SerializableObject readObject() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			SerializableObject ret = (SerializableObject) ois.readObject();
			return ret;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		SerializeSerializableObject s = new SerializeSerializableObject();
		SerializableObject obj1 = (SerializableObject)s.readObject();
		System.out.println(obj1.getS());
		System.out.println(obj1.getX());
		
	}

}

class SerializableObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9215815654265523051L;
	private String s;
	private int x;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public SerializableObject(String s, int x) {
		super();
		this.s = s;
		this.x = x;
	}
	public SerializableObject() {
		super();
	}
}
