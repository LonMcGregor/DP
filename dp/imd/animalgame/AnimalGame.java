package uk.lonm.dp.imd.animalgame;
import java.util.Scanner;
/*/r/DailyProgrammer Challenge Intermediate 212 */
public class AnimalGame {
	Scanner sin;
	Database db;
	AnimalGame(Scanner s, String location){
		sin = s;
		db = new Database(location);
	}
	private boolean askQuestion(String s){
		while(true){
			System.out.println(s);
			String answer = sin.nextLine().toLowerCase();
			if(answer.equals("y")||answer.equals("yes"))
				return true;
			else if(answer.equals("n")||answer.equals("no"))
				return false;
			else
				System.out.println("Answer should be in form yes or nn");
		}
	}
	public void StartNewGame(){
		System.out.println("Welcome to the Animal Guessing Game!");
		System.out.println("You will be asked a series of Yes/No questions, and");
		System.out.println("I will attempt to guess the animal you are thinking of.");
		System.out.println("--------------------------------------");
		System.out.println("Think of an animal and press enter to continue...");
		sin.nextLine();
		while(true){
			asking();
			try {
				if(!askQuestion("Start a New Game?"))
					break;
			} catch (Exception e) {
				break;
			}
		}
		System.out.println("Goodbye");
	}
	private void asking(){
		while(true){
			if(db.finalAnswer()){
				giveFinalAnswer(db.getChosenAnimal());
				break;
			}
			String s = db.getNextProperty();
			boolean response = askQuestion("Is your animal "+s+"?");
			db.updateChoices(s, response);
		}
	}
	private void giveFinalAnswer(String animal){
		boolean response = askQuestion("Is your animal: " + animal);
		if(response)
			System.out.println("It is okay to feel bad you did not stump me. "
					+ "I am a computer. :) Thank you for playing!");
		else
			newAnimal();
	}
	private void newAnimal(){
		System.out.println("I couldn't guess your animal.");
		System.out.println("What is it called?");
		String name = sin.nextLine();
		System.out.println("What is a property it has?");
		String property = sin.nextLine();
		db.updateAnimal(name, property);
	}
	
}
