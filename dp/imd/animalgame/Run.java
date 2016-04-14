package uk.lonm.dp.imd.animalgame;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);
		AnimalGame ag = new AnimalGame(sin, args[0]);
		ag.StartNewGame();
		sin.close();
		Database db = new Database(args[0]);
		for (Animal a : db.library) System.out.println(a);
	}
}
