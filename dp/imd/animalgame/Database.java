package uk.lonm.dp.imd.animalgame;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import uk.lonm.uniqueQueue.UniqueQueue;

public class Database {
	ArrayList<Animal> choices;
	UniqueQueue<String> propertyList;
	ArrayList<Animal> library;
	String location;
	
	public Database(String location){
		this.location = location;
		reset();
	}
	
	private void populateLibraryFromFile(String location){
		try {
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream(location));
			while(true){
				try {
					library.add((Animal) oin.readObject());
				} catch (ClassNotFoundException e) {
					break;
				} catch (IOException e) {
					break;
				}
			}
			oin.close();
		} catch (IOException e) {
			System.err.println("Error reading file. Starting with blank db");
			e.printStackTrace();
		}
	}
	private void populatePropertiesFromLibrary(){
		for(Animal a : library){
			for (String p : a.getProperties())
				propertyList.enqueue(p);
		}
	}
	private void persistFile(String location){
		try {
			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(location));
			for(Animal a : library){
				oout.writeObject(a);
			}
			oout.close();
		} catch (IOException e) {
			System.err.println("Error writing to file.");
			e.printStackTrace();
		}
	}
	
	public void updateChoices(String property, boolean hasProperty){
		ArrayList<Animal> newchoices = new ArrayList<Animal>();
		for (Animal a : choices){
			if ((a.hasProperty(property) && hasProperty) || (!a.hasProperty(property) && !hasProperty))
				//keep animal
				newchoices.add(a);
			//if ((a.hasProperty(property) && !hasProperty) || (!a.hasProperty(property) && hasProperty))
				//choices.remove(a);
		choices = newchoices;
		}
	}
	public boolean finalAnswer(){
		return (choices.size()<2 || propertyList.size()==0);
	}
	public String getNextProperty(){
		String p = propertyList.dequeue();
		return p;
	}
	public String getChosenAnimal(){
		if(choices.size()>0)
			for (Animal a : choices)
				return a.getName();
		return null;
	}
	
	public void updateAnimal(String name, String property){
		for(Animal a : library){
			if(a.getName().equals(name)){
				a.addProperty(property);
				persistFile(location);
				reset();
				return;
			}
		}
		newAnimal(name, property);
	}
	private void newAnimal(String name, String property){
		Animal a = new Animal(name);
		a.addProperty(property);
		library.add(a);
		persistFile(location);
		reset();
	}
	
	public void reset(){
		choices = new ArrayList<Animal>();
		library = new ArrayList<Animal>();
		propertyList = new UniqueQueue<String>();
		populateLibraryFromFile(location);
		populatePropertiesFromLibrary();
		for (Animal a : library)
			choices.add(a);
	}
}
