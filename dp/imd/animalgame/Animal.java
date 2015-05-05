package dp.imd.animalgame;

import java.io.Serializable;
import java.util.ArrayList;

public class Animal implements Serializable{
	private static final long serialVersionUID = 3840547386776469584L;
	ArrayList<String> properties;
	String name;
	Animal(String name){
		this.name = name;
		properties = new ArrayList<String>();
	}
	public void addProperty(String property){
		properties.add(property);
	}
	public boolean hasProperty(String property){
		return properties.contains(property);
	}
	public String getName(){
		return name;
	}
	public ArrayList<String> getProperties(){
		return properties;
	}
	public String toString(){
		String s = getName() + ":";
		for (String p : properties)
			s = s + p +"|";
		return s;
	}
}
