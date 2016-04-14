package uk.lonm.dp.easy.rockPaperScissorsLizardSpock;

public enum Card {
	ROCK, PAPER, SCISSORS, LIZARD, SPOCK;
	
	public int toInt(){
		if (this==ROCK)
			return 0;
		else if (this==PAPER)
			return 1;
		else if (this==SCISSORS)
			return 2;
		else if (this==LIZARD)
			return 3;
		else if (this==SPOCK)
			return 4;
		else return -1;
	}
	
	public String toString(){
		if (this==ROCK)
			return "Rock";
		else if (this==PAPER)
			return "Paper";
		else if (this==SCISSORS)
			return "Scissors";
		else if (this==LIZARD)
			return "Lizard";
		else if (this==SPOCK)
			return "Spock";
		else return null;
	}
	
	public static String toString(int i){
		if (i==0)
			return "ROCK";
		else if (i==1)
			return "PAPER";
		else if (i==2)
			return "SCISSORS";
		else if (i==3)
			return "LIZARD";
		else if (i==4)
			return "SPOCK";
		else return null;
	}
	
	public static Card toCard(int i){
		if (i==0)
			return ROCK;
		else if (i==1)
			return PAPER;
		else if (i==2)
			return SCISSORS;
		else if (i==3)
			return LIZARD;
		else if (i==4)
			return SPOCK;
		else return null;
	}
}
