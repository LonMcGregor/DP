package uk.lonm.dp.easy.rockPaperScissorsLizardSpock;

public class GameLogic {
	private static GameStats stats;
	private Card currentCPU;
	private Card currentPLY;
	private GameAgent CPU;

	//start game
	public GameLogic(){
		stats = new GameStats();
	}
	public void init(){
		clearStats();
		CPU = new GameAgent();
	}
	
	//get new cpu card
	public Card newComputerCard(){
		Card x = computerCard();
		currentCPU = x;
		return x;
	}
	private Card computerCard(){
		/*int choice = new Random().nextInt(4);
		if (choice == 0)
			return Card.ROCK;
		if (choice == 1)
			return Card.PAPER;
		if (choice == 2)
			return Card.SCISSORS;
		if (choice == 3)
			return Card.LIZARD;
		if (choice == 4)
			return Card.SPOCK;
		else
			return null;*/
		System.out.println();
		System.out.println("+-------------+");
		return CPU.chooseCard();
	}
	
	//stat control and return
	public void clearStats(){
		stats.reset();
	}
	public int getTotalGames() {
		return stats.getTotalGames();
	}
	public int getCpuWins() {
		return stats.getWins()[0];
	}
	public int getPlayerWins() {
		return stats.getWins()[1];
	}
	public int getTies(){
		return stats.getTies();
	}
	public String statString(){
		String x = "";
		x = x + "Total Games: " + getTotalGames();
		x = x + "\n" + "CPU Wins: " + getCpuWins();
		x = x + "\n" + "Player Wins: " + getPlayerWins();
		x = x + "\n" + "Ties: " + getTies();
		return x;
	}
	
	//gets cards
	public String getCardString(boolean x){
		if(x)
			return currentCPU.toString();
		else
			return currentPLY.toString();
	}
	
	//sets player card
	public void setPlayerCard(int c){
		if (c == 0)
			setPlayerCard( Card.ROCK);
		if (c == 1)
			setPlayerCard( Card.PAPER);
		if (c == 2)
			setPlayerCard( Card.SCISSORS);
		if (c == 3)
			setPlayerCard( Card.LIZARD);
		if (c == 4)
			setPlayerCard( Card.SPOCK);
	}
	public void setPlayerCard(Card c){
		currentPLY = c;
		System.out.println("User chose: "+c.toString());
	}
	
	public int checkWin(){
		return checkWin(currentCPU, currentPLY);
	}
	
	public int checkWin(Card cpu, Card ply){
		int win = checkCard(cpu,ply);
		CPU.incCard(true, cpu.toInt());
		CPU.incCard(false, ply.toInt());
		if(win==-1){
			throw new Error("Could not assertain win state.");
		}
		if (win==0){
			System.out.println("Computer Wins "+win+" :"+cpu.toString()+" beats "+ply.toString());
			stats.incWins(0);
		} else if (win==1){
			System.out.println("Player Wins "+win+" :"+ply.toString()+" beats "+cpu.toString());
			stats.incWins(1);
		} else {			
			System.out.println("Both tie "+win+" :"+cpu.toString()+" ties with "+ply.toString());
			stats.incTies();
		}
		return win;
	}
	
	//A wins = 0   B wins = 1   Tie = 2
	public int checkCard(Card a, Card b){
		if(a==Card.SCISSORS && b==Card.PAPER){
			return 0;
		}else if(a==Card.PAPER && b==Card.ROCK){
			return 0;
		}else if(a==Card.ROCK && b==Card.LIZARD){
			return 0;
		}else if(a==Card.LIZARD && b==Card.SPOCK){
			return 0;
		}else if(a==Card.SPOCK && b==Card.SCISSORS){
			return 0;
		}else if(a==Card.SCISSORS && b==Card.LIZARD){
			return 0;
		}else if(a==Card.LIZARD && b==Card.PAPER){
			return 0;
		}else if(a==Card.PAPER && b==Card.SPOCK){
			return 0;
		}else if(a==Card.SPOCK && b==Card.ROCK){
			return 0;
		}else if(a==Card.ROCK && b==Card.SCISSORS){
			return 0;
		}
		else if(a==Card.ROCK && b==Card.PAPER){
			return 1;
		}else if(a==Card.LIZARD && b==Card.ROCK){
			return 1;
		}else if(a==Card.SPOCK && b==Card.LIZARD){
			return 1;
		}else if(a==Card.SCISSORS && b==Card.SPOCK){
			return 1;
		}else if(a==Card.LIZARD && b==Card.SCISSORS){
			return 1;
		}else if(a==Card.PAPER && b==Card.LIZARD){
			return 1;
		}else if(a==Card.SPOCK && b==Card.PAPER){
			return 1;
		}else if(a==Card.ROCK && b==Card.SPOCK){
			return 1;
		}else if(a==Card.SCISSORS && b==Card.ROCK){
			return 1;
		}else if(a==Card.PAPER && b==Card.SCISSORS){
			return 1;
		}
		else if(a==Card.SCISSORS && b==Card.SCISSORS){
			return 2;
		}else if(a==Card.PAPER && b==Card.PAPER){
			return 2;
		}else if(a==Card.LIZARD && b==Card.LIZARD){
			return 2;
		}else if(a==Card.SPOCK && b==Card.SPOCK){
			return 2;
		}else if(a==Card.ROCK && b==Card.ROCK){
			return 2;
		}
		else return -1;

	}
}


